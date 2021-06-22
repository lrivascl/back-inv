package cl.example.iventario.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.example.iventario.model.Producto;
import cl.example.iventario.model.Transaccion;
import cl.example.iventario.model.Cliente;
import cl.example.iventario.repository.ClienteRepository;
import cl.example.iventario.repository.ProductoRepository;
import cl.example.iventario.repository.TransaccionRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TransaccionController {
	
	private Log logger = LogFactory.getLog(TransaccionController.class);
	
	@Autowired
	TransaccionRepository transaccionRepository;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/transacciones")
	public ResponseEntity<List<Transaccion>> getAllTransaccion(@RequestParam(required = false) String trx) {
		try {
			
			List<Transaccion> transaccion = new ArrayList<Transaccion>();

			if (trx == null)
				transaccionRepository.findAll().forEach(transaccion::add);
			else
				transaccionRepository.findByTrxContaining(trx).forEach(transaccion::add);

			if (transaccion.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(transaccion, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
		
	@PostMapping("/transaccion")
	public ResponseEntity<Transaccion> CreateTrx (@RequestBody Transaccion transaccion){
		try {
			Transaccion _transaccion = transaccionRepository
					.save(new Transaccion(transaccion.getTrx(),transaccion.getName(),transaccion.getCodigoProducto(),transaccion.getUnidades(),
							transaccion.getPrecio(),transaccion.getFechaTrx()));
			
			logger.info(_transaccion);
			
			if(_transaccion.getTrx().equals("STOCK")) {
				Optional<Producto> productoData = productoRepository.findByCodigo(_transaccion.getCodigoProducto());
				
				if(productoData.isPresent()) {
					Producto _producto = productoData.get();
					if(_producto.getCodigo() == _transaccion.getCodigoProducto()) {
						
						_producto.setCantidad(_producto.getCantidad()+_transaccion.getUnidades());
						productoRepository.save(_producto);
					}
					
				}	
			}else if(_transaccion.getTrx().equals("VENTA")){
				Optional<Producto> productoData = productoRepository.findByCodigo(_transaccion.getCodigoProducto());
				
				if(productoData.isPresent()) {
					Producto _producto = productoData.get();
					if(_producto.getCodigo() == _transaccion.getCodigoProducto()) {
						
						_producto.setCantidad(_producto.getCantidad()-_transaccion.getUnidades());
						productoRepository.save(_producto);
					}
					
				}	
				
			}
			if(_transaccion.getName().isEmpty() == false) {
				Optional<Cliente> clienteData = clienteRepository.findByNombreCli(_transaccion.getName());
				
				if(clienteData.isEmpty() == false) {
					
					Cliente _cliente = clienteData.get();
					if(_cliente.getNombreCli().equals(_transaccion.getName())){
						_cliente.setSaldoCompras(_cliente.getSaldoCompras()+_transaccion.getPrecio());
						clienteRepository.save(_cliente);
					}
					
				}
			}
			
			return new ResponseEntity<>(_transaccion, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/clientes/{idTrx}")
	public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("idTrx") long idTrx){
		try {
			transaccionRepository.deleteById(idTrx);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception E) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	}
}

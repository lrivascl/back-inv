package cl.example.iventario.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.example.iventario.model.Cliente;
import cl.example.iventario.repository.ClienteRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ClienteController {
	
	private Log logger = LogFactory.getLog(TransaccionController.class);
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getAllClientes(@RequestParam(required = false) String nombreCli) {
		try {
			
			List<Cliente> clientes = new ArrayList<Cliente>();

			if (nombreCli == null) {
				logger.info(clientes);
				clienteRepository.findAll().forEach(clientes::add);
			}
			else {
				logger.info(clientes);
				clienteRepository.findByNombreCliContaining(nombreCli).forEach(clientes::add);	
			}
				

			if (clientes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(clientes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/clientes/fono/{telefono}")
	public ResponseEntity<List<Cliente>> getClienteByTelefono(@PathVariable("telefono") long telefono){
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			
			clienteRepository.findByTelefono(telefono).forEach(clientes::add);
			
			if (clientes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(clientes, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/clientes/{idCliente}")
	public ResponseEntity<Cliente> getClienteByIdCliente(@PathVariable("idCliente") long idCliente){
		Optional<Cliente> clienteData = clienteRepository.findById(idCliente);
		if(clienteData.isPresent()) {
			return new ResponseEntity<>(clienteData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> createCliente (@RequestBody Cliente cliente){
		try {
			Cliente _cliente = clienteRepository
					.save(new Cliente(cliente.getNombreCli(), cliente.getTelefono(),
							cliente.getEmail(),cliente.getFechaCreacion(),cliente.getSaldoCompras(),cliente.getDescuento()));
			
			return new ResponseEntity<>(_cliente, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/clientes/{idCliente}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("idCliente") long idCliente, @RequestBody Cliente cliente){
		Optional<Cliente> clienteData = clienteRepository.findById(idCliente);
		
		if(clienteData.isPresent()) {
			Cliente _cliente = clienteData.get();
			_cliente.setNombreCli(cliente.getNombreCli());
			_cliente.setTelefono(cliente.getTelefono());
			_cliente.setEmail(cliente.getEmail());
			_cliente.setFechaCreacion(cliente.getFechaCreacion());
			_cliente.setSaldoCompras(cliente.getSaldoCompras());
			_cliente.setDescuento(cliente.getDescuento());
			return new ResponseEntity<>(clienteRepository.save(_cliente), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/clientes/{idCliente}")
	public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("idCliente") long idCliente){
		try {
			clienteRepository.deleteById(idCliente);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception E) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	}
}

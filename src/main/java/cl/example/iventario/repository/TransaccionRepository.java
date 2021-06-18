package cl.example.iventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.example.iventario.model.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{
	
	
	List<Transaccion> findByTrxContaining(String trx);
	
	List<Transaccion> findBycodigoProducto(long codigoProducto);
	
}

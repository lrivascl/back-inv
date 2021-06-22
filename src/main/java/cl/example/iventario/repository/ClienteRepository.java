package cl.example.iventario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.example.iventario.model.Cliente;


@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByTelefono(long telefono);
	
	List<Cliente> findByNombreCliContaining(String nombreCli);
	
	Optional<Cliente> findByNombreCli(String nombreCli);

}

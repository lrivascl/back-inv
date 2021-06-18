package cl.example.iventario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.example.iventario.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	  List<Producto> findByPublished(boolean published);

	  List<Producto> findByNombreContaining(String nombre);
	  
	  Optional<Producto> findByCodigo(long codigo);
	}
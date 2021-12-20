package com.example.inventario.Dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventario.Models.Producto;

@Repository
@Transactional
public interface IDaoProducto extends CrudRepository<Producto, Long>{

	//@Query(value = "SELECT productos.id, productos.nombre, productos.precio"
	//		+ " FROM productos INNER JOIN productos_categorias ON"
	//		+ " productos.id = productos_categorias.id_producto WHERE"
	//		+ " productos_categorias.id_categoria = ?1", nativeQuery = true)
	//List<Producto> findByCategoriaId(Long categoriaId);
	
	@Query(value = "SELECT *"
			+ " FROM productos INNER JOIN productos_categorias ON"
			+ " productos.id = productos_categorias.id_producto WHERE"
			+ " productos_categorias.id_categoria = :categoriaId", nativeQuery = true)
	List<Producto> findByCategoriaId(@Param("categoriaId") Long categoriaId);
	
	@Query(value = "SELECT *"
			+ " FROM productos WHERE marca_id = :marcaId", nativeQuery = true)
	List<Producto> findByMarcaId(@Param("marcaId") Long marcaId);
	
	Producto findByNombre(String nombre);
}

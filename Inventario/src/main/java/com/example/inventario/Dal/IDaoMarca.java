package com.example.inventario.Dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventario.Models.Marca;

@Repository
@Transactional
public interface IDaoMarca extends CrudRepository<Marca, Long>{

	public Marca findByNombre(String nombre);
	
}

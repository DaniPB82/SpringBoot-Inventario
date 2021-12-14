package com.example.inventario.Dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventario.Models.Categoria;

@Repository
@Transactional
public interface IDaoCategoria extends CrudRepository<Categoria, Long>{

}

package com.example.inventario.Dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventario.Models.Producto;

@Repository
@Transactional
public interface IDaoProducto extends CrudRepository<Producto, Long>{

}

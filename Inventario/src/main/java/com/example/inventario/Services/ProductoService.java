package com.example.inventario.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventario.Dal.IDaoProducto;
import com.example.inventario.Models.Producto;

@Service
public class ProductoService {

	@Autowired
	private IDaoProducto daoProducto;
	
	public List<Producto> obtenerTodosLosProductos(){
		return (List<Producto>) daoProducto.findAll();
	}
	
	public List<Producto> obtenerTodosLosProductosPorCategoria(Long id){
		return (List<Producto>) daoProducto.findByCategoriaId(id);
	}
}

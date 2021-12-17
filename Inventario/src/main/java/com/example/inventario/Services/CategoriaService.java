package com.example.inventario.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventario.Dal.IDaoCategoria;
import com.example.inventario.Models.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private IDaoCategoria daoCategoria;
	
	public List<Categoria> obtenerTodasLasCategorias(){
		return (List<Categoria>) daoCategoria.findAll();
	}
	
	public Categoria obtenerCategoriaPorId(Long id) {
		return daoCategoria.findById(id).get();
	}
	
	public Categoria obtenerCategoriaPorNombre(String nombre) {
		return daoCategoria.findByNombre(nombre);
	}
	
	public Categoria guardarCategoria(Categoria categoria) {
		return daoCategoria.save(categoria);
	}
	
	public void eliminarCategoria(Categoria categoria) {
		daoCategoria.delete(categoria);
	}
}

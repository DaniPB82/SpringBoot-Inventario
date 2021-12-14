package com.example.inventario.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventario.Dal.IDaoCategoria;
import com.example.inventario.Models.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private IDaoCategoria daocategoria;
	
	public List<Categoria> obtenerTodasLasCategorias(){
		return (List<Categoria>) daocategoria.findAll();
	}
}

package com.example.inventario.Controllers;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.inventario.Models.Categoria;
import com.example.inventario.Services.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/listar")
	public String listaCategorias(Model modelo) {
		List<Categoria> listaCategorias = categoriaService.obtenerTodasLasCategorias();
		modelo.addAttribute("listaCategorias", listaCategorias);
		return "categorias/listado_categorias";
	}

	@GetMapping(value = "/nueva")
	public String nuevaCategoria(Model modelo) {
		modelo.addAttribute("categoria", new Categoria());
		return "categorias/formulario_categoria";
	}

	@GetMapping(value = "/modificar/{id}")
	public String modificarCategoria(@PathVariable("id") Long id, Model modelo) {
		Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
		modelo.addAttribute("categoria", categoria);
		return "categorias/formulario_categoria";
	}

	@PostMapping("/guardar")
	public String guardarCategoria(Categoria categoria) {
		Categoria catTemp = categoriaService.obtenerCategoriaPorNombre(categoria.getNombre());
		if (catTemp != null) {
			return "categorias/error_categoria";
		} else {
			categoriaService.guardarCategoria(categoria);
			return "redirect:/categorias/listar";
		}
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarCategoria(@PathVariable("id") Long id, Model modelo) {
		Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
		categoriaService.eliminarCategoria(categoria);
		// modelo.addAttribute("categoria", categoria);
		return "redirect:/categorias/listar";
	}
}

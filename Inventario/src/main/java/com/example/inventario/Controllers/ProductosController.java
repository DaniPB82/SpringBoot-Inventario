package com.example.inventario.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.inventario.Models.Categoria;
import com.example.inventario.Models.Producto;
import com.example.inventario.Services.CategoriaService;
import com.example.inventario.Services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/listar")
	public String listaProductos(Model modelo) {
		List<Producto> listaProductos = productoService.obtenerTodosLosProductos();
		modelo.addAttribute("listaProductos", listaProductos);
		return "productos/listado_productos";
	}
	
	@GetMapping("/categoria/{id}")
	public String listaProductosPorCategoria(@PathVariable("id") Long id, Model modelo) {
		List<Producto> listaProductos = productoService.obtenerTodosLosProductosPorCategoria(id);
		Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
		//String nombreCategoria = categoria.getNombre();
		modelo.addAttribute("listaProductos", listaProductos);
		modelo.addAttribute("categoria", categoria);
		return "productos/listado_productos";
	}
}

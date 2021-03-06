package com.example.inventario.Controllers;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.inventario.Models.Categoria;
import com.example.inventario.Models.Marca;
import com.example.inventario.Models.Producto;
import com.example.inventario.Services.CategoriaService;
import com.example.inventario.Services.MarcaService;
import com.example.inventario.Services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	private ProductoService productoService;

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private MarcaService marcaService;

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
		
		modelo.addAttribute("listaProductos", listaProductos);
		modelo.addAttribute("categoria", categoria);
		
		return "productos/listado_productos";
	}
	
	@GetMapping("/marca/{id}")
	public String listaProductosPorMarca(@PathVariable("id") Long id, Model modelo) {
		List<Producto> listaProductos = productoService.obtenerTodosLosProductosPorMarca(id);
		
		Marca marca = marcaService.obtenerMarcaPorId(id);
		
		modelo.addAttribute("listaProductos", listaProductos);
		modelo.addAttribute("marca", marca);
		
		return "productos/listado_productos";
	}

	@GetMapping(value = "/nuevo")
	public String nuevoProducto(Model modelo) {
		List<Categoria> listaCategorias = categoriaService.obtenerTodasLasCategorias();
		listaCategorias.sort(Comparator.comparing(Categoria::getNombre));
		
		List<Marca> listaMarcas = marcaService.obtenerTodasLasMarcas();
		listaMarcas.sort(Comparator.comparing(Marca::getNombre));
		
		modelo.addAttribute("listaCategorias", listaCategorias);
		modelo.addAttribute("listaMarcas", listaMarcas);
		modelo.addAttribute("producto", new Producto());
		
		return "productos/formulario_producto";
	}

	@GetMapping(value = "/modificar/{id}")
	public String modificarProducto(@PathVariable("id") Long id, Model modelo) {
		Producto producto = productoService.obtenerProductoPorId(id);
		
		List<Categoria> listaCategorias = categoriaService.obtenerTodasLasCategorias();
		listaCategorias.sort(Comparator.comparing(Categoria::getNombre));
		
		List<Marca> listaMarcas = marcaService.obtenerTodasLasMarcas();
		listaMarcas.sort(Comparator.comparing(Marca::getNombre));
		
		modelo.addAttribute("listaCategorias", listaCategorias);
		modelo.addAttribute("listaMarcas", listaMarcas);
		modelo.addAttribute("producto", producto);
		
		return "productos/formulario_producto";
	}

	@PostMapping("/guardar")
	public String guardarProducto(Producto producto) {
		Producto proTemp = productoService.obtenerProductoPorNombre(producto.getNombre());
		if (proTemp != null) {
			if (producto.getNombre().equals(proTemp.getNombre()) && 
					producto.getPrecio().equals(proTemp.getPrecio()) &&
					producto.getCategorias().equals(proTemp.getCategorias())) {
				return "productos/error_producto";
			}
			else {
				productoService.guardarProducto(producto);
				return "redirect:/productos/listar";
			}
		}
		productoService.guardarProducto(producto);
		return "redirect:/productos/listar";
	}


	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") Long id, Model modelo) {
		Producto producto = productoService.obtenerProductoPorId(id);
		modelo.addAttribute("producto", producto);
		return "productos/eliminar_producto";
	}
	
	@PostMapping("/eliminar")
	public String eliminarProductoConfirmado(Producto producto) {
		productoService.eliminarProducto(producto);
		return "redirect:/productos/listar";
	}
}

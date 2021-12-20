package com.example.inventario.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.inventario.Models.Marca;
import com.example.inventario.Services.MarcaService;

@Controller
@RequestMapping("/marcas")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	@GetMapping("/listar")
	public String listaMarcas(Model modelo) {
		List<Marca> listaMarcas = marcaService.obtenerTodasLasMarcas();
		modelo.addAttribute("listaMarcas", listaMarcas);
		return "marcas/listado_marcas";
	}

	@GetMapping(value = "/nueva")
	public String nuevaMarca(Model modelo) {
		modelo.addAttribute("marca", new Marca());
		return "marcas/formulario_marca";
	}

	@GetMapping(value = "/modificar/{id}")
	public String modificarMarca(@PathVariable("id") Long id, Model modelo) {
		Marca marca = marcaService.obtenerMarcaPorId(id);
		modelo.addAttribute("marca", marca);
		return "marcas/formulario_marca";
	}

	@PostMapping("/guardar")
	public String guardarMarca(Marca marca) {
		Marca marTemp = marcaService.obtenerMarcaPorNombre(marca.getNombre());
		if (marTemp != null) {
			return "marcas/error_marca";
		} else {
			marcaService.guardarMarca(marca);
			return "redirect:/marcas/listar";
		}
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarMarca(@PathVariable("id") Long id, Model modelo) {
		Marca marca = marcaService.obtenerMarcaPorId(id);
		marcaService.eliminarMarca(marca);
		// modelo.addAttribute("categoria", categoria);
		return "redirect:/marcas/listar";
	}
}

package com.example.inventario.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventario.Dal.IDaoMarca;
import com.example.inventario.Models.Marca;

@Service
public class MarcaService {

	@Autowired
	private IDaoMarca daoMarca;
	
	public List<Marca> obtenerTodasLasMarcas(){
		return (List<Marca>) daoMarca.findAll();
	}
	
	public Marca obtenerMarcaPorId(Long id) {
		return daoMarca.findById(id).get();
	}
	
	public Marca obtenerMarcaPorNombre(String nombre) {
		return daoMarca.findByNombre(nombre);
	}
	
	public Marca guardarMarca(Marca marca) {
		return daoMarca.save(marca);
	}
	
	public void eliminarMarca(Marca marca) {
		daoMarca.delete(marca);
	}
}

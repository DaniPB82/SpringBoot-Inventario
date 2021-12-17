package com.example.inventario.Models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Categorias")
public class Categoria {

	@Id
    @Column(name="Id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="Nombre", unique = true, nullable = false)
    private String nombre;
    
    @ManyToMany(mappedBy = "categorias")
    private List<Producto> productos;

    
    
	public Categoria() {
		super();
	}
	
	

	public Categoria(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}



	public Categoria(Long id, String nombre, List<Producto> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.productos = productos;
	}



	public Categoria(String nombre, List<Producto> productos) {
		super();
		this.nombre = nombre;
		this.productos = productos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return nombre;
	}
    
    
    
}

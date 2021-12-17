package com.example.inventario.Models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "Nombre", nullable = false)
	private String nombre;
	
	@Column(name = "Precio", nullable = false)
	private Double precio;
	
	@JoinTable(name = "Productos_Categorias",
	        joinColumns = @JoinColumn(name = "Id_Producto", referencedColumnName = "Id", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="Id_Categoria", referencedColumnName = "Id", nullable = false))
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Categoria> categorias;

	
	
	public Producto() {
		super();
	}

	public Producto(String nombre, List<Categoria> categorias) {
		super();
		this.nombre = nombre;
		this.categorias = categorias;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", categorias=" + categorias + "]";
	}

	
	
}

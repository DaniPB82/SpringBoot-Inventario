package com.example.inventario.Models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "Productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "Nombre", unique = true, nullable = false)
	private String nombre;
	
	@NumberFormat(pattern = "#.00")
	@Column(name = "Precio", nullable = false)
	private BigDecimal precio;
	
	@ManyToOne
	@JoinColumn(name = "marca_id", nullable = false)
	private Marca marca;
	
	@JoinTable(name = "Productos_Categorias",
	        joinColumns = @JoinColumn(name = "Id_Producto", referencedColumnName = "Id", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="Id_Categoria", referencedColumnName = "Id", nullable = false))
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Categoria> categorias;

	
	
	public Producto() {
		super();
	}

	public Producto(String nombre, List<Categoria> categorias, Marca marca) {
		super();
		this.nombre = nombre;
		this.categorias = categorias;
		this.marca = marca;
	}

	public Producto(Long id, String nombre, BigDecimal precio, Marca marca, List<Categoria> categorias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + ", categorias=" + categorias + "]";
	}

	
	
}

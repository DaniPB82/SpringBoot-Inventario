package com.example.inventario.Models;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
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

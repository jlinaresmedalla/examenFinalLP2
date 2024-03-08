package com.example.demo.model;

public class Reporte {

	public String id;
	public String nombre;
	public String autor;
	public String fechaEstreno;
	
	public Reporte(String id, String nombre, String autor, String fechaEstreno) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.fechaEstreno = fechaEstreno;
	}
	
	public Reporte() {}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	
	
	
}

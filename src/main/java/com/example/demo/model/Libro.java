package com.example.demo.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
    @Column(nullable = false, length = 60)
	public String nombre; 
    @Column(nullable = false, length = 60)
	public String autor;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
	public Date fechaEstreno;
	@ManyToOne
	@JoinColumn(name = "idgenero", nullable = false)
	public Genero genero;
	
	
    public Reporte toReporte() {
        Reporte reporte = new Reporte();
        reporte.id = String.valueOf(this.id);
        reporte.nombre = this.nombre;
        reporte.autor = this.autor;

        // Formatear la fecha según el patrón deseado
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        reporte.fechaEstreno = dateFormat.format(this.fechaEstreno);

        return reporte;
    }
}

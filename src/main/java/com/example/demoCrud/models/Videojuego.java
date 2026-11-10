package com.example.demoCrud.models;

import jakarta.persistence.*;

@Entity
@Table(name = "videojuegos")
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Double precio;

    // Aquí está la relación: Muchos videojuegos pertenecen a un desarrollador
    @ManyToOne
    @JoinColumn(name = "desarrollador_id", nullable = false)
    private Desarrollador desarrollador;

    // Constructor vacío exigido por JPA
    public Videojuego() {
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Desarrollador getDesarrollador() { return desarrollador; }
    public void setDesarrollador(Desarrollador desarrollador) { this.desarrollador = desarrollador; }
}
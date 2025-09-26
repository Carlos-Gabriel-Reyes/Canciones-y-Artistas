package com.carlosreyes.canciones.modelos;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "canciones")
public class Cancion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min=5, message="Al menos 5 caracteres de longitud")
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;
    
    @Size(min=3, message="Al menos 3 caracteres de longitud")
    private String album;
    
    @Size(min=3, message="Al menos 3 caracteres de longitud")
    private String genero;
    
    @Size(min=3, message="Al menos 3 caracteres de longitud")
    private String idioma;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public Cancion() { }

    public Cancion(String titulo, Artista artista, String album, String genero, String idioma) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.idioma = idioma;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Artista getArtista() { return artista; }
    public void setArtista(Artista artista) { this.artista = artista; }
    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
}

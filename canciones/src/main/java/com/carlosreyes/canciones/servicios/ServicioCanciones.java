package com.carlosreyes.canciones.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosreyes.canciones.modelos.Cancion;
import com.carlosreyes.canciones.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {

    @Autowired
    private RepositorioCanciones repo;

    public List<Cancion> obtenerTodasLasCanciones() {
        return repo.findAll();
    }

    public Cancion obtenerCancionPorId(Long id) {
        Optional<Cancion> op = repo.findById(id);
        return op.orElse(null);
    }

    public Cancion agregarCancion(Cancion cancion) {
        return repo.save(cancion);
    
    }
    

    public Cancion actualizaCancion(Cancion cancion) {
        Cancion db = obtenerCancionPorId(cancion.getId());
        if (db == null) {
            throw new IllegalArgumentException("Canción no encontrada con id " + cancion.getId());
        }
        db.setTitulo(cancion.getTitulo());
        db.setArtista(cancion.getArtista());
        db.setAlbum(cancion.getAlbum());
        db.setGenero(cancion.getGenero());
        db.setIdioma(cancion.getIdioma());
        return repo.save(db);
    }

    public void eliminaCancion(Long id) {
    if (id != null) {
        repo.deleteById(id);
        }
    }

}

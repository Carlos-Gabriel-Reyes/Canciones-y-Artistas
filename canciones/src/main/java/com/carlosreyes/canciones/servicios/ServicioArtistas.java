package com.carlosreyes.canciones.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosreyes.canciones.modelos.Artista;
import com.carlosreyes.canciones.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {

    @Autowired
    private RepositorioArtistas repo;

    public List<Artista> obtenerTodosLosArtistas() {
        return repo.findAll();
    }

    public Artista obtenerArtistaPorId(Long id) {
        Optional<Artista> op = repo.findById(id);
        return op.orElse(null);
    }

    public Artista agregarArtista(Artista artista) {
        return repo.save(artista);
    }
}

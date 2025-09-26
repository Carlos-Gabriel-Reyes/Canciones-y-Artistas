package com.carlosreyes.canciones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.carlosreyes.canciones.modelos.Artista;
import com.carlosreyes.canciones.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {

    @Autowired
    private ServicioArtistas servicio;

    @GetMapping("/artistas")
    public String desplegarArtistas(Model model) {
        List<Artista> lista = servicio.obtenerTodosLosArtistas();
        model.addAttribute("artistas", lista);
        return "artistas";
    }

    @GetMapping("/artistas/detalle/{idArtista}")
    public String detalleArtista(@PathVariable("idArtista") Long idArtista, Model model) {
        Artista artista = servicio.obtenerArtistaPorId(idArtista);
        model.addAttribute("artista", artista);
        return "detalleArtista";
    }

    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(Model model) {
        model.addAttribute("artista", new Artista());
        return "agregarArtista";
    }

    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(
            @Valid @ModelAttribute("artista") Artista artista,
            BindingResult result) {
        if (result.hasErrors()) {
            return "agregarArtista";
        }
        servicio.agregarArtista(artista);
        return "redirect:/artistas";
    }
}

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
import com.carlosreyes.canciones.modelos.Cancion;
import com.carlosreyes.canciones.servicios.ServicioArtistas;
import com.carlosreyes.canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicio;
    @Autowired
    private ServicioArtistas servicioArtistas;

    
    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        List<Cancion> lista = servicio.obtenerTodasLasCanciones();
        model.addAttribute("canciones", lista);
        return "canciones";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String detalleCancion(@PathVariable("idCancion") Long idCancion, Model model) {
        Cancion cancion = servicio.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion); 
        return "detalleCancion";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model model) {
        model.addAttribute("cancion", new Cancion());
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
                                        @Valid @ModelAttribute("cancion") Cancion cancion,
                                        BindingResult result,
                                        Model model) {
        Long artistaId = (cancion.getArtista() != null) ? cancion.getArtista().getId() : null;
        if (artistaId == null) {
            result.rejectValue("artista", null, "Debes seleccionar un artista");
            model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "agregarCancion";
        }
        Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
        if (artista == null) {
            result.rejectValue("artista", "error.cancion", "Debes seleccionar un artista válido.");
            model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "agregarCancion";
        }
        cancion.setArtista(artista);
        servicio.agregarCancion(cancion);
        return "redirect:/canciones";
    }
    
    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
        Cancion cancion = servicio.obtenerCancionPorId(idCancion);
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());  //pa que salga la lista de artistas en el select 
        if (cancion == null) {
            return "redirect:/canciones";
        }
        model.addAttribute("cancion", cancion);
        return "editarCancion";
    }

    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable("idCancion") Long idCancion,
                                        @Valid @ModelAttribute("cancion") Cancion cancion,
                                        BindingResult result) {
        cancion.setId(idCancion);
        if (result.hasErrors()) {
            return "editarCancion";
        }
        servicio.actualizaCancion(cancion);
        return "redirect:/canciones";
    }
    
    @GetMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
        servicio.eliminaCancion(idCancion);
        return "redirect:/canciones";
    }

}


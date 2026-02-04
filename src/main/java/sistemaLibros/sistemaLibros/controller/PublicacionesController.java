package sistemaLibros.sistemaLibros.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sistemaLibros.sistemaLibros.model.Publicaciones;
import sistemaLibros.sistemaLibros.service.IPublicacionesService;
import sistemaLibros.sistemaLibros.service.IUsuarioService;

@Controller
@RequestMapping("/publicaciones")
public class PublicacionesController {

    @Autowired
    private IPublicacionesService publicacionesService;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public String listarPublicaciones(Model model){
        model.addAttribute("publicaciones", publicacionesService.listarPublicaciones());
        model.addAttribute("publicacion", new Publicaciones());
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "publicaciones/index";
    }

    @PostMapping("/guardar")
    public String guardarPublicacion(
            @Valid @ModelAttribute("publicacion") Publicaciones publicacion,
            BindingResult result,
            Model model){

        if(result.hasErrors()){
            model.addAttribute("publicaciones", publicacionesService.listarPublicaciones());
            model.addAttribute("usuarios", usuarioService.listarUsuarios());
            return "publicaciones/index";
        }

        publicacionesService.guardarPublicacion(publicacion);
        return "redirect:/publicaciones";
    }

    @GetMapping("/editar/{id}")
    public String editarPublicacion(@PathVariable Integer id, Model model){

        model.addAttribute("publicacion", publicacionesService.buscarPorId(id));
        model.addAttribute("publicaciones", publicacionesService.listarPublicaciones());
        model.addAttribute("usuarios", usuarioService.listarUsuarios());

        return "publicaciones/index";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPublicacion(@PathVariable Integer id){
        publicacionesService.eliminarPorId(id);
        return "redirect:/publicaciones";
    }
}



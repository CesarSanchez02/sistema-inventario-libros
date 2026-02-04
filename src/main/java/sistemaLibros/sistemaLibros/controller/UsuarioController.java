package sistemaLibros.sistemaLibros.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sistemaLibros.sistemaLibros.model.Usuario;
import sistemaLibros.sistemaLibros.service.IUsuarioService;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        model.addAttribute("usuario", new Usuario());
        return "usuarios/index";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
                                 BindingResult result,
                                 Model model){

        if(result.hasErrors()){
            model.addAttribute("usuarios", usuarioService.listarUsuarios());
            return "usuarios/index";
        }

        try {
            usuarioService.guardarUsuario(usuario);
        } catch (RuntimeException e) {

            if(e.getMessage().equals("EMAIL_DUPLICADO")){
                result.rejectValue(
                        "email",
                        "error.usuario",
                        "Este correo ya está registrado"
                );
            }

            model.addAttribute("usuarios", usuarioService.listarUsuarios());
            return "usuarios/index";
        }

        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable("id") Integer idUsuario, Model model){

        model.addAttribute("usuario", usuarioService.buscarPorId(idUsuario));
        model.addAttribute("usuarios", usuarioService.listarUsuarios());

        return "usuarios/index";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id,
                                  RedirectAttributes ra) {

        try {
            usuarioService.eliminarPorId(id);
            ra.addFlashAttribute("ok", "Usuario eliminado correctamente");

        } catch (Exception e) {
            ra.addFlashAttribute("error",
                    "No se puede eliminar el usuario porque tiene publicaciones asociadas");
        }

        return "redirect:/usuarios";
    }
}


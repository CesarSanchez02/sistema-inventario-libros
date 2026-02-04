package sistemaLibros.sistemaLibros.service;

import sistemaLibros.sistemaLibros.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarUsuarios();

    Usuario buscarPorId(Integer id);

    void guardarUsuario(Usuario usuario);

    void eliminarPorId(Integer id);
}

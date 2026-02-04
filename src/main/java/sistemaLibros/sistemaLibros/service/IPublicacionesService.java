package sistemaLibros.sistemaLibros.service;

import sistemaLibros.sistemaLibros.model.Publicaciones;

import java.util.List;

public interface IPublicacionesService {

    List<Publicaciones> listarPublicaciones();

    Publicaciones buscarPorId(Integer id);

    void guardarPublicacion(Publicaciones publicaciones);

    void eliminarPorId(Integer id);



}

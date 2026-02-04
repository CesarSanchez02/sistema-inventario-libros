package sistemaLibros.sistemaLibros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistemaLibros.sistemaLibros.model.Publicaciones;
import sistemaLibros.sistemaLibros.repository.PublicacionesRepository;

import java.util.List;

@Service
public class PublicacionesServiceImpl implements IPublicacionesService {
    @Autowired
    PublicacionesRepository publicacionesRepository;

    @Override
    public List<Publicaciones> listarPublicaciones() {
        return publicacionesRepository.findAll();
    }

    @Override
    public Publicaciones buscarPorId(Integer id) {
        return publicacionesRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarPublicacion(Publicaciones publicaciones) {
        publicacionesRepository.save(publicaciones);
    }

    @Override
    public void eliminarPorId(Integer id) {
        publicacionesRepository.deleteById(id);
    }
}

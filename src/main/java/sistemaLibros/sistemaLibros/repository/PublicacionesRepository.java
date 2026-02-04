package sistemaLibros.sistemaLibros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistemaLibros.sistemaLibros.model.Publicaciones;

public interface PublicacionesRepository  extends JpaRepository<Publicaciones, Integer> {
}

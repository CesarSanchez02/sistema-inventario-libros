package sistemaLibros.sistemaLibros.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publicaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPublicacion;

    @NotBlank(message = "El titulo es obligatorio.")
    String titulo;

    @NotBlank(message = "El contenido es obligatorio.")
    String contenido;


    @NotNull(message = "Ingrese una fecha.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    Usuario usuario;

}

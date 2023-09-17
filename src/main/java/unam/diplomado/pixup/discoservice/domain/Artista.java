package unam.diplomado.pixup.discoservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "artistas")
public class Artista {
	
	@Id
	private String id;
	@NotBlank(message = "El nombre no puede estar en blanco")
	@NotNull(message = "El nombre no puede ser nulo")
	@Valid
	private String nombre;

}

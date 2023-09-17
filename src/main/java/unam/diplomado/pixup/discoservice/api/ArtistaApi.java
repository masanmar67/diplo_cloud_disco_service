package unam.diplomado.pixup.discoservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import unam.diplomado.pixup.discoservice.domain.Artista;

@RequestMapping(path = "api/artistas", produces = "application/json")
@CrossOrigin("*")
public interface ArtistaApi {

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	Artista crearArtista(@RequestBody Artista artista);

	@PutMapping(path = "{id}", consumes = "application/json")
	ResponseEntity<Artista> actualizarArtista(
			@PathVariable("id") String id, @RequestBody Artista artista);
	
	@GetMapping("{id}")
	ResponseEntity<Artista> artistaPorId(@PathVariable("id") String id);
	
	@GetMapping
	Iterable<Artista> obtenerArtistas();
	
	@DeleteMapping("{id}")
	ResponseEntity<?> eliminarArtista(@PathVariable("id") String id);

}

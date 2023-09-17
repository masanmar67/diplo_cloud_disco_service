package unam.diplomado.pixup.discoservice.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pixup.discoservice.domain.Artista;
import unam.diplomado.pixup.discoservice.repository.ArtistaRepository;
import unam.diplomado.pixup.discoservice.service.ArtistaService;

@RestController
@RequestMapping(path = "api/artistas", produces = "application/json")
@CrossOrigin(origins = "*")
public class ArtistaController implements ArtistaApi {
	
	@Autowired
	private ArtistaRepository artistaRepository;
	@Autowired
	private ArtistaService artistaService;
	
	@Override
	public Artista crearArtista(Artista artista) {
		return artistaService.registrarArtista(artista);
	}

	@Override
	public ResponseEntity<Artista> actualizarArtista(String id, Artista artista){
		Artista artistaActualizado = artistaService.actualizarArtista(id, artista);
		if(artistaActualizado != null) {
			return new ResponseEntity<Artista>(artistaActualizado, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<Artista> artistaPorId(@PathVariable("id") String id) {
		Optional<Artista> artista = artistaRepository.findById(id);
		if(artista.isPresent()) {
			return new ResponseEntity<Artista>(artista.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@Override
	public Iterable<Artista> obtenerArtistas(){
		return artistaRepository.findAll();
	}
	
	@Override
	public ResponseEntity eliminarArtista(String id) {
		Optional<Artista> artista = artistaRepository.findById(id);
		if(artista.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		artistaRepository.deleteById(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}

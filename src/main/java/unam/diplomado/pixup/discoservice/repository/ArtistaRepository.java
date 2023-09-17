package unam.diplomado.pixup.discoservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixup.discoservice.domain.Artista;
import java.util.List;


public interface ArtistaRepository 
	extends MongoRepository<Artista, String>{
	
	Optional<Artista> findByNombre(String nombre);

}

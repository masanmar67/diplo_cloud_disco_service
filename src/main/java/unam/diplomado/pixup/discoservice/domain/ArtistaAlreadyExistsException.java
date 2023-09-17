package unam.diplomado.pixup.discoservice.domain;

public class ArtistaAlreadyExistsException extends RuntimeException{
	
	public ArtistaAlreadyExistsException(String nombre) {
		super("Ya existe un artista con el nombre " + nombre);
	}

}

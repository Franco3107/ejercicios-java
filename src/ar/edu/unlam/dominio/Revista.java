package ar.edu.unlam.dominio;


public class Revista extends Material{
	public Revista(String titulo, String autor) {
		super(titulo, autor);
	}

	@Override
	public String mostrarInfo() {		
		return "[Titulo: "+ getTitulo() + ", Autor: " + getAutor() + " ] ";
	}
	
}

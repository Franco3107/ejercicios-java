package ar.edu.unlam.dominio;

import java.util.Objects;

public abstract class Material {
	private Integer id=0;
	private static Integer ContadorId =1;
	private String titulo;
	private String autor;
	
	public Material(String titulo, String autor) {
		this.id=ContadorId++;
		this.titulo=titulo;
		this.autor=autor;
	}	
	@Override
	public int hashCode() {
		return Objects.hash(autor, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(titulo, other.titulo);
	}
	
	// GETTER AND SETTER
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	
	public Integer getId() {
		return id;
	}
	public abstract String mostrarInfo();
}


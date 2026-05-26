package ar.edu.unlam.dominio;

import ar.edu.unlam.interfaces.Prestable;

public class Libro extends Material implements Prestable {
	private Boolean disponible;
	
	public Libro(String titulo, String autor){
		super(titulo, autor);
		this.disponible=true;
	}
	@Override
	public String mostrarInfo() {	
		return "[ Titulo: "+ getTitulo() + ", Autor: " + getAutor() + " ] ";
	}
	
	// GETTER AND SETTER
	
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	@Override
	public Boolean prestar() {
		if(this.disponible) {
			this.disponible=false;
			return true;
		}
		return false;
	}
	@Override
	public Boolean devolver() {
		if(!this.disponible) {
			this.disponible=true;
			return true;
		}
		return false;
	}
}

package ar.edu.unlam.main;

import ar.edu.unlam.dominio.Biblioteca;
import ar.edu.unlam.dominio.Libro;
import ar.edu.unlam.dominio.Revista;

public class Main {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();

        Libro l1 = new Libro("Harry Potter", "Rowling");
        Revista r1 = new Revista("National Geographic", "NG");

        biblioteca.agregarMaterial(l1);
        biblioteca.agregarMaterial(r1);

        System.out.println(biblioteca.mostrarMateriales());

        biblioteca.prestarLibro(l1.getId());

        System.out.println(biblioteca.mostrarMateriales());
	}

}

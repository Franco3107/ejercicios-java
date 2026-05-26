package ar.edu.unlam.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.dominio.Biblioteca;
import ar.edu.unlam.dominio.Libro;
import ar.edu.unlam.dominio.Revista;
import ar.edu.unlam.dominio.Usuario;

public class BibliotecaTest {
	
	@Test
	public void DadoQueseCreoUnaBibliotecaAgregarUnLibroYNoSeDebeAdmitirDuplicados() {
		Biblioteca b1 = new Biblioteca();
		Libro l1 = new Libro("TITULO", "NOMBRE DEL AUTOR");
		Libro l2 = new Libro("TITULO", "NOMBRE DEL AUTOR");
		Libro l3 = new Libro("TITULO2", "NOMBRE DEL SEGUNDO AUTOR");
		
		b1.agregarLibro(l1);
		b1.agregarLibro(l2);
		b1.agregarLibro(l3);
		
		assertEquals(2,b1.getMateriales().size());
	}
	@Test
	public void DadoQueseCreoUnaBibliotecaAgregarUnaRevistaYNoSeDebeAdmitirDuplicados() {
		Biblioteca b1 = new Biblioteca();
		Revista r1 = new Revista("TITULO", "NOMBRE DEL AUTOR");
		Revista r2 = new Revista("TITULO", "NOMBRE DEL AUTOR");
		Revista r3 = new Revista("TITULO2", "NOMBRE DEL SEGUNDO AUTOR");
		
		b1.agregarRevista(r1);
		b1.agregarRevista(r2);
		b1.agregarRevista(r3);
		
		assertEquals(2,b1.getMateriales().size());
	}
	@Test
	public void DadoQueseCreoUnaBibliotecaAgregarUnUsuarioYNoSeDebeAdmitirDuplicados() {
		Biblioteca b1 = new Biblioteca();
		Usuario u1 = new Usuario(111, "NOMBRE USUARIO");
		Usuario u2 = new Usuario(111, "NOMBRE USUARIO");
		Usuario u3 = new Usuario(222, "NOMBRE SEGUNDO USUARIO");
		
		b1.agregarUsuario(u1);
		b1.agregarUsuario(u2);
		b1.agregarUsuario(u3);
		
		assertEquals(2,b1.getUsuarios().size());
	}
	@Test
	public void DadoQueSeCreoUnaBibliotecaMostrarLaListaDeMaterialesAgregados() {
		Biblioteca b1 = new Biblioteca();
		Revista r1 = new Revista("Titulo", "Nombre Autor");
		Libro l1 = new Libro("Titulo Libro", "Nombre Autor Libro");
		
		b1.agregarLibro(l1);
		b1.agregarRevista(r1);
		String textoDeseado = "[Titulo: Titulo, Autor: Nombre Autor ] [ Titulo: Titulo Libro, Autor: Nombre Autor Libro ] ";
		
		assertEquals(textoDeseado, b1.mostrarMateriales());
	}
	@Test
	public void DadoQueSeCreoUnaBibliotecaMostrarLaListaDeUsuariosAgregados() {
		Biblioteca b1 = new Biblioteca();
		Usuario u1 = new Usuario(111, "NOMBRE USUARIO");
		
		b1.agregarUsuario(u1);
		String textoDeseado = "[Usuario: dni=111, nombre=NOMBRE USUARIO] ";
		
		assertEquals(textoDeseado, b1.mostrarUsuario());
	}
	@Test
	public void DadoQueseCreoUnaBibliotecaAgregarLibrosYDespuesBuscarPorSuID() {
		Biblioteca b1 = new Biblioteca();
		// EL ID SE AGREGA POR EL ORDEN EN EL QUE SE AGREGAN A LA BIBLIOTECA.
		Libro l1 = new Libro("TITULO", "NOMBRE DEL AUTOR"); // 1
		Libro l2 = new Libro("TITULO2", "NOMBRE DEL SEGUNDO AUTOR"); // 2
		Libro l3 = new Libro("TITULO3", "NOMBRE DEL TERCER AUTOR"); // 3
		
		b1.agregarLibro(l1);
		b1.agregarLibro(l2);
		b1.agregarLibro(l3);
		
		assertEquals(l1,b1.buscarLibroPorID(2));
		assertEquals(l2,b1.buscarLibroPorID(3));
		assertEquals(l3,b1.buscarLibroPorID(4));
	}
	@Test
	public void DadoQueSeCreoUnaBibliotecaPrestarUnMaterialQueSeaPrestableParaElloLaDisponiblidadDeberiaPasarAFalse() {
		Biblioteca b1 = new Biblioteca();
		Libro l1 = new Libro("TITULO", "NOMBRE DEL AUTOR"); // 1
		
		b1.agregarLibro(l1);
		b1.prestarLibro(1);
		
		assertNotEquals(true, b1.prestarLibro(1));
		
	}
	@Test
	public void DadoQueSeCreoUnaBibliotecaDevolverUnMaterialQueSeaPrestableParaElloLaDisponiblidadDeberiaPasarTrue() {
		Biblioteca b1 = new Biblioteca();
		Libro l1 = new Libro("TITULO", "NOMBRE DEL AUTOR"); // 1
		
		b1.agregarLibro(l1);
		b1.devolverLibro(1);
		
		assertNotEquals(false, b1.devolverLibro(1));
		
	}
	
	
	
	
	
	
	
	
	
}

package ar.edu.unlam.main;

import java.util.Scanner;

import ar.edu.unlam.dominio.Biblioteca;
import ar.edu.unlam.dominio.Libro;
import ar.edu.unlam.dominio.Material;
import ar.edu.unlam.dominio.Revista;
import ar.edu.unlam.dominio.Usuario;
import ar.edu.unlam.enums.MenuPrincipal;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
	    Biblioteca biblioteca = new Biblioteca();
	    Integer opcion;
	    do {
	    	mostrarMensaje(MenuPrincipal.obtenerMenu());
	    	opcion= teclado.nextInt();
	    	switch (opcion) {
			case 1:
				registrarUsuario(teclado, biblioteca);
				break;
			case 2:
				crearMaterial(teclado, biblioteca);
				break;
			case 3: 
				mostrarUsuarios(biblioteca);
				break;
			case 4:
				mostrarMateriales(biblioteca);
				break;
			case 5:
				buscarMaterialID(biblioteca, teclado);
				break;
			case 6:
				prestarMaterial(biblioteca, teclado);
				break;
			case 7:
				devolverMaterial(biblioteca,teclado);
				break;
			case 8:
				mostrarMensaje("Saliendo del programa.....");
				break;
			default:
				mostrarMensaje("OPCION INAVLIDA. INTENTELO DE NUEVO :)");
				break;
			}
	    	
	    } while (opcion!=8);
	}
	
	private static void devolverMaterial(Biblioteca biblioteca, Scanner teclado) {
		// TODO Auto-generated method stub
		
	}

	private static void prestarMaterial(Biblioteca biblioteca, Scanner tc) {
		if(!biblioteca.getMateriales().isEmpty()) {
			mostrarMensaje("¿QUE QUIERE CREAR?: \n1-libro \n2-revista");
			mostrarMensaje(biblioteca.mostrarMateriales());
			Integer opcion = tc.nextInt();
			switch (opcion) {
			case 1:
				crearLibro(tc, biblioteca);
				break;
			case 2:
				crearRevista(tc, biblioteca);
			default:
				break;
			}
		} else {
			mostrarMensaje("NO HAY NINGUN MATERIAL PARA PRESTAR");
		}
	}

	private static void buscarMaterialID(Biblioteca biblioteca, Scanner tc) {
		mostrarMensaje("INGRESE EL ID DEL MATERIAL A BUSCAR: ");
		Integer id=tc.nextInt();
		Material materialBuscado= biblioteca.buscarMaterialPorId(id);
		if(materialBuscado!=null) {
			mostrarMensaje(materialBuscado.mostrarInfo());
		}else {
			mostrarMensaje("NO EXISTE NINGUN MATERIAL CON ESE ID");
		}
	}

	private static void mostrarMateriales(Biblioteca biblioteca) {
		if(!biblioteca.getMateriales().isEmpty()) {
			mostrarMensaje(biblioteca.mostrarMateriales());			
		} else {
			mostrarMensaje("TODAVIA NO SE AGREGADO NINGUN MATERIAL :(");
		}
	}

	private static void mostrarUsuarios(Biblioteca biblioteca) {
		if(!biblioteca.getUsuarios().isEmpty()) {			
			mostrarMensaje(biblioteca.mostrarUsuarios());
		} else {
			mostrarMensaje("TODAVIA NO SE AGREGO NINGUN USUARIO :(");
		}
	}

	public static void registrarUsuario(Scanner tc, Biblioteca biblioteca) {
		mostrarMensaje("Ingrese el DNI del usuario a registrar");
		Integer dni = tc.nextInt();
		
		tc.nextLine(); //LIMPIA BUFFER
		
		mostrarMensaje("Ingrese el Nombre del usuario a registrar");
		String nombre = tc.nextLine();
		
		Usuario usuarioNuevo = new Usuario(dni, nombre);
		
		if(biblioteca.agregarUsuario(usuarioNuevo)) {
			mostrarMensaje("Se agrego el usuario correctamente");
		} else {
			mostrarMensaje("El usuario ya existe. Intente otro");
		}	
	}
	public static void crearMaterial(Scanner tc , Biblioteca biblioteca) {
		mostrarMensaje("¿QUE QUIERE CREAR?: \n1-libro \n2-revista");
		Integer opcion = tc.nextInt();
		switch (opcion) {
		case 1:
			crearLibro(tc, biblioteca);
			break;
		case 2:
			crearRevista(tc, biblioteca);
		default:
			break;
		}
	}
	public static void crearLibro(Scanner tc, Biblioteca biblioteca) {
		tc.nextLine(); //limpia buffer
		mostrarMensaje("INGRESE EL TITULO");
		String titulo=tc.nextLine();
		mostrarMensaje("INGRESE EL AUTOR");
		String autor=tc.nextLine();
		Libro l1 = new Libro(titulo,autor);
		biblioteca.agregarMaterial(l1);
	}
	public static void crearRevista(Scanner tc, Biblioteca biblioteca) {
		tc.nextLine(); //LIMPIA BUFFER
		mostrarMensaje("INGRESE EL TITULO");
		String titulo=tc.nextLine();
		mostrarMensaje("INGRESE EL AUTOR");
		String autor=tc.nextLine();
		Revista r1 = new Revista(titulo,autor);
		biblioteca.agregarMaterial(r1);
	}

	
	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}

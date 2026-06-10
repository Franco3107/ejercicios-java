package ar.edu.unlam.enums;


public enum MenuPrincipal {
	CREAR_USUARIO (1, "CREAR USUARIO"),
	CREAR_MATERIAL (2, "CREAR MATERIAL"),
	MOSTRAR_USUARIOS (3, "MOSTRAR USUARIOS"),
	MOSTRAR_MATERIAL (4, "MOSTRAR MATERIAL"),
	BUSCAR_MATERIAL_POR_ID (5, "BUSCAR MATERIAL POR EL ID"),
	PRESTAR_MATERIAL (6, "PRESTAR MATERIAL"),
	DEVOLVER_MATERIAL (7, "DEVOLVER MATERIAL"),
	SALIR (8, "SALIR DEL PROGRAMA");
	
	private Integer indice;
	private String descripcion;
	
	private MenuPrincipal(Integer indice, String descripcion) {
		this.indice=indice;
		this.descripcion=descripcion;
	}
	
	public static String obtenerMenu() {
		String menuObtenido=  "💥 Ingrese una opcion:";
		MenuPrincipal[] menu = MenuPrincipal.values();
		for (MenuPrincipal opcion : menu) {
			menuObtenido += "\n" + opcion.getIndice() + ". " + opcion.getDescripcion();
		}
		return menuObtenido;
	}
//     GETTER AND SETTER
	public Integer getIndice() {
		return indice;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
}

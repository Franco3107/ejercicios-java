	package ar.edu.unlam.dominio;
	
	import java.util.HashSet;
	
	import ar.edu.unlam.interfaces.Prestable;
	
	public class Biblioteca {
		private HashSet<Usuario>usuarios;
		private HashSet<Material>materiales;
		
		public Biblioteca() {
			this.usuarios= new HashSet<>();
			this.materiales= new HashSet<>();
		}
		public Boolean agregarMaterial(Material materialNuevo) {
			if(materialNuevo==null) {
				throw new IllegalArgumentException("El material no puede ser null");
			}
			return this.materiales.add(materialNuevo);
		}
		public Boolean agregarUsuario(Usuario usuarioNuevo) {
			if(usuarioNuevo==null) {
				throw new IllegalArgumentException("El usuario no puede ser null");
			}
			return this.usuarios.add(usuarioNuevo);
		}
		public Libro buscarLibroPorID(Integer id){
			for (Material material : materiales) {
				if (material instanceof Libro) {
					if (id.equals(material.getId())) {
						return (Libro) material;
					}
				}
			}
			return null;
	
		}
		public Material buscarMaterialPorId(Integer id) {
			for (Material material : materiales) {
				if(id.equals(material.getId())) {
					return material;
				}
			}
			return null;
		}
		public Boolean prestarLibro(Integer id){
			for (Material material : materiales) {
				if(material instanceof Prestable) {
					if (material instanceof Libro && id.equals(material.getId())){
						Prestable libroPrestado = (Prestable) material;
						return libroPrestado.prestar();
						}
					}
				}
			return false;
		}
		public Boolean devolverLibro(Integer id) {
			for (Material material : materiales) {
				if(material instanceof Prestable) {
					if (material instanceof Libro && id.equals(material.getId())){
						Prestable libroPrestado = (Prestable) material;
						return libroPrestado.devolver();
						}
					}
				}
			return false;
		}
		public String mostrarMateriales() {
			String listaDeMateriales="";
			for (Material material : materiales) {
				listaDeMateriales += material.mostrarInfo();
				}
			return listaDeMateriales;
			}
		public String mostrarUsuarios() {
			String listaDeUsuarios="";
			for (Usuario usuario : usuarios) {
				listaDeUsuarios += usuario.toString();
				}
			return listaDeUsuarios;
		}
		// GETTER AND SETTER
		public HashSet<Usuario> getUsuarios() {
			return usuarios;
		}
	
		public HashSet<Material> getMateriales() {
			return materiales;
		}
		
		
		
	
	}

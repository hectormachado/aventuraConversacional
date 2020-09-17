package aventuraConv;

import java.util.ArrayList;

public class cMapa {
	
	private int id;
	private String nombre;
	private String descripcion;
	private ArrayList<cItems> itemsZona = new ArrayList<cItems>();
	
	private cMapa arriba;
	private cMapa abajo;
	private cMapa izquierda;
	private cMapa derecha;
	private cMapa subir;
	private cMapa bajar;
	
	private boolean luz;
	private boolean existeItem;
	
	private boolean arribaB;
	private boolean abajoB;
	private boolean izquierdaB;
	private boolean derechaB;
	private boolean subirB;
	private boolean bajarB;

	public cMapa(String nombre, String descripcion, boolean luz) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setLuz(luz);
	}

	public String infoZona() {
		
		return "\n" + nombre + "\n" + descripcion + "\n";
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the arriba
	 */
	public cMapa getArriba() {
		return arriba;
	}

	/**
	 * @param arriba the arriba to set
	 */
	public void setArriba(cMapa zona) {
		this.arriba = zona;
	}

	/**
	 * @return the abajo
	 */
	public cMapa getAbajo() {
		return abajo;
	}

	/**
	 * @param abajo the abajo to set
	 */
	public void setAbajo(cMapa zona) {
		this.abajo = zona;
	}

	/**
	 * @return the izquierda
	 */
	public cMapa getIzquierda() {
		return izquierda;
	}

	/**
	 * @param izquierda the izquierda to set
	 */
	public void setIzquierda(cMapa zona) {
		this.izquierda = zona;
	}

	/**
	 * @return the derecha
	 */
	public cMapa getDerecha() {
		return derecha;
	}

	/**
	 * @param derecha the derecha to set
	 */
	public void setDerecha(cMapa zona) {
		this.derecha = zona;
	}

	/**
	 * @return the subir
	 */
	public cMapa getSubir() {
		return subir;
	}

	/**
	 * @param subir the subir to set
	 */
	public void setSubir(cMapa zona) {
		this.subir = zona;
	}

	/**
	 * @return the bajar
	 */
	public cMapa getBajar() {
		return bajar;
	}

	/**
	 * @param bajar the bajar to set
	 */
	public void setBajar(cMapa zona) {
		this.bajar = zona;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the luz
	 */
	public boolean isLuz() {
		return luz;
	}

	/**
	 * @param luz the luz to set
	 */
	public void setLuz(boolean luz) {
		this.luz = luz;
	}
	
	public boolean hayLuzONo() {
		boolean estado;
		
		if(this.luz==false) {
			estado=false;
		}else {
			estado=true;
		}
		return estado;
	}
	
	public boolean miraSiTengoArriba(){
		
		boolean vamosAver;
		
		if(this.arriba != null) {
			vamosAver = true;
		}
		else {
			vamosAver=false;
		}
		return vamosAver;
	}
	
	public boolean miraSiTengoAbajo(){
			
			boolean vamosAver;
			
			if(this.abajo != null) {
				vamosAver = true;
			}
			else {
				vamosAver=false;
			}
			return vamosAver;
		}
	
	public boolean miraSiTengoIzquierda(){
		
		boolean vamosAver;
		
		if(this.izquierda != null) {
			vamosAver = true;
		}
		else {
			vamosAver=false;
		}
		return vamosAver;
	}
	
	public boolean miraSiTengoDerecha(){
		
		boolean vamosAver;
		
		if(this.derecha != null) {
			vamosAver = true;
		}
		else {
			vamosAver=false;
		}
		return vamosAver;
	}
	
	public boolean miraSiPuedoSubir(){
		
		boolean vamosAver;
		
		if(this.subir != null) {
			vamosAver = true;
		}
		else {
			vamosAver=false;
		}
		return vamosAver;
	}
	
	public boolean miraSiPuedoBajar(){
		
		boolean vamosAver;
		
		if(this.bajar != null) {
			vamosAver = true;
		}
		else {
			vamosAver=false;
		}
		return vamosAver;
	}
	
	public void ponerItemsArrayZona(cItems item) {
		
		itemsZona.add(item);
		
	}
	
	public void quitarItemsArrayZona(cItems item) {
			
			itemsZona.remove(item);
			
		}
	
	public void recorrerArrayZona() {
		System.out.println("Items Zona: \n");
/*
		for (cItems patata: itemsZona) {
			System.out.println(patata.getNombre());
		}
*/
		
		for (int a = 0; a < itemsZona.size(); a++ ) {
            System.out.print(" " + itemsZona.get(a).getNombre());
        }
		System.out.println();
	}

	

}

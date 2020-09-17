package aventuraConv;

import java.util.ArrayList;

public class cPersonaje {
	
	private String nombre;
	private cMapa posicion;
	private ArrayList<cItems> mochila = new ArrayList<cItems>();
	private boolean alto;

	/**
	 * @return the posicion
	 */
	public cMapa getPosicion() {
		return posicion;
	}

	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(cMapa posicion) {
		this.posicion = posicion;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void ponerItemsArrayJugador(cItems item) {
		
		mochila.add(item);
		
	}
	
	public void quitarItemsArrayJugador(cItems item) {
			
		mochila.remove(item);
			
		}
	public void recorrerArrayPersonaje() {
		System.out.println("Items: ");
		
		for (cItems patata: mochila) {
			System.out.println(patata.getNombre());
		}
	System.out.println();
	}
	public void vaciarArrayList() {
		mochila.removeAll(mochila);
	}
	public boolean isAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(boolean alto) {
		this.alto = alto;
	}	
	public boolean bajoAlto() {
		boolean estado;
		
		if(this.alto==false) {
			estado=false;
		}else {
			estado=true;
		}
		return estado;
	}
	}

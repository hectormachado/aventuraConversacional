	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(cMapa posicion) {
		this.posicion = posicion;
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

	/**
	 * @return the tengo
	 */
	public boolean isTengo() {
		return tengo;
	}

	/**
	 * @param tengo the tengo to set
	 */
	public void setTengo(boolean tengo) {
		this.tengo = tengo;
	}
	
}

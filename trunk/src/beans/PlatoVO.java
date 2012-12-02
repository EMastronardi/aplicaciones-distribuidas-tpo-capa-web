package beans;

import java.io.Serializable;

public class PlatoVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idPlato;
	private String nombre;
	private float precio;
	private float comisionExtra;

	public PlatoVO(){}
	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getComisionExtra() {
		return comisionExtra;
	}

	public void setComisionExtra(float comisionExtra) {
		this.comisionExtra = comisionExtra;
	}	
}

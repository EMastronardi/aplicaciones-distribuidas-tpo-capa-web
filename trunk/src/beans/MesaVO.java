package beans;

import java.io.Serializable;

public class MesaVO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int idMesa;
	private int numero;
	private String estado;
	private int capacidad;
	private int capacidadMaxima;
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	public MesaVO(int idMesa, int numero, String estado, int capacidad,
			int capacidadMaxima) {
		super();
		this.idMesa = idMesa;
		this.numero = numero;
		this.estado = estado;
		this.capacidad = capacidad;
		this.capacidadMaxima = capacidadMaxima;
	}
	
	public MesaVO(){
		
	}
	

	

}

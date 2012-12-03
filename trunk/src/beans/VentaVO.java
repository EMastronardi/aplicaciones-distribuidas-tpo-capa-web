package beans;

import java.io.Serializable;


public class VentaVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idVenta;
	private int nroMesa;
	private String estado;
	
	public VentaVO() {}


	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNroMesa() {
		return nroMesa;
	}

	public int getIdVenta(){
		return this.idVenta;
	}
	public void setIdVenta(int id){
		this.idVenta = id;
	}
	public void setNroMesa(int nroMesa) {
		this.nroMesa = nroMesa;
	}
}

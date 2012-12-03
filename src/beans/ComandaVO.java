package beans;

import java.io.Serializable;
import java.util.Date;

public class ComandaVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idComanda;
	
	
	public ComandaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Date fecha;

	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}

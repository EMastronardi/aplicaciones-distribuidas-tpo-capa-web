package modelo;

import interfaz.InterfazRemota;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import beans.PlatoVO;
import beans.SucursalVO;

public class AdministradorRMI {
	private static AdministradorRMI instancia;
	private InterfazRemota lookup;

	private void ConectarRMI() {
		try {
			this.lookup = (InterfazRemota) Naming
					.lookup("//localhost:1099/Server");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static AdministradorRMI getInstancia() {
		if (instancia == null)
			instancia = new AdministradorRMI();
		return instancia;
	}

	private AdministradorRMI() {
	}

	public String obtenerCadena() throws RemoteException,
			MalformedURLException, NotBoundException {

		boolean ok = false;
		try {
			// System.setProperty("java.security.policy", "java.policy");

			InterfazRemota test = (InterfazRemota) Naming
					.lookup("//localhost:1099/Server");
			System.out.println("Conectado con servicio remoto.");
			ok = true;

			return "OK";

		} catch (Exception e) {
			System.out.println("No se pudo conectar con servicio remoto."
					+ "\n" + e.getMessage());
		}
		System.out.println("OK");
		return "no ok";

	}

	public boolean validarUsuario(String usuario, String contrasenia)
			throws RemoteException {
		boolean valido = false;
		if (lookup == null)
			this.ConectarRMI();
		valido = lookup.validarUsuario(usuario, contrasenia);
		return valido;
	}

	public List<SucursalVO> obtenerSucursales() throws RemoteException,
			MalformedURLException, NotBoundException {

		this.ConectarRMI();
		List<SucursalVO> lista = lookup.getSucursales();
		return lista;

	}

	public SucursalVO obtenerSucursal(String usuario) throws RemoteException {
		if (lookup == null)
			this.ConectarRMI();
		SucursalVO suc = lookup.getSucursal(usuario);

		return suc;
	}

	public List<PlatoVO> obtenerPlatos() throws RemoteException {
		if (lookup == null)
			this.ConectarRMI();
		List<PlatoVO> platos= lookup.getPlatos();

		return platos;
	}
}

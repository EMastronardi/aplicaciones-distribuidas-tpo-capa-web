package modelo;

import interfaz.InterfazRemota;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import beans.SucursalVO;

public class AdministradorSucursales {
	private static AdministradorSucursales instancia;
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

	public static AdministradorSucursales getInstancia() {
		if (instancia == null)
			instancia = new AdministradorSucursales();
		return instancia;
	}

	private AdministradorSucursales() {
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
	public boolean validarUsuario(String usuario, String contraseña) throws RemoteException{
		boolean valido = false;
		this.ConectarRMI();
		valido = lookup.validarUsuario(usuario, usuario);
		return valido;
	}
	public List<SucursalVO> obtenerSucursales() throws RemoteException,MalformedURLException, NotBoundException {

		this.ConectarRMI();
		List<SucursalVO> lista = lookup.getSucursales();

		return lista;

	}
}

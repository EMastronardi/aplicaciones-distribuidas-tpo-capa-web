package modelo;

import interfaz.InterfazRemota;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import entities.SucursalEntity;

import beans.SucursalVO;

public class AdministradorSucursales {
	private static AdministradorSucursales instancia;

	public static AdministradorSucursales getInstancia() {
		if (instancia == null)
			instancia = new AdministradorSucursales();
		return instancia;
	}

	private AdministradorSucursales() {
	}

	public String obtenerCadena() throws RemoteException, MalformedURLException, NotBoundException {

		System.setProperty("java.security.policy", "java.policy");
		boolean ok = false;
		try {
			System.setSecurityManager(new RMISecurityManager());
			InterfazRemota test = (InterfazRemota) Naming.lookup("//localhost/Server");
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

	public List<SucursalEntity> obtenerSucursales() throws RemoteException,
			MalformedURLException, NotBoundException {
		InterfazRemota lookup;
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		try {
			lookup = (InterfazRemota) Naming.lookup("//localhost:2005/Server");
			List<SucursalVO> lista = lookup.getSucursales();

			List<SucursalEntity> listaEntityes = new ArrayList<SucursalEntity>();
			for (SucursalVO s : lista) {
				SucursalEntity se = new SucursalEntity();
				se.setIdSucursal(s.getIdSucursal());
				se.setNombre(s.getNombre());
				listaEntityes.add(se);
			}

			return listaEntityes;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

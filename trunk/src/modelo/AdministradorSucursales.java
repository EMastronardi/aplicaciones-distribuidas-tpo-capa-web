package modelo;

import interfaz.InterfazRemota;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
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

	public List<SucursalEntity> obtenerSucursales() throws RemoteException,MalformedURLException, NotBoundException {
		InterfazRemota lookup = (InterfazRemota) Naming.lookup("//localhost/Server");
		List<SucursalVO> lista = lookup.getSucursales();
		for (SucursalVO sucursalVO : lista) {
			System.out.println(sucursalVO.getNombre());
		}
		List<SucursalEntity> listaEntityes = new ArrayList<SucursalEntity>();
		for (SucursalVO s : lista) {
			SucursalEntity se = new SucursalEntity();
			se.setIdSucursal(s.getIdSucursal());
			se.setNombre(s.getNombre());
			listaEntityes.add(se);
		}
		return listaEntityes;
	}
}

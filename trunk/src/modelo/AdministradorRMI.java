package modelo;

import interfaz.InterfazRemota;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import beans.ComandaVO;
import beans.PlatoVO;
import beans.SucursalVO;
import beans.VentaVO;

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

	public String abrirMesa(String nombreSucursal, String nrosMesas, String cantComenzales, String nombreMozo) throws NumberFormatException, RemoteException {
		if(lookup == null)
			this.ConectarRMI();
		List<Integer> listaNros = new ArrayList<Integer>();
		String[] lista = nrosMesas.split(",");
		for (String string : lista) {
			int valor = Integer.parseInt(string);
			listaNros.add(valor);
		}
		if(lookup.abrirMesa(nombreSucursal, listaNros, nombreMozo, Integer.parseInt(cantComenzales))){
			return "Mesa Abierta";
		}else
			return "Error al abrir Mesa";
	}

	public List<PlatoVO> obtenerPlatos(String sucursal) throws RemoteException {
		if (lookup == null)
			this.ConectarRMI();
		List<PlatoVO> platos= lookup.getPlatos(sucursal);

		return platos;
	}

	public String cerrarVenta(String sucursal, String mesa) throws NumberFormatException, RemoteException {
		if (lookup == null)
			this.ConectarRMI();
		boolean resultado = lookup.cerrarVenta(sucursal, Integer.parseInt(mesa));
		return null;
	}
	
	public List<VentaVO> obtenerVentas(String sucursal, String usuario) throws RemoteException{
		if (lookup == null)
			this.ConectarRMI();
		List<VentaVO> lista = lookup.getVentasAbiertas(sucursal, usuario);
		return lista;
	}
	public boolean generarComanda(String sucursal, String nombre, Integer mesa, String[] platos, String[] cantidades) throws RemoteException{
		if (lookup == null)
			this.ConectarRMI();
		
		return lookup.generarComanda(sucursal,nombre, mesa, platos, cantidades);
	}
	public List<ComandaVO> obtenerComandasAbiertas(String sucursal) throws RemoteException{
		
		if (lookup == null)
			this.ConectarRMI();
		return lookup.getComandasAbiertas(sucursal);
		
	}

	public boolean confirmarComandaRealizada(String idComanda) throws RemoteException {
		if (lookup == null)
			this.ConectarRMI();
		return lookup.confirmarComandaRealizada(idComanda);
		
	}
}

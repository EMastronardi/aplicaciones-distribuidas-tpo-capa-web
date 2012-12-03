package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import beans.MesaVO;
import beans.PlatoVO;
import beans.SucursalVO;
import beans.VentaVO;


public interface InterfazRemota extends Remote{
	
	public boolean abrirMesa(String nombreSucursal, List<Integer> nrosMesas, String nombreMozo, int cantComenzales) throws RemoteException;
	public List<SucursalVO> getSucursales() throws RemoteException;
	public String getCadena() throws RemoteException;
	public boolean validarUsuario(String usuario, String usuario2)throws RemoteException;
	public SucursalVO getSucursal(String usuario) throws RemoteException;
	public List<PlatoVO> getPlatos(String sucursal) throws RemoteException;
	public List<VentaVO> getVentasAbiertas(String sucursal, String nombre)throws RemoteException;
	public boolean cerrarVenta(String sucursal, int nroMesa)throws RemoteException;
	
	
}

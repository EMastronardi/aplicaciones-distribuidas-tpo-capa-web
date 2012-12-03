package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import beans.MesaVO;
import beans.PlatoVO;
import beans.SucursalVO;


public interface InterfazRemota extends Remote{
	
	public boolean abrirMesa(String nombreSucursal, List<Integer> nrosMesas, String nombreMozo, int cantComenzales) throws RemoteException;
	public List<SucursalVO> getSucursales() throws RemoteException;
	public String getCadena() throws RemoteException;
	public boolean validarUsuario(String usuario, String usuario2)throws RemoteException;
	public SucursalVO getSucursal(String usuario) throws RemoteException;
	public List<PlatoVO> getPlatos() throws RemoteException;
	public List<MesaVO> getMesas(String sucursal) throws RemoteException;
	
	
}

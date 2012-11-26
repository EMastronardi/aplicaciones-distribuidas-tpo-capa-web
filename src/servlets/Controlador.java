package servlets;

import interfaz.InterfazRemota;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

	private static final long serialVersionUID = 1087702007634924546L;
	private static Controlador instancia;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String action = request.getParameter("action");
		String jspPage = "/Default.jsp";
		
		if((action == null) || action.length() < 1){
			action="default";
		}
		if("default".equals(action)){
			jspPage = "/Default.jsp";
		} else if ("abrirMesa".equals(action))
        {
			jspPage = "/AbrirMesa.jsp";
        }else if("abrirMesaServer".equals(action)){
        	List<Integer> listaMesas = new ArrayList<Integer>();
        	String[] nros= request.getParameter("nrosMesas").split(",");
        	for (String nro : nros) {
				listaMesas.add(Integer.parseInt(nro));
			}
        	int cantComenzales = Integer.parseInt(request.getParameter("cantComenzales"));
        	try {
				this.abrirMesaServer(request.getParameter("nombreSucursal"), listaMesas,request.getParameter("nombreMozo"), cantComenzales);
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
        	jspPage = "/Default.jsp";
        }
		
		
		dispatch(jspPage, request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (jsp != null) {
			/*
			 * Envía el control al JSP que pasamos como parámetro, y con los
			 * request / response cargados con los parámetros
			 */
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
	protected boolean abrirMesaServer(String nombreSucursal,List<Integer> nrosMesas,String nombreMozo, int cantComenzales) throws NotBoundException, ServletException, IOException{
		InterfazRemota lookup = (InterfazRemota) Naming.lookup("//localhost/Server");
		return lookup.abrirMesa(nombreSucursal, nrosMesas, nombreMozo, cantComenzales);
		
	}

}

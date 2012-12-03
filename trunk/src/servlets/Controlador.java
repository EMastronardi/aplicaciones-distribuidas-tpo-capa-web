package servlets;

import interfaz.InterfazRemota;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.SucursalVO;

import modelo.AdministradorRMI;

public class Controlador extends HttpServlet {

	private static final long serialVersionUID = 1087702007634924546L;
	private static Controlador instancia;
	protected String action = "";
	protected String jspPage = "";
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		action = request.getParameter("action");
		jspPage= "";
		

		if(action!=null && !action.equals("validarLogin"))
			validarSession(request);
		
		if((action == null) || action.length() < 1 ){
			action="default";
		}	
		
		if("default".equals(action)){
			jspPage = "/Default.jsp";
		} else if ("abrirMesa".equals(action))
        {
			jspPage = "/AbrirMesa.jsp";
        } else if("validarLogin".equals(action)){
        	String usuario = request.getParameter("usuario");
        	String password = request.getParameter("contrasenia");
        	if(AdministradorRMI.getInstancia().validarUsuario(usuario, password)){
        		SucursalVO suc = AdministradorRMI.getInstancia().obtenerSucursal(usuario);
        		HttpSession session = request.getSession();
        		session.setAttribute("usuario", usuario);
        		session.setAttribute("sucursal", suc.getNombre());
        		jspPage = "/Default.jsp";
        	}else{
        		jspPage="/Login.jsp";
        		response.addHeader("usuario", "invalido");
        	}
        } else if("salir".equals(action)){
        	jspPage="/Login.jsp";
        	request.getSession().setAttribute("usuario", null);
        	request.getSession().setAttribute("sucursal", null);
        } else if("confirmarAbrirMesa".equals(action)){
        	if(!request.getParameter("nrosMesa").equals(null) && !request.getParameter("nrosMesa").equals("")){
        		
        		if(!request.getParameter("cantComenzales").equals(null) && Integer.parseInt(request.getParameter("cantComenzales"))>0){
        			String resultadoAbrirMesa = AdministradorRMI.getInstancia().abrirMesa((String)request.getSession().getAttribute("sucursal"), request.getParameter("nrosMesa"), request.getParameter("cantComenzales"), (String)request.getSession().getAttribute("usuario"));
                	//request.setAttribute("mensaje", resultadoAbrirMesa);
        			jspPage = "/Default.jsp?mensaje="+resultadoAbrirMesa;
            			
        		}
        	}
        }
		
		dispatch(jspPage, request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void validarSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("usuario")== null || session.getAttribute("usuario").equals("")){
			jspPage = "/Login.jsp";
			action = "salir";
			
		}
	}
	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (jsp != null) {
			/*
			 * Envia el control al JSP que pasamos como par�metro, y con los
			 * request / response cargados con los par�metros
			 */
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
	

}

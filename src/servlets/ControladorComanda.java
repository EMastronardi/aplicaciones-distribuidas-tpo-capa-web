package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.AdministradorRMI;
import beans.PlatoVO;

public class ControladorComanda  extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Controlador instancia;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String action = request.getParameter("action");
		String jspPage = "/GenerarComanda.jsp";
		
		if((action == null) || action.length() < 1){
			action="default";
		}
		
		
		if("default".equals(action) || "salir".equals(action) || !this.valdiateSession(request)){
			jspPage = "/Login.jsp";
		} else if ("generarComanda".equals(action)){
			jspPage = "/GenerarComanda.jsp";
        }else if("confirmarComanda".equals(action)){
        	
        	String[] platos = request.getParameterValues("plato");
        	String[] cantidad = request.getParameterValues("cantidad");
        	Integer mesa = Integer.parseInt(request.getParameter("mesa"));
        	boolean resultado =AdministradorRMI.getInstancia().generarComanda((String)request.getSession().getAttribute("sucursal"), (String)request.getSession().getAttribute("usuario"), mesa, platos, cantidad);
        	if(resultado)
        		jspPage="/Default.jsp?mensaje=Comanda generada con exito!";
        	else
        		jspPage="/Default.jsp?mensaje=Comanda NO generada, error!";
        	
        	//jspPage="/ConfirmarComanda.jsp";
        }else if("confirmarComandaRealizada".equals(action)){
        	
        	jspPage = "/ConfirmarComanda.jsp";
        	
      	
        		
        }else if("confirmarComandaRealizada2".equals(action)){
        	
        	String idComanda = request.getParameter("comanda");
        	boolean resultado =AdministradorRMI.getInstancia().confirmarComandaRealizada(idComanda);
        	if(resultado)
        		jspPage="/Default.jsp?mensaje=Comanda confirmada con exito!";
        	else
        		jspPage="/Default.jsp?mensaje=Comanda NO confirmada, error!";
        }
		dispatch(jspPage, request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (jsp != null) {
			/*
			 * Env�a el control al JSP que pasamos como par�metro, y con los
			 * request / response cargados con los par�metros
			 */
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
	private  boolean valdiateSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		return (session.getAttribute("usuario") != null)?true:false;
		
	}
}

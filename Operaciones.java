package servlet;
import java.math.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.operaciones.modelo.Operacionesmatematicas;

/**
 * Servlet implementation class Operaciones
 */
@WebServlet("/Operaciones")
public class Operaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Operaciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Metodo Get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Operacionesmatematicas cuentitas;
		cuentitas= new Operacionesmatematicas();
		String snumero1;
		String snumero2;
		float fnumero1;
		float fnumero2;
		boolean isBigger=false;
		boolean isNegative=false;
		boolean isCalification=false;
		
		snumero1= request.getParameter("txtNumber1");
		snumero2= request.getParameter("txtNumber2");
		
		fnumero1= Float.parseFloat(snumero1);
		fnumero2= Float.parseFloat(snumero2);
		
		cuentitas.setNumero1(fnumero1);
		cuentitas.setNumero2(fnumero2);	
		
		response.getWriter().append("La suma es;"+cuentitas.suma()+"</br>");
		response.getWriter().append("La resta es;"+cuentitas.resta()+"</br>");
		response.getWriter().append("La multiplicacion es;"+cuentitas.multiplicar()+"</br>");
		response.getWriter().append("La division es;"+cuentitas.dividir()+"</br>");
		
		if(cuentitas.suma()>10.0)
		{
			response.sendRedirect("mayoria.jsp");
		}
		if(cuentitas.suma()<0)
		{
			response.sendRedirect("negativos.jsp");
		}
		if(cuentitas.suma()>0 && cuentitas.suma()<10)
		{
			response.sendRedirect("calificaciones.jsp");
		}
		}}

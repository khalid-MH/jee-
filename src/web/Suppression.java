package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Suppression
 */
@WebServlet("/Suppression")
public class Suppression extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suppression() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String w=request.getParameter("v"); //w recoint la valeur de la variable v, au début la variable est int 'consultation' mais quand on l'apporte on le transforme au String(chaine de caractere)
		
		String driver = "com.mysql.jdbc.Driver";
		String con = "jdbc:mysql://localhost:3306/atelier banque";
		String req = "delete from comptes where ncompte=?";
		try {
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(con, "root" ,"");
		PreparedStatement st=conn.prepareStatement(req);
		
		st.setInt(1, Integer.parseInt(w)); //on redonne à la variable son type d'origine(int)
		st.executeUpdate();
		response.sendRedirect("consultation.jsp"); //aprés la suppression, il revient à la page consultation
		}
		catch(Exception e){ 
			System.out.println(e.getMessage());
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Modification
 */
@WebServlet("/Modification")
public class Modification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vnc=request.getParameter("nc");
		String vs=request.getParameter("s");
		String vprop=request.getParameter("prop");
		String driver = "com.mysql.jdbc.Driver";
		String con = "jdbc:mysql://localhost:3306/atelier banque";
		String req = "update comptes set solde=?, proprietaire=? where ncompte=?";
		try {
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(con, "root" ,"");
		PreparedStatement st=conn.prepareStatement(req);
		st.setFloat(1, Float.parseFloat(vs));
		st.setString(2, vprop);
		st.setInt(3, Integer.parseInt(vnc)); //on redonne à la variable son type d'origine(int)
		st.executeUpdate();
		response.sendRedirect("consultation.jsp"); 
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

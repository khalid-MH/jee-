package ajout;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ajout
 */
@WebServlet("/Ajout")
public class Ajout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajout() {
        super();
        // TODO Auto-generated constructor stub
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		PrintWriter out=response.getWriter();
		String vsolde=request.getParameter("solde");
		String vprop=request.getParameter("prop");
		String driver = "com.mysql.jdbc.Driver";
		String con = "jdbc:mysql://localhost:3306/atelier banque";
		String req = "insert into comptes(solde, proprietaire) values(?,?)";
		try {
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(con, "root" ,"");
		PreparedStatement st=conn.prepareStatement(req);
		st.setDouble(1, Double.parseDouble(vsolde));
		st.setString(2, vprop);
		st.executeUpdate();
		response.sendRedirect("ajout.jsp");
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

package web;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Verification
 */
@WebServlet("/Verification")
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vlogin=request.getParameter("Login");
		String vpwd=request.getParameter("pwd");
		System.out.println(vlogin +"    "+vpwd);
		String driver = "com.mysql.jdbc.Driver";
		String con = "jdbc:mysql://localhost:3306/atelier banque";
		String req = "select * from users where login = ? and password = ?";
		try {
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(con, "root" ,"");
		PreparedStatement st=conn.prepareStatement(req);
		st.setString(1, vlogin);
		st.setString(2, vpwd);
		ResultSet res=st.executeQuery();
			if(res.next()) {    // si il a trouvé une valeur
				response.sendRedirect("ajout.jsp");
			}
			else{
				response.sendRedirect("index.jsp");
			}
			
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

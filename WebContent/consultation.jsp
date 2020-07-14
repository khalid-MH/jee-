<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<table>
<tr> <th colspan="4"> Consultation des comptes </th></tr>
<tr> <td> N compte </td> <td> Solde </td> <td> Propriétaire </td>
<td>Actions </td></tr>
<%
String driver = "com.mysql.jdbc.Driver";
String con = "jdbc:mysql://localhost:3306/atelier banque";
String req = "select * from comptes";
try {
Class.forName(driver);
Connection conn=DriverManager.getConnection(con, "root" ,"");
PreparedStatement st=conn.prepareStatement(req);
ResultSet res=st.executeQuery();
	while(res.next()) {
		int ncompte=res.getInt(1);
		Double solde=res.getDouble(2);
		String prop=res.getString(3);
		
		out.println("<tr><td>"+ncompte+"</td><td>"+solde+"</td><td>"+prop+"</td><td>"
		+"<a href='Suppression?v="+ncompte+"'><img src='delete.jpg'></a>"
		+"<a href='Modifier.jsp?v="+ncompte+"&w="+solde+"&u="+prop+"'><img src='update.jpg'></a>"+"</td></tr>"); //supression= page de servlet ?v=donner à la variable v, la valeur+ncompte+ 
	}
}
catch(Exception e){ 
	System.out.println(e.getMessage());
}
%>
</table>

</body>
</html>
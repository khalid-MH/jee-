<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<%
String nc=request.getParameter("v");
String s=request.getParameter("w");
String p=request.getParameter("u");

%>
<form method="get" action="Modification">
<table>
<tr> <th colspan="2"> Modification des comptes</th></tr>
<tr> <td> NCompte</td><td><input type="text" name="nc" value="<%=nc%>" readonly></td></tr>    
<tr> <td> Solde</td><td><input type="text" name="s" value="<%=s%>"></td></tr>
<tr> <td> Propriétaire</td><td><input type="text" name="prop" value="<%=p%>"></td></tr>
<tr> 
<td> <input type="submit" value="OK"></td>
<td> <input type="reset" value="Annuler"></td>
</tr>

</table>
</form>
</body>
</html>
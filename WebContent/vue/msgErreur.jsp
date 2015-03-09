<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erreur</title>
</head>
<body>


	<%
		// recuperation du message et affichage si il existe
		String msgErreur = (String) request.getAttribute("msgErreur");
		if (msgErreur != null) {
	%>
			<p><%=msgErreur%></p>
			<hr />
	<%	} %>
	
	
	
	
</body>
</html>
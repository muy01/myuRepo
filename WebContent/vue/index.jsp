<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/menu.css"/>
<script src="<%=request.getContextPath() %>/js/script.js"></script>
</head>



<body>


<nav>
	<ul id=menu>

        <li>
                <a href="#">ACCUEIL</a>
        </li>
        
        <li>
                <a href="#">CONTACTS</a>
                	<ul>
                		<li><a href="#">Stagiaires</a></li>
                		<li><a href="#">Professionnels</a></li>
                		<li><a href="#">Entreprises</a></li>
                	</ul>
        </li>
        
        <li>
                <a href="#">RECHERCHE STAGES</a>
        </li>
        
        <li>
                <a href="#">CERTIFICATIONS</a>
                	<ul>
                		<li><a href="<%=request.getContextPath() %>/vue/evaluations.jsp">Evaluations</a></li>
                		<li><a href="<%=request.getContextPath() %>/vue/inscriptions.jsp">Inscriptions</a></li>
                		<li><a href="<%=request.getContextPath() %>/vue/enrg_res.jsp">Enregistrer des r&eacute;sultats</a></li>
                		<li><a href="<%=request.getContextPath() %>/vue/consult_res.jsp">Consulter des r&eacute;sultats</a></li>
                	</ul>
        </li>
        
        <li>
                <a href="#">PARCOURS PRO</a>
        </li>
        
        <li>
                <a href="#">DOCUMENTS</a>
        </li>
        
        <li>
                <a href="#">REFERENTIEL</a>
                	 <ul>
                		<li><a href="#">Titre</a></li>
                		<li><a href="#">CCP</a></li>
                		<li><a href="#">Section</a></li>
                	</ul>
        </li>    
	</ul>
</nav>






</body>
</html>
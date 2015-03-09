
<%@page import="java.util.Date"%>
<%@page import="z.exceptions.*"%>
<%@page import="z.tech.*"%>
<%@page import="certification.metierEjb.evaluation.Evaluation"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<% 
// Récupération de l'objet Eval et conversion pour affichage
	Evaluation ficheEval  =  (Evaluation) request.getAttribute("ficheEval");
	Integer osia 		  =  (Integer) ficheEval.getOsia();
	String label		  =  (String) ficheEval.getLabel();
	Date date 			  =  (Date) ficheEval.getDate();
	String sDate		  =  (String) Util.dateToString(date, "dd/MM/yyyy");
	String section 		  =  (String) ficheEval.getSection();
%>     
    
    
    
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/menu.css"/>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/gen.css"/>
<script src="<%=request.getContextPath() %>/js/script.js"></script>
</head>



<body>

<!-- MENU DE NAVIGATION-->
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
                		<li><a href="#">Evaluations</a></li>
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


<!-- FORMULAIRE CREATION-->

<section id= res>
	<div id=cadre>
		<h1>Evaluations</h1>
	</div>
	
	<div id=cadre2>
	<form id="form1" action="<%= request.getContextPath() %>/do/validModifEval" 
	method="post">
	
			<!-- Affichage de la ficheEval (click modifier) -->
			
			
			<fieldset><legend>Cr&eacute;er l'&eacute;valuation :</legend>
					<p>
					<input type="number" name="osia" id="field1" min = "1" value="<%=osia%>" /> OSIA
					</p>
					<p>
					<input type="text" name="label" id="field1" value="<%=label%>"/> Label
					</p>
					<p>
					<input type="date" name="dateval" id="field1" value="<%=sDate%>"/> Date
					</p>
					<p>
					<input type="text" name="section" id="field1" value="<%=section%>"/> Section
					</p>
				<select id="field1">
					<option  value="CDI2015">non implemente</option>
				</select>
					Section<br>
			
			
			<span>
				<input type="reset" value="Effacer"/> 
				<input type="submit" id="btnValidate" value="Valider les modifications" /><br>
			</span>
			
			</fieldset>	
		</form>
	</div>	
</section>	





</body>
</html>
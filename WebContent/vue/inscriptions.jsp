<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscriptions</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/menu.css"/>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/gen.css"/>
<script src="<%=request.getContextPath() %>/js/script.js"></script>
</head>



<body>

<section id= res>
<!-- MENU DE NAVIGATION-->
<nav>
	<ul id=menu>

        <li>
                <a href="<%=request.getContextPath() %>/vue/index.jsp">ACCUEIL</a>
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
                		<li><a href="#">Inscriptions</a></li>
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
</section>

<!-- FORMAULAIRE-->

<section id= res>
	<div id=cadre>
		<h1>Inscriptions</h1>
	</div>
	
	<div id=cadre2>
	<form id="form2" action="<%= request.getContextPath() %>/do/inscrire" method="post">
	
		
	
		
			<fieldset><legend>Choisir l'évaluation et le stagiaire :</legend>
			<p>
			Evaluation :
				<select id="field1">
					<option value="CDI2015">CDI2015</option>
					<option value="CDI2014">CDI2014</option>
					<option value="CDI2013">CDI2013</option>
				</select>
			</p>
			Stagiaire : 
				<select id="field1">
					<option value="Michel Paul">Michel Paul</option>
					<option value="Vagiti Violleta">Vagiti Violleta</option>
					<option value="Marou George">Marou George</option>
					<option value="Vinci Adam">Vinci Adam</option>
				</select>
			<p>
			</p>
			<span>
				<input type="reset" value="Effacer"/> 
				<input type="submit" id="btnValidate" value="Valider" /><br>
			</span>
			
			</fieldset>	
		</form>
	</div>	
</section>	

<section>		
	<div id=cadre2>
		<form id="form3" action="<%= request.getContextPath() %>/do/lister_inscription" method="post">	
			<fieldset><legend>Afficher les inscriptions:</legend>
			<p>
			Evaluation :
				<select id="field1">
					<option value="CDI2015">CDI2015</option>
					<option value="CDI2014">CDI2014</option>
					<option value="CDI2013">CDI2013</option>
				</select>
		
			<input type="submit" id="btnValidate" value="afficher les inscriptions" />
			</fieldset>
		</form>
	</div>
</section>				
				
			

	
</body>
</html>
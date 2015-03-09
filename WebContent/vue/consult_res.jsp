<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultats</title>
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
                		<li><a href="<%=request.getContextPath() %>/vue/evaluations.jsp">Evaluations</a></li>
                		<li><a href="<%=request.getContextPath() %>/vue/inscriptions.jsp">Inscriptions</a></li>
                		<li><a href="<%=request.getContextPath() %>/vue/enrg_res.jsp">Enregistrer des r&eacute;sultats</a></li>
                		<li><a href="#">Consulter des r&eacute;sultats</a></li>
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


<!-- FORMULAIRE-->

<section id= res>
	<div id=cadre>
		<h1>Consulter les résultats</h1>
	</div>
	
	<div id=cadre2>
	<form id="form1" action="<%= request.getContextPath() %>/do/consultResultat" method="post">
		
			<fieldset><legend>Rechercher:</legend>
			<p>
				<select id="field1">
					<option value="CDI2015">CDI2015</option>
					<option value="CDI2014">CDI2014</option>
					<option value="CDI2013">CDI2013</option>
				</select>
				Rechercher par Section 
			</p>
			<p>
				<select id="field1">
					<option value="Eval CDI 2015">CDI2015</option>
					<option value="Eval CDI 2014">CDI2014</option>
					<option value="Eval CDI 2013">CDI2013</option>
				</select>
				Rechercher par Evaluation 
			</p>
			<p>
				<select id="field1">
					<option value="Michel Paul">Michel Paul</option>
					<option value="Vagiti Violleta">Vagiti Violleta</option>
					<option value="Marou George">Marou George</option>
					<option value="Vinci Adam">Vinci Adam</option>
				</select>
				Rechercher par Stagiaire 
			</p>
			
			
			
			<span>
				<input type="reset" value="Effacer"/> 
				<input type="submit" id="btnValidate" value="Valider" /><br>
			</span>
			
			</fieldset>	
		</form>
	</div>	
</section>	

<!-- FORMULAIRE-->

<section>
	<div id=tableau>
	<form id="form2" action="<%= request.getContextPath() %>/do/delResultat" method="post">
		<caption>  R&eacute;sultat de la recherche :</caption>
			<table style="width:100%">
					<tr>
						<th>Suppr</th>
						<th>Osia</th>
						<th>Nom</th>
						<th>Pr&eacute;nom</th>
						<th>Section</th>
						<th>Evaluation</th>
						<th>CCP</th>
						<th>Date</th>
					</tr>
					<tr>
						<td><input type="submit" id="btnValidate" value="Suppr" /></td>
						<td>valeur</td>
						<td>valeur</td>
						<td>valeur</td>
						<td>valeur</td>
						<td>valeur</td>
						<td>valeur</td>
						<td>valeur</td>
					<tr>
					
					<tr>
						<td colspan="8">Pas de r&eacute;sultat</td>
					</tr>
			</table>		
				
	</div>
</section>

<section>
	<div id=cadre2>
	<form id="form3" action="<%= request.getContextPath() %>/do/updateResultat" method="post">
		<fieldset><legend>R&eacute;sultat de la recherche :</legend>
			
			<p><input type="submit" id="btnValidate" value="Modifier des résultats" /></p>	

		</fieldset>
	</div>
</section>





</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enregistrer resultats</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/menu.css"/>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/gen.css"/>
<script src="<%=request.getContextPath() %>/js/script.js"></script>
</head>



<body>

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
                		<li><a href="<%=request.getContextPath() %>/vue/inscriptions.jsp">Inscriptions</a></li>
                		<li><a href="#">Enregistrer des r&eacute;sultats</a></li>
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


<!-- FORMULAIRE-->
<section id= res>
	<div id=cadre>
		<h1>Enregistrer des résultats</h1>
	</div>
	
	<form id="form1" action="<%= request.getContextPath() %>/do/creerResultat" method="post">
	
		<div id=cadre2>
			<fieldset><legend>Choisir l'évaluation et le stagiaire :</legend>
			<p>
			Evaluation :
				<select id="field1">
					<option value="CDI2015">CDI2015</option>
					<option value="CDI2014">CDI2014</option>
					<option value="CDI2013">CDI2013</option>
				</select>

			Stagiaire : 
				<select id="field1">
					<option value="Michel Paul">Michel Paul</option>
					<option value="Vagiti Violleta">Vagiti Violleta</option>
					<option value="Marou George">Marou George</option>
					<option value="Vinci Adam">Vinci Adam</option>
				</select>
			</p>
			</fieldset>		
		</div>		
			
		<div id=cadre2>	
			<fieldset><legend>Choisir les CCP obtenus :</legend>
			
				<p><input type="checkbox" name="ccp1" value="ccp1">CCP1</p>
				<p><input type="checkbox" name="ccp2" value="ccp2">CCP2</p>
				<p><input type="checkbox" name="ccp3" value="ccp3">CCP3</p>
				<p><input type="checkbox" name="ccp4" value="ccp4">CCP4</p>
			</fieldset>
		</div>		
				
		<div id=cadre2>	
			<fieldset><legend>Saisir les préconisations du jury :</legend>
				<p><textarea name="message" rows="30" cols="120"></textarea></p>
			</fieldset>
		</div>					
		
		<div id=cadre2>				
			<span>
				<input type="reset" value="Effacer"/> 
				<input type="submit" id="btnValidate" value="Valider" />
			</span>
		</div>

	</form>



</section>





</body>
</html>
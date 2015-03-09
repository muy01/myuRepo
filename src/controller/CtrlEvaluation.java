package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;




import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import z.exceptions.ObjectExistException;
import certification.IGestionCertication;
import certification.metierEjb.evaluation.Evaluation;

/**
 * Servlet implementation class CtrlCertification
 * Controleur de l'UC4-1 Evaluation
 */
@WebServlet(
		name = "Gestion Controler", 
		description = "Controlleur des fonctionnalités de gestion des évaluations ", 
		urlPatterns = {"/eval/*"}
		)
public class CtrlEvaluation extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher 		disp;
	private IGestionCertication 	serviceEvaluation;
	//private String 					msgErreur 			= null;            




	/**
	 * Dispatcher de l'évaluation vers les méthodes de traitements
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("CTRL EVALUATION *****  doPost " );

		//Instanciation couche service
		getEJB();

					// Récupération de la méthode d'envoi de la requète
					//String methode = request.getMethod().toLowerCase() >> je passe directement en post

		// Récupération de l'action à exécuter
		String action = request.getPathInfo();

		//appelle des méthodes  pour traitements
		if (action == null) 		action = "/accueil";
		if (action.equals("/*"))	action = "/accueil";

		if (action.equals("/creerEval"))            doAddEvaluation(request, response);
		else if (action.equals("/listerEval"))      doGetEvaluations(request, response);
		else if (action.equals("/supprEval"))       doDeleteEvaluation(request, response);
		else if (action.equals("/modifEval"))       doGetEvaluation(request, response);
		else if (action.equals("/validModifEval"))	doUpdateEvaluation(request, response);

		else{
			doGoAccueil(request, response);
		}

	}




	/**
	 * Modifier une évaluation
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doUpdateEvaluation(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{ {

				System.out.println("CTRL EVALUATION *****  doUpdateEvaluation " );		

				//récupération des données
				String osia 	= request.getParameter("osia");
				String label 	= request.getParameter("label");
				String date		= request.getParameter("date");
				String section 	= request.getParameter("section");

								
				//Transfo string osia en int osia avant objet
				int osiaInt = 0;
				
				try{
					osiaInt = Integer.parseInt(osia);
				}catch (NumberFormatException nfe){
					System.out.println("Erreur de format");
					//la jsp pour l'erreur n'existe pas
					request.setAttribute("msgErreur", "Erreur de format ");
					disp = request.getRequestDispatcher("/vue/msgErreur.jsp");  	    	
					disp.forward(request,response);
				}



				//Transfo string date en Date date avant objet
				//Date dDate = Util.stringToDate(date, "dd/MM/yyyy") >> le parse ne marche pas on fera donc un new date a la place;
				Date dDate = new Date();
				System.out.println("parse date" + dDate);

				//Transfo en objet
				
				boolean creerEvalOk = true;
				
				if (creerEvalOk){

					Evaluation eval = new Evaluation(osiaInt, label, dDate, section);
					System.out.println("instanciation eval : " + eval);
					//envoie pour persistence
					serviceEvaluation.updateEvaluation(eval);

					//et le renvoyer a la JSP
					request.setAttribute("modifEval", eval);
					disp = request.getRequestDispatcher("/vue/evaluations.jsp");
					doGetEvaluations(request, response);
					
				}else{
				//	request.setAttribute("msgErreur", "Erreur de saisie ");
					disp = request.getRequestDispatcher("/vue/msgErreur.jsp");  	    	
					disp.forward(request,response);
				}
			}

	}




	/**
	 * Ajouter Créer une évaluation
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doAddEvaluation (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{

		System.out.println("CTRL EVALUATION *****  doAddEvaluation " );
		
	
			String osia 	= null;
			String label 	= null;
			String date		= null;
			String section 	= null;
			
			try{
			//récupération des données
			osia 		= request.getParameter("osia");
			label 		= request.getParameter("label");
			date		= request.getParameter("date");
			section 	= request.getParameter("section");
			
			}catch (Exception e){
				System.out.println("ERROR 250");
				
			}


			//Transfo string osia en int osia avant objet
			int osiaInt = 0; //init a 0 mais on vérirife 
			
			try{
				osiaInt = Integer.parseInt(osia);
				
			}catch (NumberFormatException nfe){
				
				System.out.println("ERROR 150");
				request.setAttribute("msgErreur", "Erreur de format ");
				disp = request.getRequestDispatcher("/vue/msgErreur.jsp");  	    	
				disp.forward(request, response);
			}


			//Transfo string date en Date date avant objet
			Date dDate = new Date();

			

			//Transfo en objet
			try{

				boolean creerEvalOk = true;
				if (creerEvalOk){

					Evaluation eval = new Evaluation(osiaInt, label, dDate, section);
					System.out.println("instanciation eval : " + eval);

					//envoie pour persistence

					serviceEvaluation.addEvaluation(eval);

					//et le renvoyer a la JSP
					disp = request.getRequestDispatcher("/vue/evaluations.jsp");
					doGetEvaluations(request, response);
				}

			}catch (ObjectExistException e){
				
				System.out.println("ERROR 100");
				request.setAttribute("msgErreur", "Cette évaluation existe déjà ");
				disp = request.getRequestDispatcher("/vue/msgErreur.jsp");  	    	
				disp.forward(request, response);
			}



	}


	/**
	 * Affichage d'une évaluation pour la modifier
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doGetEvaluation (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{

		String osia = request.getParameter("osia");

		//Transfo string osia en int osia avant objet
		int osiaInt = 0;
		
		try{
			osiaInt = Integer.parseInt(osia);
			
		}catch (NumberFormatException nfe){
			
			System.out.println("Erreur de format");
			//la jsp pour l'erreur n'existe pas
			request.setAttribute("msgErreur", "Erreur de format ");
			disp = request.getRequestDispatcher("/vue/msgErreur.jsp");  	    	
			disp.forward(request, response);
		}

		
		//Transfo en objet ET envoie en base
		boolean delEvalOK = true;		
		if (delEvalOK){
			
			Evaluation eval3 = new Evaluation(osiaInt);
			System.out.println("CtrlEvaluation **** updateEvaluation id : " + eval3 );
			serviceEvaluation.updateEvaluation(eval3);

			//Récupération 	des données
			Evaluation ficheEval = serviceEvaluation.getEvaluation(eval3);
			//et le renvoyer a la JSP
			request.setAttribute("ficheEval", ficheEval);
			disp = request.getRequestDispatcher("/vue/ficheEvaluation.jsp");
			disp.forward(request, response);
			
		}else{
			
			request.setAttribute("msgErreur", "Erreur de saisie ");
			disp = request.getRequestDispatcher("/vue/msgErreur");  	    	
			disp.forward(request,response);
		}

	}


	/**
	 * Supprimer une évaluation
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doDeleteEvaluation (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{

		String osia = request.getParameter("osia");

		//Transfo string osia en int osia avant objet
		int osiaInt = 0;
		
		try{
			osiaInt = Integer.parseInt(osia);
			
		}catch (NumberFormatException nfe){
			
			System.out.println("Erreur de format");
			//la jsp pour l'erreur n'existe pas
			request.setAttribute("msgErreur", "Erreur de format ");
			disp = request.getRequestDispatcher("/vue/msgErreur.jsp");  	    	
			disp.forward(request, response);
		}

		boolean delEvalOK = true;		
		if (delEvalOK){
			Evaluation eval2 = new Evaluation(osiaInt);
			System.out.println("evaluation id : " + eval2 );
			serviceEvaluation.deleteEvaluation(eval2);

			//et le renvoyer a la JSP
			disp = request.getRequestDispatcher("/vue/evaluations.jsp");
			doGetEvaluations(request, response);

		}else{
			request.setAttribute("msgErreur", "Erreur de saisie ");
			disp = request.getRequestDispatcher("/vue/msgErreur");  	    	
			disp.forward(request,response);
		}

	}



	/**
	 * Récupérer une liste d'évaluation
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doGetEvaluations (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{

		System.out.println("****************** methode doLister ************");

		List<Evaluation> liste = serviceEvaluation.getEvaluations();
		request.setAttribute("liste", liste);
		disp = request.getRequestDispatcher("/vue/evaluations.jsp");
		disp.forward(request, response);

	}




	/**
	 * Dispatch vers l'accueil
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void doGoAccueil(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(response.encodeRedirectURL("/GestionSectionClient/"));
	}

	/**
	 * Instanciation de la couche service
	 * si on decide de faire un controleur par UC alors il faudrait en le 
	 * mettre dans une autre classe
	 */
	private void getEJB() {
		// instanciation de la couche [service]
		InitialContext initialContext;

		// acces JNDI
		try {
			initialContext = new InitialContext();
			serviceEvaluation = (IGestionCertication) initialContext.lookup("ejb:/GestionSectionServer/GestionCertificationStateless!certification.IGestionCertication");

		}
		catch (Exception e) {
			System.out.println("Erreur acces EJB : " + e);
			
			
		}

	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}











}




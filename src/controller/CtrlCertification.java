package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controleur de l'UC4 Certification qui dispatch vers les :
 * controleur UC Evaluation: il n'y a que celui-la d'implementé
 * controleur UC Jury
 * controleur UC Resultat
 */
@WebServlet(
		name = "CtrlCertification", 
		description = "Controleur de l'UC Certification", 
		urlPatterns = {"/do/*"}
		)
public class CtrlCertification extends HttpServlet {

	private static final long serialVersionUID = 1L;





	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {

		try{

			System.out.println("*** CONTROLLER1  CERTIFICATION   ******   doPost");

			// Récupération de la méthode d'envoi de la requète
			String methode = request.getMethod().toLowerCase();

			// Récupération de l'action à exécuter et renvoie vers le controleur associé
			String action = request.getPathInfo();

			if (action == null) 		action = "/accueil";
			if (action.equals("/*"))	action = "/accueil";	

			try{
				if (action.equals("/creerEval")){
					try{
						System.out.println("test2");
						request.getRequestDispatcher("/eval/creerEval").forward(request, response);

					}catch (Exception e){
						System.out.println("ERROR 2");
					}
				}

				else if (action.equals("/listerEval")){
					try{
						request.getRequestDispatcher("/eval/listerEval").forward(request, response);

					}catch (Exception e){
						System.out.println("ERROR 3");
					}
				}
				else if (action.equals("/supprEval")){
					try{
						request.getRequestDispatcher("/eval/supprEval").forward(request, response);

					}catch (Exception e){
						System.out.println("ERROR 4");
					}
				}
				else if (action.equals("/modifEval")){
					try{
						request.getRequestDispatcher("/eval/modifEval").forward(request, response);

					}catch (Exception e){
						System.out.println("ERROR 5");
					}
				}
				else if (action.equals("/validModifEval")){
					try{
						request.getRequestDispatcher("/eval/validModifEval").forward(request, response);

					}catch (Exception e){
						System.out.println("ERROR 6");
					}
				}
				else if (action.equals("/accueil")) {
					try{
						doGoAccueil(request, response);

					}catch (Exception e){
						System.out.println("ERROR 7");
					}
				}
				else{
					doGoAccueil(request, response);
				}
			}catch (Exception e){
				System.out.println("ERROR 8");
			}


		}catch (Exception e ){
			System.out.println("je suis là");
		}

	}




	/**
	 * Transfert automatique en méthode post
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//tout en post
		doPost(request, response);
	}





	/**
	 * Dispatch vers l'accueil
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void doGoAccueil(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect(request.getContextPath() + "/vue/index.jsp");
	}

}













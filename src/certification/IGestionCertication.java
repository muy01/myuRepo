package certification;

import java.util.List;

import z.exceptions.ObjectExistException;
import certification.metierEjb.evaluation.Evaluation;

public interface IGestionCertication {

/*
 * METHODES EVALUATION
 */
	public void addEvaluation(Evaluation eval)throws ObjectExistException;
	public void updateEvaluation(Evaluation eval);
	public void deleteEvaluation(Evaluation eval);
	
	public Evaluation findEvaluationId(int osia);
	public Evaluation getEvaluation(Evaluation eval);
	public List<Evaluation> getEvaluations();
	
	
/*
 * METHODES JURY
*/


/*
 * METHODES RESULTATS EVAL
*/
}

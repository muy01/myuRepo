package certification.metierEjb.evaluation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * 
 */
@Entity
public class Evaluation implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	private int osia;
	private String label;
	private Date date;
	private String section;
	
	
	
	
	public Evaluation() {
		super();
	}

	
	/**
	 * Constructeur pour Créer en base
	 * @param osia
	 * @param label
	 * @param date
	 * @param section
	 */
	public Evaluation(int osia, String label, Date date, String section) {
		super();
		this.osia = osia;
		this.label = label;
		this.date = date;
		this.section = section;
	}


	/**
	 * Constructeur pour la recherche par Id
	 * @param osia
	 */
	public Evaluation(int osia) {
		super();
		this.osia = osia;
	}


	
	
@Override
	public String toString() {
		return "Evaluation [osia=" + osia + ", label=" + label + ", date="
				+ date + ", section=" + section + "]";
	}


	/*
 * GETTERS AND SETTERS
 */
	public int getOsia() {
		return osia;
	}


	public void setOsia(int osia) {
		this.osia = osia;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getSection() {
		return section;
	}


	public void setSection(String section) {
		this.section = section;
	}
	
	
	
	
	
	
	

}

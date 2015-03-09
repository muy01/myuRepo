package z.tech;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Classe utilitaire permettant de gérer les "dates" 
 * et String
 */
public class Util {

	// affichage message
	public static void afficheMessage(String strMessage)
	{
		System.out.println(strMessage);
	}
	// conversion Date to String
	/**
	 * String sFormat = "dd/MM/yy hh:mm";
	 * String sFormat = "dd/MM/yyyy";
	 * @param dDate
	 * @param sFormat
	 * @return
	 */
	public static String dateToString(Date dDate, String sFormat)  
	{
		// String sFormat = "dd/MM/yy hh:mm";
		// String sFormat = "dd/MM/yyyy";
		String sDate = "";
		SimpleDateFormat sdf;
		try {
			sdf = new SimpleDateFormat(sFormat);
			sDate = sdf.format(dDate);
		}
		catch (Exception e){
			sDate = "";
		}
		// System.out.println(sDate);
		return sDate;
	}
	//		 conversion String to Date
	public static Date stringToDate(String sDate, String sFormat)  
	{
		SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
		Date maDate;
		try {
			maDate = sdf.parse(sDate);
		} catch (ParseException e) {
			// le mois = mois - 1   <=>    0 => janvier
			maDate = new GregorianCalendar(1900,00,01).getTime();
		}
		return maDate;
	} 

	@SuppressWarnings("unused")
	private static boolean testDate (int year, int month, int day){ 
		
		// attention : le mois = mois - 1
		// 11 => décembre
		//  0 => janvier
		GregorianCalendar calendar = new GregorianCalendar(); 
		calendar.set(year, month, day); 
		int goodYear = calendar.get(Calendar.YEAR); 
		int goodMonth = calendar.get(Calendar.MONTH); 
		int goodDay = calendar.get(Calendar.DAY_OF_MONTH); 
//		System.out.println("***************************"); 
//		System.out.println("Date entrée = " + year + month + day); 
//		System.out.println("Date formatée = " + goodYear + goodMonth + goodDay); 

		if(goodYear==year & goodMonth==month & goodDay==day){ 
//			System.out.println("Date valide"); 
			return true; 
		} 
//		System.out.println("Date non valide"); 
		return false; 
	} 
	
	
	

	
	

	// http://www.jmdoudoux.fr/java/dej/chap-utilisation_dates.htm
	public static Date ajouterJour(Date date, int nbJour) { 
		  Calendar cal = Calendar.getInstance(); 
		  cal.setTime(date);
		  cal.add(Calendar.DATE, nbJour);
		  return cal.getTime();
	}
	
	public static Date ajouterMois(Date date, int nbMois) {
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  cal.add(Calendar.MONTH, nbMois);
		  return cal.getTime(); 
		}
	public static Date ajouterAnnee(Date date, int nbAnnee) {
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  cal.add(Calendar.YEAR, nbAnnee);
		  return cal.getTime();
		}
	public static Date ajouterHeure(Date date, int nbHeure) {
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  cal.add(Calendar.HOUR, nbHeure);
		  return cal.getTime();
		}
	public static Date ajouterMinute(Date date, int nbMinute) { 
		  Calendar cal = Calendar.getInstance(); 
		  cal.setTime(date);
		  cal.add(Calendar.MINUTE, nbMinute);
		  return cal.getTime();
		}
	public static Date ajouterSeconde(Date date, int nbSeconde) {
		  Calendar cal = Calendar.getInstance(); 
		  cal.setTime(date);
		  cal.add(Calendar.SECOND, nbSeconde); 
		  return cal.getTime();
		}


}

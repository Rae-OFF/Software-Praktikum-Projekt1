package controller;

import AUI.ZusammenfassungsAUI;
import model.Arzt;
import model.EPA;
import model.Ueberweisung;
import model.Untersuchungsbericht;

import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.List;

public class ZusammenfassungsController {

    /**
 	 * 
 	 */
    private List<Untersuchungsbericht> zusammenfassung;

    /**
 	 * 
 	 */
    private EPAController ePAController;

    /**
 	 * 
 	 */
    private ZusammenfassungsAUI zusammenfassungsAUI;



    public ZusammenfassungsController(EPAController e) {
    	ePAController=e;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param untersuchungsbericht
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addToZusammenfassung(Untersuchungsbericht untersuchungsbericht) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param versicherungsnummer
 	 * @param iCD
 	 * @return List<Untersuchungsbericht>
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public List<Untersuchungsbericht> createZusammenfassungEinArzt(String versicherungsnummer, String iCD) throws UnsupportedOperationException {
		EPA e= ePAController.getEPA();
		Arzt a = e.getArzt(ePAController.getCurrLoggedIn());// get arzt
		ArrayList<Untersuchungsbericht>berichtlist= a.getUntersuchungsberichte(versicherungsnummer);
		if(!iCD.equals("leer")){
			for(int i=0; i<berichtlist.size();i++){
				if(!berichtlist.get(i).getICD().equals(iCD)){
					berichtlist.remove(i);// remove berichte that have icd != icd to find from list
				}
			}
		}
		return berichtlist;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param versicherungsnummer
 	 * @param iCD
 	 * @return List<Untersuchungsbericht>
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public ArrayList<Untersuchungsbericht> createZusammenfassungAlleAerzte(String versicherungsnummer, String iCD) throws UnsupportedOperationException {
         EPA e= ePAController.getEPA();
         Arzt a = e.getArzt(ePAController.getCurrLoggedIn());// get arzt
		 ArrayList<Untersuchungsbericht>berichtlist= new ArrayList<Untersuchungsbericht>();//zum ausgabe
		 if(a.getPatient(versicherungsnummer)!=null&&e.checkNumPatient(versicherungsnummer)){// patient valid
			 ArrayList<Ueberweisung> ue=a.getPatient(versicherungsnummer).getUeberweisungsList();// get ueberweisungslist from patient with versicherungsnummer
			 for(int i=0; i<ue.size(); i++){
				 if(ue.get(i).getNeuarztnummer().equals(ePAController.getCurrLoggedIn())&&ue.get(i).isDatenStimmZu()) {// interpretioert ueberweisung mit neuarztnum == this arztnum && derren Daten wurden schon zugestimmt
					 berichtlist.addAll(ue.get(i).getUntersuchungsbericht());// get all untersuchung from ueberweisunglist
				 }
			 }
			 if(!iCD.equals("leer")){
				 for(int i=0; i<berichtlist.size();i++){
					 if(!berichtlist.get(i).getICD().equals(iCD)){
						 berichtlist.remove(i);// remove berichte that have icd != icd to find from list
					 }
				 }
			 }
		 }
         return berichtlist;
    }
}

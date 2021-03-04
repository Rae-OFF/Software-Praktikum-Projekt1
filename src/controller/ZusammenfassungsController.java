package controller;

import AUI.ZusammenfassungsAUI;
import model.Arzt;
import model.EPA;
import model.Ueberweisung;
import model.Untersuchungsbericht;

import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Zusammenfassungs controller.
 */
public class ZusammenfassungsController {

    private List<Untersuchungsbericht> zusammenfassung;

    private EPAController ePAController;

    private ZusammenfassungsAUI zusammenfassungsAUI;


	/**
	 * Instantiates a new Zusammenfassungs controller.
	 *
	 * @param e the e
	 */
	public ZusammenfassungsController(EPAController e) {
    	ePAController=e;
    }

	/**
	 * Add to zusammenfassung.
	 *
	 * @param untersuchungsbericht the untersuchungsbericht
	 * @throws UnsupportedOperationException the unsupported operation exception
	 */
	public void addToZusammenfassung(Untersuchungsbericht untersuchungsbericht) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

	/**
	 * Create zusammenfassung ein arzt list.
	 *
	 * @param versicherungsnummer the versicherungsnummer
	 * @param iCD                 the cd
	 * @return the list
	 */
	public List<Untersuchungsbericht> createZusammenfassungEinArzt(String versicherungsnummer, String iCD){
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
	 * Create zusammenfassung alle aerzte array list.
	 *
	 * @param versicherungsnummer the versicherungsnummer
	 * @param iCD                 the cd
	 * @return the array list
	 */
	public ArrayList<Untersuchungsbericht> createZusammenfassungAlleAerzte(String versicherungsnummer, String iCD){
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

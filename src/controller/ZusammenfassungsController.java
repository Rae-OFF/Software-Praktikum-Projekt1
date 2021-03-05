package controller;

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
	public ArrayList<Untersuchungsbericht> createZusammenfassungEinArzt(String versicherungsnummer, String iCD){
		EPA e= ePAController.getEPA();
		Arzt a = e.getArzt(ePAController.getCurrLoggedIn());// get arzt
		ArrayList<Untersuchungsbericht>berichtlist= a.getUntersuchungsberichte(versicherungsnummer); // get untersuchungbericht
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
		 ArrayList<Untersuchungsbericht>berichtlist= createZusammenfassungEinArzt(versicherungsnummer,iCD);
		 if(a.getFachrichtung().equals("Hausarzt")){
		 	for(int i=0; i<a.getPatient(versicherungsnummer).getUntersuchungList().size();i++){
		 		boolean check=false;
		 		for(int j=0;j<berichtlist.size();j++){
		 			if(equalsBericht(berichtlist.get(j),a.getPatient(versicherungsnummer).getUntersuchungList().get(i) )){
		 				check=true;
		 				break;
					}
				}
		 		if(check==false){berichtlist.add(a.getPatient(versicherungsnummer).getUntersuchungList().get(i));}
			}
		 }else{
			 ArrayList<Ueberweisung> ue=a.getPatient(versicherungsnummer).getUeberweisungsList();// get ueberweisungslist from patient with versicherungsnummer
			 for(int i=0; i<ue.size(); i++){
				 if(ue.get(i).getNeuarztnummer().equals(ePAController.getCurrLoggedIn())&&ue.get(i).isDatenStimmZu()) {// interpretioert ueberweisung mit neuarztnum == this arztnum && derren Daten wurden schon zugestimmt
					 for(int k=0; k<ue.get(i).getUntersuchungsbericht().size();k++){
						 boolean check=false;
						 for(int j=0;j<berichtlist.size();j++){
							 if(equalsBericht(berichtlist.get(j), ue.get(i).getUntersuchungsbericht().get(k))){
								 check=true;
								 break;
							 }
						 }
						 if(check==false){berichtlist.add(ue.get(i).getUntersuchungsbericht().get(k));}
					 }
				 }
			 }
		 }
		if(!iCD.equals("leer")){
			for(int i=0; i<berichtlist.size();i++){
				if(!berichtlist.get(i).getICD().equals(iCD)){
					berichtlist.remove(i);// remove berichte that have icd != icd to find from list
				}
			}
		}
         return berichtlist;
    }
    private boolean equalsBericht(Untersuchungsbericht u1, Untersuchungsbericht u2){
		return u1.getBehandenderArzt().equals(u2.getBehandenderArzt())&&u1.getDatum().equals(u2.getDatum())&&u1.getICD().equals(u2.getICD())&&u1.getPatientVersicherungnum().equals(u2.getPatientVersicherungnum())
		&&u1.getBehandlung().equals(u2.getBehandlung())&&u1.getDiagnose().equals(u2.getDiagnose())&&u1.getMed().equals(u2.getMed())&&u1.getNotes().equals(u2.getNotes());

	}
}

package controller;

import model.Arzt;
import model.EPA;
import model.Ueberweisung;
import model.Untersuchungsbericht;

import java.lang.UnsupportedOperationException;
import java.util.ArrayList;


/**
 * The type Zusammenfassungs controller.
 */
public class ZusammenfassungsController {

    private EPAController ePAController;

	/**
	 * Instantiates a new Zusammenfassungs controller.
	 *
	 * @param epaController the epaController
	 */
	public ZusammenfassungsController(EPAController epaController) {
    	ePAController=epaController;
    }

	/**
	 * Add to zusammenfassung.
	 *
	 * @param untersuchungsbericht the untersuchungsbericht
	 */
	public void addToZusammenfassung(Untersuchungsbericht untersuchungsbericht) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

	/**
	 * Create zusammenfassung ein arzt
	 *
	 * @param versicherungsnummer the versicherungsnummer
	 * @param iCD                 the icd
	 * @return the array list of untersuchungbericht
	 */
	public ArrayList<Untersuchungsbericht> createZusammenfassungEinArzt(String versicherungsnummer, String iCD){
		EPA epa= ePAController.getEPA();// get epa
		Arzt arzt = epa.getArzt(ePAController.getCurrLoggedIn());// get arzt with arzt id == login nummer
		ArrayList<Untersuchungsbericht>berichtlist=new ArrayList<Untersuchungsbericht>();
		berichtlist.addAll(arzt.getUntersuchungsberichte(versicherungsnummer)); // get untersuchungberichtlist of arzt, save in berichtlist
		if(!iCD.equals("leer")){ // wenn icd eingegeben wird
			berichtlist.removeIf(Untersuchungsbericht->!Untersuchungsbericht.getICD().equals(iCD));
		}
		return berichtlist; // return berichtlist
    }

	/**
	 * Create zusammenfassung alle aerzte
	 *
	 * @param versicherungsnummer the versicherungsnummer
	 * @param iCD                 the icd
	 * @return the array list of untersuchungbericht
	 */
	public ArrayList<Untersuchungsbericht> createZusammenfassungAlleAerzte(String versicherungsnummer, String iCD){
         EPA epa= ePAController.getEPA(); // get epa
         Arzt arzt = epa.getArzt(ePAController.getCurrLoggedIn());// get arzt with arzt id == login nummer
		 ArrayList<Untersuchungsbericht>berichtlist= createZusammenfassungEinArzt(versicherungsnummer,iCD); // get untersuchungberichtlist of this arzt, save in berichtlist
		if(arzt.checkPatientValid(versicherungsnummer)){
			if(arzt.getFachrichtung().equals("Hausarzt")){ // if arzt is hausarzt
				for(int i=0; i<arzt.getPatient(versicherungsnummer).getUntersuchungList().size();i++){ // check every untersuchungbericht in untersuchungberichtlist of patient with versicherungsnummer in patient list of arzt
					if(arzt.getPatient(versicherungsnummer).getUntersuchungList().get(i).isWeiterSchicken()){// if bericht ist zum weiterschicken
						boolean check=false;
						for(int j=0;j<berichtlist.size();j++){ // check every untersuchungbericht in berichtlist
							if(equalsBericht(berichtlist.get(j),arzt.getPatient(versicherungsnummer).getUntersuchungList().get(i) )){ // if duplicate
								check=true; // check = true
							}
						}
						if(check==false){berichtlist.add(arzt.getPatient(versicherungsnummer).getUntersuchungList().get(i));}// not duplicate -> check == false and save in berichtlist
					}
				}
			}else{ // if arzt != hausarzt
				ArrayList<Ueberweisung> ueberweisungsList=arzt.getPatient(versicherungsnummer).getUeberweisungsList();// get ueberweisungslist from patient with versicherungsnummer, save in ueberweisungsList
				for(int i=0; i<ueberweisungsList.size(); i++){ // check every ueberweisung in ueberweisungsList
					if(ueberweisungsList.get(i).getNeuarztnummer().equals(ePAController.getCurrLoggedIn())&&ueberweisungsList.get(i).isDatenStimmZu()) {// get ueberweisung in ueberweisungsList mit neuarztnum == this arztnum && derren Daten wurden schon zugestimmt
						for(int k=0; k<ueberweisungsList.get(i).getUntersuchungsbericht().size();k++){ // check every untersuchungbericht in untersuchungberichtlist of that ueberweisung
							boolean check=false;
							for(int j=0;j<berichtlist.size();j++){
								if(equalsBericht(berichtlist.get(j), ueberweisungsList.get(i).getUntersuchungsbericht().get(k))){// if duplicate in berichtlist
									check=true; // check = true
								}
							}
							if(check==false){berichtlist.add(ueberweisungsList.get(i).getUntersuchungsbericht().get(k));}// not duplicate -> check == false and save in berichtlist
						}
					}
				}
			}
		}
		if(!iCD.equals("leer")){ // if ice was given
			berichtlist.removeIf(Untersuchungsbericht->!Untersuchungsbericht.getICD().equals(iCD));
		}
         return berichtlist; // return berichtlist
    }

	/**
	 *  check if 2 untersuchungbericht the same
	 * @param untersuchungsbericht1
	 * @param untersuchungsbericht2
	 * @return true if 2 untersuchungbericht the same
	 */
    private boolean equalsBericht(Untersuchungsbericht untersuchungsbericht1, Untersuchungsbericht untersuchungsbericht2){ // check every attribut of 2 untersuchungbericht in parameter to find if 2 r the same
		return untersuchungsbericht1.getBehandenderArzt().equals(untersuchungsbericht2.getBehandenderArzt())&&untersuchungsbericht1.getDatum().equals(untersuchungsbericht2.getDatum())&&untersuchungsbericht1.getICD().equals(untersuchungsbericht2.getICD())&&untersuchungsbericht1.getPatientVersicherungnum().equals(untersuchungsbericht2.getPatientVersicherungnum())
		&&untersuchungsbericht1.getBehandlung().equals(untersuchungsbericht2.getBehandlung())&&untersuchungsbericht1.getDiagnose().equals(untersuchungsbericht2.getDiagnose())&&untersuchungsbericht1.getMed().equals(untersuchungsbericht2.getMed())&&untersuchungsbericht1.getNotes().equals(untersuchungsbericht2.getNotes());

	}
}

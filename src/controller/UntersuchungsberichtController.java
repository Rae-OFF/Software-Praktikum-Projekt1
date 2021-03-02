package controller;

import AUI.UntersuchungsberichtAUI;
import model.EPA;
import model.Untersuchungsbericht;
import model.Arzt;
import model.Patient;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.time.LocalDateTime;
import java.util.List;

import static java.lang.Character.isLetter;

public class UntersuchungsberichtController {

    /**
 	 * 
 	 */
    private EPAController ePAController;

    /**
 	 * 
 	 */
    private UntersuchungsberichtAUI untersuchungsberichtAUI;

    public UntersuchungsberichtController(EPAController epaController) {
    }

    /**
 	 *
 	 * TODO: create JavaDoc.
	 * @param versicherungsnummer des Patienten
 	 * @param dateTime Datum und Uhrzeit
 	 * @param diagnose des Patienten
 	 * @param med -ikamente des Patienten
 	 * @param behandlung des Patienten
 	 * @param icd der Behandlung
	 * @param notes Notizen zum Patienten
 	 */
    public void createUntersuchungsbericht(String versicherungsnummer, LocalDateTime dateTime, String icd, List<String> med, String diagnose, String behandlung, List<String> notes){
    	if(!datenUeberpruefen(icd, versicherungsnummer)){
    		//ausgabe falsche eingabe
		}
    	else{
    		Untersuchungsbericht bericht = new Untersuchungsbericht(versicherungsnummer, ePAController.getCurrLoggedIn(),dateTime, icd, med, diagnose, behandlung, notes);
    		addUntersuchungbericht(versicherungsnummer, bericht);
    	}
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param versicherungsnummer ist die Versicherungsnummer des Patienten.
 	 * @param untersuchungsbericht ist der Untersuchungsbericht der beim Arzt und beim Patienten hinzugefügt werden soll.
 	 */
    public void addUntersuchungbericht(String versicherungsnummer, Untersuchungsbericht untersuchungsbericht){
		EPA epa = ePAController.getEPA();
        Arzt arzt = epa.getArzt(ePAController.getCurrLoggedIn());
        Patient patient = epa.getPatient(versicherungsnummer);
        arzt.addUntersuchungsberichrt(untersuchungsbericht);
        patient.addUntersuchungsList(untersuchungsbericht);
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return boolean gibt wahr zurück wenn die eingegebenen Daten korrekt sind.
 	 */
    public boolean datenUeberpruefen(String icd, String versicherungsnummer){
		CharacterIterator icdIterator = new StringCharacterIterator(icd);
		boolean icdRightFormat = true;
		if(!Character.isUpperCase(icdIterator.current())){
			icdRightFormat = false;
		}
		else{
			icdIterator.next();
			if(icdIterator.current()==CharacterIterator.DONE||!(Character.isDigit(icdIterator.current())||Character.isDigit(icdIterator.next()))){
				icdRightFormat = false;
			}
			else{
				icdIterator.next();
				if(icdIterator.current()!=CharacterIterator.DONE&&icdIterator.current()!='.'){
					icdRightFormat = false;
				}
				else{
					icdIterator.next();
					if(icdIterator.current()==CharacterIterator.DONE||!(Character.isDigit(icdIterator.current())||Character.isDigit(icdIterator.next()))){
						icdRightFormat = false;
					}
					else icdRightFormat = true;
				}
			}
		}
		EPA epa = ePAController.getEPA();
		boolean patientExists = epa.checkNumPatient(versicherungsnummer);
		return (icdRightFormat&&patientExists);
    }
}

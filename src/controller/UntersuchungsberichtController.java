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
		Untersuchungsbericht bericht = new Untersuchungsbericht(versicherungsnummer, ePAController.getCurrLoggedIn(),dateTime, icd, med, diagnose, behandlung, notes);
		addUntersuchungbericht(versicherungsnummer, bericht);
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
    public boolean iCDUeberpruefen(String icd){
		CharacterIterator icdIterator = new StringCharacterIterator(icd);
		if(!Character.isUpperCase(icdIterator.current())||icdIterator.current()==CharacterIterator.DONE){
			return false;
		}
		else{
			icdIterator.next();
			if(icdIterator.current()==CharacterIterator.DONE||!(Character.isDigit(icdIterator.current())||Character.isDigit(icdIterator.next()))||icdIterator.current()==CharacterIterator.DONE){
				return false;
			}
			else{
				icdIterator.next();
				if(icdIterator.current()!=CharacterIterator.DONE&&icdIterator.current()!='.'||icdIterator.current()==CharacterIterator.DONE){
					return false;
				}
				else{
					icdIterator.next();
					if(icdIterator.current()==CharacterIterator.DONE||!(Character.isDigit(icdIterator.current())||Character.isDigit(icdIterator.next()))||icdIterator.current()==CharacterIterator.DONE){
						return false;
					}
					else return true;
				}
			}
		}
    }

    public boolean versicherungsnummerUeberpruefen(String versicherungsnummer){
		EPA epa = ePAController.getEPA();
		return epa.checkNumPatient(versicherungsnummer);
	}

	public boolean UhrzeitUeberpruefen(String uhrzeit){
		CharacterIterator timeIterator = new StringCharacterIterator(uhrzeit);
		if(!Character.isDigit(timeIterator.current())|| timeIterator.current() >2){
			return false;
		}
		else{
			timeIterator.next();
			if(!Character.isDigit(timeIterator.current())||timeIterator.next()!=':'){
				return false;
			}
			else{
				timeIterator.next();
				if(!Character.isDigit(timeIterator.current())|| timeIterator.current() >5){
					return false;
				}
				else{
					timeIterator.next();
					if(!Character.isDigit(timeIterator.current())){
						return false;
					}
					else return true;
				}
			}
		}
	}
}

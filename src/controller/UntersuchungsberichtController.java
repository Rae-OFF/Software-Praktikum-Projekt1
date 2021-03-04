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

/**
 * Für die Verwaltung und erstellung von Unteruchungsberichten.
 */
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
 	 *Erstellt ein neues Untersuchungsberichtobjekt und fügt es hinzu.
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
 	 * Fügt den angegebenen Untersuchungsbericht dem angegebenen Patienten und dem Arzt der diesen erstellt hinzu.
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
	 * Ist zum überprüfen der ICDeingabe.
	 * @param icd die zu überprüfende ICD.
	 * @return true für Großbuchstabe und 2 Zahlen und ggf. noch Punkt und 1-2 Zahlen.
	 */
    public boolean iCDUeberpruefen(String icd){
		CharacterIterator icdIterator = new StringCharacterIterator(icd);
		if(!Character.isUpperCase(icdIterator.current())){
			return false;
		}
		else{
			icdIterator.next();
			if(!(Character.isDigit(icdIterator.current()))){
				return false;
			}
			else{
				icdIterator.next();
				if(!Character.isDigit(icdIterator.current())){
					return false;
				}
				else{
					icdIterator.next();
					if(icdIterator.current()!='.'&&icdIterator.current() !=CharacterIterator.DONE){
						return false;
					}
					else{
						if(icdIterator.current() !=CharacterIterator.DONE){
							icdIterator.next();
							if(!Character.isDigit(icdIterator.current())){
								return false;
							}
							else
								icdIterator.next();
								if(!Character.isDigit(icdIterator.current())&&icdIterator.current() !=CharacterIterator.DONE){
								return false;
								}
								else
									if(icdIterator.next()!=CharacterIterator.DONE){
										return false;
									}
									else return true;
						}
						else return true;
					}
				}
			}
		}
    }

	/**
	 * Ist zum überprüfen der Versicherungsnummerneingabe.
	 * @return true für Format ist richtig.
	 */
    public boolean versicherungsnummerUeberpruefen(String versicherungsnummer){
		EPA epa = ePAController.getEPA();
		return epa.checkNumPatient(versicherungsnummer);
	}


	/**
	 * Ist zum überprüfen der Urzeiteingabe.
	 * @param uhrzeit die zu überprüfende Uhrzeit.
	 * @return true für Format ist richtig.
	 */
	public boolean uhrzeitUeberpruefen(String uhrzeit){
		CharacterIterator timeIterator = new StringCharacterIterator(uhrzeit);
		String stunden="";
		int stundenInt;
		String minuten="";
		int minutenInt;
		if(!Character.isDigit(timeIterator.current())){
			return false;
		}
		else{
			stunden+=timeIterator.current();
			timeIterator.next();
			if(!Character.isDigit(timeIterator.current())){
				return false;
			}
			else{
				stunden+=timeIterator.current();
				stundenInt=Integer.parseInt(stunden);
				timeIterator.next();
				if(timeIterator.current()!=':'||(stundenInt>24&&stundenInt<0)){
					return false;
				}
				else
				{
					timeIterator.next();
					if(!Character.isDigit(timeIterator.current())){
						return false;
					}
					else{
						minuten+=timeIterator.current();
						timeIterator.next();
						if(!Character.isDigit(timeIterator.current())){
							return false;
						}
						else
							minuten+=timeIterator.current();
							minutenInt=Integer.parseInt(minuten);
							if(minutenInt>60&&stundenInt<0){// kleine anmerkung es gibt kein minute 60
								return false;
							}
							else return true;
					}
				}
			}
		}
	}
}

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
 * The type Untersuchungsbericht controller.
 */
public class UntersuchungsberichtController {

    private EPAController ePAController;

    private UntersuchungsberichtAUI untersuchungsberichtAUI;

	/**
	 * Instantiates a new Untersuchungsbericht controller.
	 *
	 * @param epaController the epa controller
	 */
	public UntersuchungsberichtController(EPAController epaController) {
    }

	/**
	 * Create untersuchungsbericht.
	 *
	 * @param versicherungsnummer the versicherungsnummer
	 * @param dateTime            the date time
	 * @param icd                 the icd
	 * @param med                 the med
	 * @param diagnose            the diagnose
	 * @param behandlung          the behandlung
	 * @param notes               the notes
	 */
	public void createUntersuchungsbericht(String versicherungsnummer, LocalDateTime dateTime, String icd, List<String> med, String diagnose, String behandlung, List<String> notes){
		Untersuchungsbericht bericht = new Untersuchungsbericht(versicherungsnummer, ePAController.getCurrLoggedIn(),dateTime, icd, med, diagnose, behandlung, notes);
		addUntersuchungbericht(versicherungsnummer, bericht);
    }

	/**
	 * Add untersuchungbericht.
	 *
	 * @param versicherungsnummer  the versicherungsnummer
	 * @param untersuchungsbericht the untersuchungsbericht
	 */
	public void addUntersuchungbericht(String versicherungsnummer, Untersuchungsbericht untersuchungsbericht){
		EPA epa = ePAController.getEPA();
        Arzt arzt = epa.getArzt(ePAController.getCurrLoggedIn());
        Patient patient = epa.getPatient(versicherungsnummer);
        arzt.addUntersuchungsberichrt(untersuchungsbericht);
        patient.addUntersuchungsList(untersuchungsbericht);
    }

	/**
	 * Cd ueberpruefen boolean.
	 *
	 * @param icd the icd
	 * @return the boolean
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
	 * Versicherungsnummer ueberpruefen boolean.
	 *
	 * @param versicherungsnummer the versicherungsnummer
	 * @return the boolean
	 */
	public boolean versicherungsnummerUeberpruefen(String versicherungsnummer){
		EPA epa = ePAController.getEPA();
		return epa.checkNumPatient(versicherungsnummer);
	}


	/**
	 * Uhrzeit ueberpruefen boolean.
	 *
	 * @param uhrzeit the uhrzeit
	 * @return the boolean
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

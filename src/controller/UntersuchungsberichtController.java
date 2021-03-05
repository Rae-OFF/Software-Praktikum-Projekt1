package controller;

import model.EPA;
import model.Untersuchungsbericht;
import model.Arzt;
import model.Patient;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Untersuchungsbericht controller.
 */
public class UntersuchungsberichtController {

    private EPAController ePAController;


	/**
	 * Instantiates a new Untersuchungsbericht controller.
	 *
	 * @param epaController the epa controller
	 */
	public UntersuchungsberichtController(EPAController epaController) {
		ePAController = epaController;
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
		return icd.matches("[A-Z]\\d{1,2}(\\.\\d{1,2}){0,1}");
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
		return uhrzeit.matches("([2][0-3]|[0-1][0-9]|[1-9]):[0-5][0-9]");
	}

	public  boolean felderLeer(String uhrzeit, String versicherungsnummer, String symptome, String icd, String behandlung,String medikamente){
		return uhrzeit==null||uhrzeit==""||versicherungsnummer==null||versicherungsnummer==""||symptome==null||symptome==""||icd==null||icd=="" ||behandlung==null||behandlung==""||medikamente==null||medikamente=="";
	}
}

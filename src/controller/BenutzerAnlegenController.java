package controller;

import model.Arzt;
import model.EPA;
import model.Patient;

import java.lang.UnsupportedOperationException;
import java.util.List;

public class BenutzerAnlegenController {

    /**
 	 * 
 	 */
    private EPAController ePAController;

    public BenutzerAnlegenController(EPAController e) {
    	this.ePAController = e ;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
	 * @param Vorname Datum und Uhrzeit
	 * @param Nachname des Patienten
	 * @param fach -ikamente des Patienten
	 * @param num des Patienten
	 * @param passwort des Patienten
	 * @param Tel des Patienten
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void ArztAnlegen(String Vorname,String Nachname, String fach, String num, String passwort, String Tel)
			throws UnsupportedOperationException {

             // neuen Artzt Anlegen
			Arzt arzt = new Arzt(Vorname, Nachname, fach, num, passwort, Tel);




        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
	 * @param versicherungsnummer des Patienten
	 * @param Vorname Datum und Uhrzeit
	 * @param Nachname des Patienten
	 * @param Address -ikamente des Patienten
	 * @param Geschlecht des Patienten
	 * @param pass des Patienten
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void PatientAnlegen(String versicherungsnummer, String Vorname,String Nachname, String Address, String Geschlecht, String Birth, String pass)
			throws UnsupportedOperationException {
    	//neuen Patient anlegen
		Patient patient = new Patient(versicherungsnummer, Vorname, Nachname, Address, Geschlecht, Birth, pass) ;


		throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}

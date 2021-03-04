package controller;

import model.Arzt;
import model.EPA;
import model.Patient;

import java.lang.UnsupportedOperationException;
import java.security.InvalidParameterException;
import java.util.List;
/**
 * einen neuen Benutzer anlegen der , Patient oder Arzt sein kann
 */
public class BenutzerAnlegenController {

	/**
	 * 
	 */
    private EPAController ePAController;

    public BenutzerAnlegenController(EPAController e) {
    	this.ePAController = e ;
    }

    /**
	 * Diese Methode liegt einen neuen Arzt an
	 * @param Vorname des Arztes
	 * @param Nachname des Arztes
	 * @param fach  des Arztes
	 * @param num des Arztes
	 * @param passwort des Arztes
	 * @param Tel des Arztes
 	 */
    public void ArztAnlegen(String Vorname,String Nachname, String fach, String num, String passwort, String Tel)
			 {
    	if (Vorname == null || Nachname== null || fach == null || num == null || passwort == null || Tel == null  ){
    		//ungültige Eingabe ;
			throw new InvalidParameterException();
		}

             // neuen Artzt Anlegen
			Arzt arzt = new Arzt(Vorname, Nachname, fach, num, passwort, Tel);

    }

    /**
	 *  Diese Methode liegt einen neuen Patient an
	 * @param versicherungsnummer des Patienten
	 * @param Vorname Datum und Uhrzeit
	 * @param Nachname des Patienten
	 * @param Address  des Patienten
	 * @param Geschlecht des Patienten
	 * @param Birth des Patienten
	 * @param pass des Patienten
	 */
    public void PatientAnlegen(String versicherungsnummer, String Vorname,String Nachname, String Address, String Geschlecht, String Birth, String pass)
			 {
    	if ( versicherungsnummer == null ||Vorname == null || Nachname== null || Address == null || Geschlecht == null || Birth == null || pass == null  ) {
			//ungültige Eingabe ;
			throw new InvalidParameterException();
		}

    	//neuen Patient anlegen
		Patient patient = new Patient(versicherungsnummer, Vorname, Nachname, Address, Geschlecht, Birth, pass) ;


    }
}

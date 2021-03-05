package controller;

import model.EPA;
import model.Patient;
import model.Untersuchungsbericht;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * personliche Daten bearbeiten
 */

public class PatientDatenController {

	/**
	 *
	 */

	private EPAController ePAController;

	public PatientDatenController(EPAController ePAController) {
		this.ePAController = ePAController ;

	}
	/**
	 * *Diese Methode ermauglicht die Daten eines schon existierend Patient zu bearbeiten
	 * @param versicherungsnummer des Patienten
	 * @param Vorname Datum und Uhrzeit
	 * @param Nachname des Patienten
	 * @param Address -ikamente des Patienten
	 * @param Geschlecht des Patienten
	 * @param Birth des Patienten
	 * @param pass des Patienten
	 */

	public void PatientDatenUpdate(String versicherungsnummer, String Vorname,String Nachname, String Address, String Geschlecht, String Birth, String pass) throws IOException {
		EPA epa = ePAController.getEPA();
		Patient patient = epa.getPatient(versicherungsnummer);
		patient.setVorname(Vorname);
		patient.setNachname(Nachname);
		patient.setAddress(Address);
		patient.setGeschlecht(Geschlecht);
		patient.setBirth(Birth);
		patient.setPasswort(pass);
		ePAController.getIO().save();
	}
	/**
	 * Diese Methode ist verantwortlich feur Auswahl Von  Untersuchungsberichten
	 * @param versicherungsnummer des Patienten
	 * @param  icd der Krankheit
	 * @return liste aller Untersuchungsberichte einer bestimmten Krankheit
	 */
	public List<Untersuchungsbericht> berichteAussuchen(String versicherungsnummer , String icd ) {
		if (versicherungsnummer == null || icd == null  ){
			// ungültige Eingabe
			throw new InvalidParameterException();

		}
		List<Untersuchungsbericht> list1 = null;
		EPA epa = ePAController.getEPA();
		Patient patient = epa.getPatient(versicherungsnummer);
		List<Untersuchungsbericht> list =patient.getUntersuchungList();
		for(Untersuchungsbericht untersuchungsbericht: list){
			if(untersuchungsbericht.getICD().equals(icd)){
				list1.add(untersuchungsbericht);

			}
		}

		return list1;
	}



}

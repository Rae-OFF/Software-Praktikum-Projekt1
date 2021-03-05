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

	/**
	 * Instantiates a new Patient daten controller.
	 *
	 * @param ePAController the e pa controller
	 */
	public PatientDatenController(EPAController ePAController) {
		this.ePAController = ePAController ;

	}
	/**
	 * *Diese Methode ermauglicht die Daten eines schon existierend Patient zu bearbeiten
	 * @param versicherungsnummer des Patienten
	 * @param vorname Datum und Uhrzeit
	 * @param nachname des Patienten
	 * @param address -ikamente des Patienten
	 * @param geschlecht des Patienten
	 * @param birth des Patienten
	 * @param pass des Patienten
	 */

	public void patientDatenUpdate(String versicherungsnummer, String vorname, String nachname, String address, String geschlecht, String birth, String pass) throws IOException {
		EPA epa = ePAController.getEPA();
		Patient patient = epa.getPatient(versicherungsnummer);
		patient.setVorname(vorname);
		patient.setNachname(nachname);
		patient.setAddress(address);
		patient.setGeschlecht(geschlecht);
		patient.setBirth(birth);
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

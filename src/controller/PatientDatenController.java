package controller;

import model.EPA;
import model.Patient;
import model.Untersuchungsbericht;

import javax.sound.midi.InvalidMidiDataException;
import java.security.InvalidParameterException;
import java.util.List;

public class PatientDatenController {

	private EPAController ePAController;

	public PatientDatenController(EPAController ePAController) {
		this.ePAController = ePAController ;

	}

	public void PatientDatenUpdate(String versicherungsnummer, String Vorname,String Nachname, String Address, String Geschlecht, String Birth, String pass) {
		EPA epa = ePAController.getEPA();
		Patient patient = epa.getPatient(versicherungsnummer);
		patient.setVorname(Vorname);
		patient.setNachname(Nachname);
		patient.setAddress(Address);
		patient.setGeschlecht(Geschlecht);
		patient.setBirth(Birth);
		patient.setPasswort(pass);
	}
	/**
	 *
	 * TODO: create JavaDoc.
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

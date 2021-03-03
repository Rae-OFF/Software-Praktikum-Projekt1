package controller;

import model.EPA;
import model.Patient;
import model.Untersuchungsbericht;

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

	public List<Untersuchungsbericht> berichteAussuchen() {



		return null;
	}



}

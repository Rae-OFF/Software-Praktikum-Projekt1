package controller;

import model.Arzt;
import model.EPA;
import model.Patient;
import model.Untersuchungsbericht;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
		EPA epa = ePAController.getEPA();  // get epa
		Patient patient = epa.getPatient(versicherungsnummer); // get patient with versicherungnummer
		patient.setVorname(vorname); // update new info like parameter with setter
		patient.setNachname(nachname);
		patient.setAddress(address);
		patient.setGeschlecht(geschlecht);
		patient.setBirth(birth);
		patient.setPasswort(pass);
		ePAController.getIO().save(); // save
	}
	public void patientSetArzt(String versicherungsnummer, String ArztID) throws IOException {
		EPA epa = ePAController.getEPA(); // get ePA
		Patient patient = epa.getPatient(versicherungsnummer); // get patient
		Arzt arzt=epa.getArzt(ArztID); // get arzt
		patient.behandeldenArztAendern(arzt); // add arzt as patient hausarzt
		arzt.addPatientToList(patient);
		ePAController.getIO().save();// save
	}
	public ArrayList<Untersuchungsbericht> getUntersuchungbericht(LocalDateTime startDate, LocalDateTime endDate, String versicherungsnummer){ // return all untersuchungbericht of patient with versicherungnummer in between startdate and enddate
		ArrayList<Untersuchungsbericht> untersuchungsberichtsList= ePAController.getEPA().getPatient(versicherungsnummer).getUntersuchungList(); // get unterscuhungberichtlist
		ArrayList<Untersuchungsbericht> untersuchungsberichtsreturn=new ArrayList<Untersuchungsbericht>();
		untersuchungsberichtsreturn.addAll(untersuchungsberichtsList);
		untersuchungsberichtsreturn.removeIf(Untersuchungsbericht->Untersuchungsbericht.getDatum().isBefore(startDate)||Untersuchungsbericht.getDatum().isAfter(endDate));
		return untersuchungsberichtsreturn;
	}




}

package model;

import java.time.LocalDateTime;
import java.util.List;


public class Untersuchungsbericht {

	private String patientVersicherungnum;

	private LocalDateTime datum;

	private List<String> notes;

	private String iCD;

	private List<String> med;

	private String diagnose;

	private String behandlung;

	private String behandenderArzt;

	public Untersuchungsbericht(String versicherungsnummer, String behandelnderArzt, LocalDateTime datum, String iCD, List<String> med, String diagnose, String behandlung, List<String> notes) {

	}

	public List<String> getInfo() {
		return notes;
	}

	public String getPatientNum() {
		return patientVersicherungnum;
	}

	public void setInfo(String diagnose, List<String> Med, String Behandlung, String icd) {

	}

	public String getICD() {
		return iCD;
	}

	public String toString(){
		String ausgabe="";
		ausgabe+="Name: "+""+"/n";
		ausgabe+="Datum: "+datum  +"/n";
		ausgabe+="Behandelnder Arzt: "+""+"/n";
		ausgabe+="ICD: "+iCD+"/n";
		ausgabe+="Diagnose: "+diagnose+"/n";
		ausgabe+="verabreichte Medikamente:/n";
		for (String x:med) {
			ausgabe+="-"+x+"/n";
		}
		ausgabe+="/n";
		ausgabe+="Behandlung: "+behandlung+"/n";
		ausgabe+="Notizen:/n";
		for (String y:notes) {
			ausgabe+="-"+y+"/n";
		}
		return ausgabe;
	}

}

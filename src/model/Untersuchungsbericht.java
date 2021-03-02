package model;

import java.time.LocalDateTime;
import java.util.List;

public class Untersuchungsbericht {

	private String patientVersicherungnum;

	private LocalDateTime datum;

	private List<String> sonstigesInfo;

	private String iCD;

	private List<String> med;

	private String diagnose;

	private String behandlung;

	private String behandenderArzt;

	public Untersuchungsbericht(String versicherungsnummer, String behandelnderArzt, LocalDateTime datum, String iCD, List<String> med, String diagnose, String behandlung, List<String> notes) {

	}

	public List<String> getInfo() {
		return sonstigesInfo;
	}

	public String getPatientNum() {
		return patientVersicherungnum;
	}

	public void setInfo(String diagnose, List<String> Med, String Behandlung, String icd) {

	}

	public String getICD() {
		return iCD;
	}

}

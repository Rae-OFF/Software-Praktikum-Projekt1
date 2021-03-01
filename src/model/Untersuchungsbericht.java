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

	public Untersuchungsbericht(String versicherungsnummer, LocalDateTime datum, List<String> sonstigeInfo, String iCD, List<String> med, String diagnose, String behandlung, String behandelnderArzt) {

	}

	public List<String> getInfo() {
		return null;
	}

	public String getPatientNum() {
		return null;
	}

	public void setInfo(String diagnose, List<String> Med, String Behandlung, String icd) {

	}

	public String getICD() {
		return null;
	}

}

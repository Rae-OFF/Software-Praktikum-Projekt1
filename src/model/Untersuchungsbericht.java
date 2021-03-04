package model;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The type Untersuchungsbericht.
 */
public class Untersuchungsbericht {

	private String patientVersicherungnum;

	private LocalDateTime datum;

	private List<String> notes;

	private String iCD;

	private List<String> med;

	private String diagnose;

	private String behandlung;

	private String behandenderArzt;

	/**
	 * Instantiates a new Untersuchungsbericht.
	 *
	 * @param versicherungsnummer the versicherungsnummer
	 * @param behandelnderArzt    the behandelnder arzt
	 * @param datum               the datum
	 * @param iCD                 the cd
	 * @param med                 the med
	 * @param diagnose            the diagnose
	 * @param behandlung          the behandlung
	 * @param notes               the notes
	 */
	public Untersuchungsbericht(String versicherungsnummer, String behandelnderArzt, LocalDateTime datum, String iCD, List<String> med, String diagnose, String behandlung, List<String> notes) {
		patientVersicherungnum = versicherungsnummer;
		this.behandenderArzt = behandelnderArzt;
		this.datum = datum;
		this.iCD = iCD;
		this.med = med;
		this.diagnose = diagnose;
		this.behandlung = behandlung;
		this.notes = notes;
	}

	/**
	 * Gets info.
	 *
	 * @return the info
	 */
	public List<String> getInfo() {
		return notes;
	}

	/**
	 * Gets patient num.
	 *
	 * @return the patient num
	 */
	public String getPatientNum() {
		return patientVersicherungnum;
	}

	/**
	 * Sets info.
	 *
	 * @param diagnose   the diagnose
	 * @param Med        the med
	 * @param Behandlung the behandlung
	 * @param icd        the icd
	 */
	public void setInfo(String diagnose, List<String> Med, String Behandlung, String icd) {

	}

	/**
	 * todo: name
	 * @return
	 */
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

	/**
	 * Gets patient versicherungnum.
	 *
	 * @return the patient versicherungnum
	 */
	public String getPatientVersicherungnum() {
		return patientVersicherungnum;
	}

	/**
	 * Gets icd.
	 *
	 * @return the icd
	 */
	public String getICD() {
		return iCD;
	}

	/**
	 * Gets datum.
	 *
	 * @return the datum
	 */
	public LocalDateTime getDatum() {
		return datum;
	}

	/**
	 * Gets notes.
	 *
	 * @return the notes
	 */
	public List<String> getNotes() {
		return notes;
	}

	/**
	 * Gets med.
	 *
	 * @return the med
	 */
	public List<String> getMed() {
		return med;
	}

	/**
	 * Gets diagnose.
	 *
	 * @return the diagnose
	 */
	public String getDiagnose() {
		return diagnose;
	}

	/**
	 * Gets behandlung.
	 *
	 * @return the behandlung
	 */
	public String getBehandlung() {
		return behandlung;
	}

	/**
	 * Gets behandender arzt.
	 *
	 * @return the behandender arzt
	 */
	public String getBehandenderArzt() {
		return behandenderArzt;
	}
}

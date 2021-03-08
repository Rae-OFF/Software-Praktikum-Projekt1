package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 */
public class Patient implements Serializable {

	private String versicherungNum;

	private ArrayList<Ueberweisung> ueberweisungsList;

	private ArrayList<Untersuchungsbericht> untersuchungsberichtsList;

	private String vorName;

	private String nachName;

	private String address;

	private String geschlecht;

	private String gesburtsDatum;

	private ArrayList<String> revision;

	private Arzt behandelnderArzt;

	private String nameAltArzt;

    private boolean isNeuDaten=false; // new ueberweisung added ?

	private boolean isNeuUntersuchung=false;

	private String passwort;

	/**
	 *
	 * @param versicherungNum Versicherungsnummer des Patienten
	 * @param vorName Vorname des Patienten
	 * @param nachName Nachname des des Patienten
	 * @param address Adresse des Patienten
	 * @param geschlecht Geschlecht des Patienten
	 * @param birth Geburtsdatum des Patienten
	 * @param passWort Passwort des Patienten
	 */
	public Patient(String versicherungNum, String vorName,String nachName, String address, String geschlecht, String birth, String passWort) {
		this.passwort=passWort; // create new patient with attributes given in parameter
        this.versicherungNum=versicherungNum;
		this.vorName=vorName;
		this.nachName=nachName;
        this.address=address;
        this.geschlecht=geschlecht;
        this.gesburtsDatum=birth;
		this.ueberweisungsList= new ArrayList<Ueberweisung>(); // make empty lists
		this.untersuchungsberichtsList= new ArrayList<Untersuchungsbericht>();
		this.revision= new ArrayList<String>();
	}

	 /**
	 *
	 * @return Versicherungsnummer
	 */
	public String getNum() {
		return versicherungNum;
	}

	/**
	 *
	 * @return Geburtsdatum
	 */
    public String getGesburtsDatum(){return gesburtsDatum;}

	/**
	 *
	 * @param newRevision die neue Revision
	 */
	public void addToRevision(String newRevision) {
        this.revision.add(newRevision);
	}

	/**
	 *
	 * @param newVorname der neue Vorname
	 */
	public void setVorname(String newVorname) {
        if(newVorname.equals(vorName)){}
        else{ // if newVorname != newVorname
        	revision.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" Ihrer Vorname wurde von "+vorName+" zu "+newVorname+" geandert"); // add revision
			vorName=newVorname; // change newVorname to newVorname
		}
	}

	/**
	 *
	 * @param newNachname der neue Nachname
	 *
	 */
	public void setNachname(String newNachname) {
        if(newNachname.equals(nachName)){}
        else{ // if newNachname != newNachname
            revision.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" Ihrer Vorname wurde von "+nachName+" zu "+newNachname+" geandert"); // add revision
			nachName=newNachname; // change newNachname to newNachname
		}
	}

	/**
	 *
	 * @param newAddress die neue Adresse
	 *
	 */
	public void setAddress(String newAddress) {
		if(newAddress.equals(address)){}
        else{ // if newAddress != address
			revision.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" Ihre Addresse wurde von "+address+" zu "+newAddress+" geandert"); // add revision
        	address=newAddress; // change address to newAddress
		}
	}

	/**
	 *
	 * @param newGeschlecht das neue Geschlecht
	 */
	public void setGeschlecht(String newGeschlecht) {
		if(geschlecht.equals(newGeschlecht)){} // if newGeschlecht != geschlecht
		else{
			revision.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" Ihr Geschlecht wurde von "+geschlecht+" zu "+newGeschlecht+" geandert"); // add revision
			geschlecht=newGeschlecht; // set geschelcht to newGeschlecht
		}
	}
	/**
	 *
	 * @param newPasswort das neue Passwort
	 */
	public void setPasswort(String newPasswort){
		if(passwort.equals(newPasswort)){}// if newPasswort != passwort
		else{
			revision.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" Ihr Passwort wurde von "+passwort+" zu "+newPasswort+" geandert"); // add revision
			passwort=newPasswort;// set passwort to newPasswort
		}
	}
	/**
	 *
	 * @param newBirth das neue Geburtsdatum
	 */
	public void setBirth(String newBirth) {
        if(gesburtsDatum.equals(newBirth)){}
        else{// if newBirth != gesburtDatum
        	revision.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" Ihr Gesburtsdatum wurde von "+gesburtsDatum+" zu "+newBirth+" geandert"); // add revision
            gesburtsDatum=newBirth;// set gesburtsDatum to newBirth
		}
	}

	/**
	 *
	 * @param neuDaten die neue Daten
	 */
	public void setNeuDaten(boolean neuDaten){isNeuDaten=neuDaten;}// set if new Data added
	public void setNeuUntersuchung(boolean neuUntersuchung){isNeuUntersuchung=neuUntersuchung;}

	/**
	 *
	 * @return boolean
	 */
	public boolean isNeuDaten(){return isNeuDaten;}
	public boolean isNeuUntersuchung(){return  isNeuUntersuchung;}

	/**
	 * Daten erneuen
	 */
	public void updateDaten(){
		int count=0; // check if all ueberweisung was confirmed
		for(int i=0; i< ueberweisungsList.size();i++){
			if(!ueberweisungsList.get(i).isDatenStimmZu()){
                count++;
			}
		}
		isNeuDaten=(count!=0); // if there is ueberweisung that wasnt confirmed -> isNeuDaten = true
	}

	/**
	 *
	 * @param ueberweisung neue Ueberweisung hinzufuegen
	 */
    public void addUeberweisungsList(Ueberweisung ueberweisung){
		nameAltArzt= behandelnderArzt.getName();// get name from arzt that make the ueberweisung
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = LocalDateTime.now().format(formatter);
		String newRevision =formattedDateTime+" Sie wurden von Arzt(in) "+nameAltArzt+" überwiesen"; // add revision with time and name of arzt
		revision.add(newRevision);
		setNeuDaten(true); // set new data
		ueberweisungsList.add(ueberweisung);// add to ueberweisunglist
	}

	/**
	 *
	 * @return ueberweisungsList
	 */
    public ArrayList<Ueberweisung> getUeberweisungsList(){return ueberweisungsList;}

	/**
	 *
	 * @return Revision
	 */
	public ArrayList<String> getRevision() {
		return revision;
	}

	/**
	 *
	 * @param untersuchungsbericht Untersuchungsbericht
	 */
	public void addUntersuchungsList(Untersuchungsbericht untersuchungsbericht) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = LocalDateTime.now().format(formatter);
		String newRevision =formattedDateTime+"  Arzt(in) "+untersuchungsbericht.getBehandenderArzt()+" hat eine Untersuchungbericht gemacht"; // add revision with time and name of arzt
		revision.add(newRevision);
		setNeuUntersuchung(true);
		untersuchungsberichtsList.add(untersuchungsbericht);
	}

	/**
	 *
	 * @return Untersuchungslist
	 */
	public ArrayList<Untersuchungsbericht> getUntersuchungList() {
		return untersuchungsberichtsList;
	}

	/**
	 *
	 * @param arzt
	 */
	public void behandeldenArztAendern(Arzt arzt) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = LocalDateTime.now().format(formatter);
		String newRevision =formattedDateTime+" Arzt(in) "+ arzt.getName()+" ist nun ihr(e) Hausarzt(in)";// set new hausarzt, add revision
		revision.add(newRevision);
		this.behandelnderArzt=arzt;
	}

	/**
	 *
	 * @return behandelnder Arzt
	 */
	public Arzt getBehandelnderArzt(){return behandelnderArzt;}

	/**
	 *
	 * @return Passwort
	 */
    public String getPasswort(){return passwort;}

	/**
	 *
	 * @return Name
	 */
	public String getName() {
		return vorName+" "+nachName;
	}

	/**
	 *
	 * @return Vorname
	 */
	public String getVorname(){return vorName;}

	/**
	 *
	 * @return Nachname
	 */
	public String getNachname(){return nachName;}

	/**
	 *
	 * @return Adresse
	 */
	public String getAddress(){return address;}

	/**
	 *
	 * @return Geschlecht
	 */
	public String getGeschlecht(){return geschlecht;}

	/**
	 * Equals check ib 2 patient same
	 *
	 * @param patient1 the patient to check
	 * @return true if 2 patient the same
	 */
	@Override
	public boolean equals(Object patient1) { // check if 2 patient are the same
		Patient patient = (Patient) patient1;
		return(patient.getNum().equals(this.getNum())&&patient.getVorname().equals(this.getVorname())&&patient.getNachname().equals(this.getNachname())&&patient.getAddress().equals(this.getAddress())&&patient.getGeschlecht().equals(this.getGeschlecht())&&patient.getGesburtsDatum().equals(this.getGesburtsDatum())&&patient.getPasswort().equals(this.getPasswort())&&(patient.getBehandelnderArzt()==null&&this.getBehandelnderArzt()==null||patient.getBehandelnderArzt().equals(this.getBehandelnderArzt())));
	}

}

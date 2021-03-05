package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    private boolean isNeuDaten=false;

	private String passwort;

	/**
	 *
	 * @param versicherungNum
	 * @param vorName
	 * @param nachName
	 * @param address
	 * @param geschlecht
	 * @param birth
	 * @param passWort
	 */
	public Patient(String versicherungNum, String vorName,String nachName, String address, String geschlecht, String birth, String passWort) {
		this.passwort=passWort;
        this.versicherungNum=versicherungNum;
		this.vorName=vorName;
		this.nachName=nachName;
        this.address=address;
        this.geschlecht=geschlecht;
        this.gesburtsDatum=birth;
		this.ueberweisungsList= new ArrayList<Ueberweisung>();
		this.untersuchungsberichtsList= new ArrayList<Untersuchungsbericht>();
		this.revision= new ArrayList<String>();
	}

	 /**
	 *
	 * @return
	 */
	public String getNum() {
		return versicherungNum;
	}

	/**
	 *
	 * @return
	 */
    public String getGesburtsDatum(){return gesburtsDatum;}

	/**
	 *
	 * @param r
	 */
	public void addToRevision(String r) {
        revision.add(r);
	}

	/**
	 *
	 * @param n
	 */
	public void setVorname(String n) {
        if(n.equals(vorName)){}
        else{
        	revision.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" Ihrer Vorname wurde von "+vorName+" zu "+n+" geandert");
			vorName=n;
		}
	}

	/**
	 *
	 * @param n
	 */
	public void setNachname(String n) {
        if(n.equals(nachName)){}
        else{
            revision.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" Ihrer Vorname wurde von "+nachName+" zu "+n+" geandert");
			nachName=n;
		}
	}

	/**
	 *
	 * @param a
	 */
	public void setAddress(String a) {
		if(a.equals(address)){}
        else{
			revision.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" Ihre Addresse wurde von "+address+" zu "+a+" geandert");
        	address=a;
		}
	}

	/**
	 *
	 * @param s
	 */
	public void setGeschlecht(String s) {
		if(geschlecht.equals(s)){}
		else{
			revision.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" Ihr Geschlecht wurde von "+geschlecht+" zu "+s+" geandert");
			geschlecht=s;
		}
	}
	/**
	 *
	 * @param p
	 */
	public void setPasswort(String p){
		if(passwort.equals(p)){}
		else{
			revision.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" Ihr Passwort wurde von "+passwort+" zu "+p+" geandert");
			passwort=p;
		}
	}
	/**
	 *
	 * @param b
	 */
	public void setBirth(String b) {
        if(gesburtsDatum.equals(b)){}
        else{
        	revision.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" Ihr Gesburtsdatum wurde von "+gesburtsDatum+" zu "+b+" geandert");
            gesburtsDatum=b;
		}
	}

	/**
	 *
	 * @param b
	 */
	public void setNeuDaten(boolean b){isNeuDaten=b;}

	/**
	 *
	 * @return
	 */
	public boolean isNeuDaten(){return isNeuDaten;}

	/**
	 *
	 */
	public void updateDaten(){
		int count=0;
		for(int i=0; i< ueberweisungsList.size();i++){
			if(!ueberweisungsList.get(i).isDatenStimmZu()){
                count++;
			}
		}
		isNeuDaten=(count!=0);
	}

	/**
	 *
	 * @param u
	 */
    public void addUeberweisungsList(Ueberweisung u){
		nameAltArzt= behandelnderArzt.getName();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = LocalDateTime.now().format(formatter);
		String s =formattedDateTime+" Sie wurden von Arzt(in) "+nameAltArzt+" überwiesen";
		revision.add(s);
		setNeuDaten(true);
		ueberweisungsList.add(u);
	}

	/**
	 *
	 * @return
	 */
    public ArrayList<Ueberweisung> getUeberweisungsList(){return ueberweisungsList;}

	/**
	 *
	 * @return
	 */
	public ArrayList<String> getRevision() {
		return revision;
	}

	/**
	 *
	 * @param u
	 */
	public void addUntersuchungsList(Untersuchungsbericht u) {
        untersuchungsberichtsList.add(u);
	}

	/**
	 *
	 * @return
	 */
	public ArrayList<Untersuchungsbericht> getUntersuchungList() {
		return untersuchungsberichtsList;
	}

	/**
	 *
	 * @param artzt
	 */
	public void behandeldenArztAendern(Arzt artzt) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = LocalDateTime.now().format(formatter);
		String s =formattedDateTime+" Arzt(in) "+ artzt.getName()+" ist nun ihr(e) Hausarzt(in)";
		revision.add(s);
		this.behandelnderArzt=artzt;
	}

	/**
	 *
	 * @return
	 */
	public Arzt getBehandelnderArzt(){return behandelnderArzt;}

	/**
	 *
	 * @return
	 */
    public String getPasswort(){return passwort;}

	/**
	 *
	 * @return
	 */
	public String getName() {
		return vorName+" "+nachName;
	}

	/**
	 *
	 * @return
	 */
	public String getVorname(){return vorName;}

	/**
	 *
	 * @return
	 */
	public String getNachname(){return nachName;}

	/**
	 *
	 * @return
	 */
	public String getAddress(){return address;}

	/**
	 *
	 * @return
	 */
	public String getGeschlecht(){return geschlecht;}

	/**
	 * Equals boolean.
	 *
	 * @param o the patient
	 * @return the boolean
	 */
	@Override
	public boolean equals(Object o) {
		Patient patient = (Patient)o;
		return(patient.getNum().equals(this.getNum())&&patient.getVorname().equals(this.getVorname())&&patient.getNachname().equals(this.getNachname())&&patient.getAddress().equals(this.getAddress())&&patient.getGeschlecht().equals(this.getGeschlecht())&&patient.getGesburtsDatum().equals(this.getGesburtsDatum())&&patient.getPasswort().equals(this.getPasswort())&&patient.getBehandelnderArzt().equals(this.getBehandelnderArzt()));
	}

}

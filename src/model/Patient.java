package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Patient {

	private String num;

	private ArrayList<Ueberweisung> ueberweisungsList;

	private String Vorname;
	private String Nachname;

	private String address;

	private String geschlecht;

	private String gesburtsDatum;

	private ArrayList<String> revision;

	private ArrayList<Untersuchungsbericht> untersuchungsList;

	private Arzt behandelnderArzt;

	private Collection<Ueberweisung> überweisung;
	private String passwort;


	private Collection<Untersuchungsbericht> untersuchungsbericht;

	public Patient(String num, String Vorname,String Nachname, String Address, String Geschlecht, String Birth, String pass) {
		this.passwort=pass;;
        this.num=num;
		this.Vorname=Vorname;
		this.Nachname=Nachname;
        this.address=Address;
        this.geschlecht=Geschlecht;
        this.gesburtsDatum=Birth;
		ueberweisungsList= new ArrayList<Ueberweisung>();
		revision= new ArrayList<String>();
		untersuchungsList= new ArrayList<Untersuchungsbericht>();
	}

	public String getNum() {
		return num;
	}
    public String getGesburtsDatum(){return gesburtsDatum;}
	public void addToRevision(String r) {

	}

	public void setVorname(String n) {
        Vorname=n;
	}
	public void setNachname(String n) {
        Nachname=n;
	}
	public void setAddress(String a) {

	}

	public void setGeschlecht(String s) {

	}

	public void setBirth(String b) {

	}

	public List<String> getRevision() {
		return null;
	}

	public List<String> getInfo() {
		return null;
	}

	public List<Ueberweisung> getÜberweisungList() {
		return null;
	}

	public void addUntersuchungsList(Untersuchungsbericht u) {

	}

	public List<Untersuchungsbericht> getUntersuchungList() {
		return null;
	}

	public void behandeldenArztAendern(Arzt artzt) {
		this.behandelnderArzt=artzt;

	}
	public Arzt getBehandelnderArzt(){return behandelnderArzt;}
    public String getPasswort(){return passwort;}
	public String getName() {
		return Vorname+" "+Nachname;
	}
	public String getVorname(){return Vorname;}
	public String getNachname(){return Nachname;}
	public String getAddress(){return address;}
	public String getGeschlecht(){return geschlecht;}
	public void setPasswort(String p){passwort=p;}

}

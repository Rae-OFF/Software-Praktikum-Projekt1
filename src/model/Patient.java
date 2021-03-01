package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Patient {

	private String num;

	private ArrayList<Ueberweisung> ueberweisungsList;

	private String name;

	private String address;

	private String geschlecht;

	private String gesburtsDatum;

	private ArrayList<String> revision;

	private ArrayList<Untersuchungsbericht> untersuchungsList;

	private Arzt behandelnderArzt;

	private Collection<Ueberweisung> überweisung;
	private String passwort;


	private Collection<Untersuchungsbericht> untersuchungsbericht;

	public Patient(String num, String name, String Address, String Geschlecht, String Birth, String pass) {
		this.passwort=pass;
        this.name=name;
        this.num=num;
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

	public void addToRevision(String r) {

	}

	public void setName(String n) {

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

	}
    public String getPasswort(){return passwort;}
	public String getName() {
		return null;
	}
	public void setPasswort(String p){passwort=p;}

}

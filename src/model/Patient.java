package model;

import java.util.Collection;
import java.util.List;

public class Patient {

	private String num;

	private List<Ueberweisung> ueberweisungsList;

	private String name;

	private String address;

	private String geschlecht;

	private String gesburtsDatum;

	private List<String> revision;

	private List<Untersuchungsbericht> untersuchungsList;

	private Arzt behandelnderArzt;

	private Collection<Ueberweisung> überweisung;

	private Collection<Untersuchungsbericht> untersuchungsbericht;

	public Patient(String num, String name, String Address, String Geschlecht, String Birth) {

	}

	public String getNum() {
		return null;
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

	public String getName() {
		return null;
	}

}

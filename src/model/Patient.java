package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Patient {

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

	public String getNum() {
		return versicherungNum;
	}
    public String getGesburtsDatum(){return gesburtsDatum;}
	public void addToRevision(String r) {
        revision.add(r);
	}
	public void setVorname(String n) {
        vorName=n;
	}
	public void setNachname(String n) {
        nachName=n;
	}
	public void setAddress(String a) {
         address=a;
	}
	public void setGeschlecht(String s) {
        geschlecht=s;
	}
	public void setBirth(String b) {
        gesburtsDatum=b;
	}
	public void setNeuDaten(boolean b){isNeuDaten=b;}
	public boolean isNeuDaten(){return isNeuDaten;}
	public void updateDaten(){
		int count=0;
		for(int i=0; i< ueberweisungsList.size();i++){
			if(!ueberweisungsList.get(i).isDatenStimmZu()){
                count++;
			}
		}
		isNeuDaten=(count!=0);
	}
    public void addUeberweisungsList(Ueberweisung u){
		nameAltArzt= behandelnderArzt.getName();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = LocalDateTime.now().format(formatter);
		String s =formattedDateTime+" Sie wurden von Arzt(in) "+nameAltArzt+" überwiesen";
		revision.add(s);
		setNeuDaten(true);
		ueberweisungsList.add(u);
	}
    public ArrayList<Ueberweisung> getUeberweisungsList(){return ueberweisungsList;}

	public ArrayList<String> getRevision() {
		return revision;
	}

	public void addUntersuchungsList(Untersuchungsbericht u) {
        untersuchungsberichtsList.add(u);
	}

	public ArrayList<Untersuchungsbericht> getUntersuchungList() {
		return untersuchungsberichtsList;
	}

	public void behandeldenArztAendern(Arzt artzt) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = LocalDateTime.now().format(formatter);
		String s =formattedDateTime+" Arzt(in) "+ artzt.getName()+" ist nun ihr(e) Hausarzt(in)";
		revision.add(s);
		this.behandelnderArzt=artzt;
	}
	public Arzt getBehandelnderArzt(){return behandelnderArzt;}
    public String getPasswort(){return passwort;}
	public String getName() {
		return vorName+" "+nachName;
	}
	public String getVorname(){return vorName;}
	public String getNachname(){return nachName;}
	public String getAddress(){return address;}
	public String getGeschlecht(){return geschlecht;}
	public void setPasswort(String p){passwort=p;}

}

package model;

import java.util.ArrayList;
import java.util.Collection;
import java.lang.UnsupportedOperationException;
import java.util.List;

public class Arzt {

    /**
 	 * 
 	 */
    private String num;

    /**
 	 * 
 	 */
    private ArrayList<Patient> patientList;

    /**
 	 * 
 	 */
    private ArrayList<Ueberweisung> ueberweisungList;

    /**
 	 * 
 	 */
    private ArrayList<Untersuchungsbericht> untersuchungsList;

    /**
 	 * 
 	 */
    private String fachrichtung;

    /**
 	 * 
 	 */
    private String Vorname;
    private String Tel;
	private String Nachname;
    /**
 	 * 
 	 */
    private ArrayList<String> revision;

    /**
 	 * 
 	 */
    private Collection<Patient> patient;

    /**
 	 * 
 	 */
    private Collection<Untersuchungsbericht> untersuchungsbericht;

    /**
 	 * 
 	 */
    private Collection<Ueberweisung> ueberweisung;
    private String passwort;
    public Arzt(String Vorname,String Nachname, String fach, String num, String passwort, String Tel) {
    	this.passwort= passwort;
    	this.num=num;
    	this.Vorname=Vorname;
    	this.Nachname=Nachname;
    	this.fachrichtung=fach;
    	this.Tel=Tel;
		patientList=new ArrayList<Patient>();
		ueberweisungList=new ArrayList<Ueberweisung>();
		untersuchungsList= new ArrayList<Untersuchungsbericht>();
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param patient
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addPatientToList(Patient patient) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }


    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param patient
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void removeFromPatientlist(Patient patient) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param u
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addUntersuchungsberichrt(Untersuchungsbericht u) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param u
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addÜberweisung(Ueberweisung u) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param f
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void setFach(String f) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
    public String getFachrichtung(){return fachrichtung;}

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param n
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void setName(String n) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param r
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addToRevision(String r) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return List<String>
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public ArrayList<String> getInfo() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param versicherungsnummer
 	 * @return boolean
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public boolean checkPatientValid(String versicherungsnummer) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param versicherungsnummer
 	 * @return List<Untersuchungsbericht>
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public ArrayList<Untersuchungsbericht> getUntersuchungsberichte(String versicherungsnummer) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return String
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public String getNum() throws UnsupportedOperationException {
        return num;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return List<String>
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public ArrayList<String> getRevision() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return String
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public String getName() throws UnsupportedOperationException {
        return Vorname+" "+Nachname;
    }
    public String getTel(){return Tel;}
    public void setTel(String n){Tel=n;}
	public String getVorname(){return Vorname;}
	public String getNachname(){return Nachname;}
    public String getPasswort(){return passwort;}
    public void setPasswort(String p){this.passwort=p;}
}

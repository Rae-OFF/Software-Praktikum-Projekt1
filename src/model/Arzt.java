package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.lang.UnsupportedOperationException;
import java.util.List;

public class Arzt {

    /**
 	 * 
 	 */
    private String idNum;

    /**
 	 * 
 	 */
    private ArrayList<Patient> patientList;


    /**
 	 * 
 	 */
    private ArrayList<Untersuchungsbericht> untersuchungsList;

    /**
 	 * 
 	 */
    private String fachRichtung;

    /**
 	 * 
 	 */
    private String vorName;
    private String tel;
	private String nachName;
    /**
 	 * 
 	 */
    private ArrayList<String> revision;

    /**
 	 * 
 	 */
    private ArrayList<Patient> patient;


    private String passWort;
    public Arzt(String vorName,String nachName, String fach, String idNum, String passWort, String tel) {
    	this.passWort= passWort;
    	this.idNum=idNum;
    	this.vorName=vorName;
    	this.nachName=nachName;
    	this.fachRichtung=fach;
    	this.tel=tel;
		patientList=new ArrayList<Patient>();
		untersuchungsList= new ArrayList<Untersuchungsbericht>();
		revision=new ArrayList<String>();
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param patient
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addPatientToList(Patient patient)  {
    	String time= LocalDateTime.now().toString();
    	String s= time+" Patient(in) "+patient.getName()+" mit Versicherungsnummer "+patient.getNum()+" wurde in ihrer Patientenliste hinzugefügt";
    	revision.add(s);
        patientList.add(patient);
    }


    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param patient
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void removeFromPatientlist(Patient patient)  {
        patientList.remove(patient);
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addUntersuchungsberichrt(Untersuchungsbericht untersuchungsbericht)  {
        untersuchungsList.add(untersuchungsbericht);
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
    public String getFachrichtung(){return fachRichtung;}

    public void setName(String n) {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    public void addToRevision(String re) {
        revision.add(re);
    }


    public Patient getPatient(String num){
		for(int i=0; i< patientList.size(); i++){
			if(patientList.get(i).getNum().equals(num)){return patientList.get(i);}
		}
    	return null;
	}
    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param versicherungsnummer
 	 * @return boolean
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public boolean checkPatientValid(String versicherungsnummer)  {
        for(int i=0; i< patientList.size(); i++){
        	if(patientList.get(i).getNum().equals(versicherungsnummer)){return true;}
		}
        return false;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param versicherungsnummer
 	 * @return List<Untersuchungsbericht>
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public ArrayList<Untersuchungsbericht> getUntersuchungsberichte(String versicherungsnummer){
        ArrayList<Untersuchungsbericht> berichtList= new ArrayList<Untersuchungsbericht>();
        for(int i=0; i< untersuchungsList.size();i++){
        	if(untersuchungsList.get(i).getPatientNum().equals(versicherungsnummer)){berichtList.add(untersuchungsList.get(i));}
		}
        return berichtList;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return String
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public String getNum()   {
        return idNum;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return List<String>
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public ArrayList<String> getRevision()  {
        return revision;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return String
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public String getName()  {
        return vorName+" "+nachName;
    }
    public String getTel(){return tel;}
    public void setTel(String n){tel=n;}
	public String getVorname(){return vorName;}
	public String getNachname(){return nachName;}
    public String getPasswort(){return passWort;}
    public void setPasswort(String passWort){this.passWort=passWort;}
}

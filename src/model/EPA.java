package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.lang.UnsupportedOperationException;
import java.util.List;

public class EPA implements Serializable {

    /**
 	 * 
 	 */
    private ArrayList<Arzt> arztList;

    /**
 	 * 
 	 */
    private ArrayList<Patient> patientList;

    /**
 	 * 
 	 */


    public EPA() {
    	this.arztList= new ArrayList<Arzt>();
    	this.patientList= new ArrayList<Patient>();
    	ArrayList<Untersuchungsbericht> untersuchungslist=new ArrayList<Untersuchungsbericht>();
    	Arzt testArzt1 =new Arzt("hai","nguyen","unknown","1234","1234","1900");
    	Arzt testArzt2 = new Arzt("tram","la","unknown","5678","5678","1090");
		arztList.add(testArzt2);
		Patient testPatient1 =new Patient("1234","hai","nguyen","ho chi minh stadt","male","1.1.2022","1234");
		ArrayList<String> medikamente= new ArrayList<>() ;
		medikamente.add("med1");
		medikamente.add("med2");
		ArrayList<String> notiz= new ArrayList<String>() ;
		notiz.add("notiz1");
		notiz.add("notiz2");
		Untersuchungsbericht untersuchungsbericht1= new Untersuchungsbericht("1234", "hai nguyen", LocalDateTime.now(), "000.0",medikamente, "aaaa", "aaaaa", notiz);
		Untersuchungsbericht untersuchungsbericht2= new Untersuchungsbericht("5678", "hai nguyen", LocalDateTime.now(), "000.0",medikamente, "aaaa", "aaaaa", notiz);
		testPatient1.behandeldenArztAendern(testArzt1);
		testPatient1.addUntersuchungsList(untersuchungsbericht1);
		untersuchungslist.add(untersuchungsbericht1);
		Ueberweisung ueberweisung1=new Ueberweisung();
		ueberweisung1.setAltArztNummer("1234").setPatientNummer("1234").setNeuArztNummer("5678").setUntersuchungberichtInit(untersuchungslist).setAuftrag("test").setDate("1.1.2022");
		testPatient1.addUeberweisungsList(ueberweisung1);
		Ueberweisung ueberweisung2=new Ueberweisung();
		ueberweisung2.setAltArztNummer("5678").setPatientNummer("1234").setNeuArztNummer("1234").setUntersuchungberichtInit(untersuchungslist).setAuftrag("test").setDate("2.1.2022");
		testPatient1.addUeberweisungsList(ueberweisung2);
		testArzt1.addPatientToList(testPatient1);
		arztList.add(testArzt1);
		Patient testPatient2 =new Patient("5678","tram","la","ho chi minh stadt","female","1.1.2022","5678");
		testPatient2.addUntersuchungsList(untersuchungsbericht2);
		testPatient2.addUntersuchungsList(untersuchungsbericht2);
		patientList.add(testPatient1);
		patientList.add(testPatient2);
		// testArzt1 id 1234 pass 1234, hat patient testPatient1
		// testArzt2 id 5678 pass 5678  hat kein patient
		// testPatient1 id 1234 pass 1234 hat Arzt testArzt1, hat Untersuchungsbericht untersuchungsbericht1, hat 2 Ueberweisung ueberweisung1 ueberweisung 2
		// ueberweisung hat untersuchungsbericht
		// testPatient2 id 5678 pass 5678 hat 2 untersuchungen untersuchungsbericht2
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param num
 	 * @return Patient
 	 */
    public Patient getPatient(String num) {
		for(int i=0; i< patientList.size(); i++){
			if(patientList.get(i).getNum().equals(num)){return patientList.get(i);}
		}
		return null;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param num
 	 * @return Arzt
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public Arzt getArzt(String num) {
        for(int i=0; i< arztList.size(); i++){
        	if(arztList.get(i).getNum().equals(num)){return arztList.get(i);}
		}
        return null;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param num
 	 * @return boolean
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public boolean checkNumArzt(String num)  {
        for(int i=0; i< arztList.size(); i++){
        	if(arztList.get(i).getNum().equals(num)){return true;}
		}
        return false;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param num
 	 * @return boolean
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public boolean checkNumPatient(String num)  {
		for(int i=0; i< patientList.size(); i++){
			if(patientList.get(i).getNum().equals(num)){return true;}
		}
		return false;
    }
}

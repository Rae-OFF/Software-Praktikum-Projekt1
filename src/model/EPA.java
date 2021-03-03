package model;

import java.util.ArrayList;
import java.util.Collection;
import java.lang.UnsupportedOperationException;
import java.util.List;

public class EPA {

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
		Untersuchungsbericht untersuchungsbericht= new Untersuchungsbericht("","",null,"",null,"","",null);
		testPatient1.behandeldenArztAendern(testArzt1);
		testPatient1.addUntersuchungsList(untersuchungsbericht);
		untersuchungslist.add(untersuchungsbericht);
		Ueberweisung ueberweisung = new Ueberweisung("1234","1234","5678",untersuchungslist,"test","1.1.2022");
		testPatient1.addUeberweisungsList(ueberweisung);
		testArzt1.addPatientToList(testPatient1);
		arztList.add(testArzt1);
		Patient testPatient2 =new Patient("5678","tram","la","ho chi minh stadt","female","1.1.2022","5678");
		patientList.add(testPatient1);
		patientList.add(testPatient2);
		// testArzt1 id 1234 pass 1234, hat patient testPatient1
		// testArzt2 id 5678 pass 5678  hat kein patient
		// testPatient1 id 1234 pass 1234 hat Arzt testArzt1, hat Untersuchungsbericht untersuchungsbericht(leer), hat Ueberweisung ueberweisung
		// ueberweisung hat untersuchungsbericht
		// testPatient2 id 5678 pass 5678 hat nichts
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
    public Arzt getArzt(String num) throws UnsupportedOperationException {
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
    public boolean checkNumArzt(String num) throws UnsupportedOperationException {
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
    public boolean checkNumPatient(String num) throws UnsupportedOperationException {
		for(int i=0; i< patientList.size(); i++){
			if(patientList.get(i).getNum().equals(num)){return true;}
		}
		return false;
    }
}

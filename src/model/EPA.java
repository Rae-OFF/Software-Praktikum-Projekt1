package model;

import java.util.ArrayList;
import java.util.Collection;
import java.lang.UnsupportedOperationException;
import java.util.List;

public class EPA {

    /**
 	 * 
 	 */
    private ArrayList<Arzt> arzt;

    /**
 	 * 
 	 */
    private ArrayList<Patient> patient;

    /**
 	 * 
 	 */


    public EPA() {
    	arzt= new ArrayList<Arzt>();
    	patient= new ArrayList<Patient>();
    	ArrayList<Untersuchungsbericht> untersuchungslist=new ArrayList<Untersuchungsbericht>();
    	Arzt a =new Arzt("hai","nguyen","unknown","1234","1234","1900");
    	Arzt a1 = new Arzt("tram","la","unknown","5678","5678","1090");
		arzt.add(a1);
		Patient p =new Patient("1234","hai","nguyen","ho chi minh stadt","male","1.1.2022","1234");
		Untersuchungsbericht u= new Untersuchungsbericht("","",null,"",null,"","",null);
		p.behandeldenArztAendern(a);
		p.addUntersuchungsList(u);
		untersuchungslist.add(u);
		Ueberweisung ue = new Ueberweisung("1234","1234","5678",untersuchungslist,"test","1.1.2022");
		p.addUeberweisungsList(ue);
		a.addPatientToList(p);
		arzt.add(a);
		Patient p1 =new Patient("5678","tram","la","ho chi minh stadt","female","1.1.2022","5678");
		patient.add(p);
		patient.add(p1);
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param num
 	 * @return Patient
 	 */
    public Patient getPatient(String num) {
		for(int i=0; i< patient.size(); i++){
			if(patient.get(i).getNum().equals(num)){return patient.get(i);}
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
        for(int i=0; i< arzt.size(); i++){
        	if(arzt.get(i).getNum().equals(num)){return arzt.get(i);}
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
        for(int i=0; i< arzt.size(); i++){
        	if(arzt.get(i).getNum().equals(num)){return true;}
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
		for(int i=0; i< patient.size(); i++){
			if(patient.get(i).getNum().equals(num)){return true;}
		}
		return false;
    }
}

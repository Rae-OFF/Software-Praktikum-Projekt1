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
    	arzt.add(new Arzt("","","1234","1234"));
    	patient.add(new Patient("1234","","","","","1234"));

    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param num
 	 * @return Patient
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public Patient getPatient(String num) throws UnsupportedOperationException {
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

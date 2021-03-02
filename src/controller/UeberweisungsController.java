package controller;

import AUI.UeberweisungsAUI;
import model.*;

import java.lang.UnsupportedOperationException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class UeberweisungsController {

    /**
 	 * 
 	 */
    private EPAController ePAController;

    /**
 	 * 
 	 */
    private UeberweisungsAUI ueberweisungsAUI;

    public UeberweisungsController(EPAController e) {
    	this.ePAController=e;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 

 	 * @return Ueberweisung
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public Ueberweisung createUeberweisung(String altArzt,String pnum, String Artzbezeich, String Auftrag, ArrayList<Untersuchungsbericht> berichtliste,String time) throws UnsupportedOperationException {
		Ueberweisung ueberweisung= new Ueberweisung(altArzt,pnum,Artzbezeich,berichtliste,Auftrag,time);
		return ueberweisung;
    }

    /**
 	 *

 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addÜberweisung( Ueberweisung u) throws UnsupportedOperationException {
        EPA epa= ePAController.getEPA();
        Patient p =epa.getPatient(u.getPatientnummer());
        Arzt neuArzt = epa.getArzt(u.getNeuarztnummer());
        p.behandeldenArztAendern(neuArzt);
        neuArzt.addPatientToList(p);
        p.addUeberweisungsList(u);
        Arzt altArzt=epa.getArzt(ePAController.getCurrLoggedIn());
        altArzt.addÜberweisung(u);

    }
}

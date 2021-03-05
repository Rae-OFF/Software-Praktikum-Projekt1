package controller;

import model.*;
import java.io.IOException;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;

/**
 * The type Ueberweisungs controller.
 */
public class UeberweisungsController {

    /**
 	 * 
 	 */
    private EPAController ePAController;

    /**
 	 * 
 	 */

    public UeberweisungsController(EPAController epaController) {
    	this.ePAController=epaController;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 

 	 * @return Ueberweisung
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public Ueberweisung createUeberweisung(String altArzt,String versicherungsNum, String neuArzt, String auftrag, ArrayList<Untersuchungsbericht> berichtListe,String time) {
		//Ueberweisung ueberweisung= new Ueberweisung(altArzt,versicherungsNum,neuArzt,berichtListe,auftrag,time);
        Ueberweisung ueberweisung=new Ueberweisung();
        ueberweisung.setPatientNummer(versicherungsNum).setAltArztNummer(altArzt).setNeuArztNummer(neuArzt).setAuftrag(auftrag).setUntersuchungberichtInit(berichtListe).setDate(time);
		return ueberweisung;
    }

    /**
 	 *

 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addUeberweisung( Ueberweisung ueberweisung) throws IOException {
        EPA epa= ePAController.getEPA();
        Patient patient =epa.getPatient(ueberweisung.getPatientnummer());
        Arzt neuArzt = epa.getArzt(ueberweisung.getNeuarztnummer());
        patient.behandeldenArztAendern(neuArzt);
        neuArzt.addPatientToList(patient);
        patient.addUeberweisungsList(ueberweisung);
        Arzt altArzt=epa.getArzt(ueberweisung.getAltArztnummer());
        neuArzt.addToRevision(ueberweisung.getDate()+" Sie haben eine Patient Überweisung von Arzt(in) "+altArzt.getName());
        altArzt.addToRevision(ueberweisung.getDate()+" Sie haben eine Patient Überweisung zu Arzt(in) "+neuArzt.getName()+" gemacht");
        ePAController.getIO().save();
    }
}

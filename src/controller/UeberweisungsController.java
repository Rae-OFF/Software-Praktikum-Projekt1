package controller;

import model.*;
import java.io.IOException;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;

/**
 * The type Ueberweisungs controller.
 */
public class UeberweisungsController {

    private EPAController ePAController;

    /**
     * Instantiates a new Ueberweisung Construktur
     * @param epaController epaController
     */

    public UeberweisungsController(EPAController epaController) {
    	this.ePAController=epaController;
    }

    /**
 	 *
 	 * neue Ueberweisung erstellen.

 	 *
     * create new ueberweisung
 	 * @return Ueberweisung
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public Ueberweisung createUeberweisung(String altArzt,String versicherungsNum, String neuArzt, String auftrag, ArrayList<Untersuchungsbericht> berichtListe,String time) {
        Ueberweisung ueberweisung=new Ueberweisung(); // create ueberweisung with empty constructor
        ueberweisung.setPatientNummer(versicherungsNum).setAltArztNummer(altArzt).setNeuArztNummer(neuArzt).setAuftrag(auftrag).setUntersuchungberichtInit(berichtListe).setDate(time); // set attributes
		return ueberweisung; // return ueberweisung
    }

    /**
 	 * add new ueberweisung to its patient / arzt list
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 *
 	 *
 	 */
    public void addUeberweisung( Ueberweisung ueberweisung) throws IOException {
        EPA epa= ePAController.getEPA(); // get epa
        Patient patient =epa.getPatient(ueberweisung.getPatientnummer()); // get patient with info from ueberweisung in parameter
        Arzt neuArzt = epa.getArzt(ueberweisung.getNeuarztnummer()); // get new arzt the same way
        neuArzt.addPatientToList(patient); // add patient to list of new arzt
        patient.addUeberweisungsList(ueberweisung); // add ueberweisung in parameter ot list of patient
        Arzt altArzt=epa.getArzt(ueberweisung.getAltArztnummer()); // get old arzt the same way
        neuArzt.addToRevision(ueberweisung.getDate()+" Sie haben eine Patient Überweisung von Arzt(in) "+altArzt.getName()); // update revision 2 arzt
        altArzt.addToRevision(ueberweisung.getDate()+" Sie haben eine Patient Überweisung zu Arzt(in) "+neuArzt.getName()+" gemacht");
        ePAController.getIO().save(); // save
    }
}

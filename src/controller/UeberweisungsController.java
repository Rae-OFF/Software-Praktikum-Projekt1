package controller;

import AUI.UeberweisungsAUI;
import model.Ueberweisung;

import java.lang.UnsupportedOperationException;

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
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param arztNummer
 	 * @param patientenNummer
 	 * @return Ueberweisung
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public Ueberweisung createUeberweisung(String arztNummer, String patientenNummer) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param patientenNummer
 	 * @param untersuchungsbericht
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addÜberweisung(String patientenNummer, Ueberweisung untersuchungsbericht) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}

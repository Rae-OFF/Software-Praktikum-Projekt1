package controller;

import AUI.ZusammenfassungsAUI;
import model.Untersuchungsbericht;

import java.lang.UnsupportedOperationException;
import java.util.List;

public class ZusammenfassungsController {

    /**
 	 * 
 	 */
    private List<Untersuchungsbericht> zusammenfassung;

    /**
 	 * 
 	 */
    private EPAController ePAController;

    /**
 	 * 
 	 */
    private ZusammenfassungsAUI zusammenfassungsAUI;

    public ZusammenfassungsController(EPAController e) {
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param untersuchungsbericht
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addToZusammenfassung(Untersuchungsbericht untersuchungsbericht) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param versicherungsnummer
 	 * @param iCD
 	 * @return List<Untersuchungsbericht>
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public List<Untersuchungsbericht> createZusammenfassungEinArzt(String versicherungsnummer, String iCD) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param versicherungsnummer
 	 * @param iCD
 	 * @return List<Untersuchungsbericht>
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public List<Untersuchungsbericht> createZusammenfassungAlleAerzte(String versicherungsnummer, String iCD) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}

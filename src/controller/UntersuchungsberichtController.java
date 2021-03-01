package controller;

import AUI.UntersuchungsberichtAUI;
import model.Untersuchungsbericht;

import java.lang.UnsupportedOperationException;
import java.time.LocalDateTime;
import java.util.List;

public class UntersuchungsberichtController {

    /**
 	 * 
 	 */
    private EPAController ePAController;

    /**
 	 * 
 	 */
    private UntersuchungsberichtAUI untersuchungsberichtAUI;

    public UntersuchungsberichtController(EPAController e) {
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param d
 	 * @param diagnose
 	 * @param Med
 	 * @param Behandlung
 	 * @param icd
 	 * @param pnum
 	 * @return Untersuchungsbericht
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public Untersuchungsbericht createUntersuchungsbericht(LocalDateTime d, String diagnose, List<String> Med, String Behandlung, String icd, String pnum) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param pnum
 	 * @param u
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addUntersuchungbericht(String pnum, Untersuchungsbericht u) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return boolean
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public boolean datenUeberpruefen() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}

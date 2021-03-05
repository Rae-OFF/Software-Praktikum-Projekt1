
package controller;

import controller.EPAController;
import controller.UeberweisungsController;
import model.EPA;
import model.Ueberweisung;
import model.Untersuchungsbericht;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 *Zur überprüfung der Klasse ZusammenfassungController.
 */
public class ZusammenfassungControllerTest {
    EPAController epaController=new EPAController();

    /**
     *Setup ,was in den Test gebraucht wird.
     */
    @Before
    public void setUp() throws Exception {
        epaController.setCurrLoggedIn("1234");
    }

    /**
     *Test,  ob Zusammenfassung von aktuell behandelndem Arzt richtig erstellt wird .
     */
    @Test
    public void createzusammenfassungEinArzte() {
        ArrayList<Untersuchungsbericht> untersuchungsberichts=epaController.getZusammenfassungsController().createZusammenfassungEinArzt("1234","leer");
        assertEquals(untersuchungsberichts.size(),1);
    }

    /**
     *Test,  ob Zusammenfassung von unterschiedlichen Ärzten richtig erstellt wird .
     */
    @Test
    public void createzusammenfassungAllerArzt() {
        ArrayList<Untersuchungsbericht> untersuchungsberichts1=epaController.getZusammenfassungsController().createZusammenfassungAlleAerzte("1234","leer");
        assertEquals(untersuchungsberichts1.size(),3);
    }
}


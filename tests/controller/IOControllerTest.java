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
 * The type Io controller test.
 */
public class IOControllerTest {
    /**
     * The Epa controller.
     */
    EPAController epaController=new EPAController();

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Save.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    @Test
    public void save() throws IOException, ClassNotFoundException {
        EPA epa1=epaController.getEPA();
        epaController.getIO().save();
        epaController.getIO().load();
        EPA epa2=epaController.getEPA();
        assertEquals(epa2.getArztList().size(),epa1.getArztList().size());
        assertEquals(epa2.getPatientList().size(),epa1.getPatientList().size());
        for(int i=0; i<epa2.getArztList().size(); i++ ){
            assertTrue(epa2.getArztList().get(i).equals(epa1.getArztList().get(i)));
        }
        for(int i=0; i<epa2.getArztList().size(); i++ ){
            assertTrue(epa2.getPatientList().get(i).equals(epa1.getPatientList().get(i)));
        }
    }

    /**
     * Load.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    @Test
    public void load() throws IOException, ClassNotFoundException {
        EPA epa1=epaController.getEPA();
        epaController.getIO().load();
        EPA epa2=epaController.getEPA();
        assertEquals(epa2.getArztList().size(),epa1.getArztList().size());
        assertEquals(epa2.getPatientList().size(),epa1.getPatientList().size());
        for(int i=0; i<epa2.getArztList().size(); i++ ){
            assertTrue(epa2.getArztList().get(i).equals(epa1.getArztList().get(i)));
        }
        for(int i=0; i<epa2.getArztList().size(); i++ ){
            assertTrue(epa2.getPatientList().get(i).equals(epa1.getPatientList().get(i)));
        }
    }

}

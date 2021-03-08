
package controller;

import controller.EPAController;
import controller.UeberweisungsController;
import model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *Zur überprüfung der Klasse ZusammenfassungController.
 */
public class ZusammenfassungControllerTest {
    EPAController epaController=new EPAController();
    Untersuchungsbericht[] untersuchung=new Untersuchungsbericht[3];
    /**
     *Setup ,was in den Test gebraucht wird.
     */
    @Before
    public void setUp() throws Exception {
        EPA epa= new EPA();
        Arzt arzt1= new Arzt("testone","testone","Hausarzt","1234","1234","1111");
        Arzt arzt2= new Arzt("testtwo","testtwo","Hausarzt","5678","5678","1111");
        Arzt arzt3= new Arzt("testthree","testthree","Hausarzt","890","890","1111");
        Patient p = new Patient("1234","test","test","bochum","m","1.1.1111","1234");
        p.behandeldenArztAendern(arzt1);
        arzt1.addPatientToList(p);
        untersuchung[0]= new Untersuchungsbericht("1234", "1234", LocalDateTime.now(), "A0", null,"","", null);
        p.addUntersuchungsList(untersuchung[0]);
        arzt1.addUntersuchungsberichrt(untersuchung[0]);
        untersuchung[1]= new Untersuchungsbericht("1234", "5678", LocalDateTime.now(), "A1", null,"","", null);
        p.addUntersuchungsList(untersuchung[1]);
        arzt2.addUntersuchungsberichrt(untersuchung[1]);
        untersuchung[2]= new Untersuchungsbericht("1234", "890", LocalDateTime.now(), "A2", null,"","", null);
        p.addUntersuchungsList(untersuchung[2]);
        arzt3.addUntersuchungsberichrt(untersuchung[2]);
        epa.addPatientToList(p);
        epa.addArzttToList(arzt1);
        epa.addArzttToList(arzt2);
        epa.addArzttToList(arzt3);
        epaController.setEPA(epa);
        epaController.setCurrLoggedIn("1234");
    }

    /**
     *Test,  ob Zusammenfassung von aktuell behandelndem Arzt richtig erstellt wird .
     */
    @Test
    public void createzusammenfassungEinArzte() {
        ArrayList<Untersuchungsbericht> untersuchungsberichts=epaController.getZusammenfassungsController().createZusammenfassungEinArzt("1234","leer");
        assertEquals(untersuchungsberichts.size(),1);
        for(int i=0;i< untersuchungsberichts.size();i++){
            assertTrue(equalsBericht(untersuchungsberichts.get(i),untersuchung[i]));
        }
    }

    /**
     *Test,  ob Zusammenfassung von unterschiedlichen Ärzten richtig erstellt wird .
     */
    @Test
    public void createzusammenfassungAllerArzt() {
        ArrayList<Untersuchungsbericht> untersuchungsberichts1=epaController.getZusammenfassungsController().createZusammenfassungAlleAerzte("1234","leer");
        assertEquals(untersuchungsberichts1.size(),1);
        for(int i=0;i< untersuchungsberichts1.size();i++){
            assertTrue(equalsBericht(untersuchungsberichts1.get(i),untersuchung[i]));
        }
    }

    /**
     * Test,  ob Zusammenfassung von unterschiedlichen Ärzten richtig erstellt wird .
     */
    @Test
    public void createzusammenfassungAllerArzt2() {
        untersuchung[1].setWeiterSchicken(true);
        untersuchung[2].setWeiterSchicken(true);
        ArrayList<Untersuchungsbericht> untersuchungsberichts2=epaController.getZusammenfassungsController().createZusammenfassungAlleAerzte("1234","leer");
        for(int i=0;i< untersuchungsberichts2.size();i++){
            assertTrue(equalsBericht(untersuchungsberichts2.get(i),untersuchung[i]));
        }
        assertEquals(untersuchungsberichts2.size(),3);
    }

    /**
     *  Test, ob zwei gleiche Untersuchungsbericht unterschieden werden können.
     * @param untersuchungsbericht1  untersuchungsbericht1
     * @param untersuchungsbericht2  untersuchungsbericht2
     * @return true or false
     */
    private boolean equalsBericht(Untersuchungsbericht untersuchungsbericht1, Untersuchungsbericht untersuchungsbericht2){ // check every attribut of 2 untersuchungbericht in parameter to find if 2 r the same
        return untersuchungsbericht1.getBehandenderArzt().equals(untersuchungsbericht2.getBehandenderArzt())&&untersuchungsbericht1.getDatum().equals(untersuchungsbericht2.getDatum())&&untersuchungsbericht1.getICD().equals(untersuchungsbericht2.getICD())&&untersuchungsbericht1.getPatientVersicherungnum().equals(untersuchungsbericht2.getPatientVersicherungnum())
                &&untersuchungsbericht1.getBehandlung().equals(untersuchungsbericht2.getBehandlung())&&untersuchungsbericht1.getDiagnose().equals(untersuchungsbericht2.getDiagnose());

    }
    @After
    public void tearDown() throws IOException {
        EPA epa= new EPA();
        epaController.setEPA(epa);
        epaController.getIO().save();
    }
}


package controller;

import model.Arzt;
import model.EPA;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.InvalidParameterException;
import static org.junit.Assert.*;

/**
 *Zur überprüfung der Klasse BenutzerAnlegenController.
 */
public class BenutzerAnlegenControllerTest {

    private EPA epa;

    private EPAController epaController;

    private BenutzerAnlegenController benutzerAnlegenController;

    private Arzt testArzt;

    /**
     *Setup für gebraucht in den Tests.
     */
    @Before
    public void setUp() throws Exception {
        String vorname="Mark";
        String nachname = "Ammermüller";
        String fach = "Psychater";
        String num = "1248";
        String passwort = "1234";
        String tel = "0208 123456789";
        epaController = new EPAController();
        epa = epaController.getEPA();
        testArzt = new Arzt(vorname, nachname, fach, num,passwort,tel);
        benutzerAnlegenController=epaController.getAktAnlegenController();
    }

    /**
     *Test, ob der Fehler mit null ausgegeben wird.
     */
    @Test(expected = InvalidParameterException.class)
    public void arztAnlegen() throws IOException {
        //test1:
        benutzerAnlegenController.arztAnlegen("Mark", "", "Psychater", "1248", "1234", "0208 123456789");
    }

    /**
     *Test, ob Arzt objekt richtig angelegt wird.
     */
    @Test
    public void arztAnlegen2() throws IOException {
        //test2:
        benutzerAnlegenController.arztAnlegen("Mark", "Ammermüller", "Psychater", "1248", "1234", "0208 123456789");
        assertEquals(testArzt,epa.getArzt("1248"));
    }

    /**
     *Test, ob der Fehler mit null ausgegeben wird.
     */
    @Test(expected = InvalidParameterException.class)
    public void patientAnlegen() throws IOException {
        //test2:
        benutzerAnlegenController.patientAnlegen("1248", "Mark", "", "Linguster weg", false,"20.05.01","1234","");
    }

    /**
     *Test, ob Patient objekt richtig angelegt wird.
     */
    @Test(expected = InvalidParameterException.class)
    public void patientAnlegen2() throws IOException {
        //test2:
        benutzerAnlegenController.patientAnlegen("1248", "Mark", "", "Linguster weg", false,"20.05.01","1234","");
        assertEquals(testArzt,epa.getPatient("1248"));
    }
}
package controller;

import model.Arzt;
import model.EPA;
import model.Patient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * The type Benutzer anlegen controller test.
 */
public class BenutzerAnlegenControllerTest {

    private EPA epa;

    private BenutzerAnlegenController benutzerAnlegenController;

    private Arzt testArzt;

    private Patient testPatient;

    private String vorname;

    private String nachname;

    private String fach;

    private String num;

    private String passwort;

    private String tel;

    private String adresse;

    private String birth;

    /**
     * Set up.
     */
    @Before
    public void setUp(){
        vorname="Mark";
        nachname = "Ammermüller";
        fach = "Psychater";
        num = "1248";
        passwort = "1234";
        tel = "0208 123456789";
        adresse = "Lingusterweg";
        birth = "20.05.01";
        EPAController epaController = new EPAController();
        epa = epaController.getEPA();
        testArzt = new Arzt(vorname, nachname, fach, num,passwort, tel);
        epa.addArzttToList(testArzt);
        testPatient = new Patient(num,vorname,nachname,adresse,"m",birth,passwort);
        testPatient.behandeldenArztAendern(epa.getArzt(num));
        benutzerAnlegenController= epaController.getAktAnlegenController();
    }


    /**
     * Arzt anlegen.
     *
     * @throws IOException the io exception
     */
    @Test
    public void arztAnlegen() throws IOException {
        //test2:
        benutzerAnlegenController.arztAnlegen(vorname, nachname, fach, num, passwort, tel);
        assert(epa.getArzt(num).equals(testArzt));
    }

    /**
     * Patient anlegen.
     *
     * @throws IOException the io exception
     */
    @Test
    public void patientAnlegen() throws IOException {
        //test2:
        benutzerAnlegenController.patientAnlegen(num, vorname, nachname, adresse, false, birth, passwort,num);
        assert(epa.getPatient(num).equals(testPatient));
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown(){
        epa.removeArzt(num);
        epa.removePatient(num);
        testArzt=null;
        testPatient=null;
    }
}
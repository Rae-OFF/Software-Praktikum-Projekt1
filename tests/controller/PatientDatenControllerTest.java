package controller;

import model.Arzt;
import model.EPA;
import model.Patient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

/**
 *Zur überprüfung der Klasse PatientDatenController.
 */
public class PatientDatenControllerTest {

    private EPA epa;

    private EPAController epaController;

    private Patient testPatient;
    private Arzt testArzt;

    private BenutzerAnlegenController benutzerAnlegenController;

    private PatientDatenController patientDatenController;

    private String num;

    private String vorname;

    private String nachname;

    private String adresse;

    private String testGeschlecht;

    private String birth;

    private String passwort;

    private String hausarzt;

    /**
     *Setup für gebraucht in den Tests.
     */
    @Before
    public void setUp() throws Exception {
        epaController = new EPAController();
        benutzerAnlegenController = epaController.getAktAnlegenController();
        epa = epaController.getEPA();
        num = "8421";
        vorname="Mark";
        nachname = "Ammermüller";
        adresse = "Lingusterweg";
        testGeschlecht = "m";
        boolean geschlecht = false;
        birth = "20.05.01";
        passwort = "1234";
        hausarzt = "1357";
        testPatient = new Patient(num,vorname,nachname,adresse,testGeschlecht,birth,passwort);
        testArzt=new Arzt(vorname,nachname,"leer",hausarzt,"1234","0000");
        testPatient.behandeldenArztAendern(testArzt);
        epa.addArzttToList(testArzt);
        benutzerAnlegenController.patientAnlegen(num,vorname,nachname,adresse,geschlecht,birth,passwort,hausarzt);
        patientDatenController = epaController.getPatientDatenController();
    }

    /**
     * tearDown
     * @throws Exception Exception
     */
    @After
    public void tearDown() throws Exception {
        epa.removePatient(num);
        epa.removeArzt(hausarzt);
        testPatient=null;
        testArzt=null;
    }

    /**
     *Test, ob Daten von Patient erneut werden.
     */
    @Test
    public void patientDatenUpdate(){
        nachname = "newName";
        try {
            //Test wurde verändert?
            System.out.println(epa.getPatient(num).equals(testPatient));
            patientDatenController.patientDatenUpdate(num,vorname,nachname,adresse,testGeschlecht,birth,passwort);
            assert(!(epa.getPatient(num).equals(testPatient)));
            //Test wurde richtig verändert?
            testPatient.setNachname("newName");
            System.out.println(epa.getPatient(num).equals(testPatient));
            assert(epa.getPatient(num).equals(testPatient));
        } catch (IOException e) {
            System.out.println("PatientenDatenUpdateTest fehler bei update");
        }
    }

}
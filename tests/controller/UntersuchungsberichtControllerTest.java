package controller;

import model.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * The type Untersuchungsbericht controller test.
 */
public class UntersuchungsberichtControllerTest {
    private EPAController epaController;
    private UntersuchungsberichtController usController;
    private EPA epa;

    private String versicherungsnummer;
    private String behandelnderArzt;
    private LocalDateTime datum;
    private LocalDateTime testTime;
    private String iCD;
    private List<String> med;
    private String diagnose;
    private String behandlung;
    private List<String> notiz;
    private Untersuchungsbericht us;
    private Patient patient;
    private Arzt arzt;
    private List<Arzt> arztList;
    private List<Patient> patientList;


    /**
     * Sets up.
     */
    @Before
    public void setUp() {

        epaController = new EPAController();
        usController= epaController.getUntersuchungsberichtcontroller();
        epa=epaController.getEPA();
        epaController.setCurrLoggedIn("1234");
        ArrayList<Untersuchungsbericht> untersuchungslist=new ArrayList<Untersuchungsbericht>();
        Arzt testArzt1 =new Arzt("hai","nguyen","unknown","1234","1234","1900");
        Arzt testArzt2 = new Arzt("tram","la","unknown","5678","5678","1090");
        Patient testPatient1 =new Patient("1234","hai","nguyen","ho chi minh stadt","male","2022-01-01","1234");
        ArrayList<String> medikamente= new ArrayList<>() ;
        medikamente.add("med1");
        medikamente.add("med2");
        ArrayList<String> notiz= new ArrayList<String>() ;
        notiz.add("notiz1");
        notiz.add("notiz2");
        Untersuchungsbericht untersuchungsbericht1= new Untersuchungsbericht("1234", "hai nguyen", LocalDateTime.now(), "000.0",medikamente, "aaaa", "aaaaa", notiz);
        Untersuchungsbericht untersuchungsbericht3= new Untersuchungsbericht("1234", "hai nguyen", LocalDateTime.now(), "000.0",medikamente, "bbbb", "bbbbb", notiz);
        Untersuchungsbericht untersuchungsbericht2= new Untersuchungsbericht("5678", "hai nguyen", LocalDateTime.now(), "000.0",medikamente, "aaaa", "aaaaa", notiz);
        Untersuchungsbericht untersuchungsbericht4= new Untersuchungsbericht("1234", "hai nguyen", LocalDateTime.now(), "000.0",medikamente, "cccc", "ccccc", notiz);
        testPatient1.behandeldenArztAendern(testArzt1);
        testPatient1.addUntersuchungsList(untersuchungsbericht1);
        untersuchungslist.add(untersuchungsbericht4);
        untersuchungslist.add(untersuchungsbericht3);
        Ueberweisung ueberweisung1=new Ueberweisung();
        ueberweisung1.setAltArztNummer("5678").setPatientNummer("1234").setNeuArztNummer("1234").setUntersuchungberichtInit(untersuchungslist).setAuftrag("test").setDate("2022-01-01");
        ueberweisung1.setDatenStimmZu(true);
        testPatient1.addUeberweisungsList(ueberweisung1);
        Ueberweisung ueberweisung2=new Ueberweisung();
        ueberweisung2.setAltArztNummer("5678").setPatientNummer("1234").setNeuArztNummer("1234").setUntersuchungberichtInit(new ArrayList<Untersuchungsbericht>()).setAuftrag("test").setDate("2022-02-02");
        testPatient1.addUeberweisungsList(ueberweisung2);
        testArzt1.addPatientToList(testPatient1);
        testArzt1.addUntersuchungsberichrt(untersuchungsbericht1);
        Patient testPatient2 =new Patient("5678","tram","la","ho chi minh stadt","female","2022-01-01","5678");
        testPatient2.addUntersuchungsList(untersuchungsbericht2);
        testPatient2.addUntersuchungsList(untersuchungsbericht2);

        patientList=epa.getPatientList();
        patientList.add(testPatient1);
        patientList.add(testPatient2);
        // testArzt1 id 1234 pass 1234, hat patient testPatient1 und untersuchungsbericht1
        // testArzt2 id 5678 pass 5678  hat kein patient
        // testPatient1 id 1234 pass 1234 hat Arzt testArzt1, hat Untersuchungsbericht untersuchungsbericht1, hat 2 Ueberweisung ueberweisung1 ueberweisung 2
        // ueberweisung hat untersuchungsbericht
        // testPatient2 id 5678 pass 5678 hat 2 untersuchungen untersuchungsbericht2

        epa.addArzttToList(testArzt1);
        epa.addArzttToList(testArzt2);
        epa.addPatientToList(testPatient1);
        epa.addPatientToList(testPatient2);

        arztList = epa.getArztList();
        arzt = epa.getArzt(epaController.getCurrLoggedIn());
        patient= epa.getPatient("1234");

        versicherungsnummer=patient.getNum();

        behandelnderArzt="hai nguyen";
        med= new ArrayList<>() ;
        med.add("med1");
        med.add("med2");
        notiz= new ArrayList<String>() ;
        notiz.add("notiz1");
        notiz.add("notiz2");
        diagnose="aaaa";
        behandlung="aaaaa";
        iCD="A34.56";
        datum= LocalDateTime.now();
        testTime=LocalDateTime.now();


    }


    /**
     * Create untersuchungsbericht.
     */
    @Test
    public void createUntersuchungsbericht() {

        int size1=arzt.getUntersuchungsberichte(versicherungsnummer).size();
        int size2=patient.getUntersuchungList().size();
        try {
            usController.createUntersuchungsbericht(versicherungsnummer,datum,iCD,med,diagnose,behandlung,notiz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int size3=arzt.getUntersuchungsberichte(versicherungsnummer).size();
        int size4=patient.getUntersuchungList().size();
        assertEquals(size3,size1+1);
        assertEquals(size4,size2+1);
    }

    /**
     * Add untersuchungbericht.
     */
    @Test
    public void addUntersuchungbericht() {
        int size1=arzt.getUntersuchungsberichte(versicherungsnummer).size();
        int size2=patient.getUntersuchungList().size();
        us = new Untersuchungsbericht(versicherungsnummer,behandelnderArzt,datum,iCD,med,diagnose,behandlung,notiz);
        try {
            usController.addUntersuchungbericht(versicherungsnummer, us);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int size3=arzt.getUntersuchungsberichte(versicherungsnummer).size();
        int size4=patient.getUntersuchungList().size();
        assertEquals(size3,size1+1);
        assertEquals(size4,size2+1);
    }

    /**
     * Cd ueberpruefen.
     */
    @Test
    public void iCDUeberpruefen() {
        String iCD2="ssd,,";
        assertTrue(usController.iCDUeberpruefen(iCD));
        assertFalse(usController.iCDUeberpruefen(iCD2));

    }

    /**
     * Versicherungsnummer ueberpruefen.
     */
    @Test
    public void versicherungsnummerUeberpruefen() {
        String versicherungsnummer2="sdf123";
        assertTrue(usController.versicherungsnummerUeberpruefen(versicherungsnummer));
        assertFalse(usController.versicherungsnummerUeberpruefen(versicherungsnummer2));
    }

    /**
     * Uhrzeit ueberpruefen.
     */
    @Test
    public void uhrzeitUeberpruefen() {
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
        assertTrue(usController.uhrzeitUeberpruefen(testTime.format(formatterTime)));
    }

    /**
     * Felder leer.
     */
    @Test
    public void felderLeer(){
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String symptome="how are you";
        String medikamente="jasmin";
        assertFalse(usController.felderLeer(testTime.format(formatterTime), versicherungsnummer, symptome, iCD, behandlung,medikamente));
        symptome=null;
        assertTrue(usController.felderLeer(testTime.format(formatterTime), versicherungsnummer, symptome, iCD, behandlung,medikamente));
    }

    /**
     * Tear down.
     *
     * @throws IOException the io exception
     */
    @After
    public void tearDown() throws IOException {
        EPA epa= new EPA();
        epaController.setEPA(epa);
        epaController.getIO().save();
    }

}
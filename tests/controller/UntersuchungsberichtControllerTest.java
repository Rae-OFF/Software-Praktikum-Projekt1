package controller;

import model.Arzt;
import model.EPA;
import model.Patient;
import model.Untersuchungsbericht;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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




    @Before
    public void setUp() {
        epaController = new EPAController();
        usController= epaController.getUntersuchungsberichtcontroller();
        epa=epaController.getEPA();
        epaController.setCurrLoggedIn("1234");

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

    @Test
    public void createUntersuchungsbericht() {
        int size1=arzt.getUntersuchungsberichte(versicherungsnummer).size();
        int size2=patient.getUntersuchungList().size();
        usController.createUntersuchungsbericht(versicherungsnummer,datum,iCD,med,diagnose,behandlung,notiz);
        assertEquals(size1,size1+1);
        assertEquals(size2,size2+1);
    }


    @Test
    public void addUntersuchungbericht() {
        int size1=arzt.getUntersuchungsberichte(versicherungsnummer).size();
        int size2=patient.getUntersuchungList().size();
        us = new Untersuchungsbericht(versicherungsnummer,behandelnderArzt,datum,iCD,med,diagnose,behandlung,notiz);
        usController.addUntersuchungbericht(versicherungsnummer, us);
        assertEquals(size1,size1+1);
        assertEquals(size2,size2+1);
    }

    @Test
    public void iCDUeberpruefen() {
        String iCD2="ssd,,";
        assertTrue(usController.iCDUeberpruefen(iCD));
        assertFalse(usController.iCDUeberpruefen(iCD2));

    }

    @Test
    public void versicherungsnummerUeberpruefen() {
        String versicherungsnummer2="sdf123";
        assertTrue(usController.versicherungsnummerUeberpruefen(versicherungsnummer));
        assertFalse(usController.versicherungsnummerUeberpruefen(versicherungsnummer2));
    }

    @Test
    public void uhrzeitUeberpruefen() {
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
        assertTrue(usController.uhrzeitUeberpruefen(testTime.format(formatterTime)));
    }

    @Test
    public void felderLeer(){
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String symptome="how are you";
        String medikamente="jasmin";
        assertFalse(usController.felderLeer(testTime.format(formatterTime), versicherungsnummer, symptome, iCD, behandlung,medikamente));
        symptome=null;
        assertTrue(usController.felderLeer(testTime.format(formatterTime), versicherungsnummer, symptome, iCD, behandlung,medikamente));
    }
}
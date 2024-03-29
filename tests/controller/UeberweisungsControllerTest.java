package controller;

import controller.EPAController;
import controller.UeberweisungsController;
import model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * The type Ueberweisungs controller test.
 */
public class UeberweisungsControllerTest {
    private EPAController epaController = new EPAController();
    private Ueberweisung ueberweisung ;
    private UeberweisungsController ueberweisungsController;
    private ArrayList<Untersuchungsbericht> untersuchungslist;


    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        EPA epa= epaController.getEPA();
        Arzt arzt1= new Arzt("testone","testone","Hausarzt","1234","1234","1111");
        Arzt arzt2= new Arzt("testtwo","testtwo","Hausarzt","5678","5678","1111");
        Patient p = new Patient("1234","test","test","bochum","m","1.1.1111","1234");
        p.behandeldenArztAendern(arzt1);
        arzt1.addPatientToList(p);
        epa.addPatientToList(p);
        epa.addArzttToList(arzt1);
        epa.addArzttToList(arzt2);
        epaController.setEPA(epa);
        ueberweisungsController = epaController.getUeberweisungsController();
        untersuchungslist  = new ArrayList<Untersuchungsbericht>();
        ueberweisung = new Ueberweisung();
        ueberweisung.setAltArztNummer("1234").setPatientNummer("1234").setNeuArztNummer("5678").setUntersuchungberichtInit(untersuchungslist).setAuftrag("test").setDate("1.1.2022");
    }

    /**
     * Create ueberweisung.
     */
    @Test
    public void createUeberweisung() {
        Ueberweisung ueberweisung1 = ueberweisungsController.createUeberweisung("1234","1234","5678","test",untersuchungslist,"1.1.2022");
        assertEquals(ueberweisung.getDate(),ueberweisung1.getDate());
        assertEquals(ueberweisung.getNeuarztnummer(),ueberweisung1.getNeuarztnummer());
        assertEquals(ueberweisung.getAltArztnummer(),ueberweisung1.getAltArztnummer());
        assertEquals(ueberweisung.getPatientnummer(),ueberweisung1.getPatientnummer());
        assertEquals(ueberweisung.getAuftrag(),ueberweisung1.getAuftrag());
        assertEquals(ueberweisung.getUntersuchungsbericht(),ueberweisung1.getUntersuchungsbericht());
    }

    /**
     * Create ueberweisung 1.
     */
    @Test
    public void createUeberweisung1() {
        Ueberweisung ueberweisung2 = ueberweisungsController.createUeberweisung("1234","" ,"5678","test",untersuchungslist,"1.1.2022");
        assertEquals(ueberweisung.getDate(),ueberweisung2.getDate());
        assertEquals(ueberweisung.getNeuarztnummer(),ueberweisung2.getNeuarztnummer());
        assertEquals(ueberweisung.getAltArztnummer(),ueberweisung2.getAltArztnummer());
        assertNotEquals(ueberweisung.getPatientnummer(),ueberweisung2.getPatientnummer());
        assertEquals(ueberweisung.getAuftrag(),ueberweisung2.getAuftrag());
        assertEquals(ueberweisung.getUntersuchungsbericht(),ueberweisung2.getUntersuchungsbericht());
    }

    /**
     * Add ueberweisung.
     *
     * @throws IOException the io exception
     */
    @Test
    public void addUeberweisung() throws IOException {
        Ueberweisung ueberweisung2 = new Ueberweisung().setAltArztNummer("1234").setPatientNummer("1234").setNeuArztNummer("5678").setUntersuchungberichtInit(untersuchungslist).setAuftrag("test").setDate("20.1.2022");
        int revision1 = epaController.getEPA().getArzt("1234").getRevision().size();
        int revision2 = epaController.getEPA().getArzt("5678").getRevision().size();
        ueberweisungsController.addUeberweisung(ueberweisung2);
        assertEquals(epaController.getEPA().getPatient("1234").getUeberweisungsList().size(),1);
        Ueberweisung ueberweisung= epaController.getEPA().getPatient("1234").getUeberweisungsList().get(0);
        assertEquals(ueberweisung.getDate(),ueberweisung2.getDate());
        assertEquals(ueberweisung.getNeuarztnummer(),ueberweisung2.getNeuarztnummer());
        assertEquals(ueberweisung.getAltArztnummer(),ueberweisung2.getAltArztnummer());
        assertEquals(ueberweisung.getPatientnummer(),ueberweisung2.getPatientnummer());
        assertEquals(ueberweisung.getAuftrag(),ueberweisung2.getAuftrag());
        assertEquals(ueberweisung.getUntersuchungsbericht(),ueberweisung2.getUntersuchungsbericht());
        assertEquals(epaController.getEPA().getArzt("5678").checkPatientValid("1234"),true);// test if new patient added to list
        assertEquals(epaController.getEPA().getArzt("1234").getRevision().size(),revision1+1);// test if new revision added, for arzt 1 revision with ueberweisung
        assertEquals(epaController.getEPA().getArzt("5678").getRevision().size(),revision2+2);// test if new revision added, for arzt 2 revision with ueberweisung and new patient in list
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
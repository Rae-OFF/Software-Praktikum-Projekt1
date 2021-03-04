
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


public class UeberweisungsControllerTest {

    EPAController epaController = new EPAController();
    EPA epa= epaController.getEPA();
    UeberweisungsController ueberweisung1 = epaController.getUeberweisungsController();
    ArrayList<Untersuchungsbericht> untersuchungslist  = new ArrayList<Untersuchungsbericht>();
    Ueberweisung ueberweisung = new Ueberweisung();


    @Before
    public void setUp() throws Exception {
        ueberweisung.setAltArztNummer("1234").setPatientNummer("1234").setNeuArztNummer("5678").setUntersuchungberichtInit(untersuchungslist).setAuftrag("test").setDate("1.1.2022");
    }

    @Test
    public void createUeberweisung() {
       Ueberweisung ueberweisung2 = ueberweisung1.createUeberweisung("1234","1234","5678","test",untersuchungslist,"1.1.2022");
       assertEquals(ueberweisung.getDate(),ueberweisung2.getDate());
       assertEquals(ueberweisung.getNeuarztnummer(),ueberweisung2.getNeuarztnummer());
       assertEquals(ueberweisung.getAltArztnummer(),ueberweisung2.getAltArztnummer());
       assertEquals(ueberweisung.getPatientnummer(),ueberweisung2.getPatientnummer());
       assertEquals(ueberweisung.getAuftrag(),ueberweisung2.getAuftrag());
       assertEquals(ueberweisung.getUntersuchungsbericht(),ueberweisung2.getUntersuchungsbericht());
    }

    @Test
   public void addUeberweisung() throws IOException {
        ueberweisung1.addUeberweisung(ueberweisung);
        assertEquals(epa.getPatient("1234").getUeberweisungsList().size(),3);
    }
}

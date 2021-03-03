package controller;

import model.EPA;

import java.lang.UnsupportedOperationException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EPAController {

	private boolean isArzt;
    /**
 	 * 
 	 */
    private String currLoggedIn;

    /**
 	 * 
 	 */
    private EPA ePA;

    /**
 	 * 
 	 */
    private IOController iOController;

    /**
 	 * 
 	 */
    private UntersuchungsberichtController untersuchungsberichtController;

    /**
 	 * 
 	 */
    private UeberweisungsController ueberweisungsController;

    /**
 	 * 
 	 */
    private PatientDatenController patientDatencontroller;

    /**
 	 * 
 	 */
    private BenutzerAnlegenController benutzerAnlegenController;

    /**
 	 * 
 	 */
    private ZusammenfassungsController zusammenfassungsController;

    public EPAController() {
    	this.ePA=new EPA();
    	this.ueberweisungsController=new UeberweisungsController(this);
		this.untersuchungsberichtController=new UntersuchungsberichtController(this);
    }
    public void setisArzt(boolean b){this.isArzt=b;}

	public boolean isArzt() {
		return isArzt;
	}

	/**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return EPA
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public EPA getEPA() throws UnsupportedOperationException {
        return ePA;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void setEPA(EPA epa) throws UnsupportedOperationException {
        this.ePA=epa;
    }
    public String getTime(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
	}

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return IOController
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public IOController getIO() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }


    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void setNum() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return PatientDatencontroller
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public PatientDatenController getPatientDatenController() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return BenutzerAnlegenController
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public BenutzerAnlegenController getAktAnlegenController() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return UntersuchungsberichtController
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public UntersuchungsberichtController getUntersuchungsberichtcontroller() {
        return untersuchungsberichtController;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return UeberweisungsController
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public UeberweisungsController getUeberweisungsController() throws UnsupportedOperationException {
        return ueberweisungsController;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return int
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public int getBehandlungcontroller() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return ZusammenfassungsController
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public ZusammenfassungsController getZusammenfassungsController() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return String
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void setCurrLoggedIn(String num){currLoggedIn=num;}
    public String getCurrLoggedIn() throws UnsupportedOperationException {
        return currLoggedIn;
    }
}

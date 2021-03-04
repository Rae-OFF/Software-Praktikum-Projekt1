package controller;

import model.EPA;

import java.lang.UnsupportedOperationException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Epa controller.
 */
public class EPAController {

	private boolean isArzt;
    private String currLoggedIn;

    private EPA ePA;

    private IOController iOController;

    private UntersuchungsberichtController untersuchungsberichtController;

    private UeberweisungsController ueberweisungsController;

    private PatientDatenController patientDatencontroller;

    private BenutzerAnlegenController benutzerAnlegenController;

    private ZusammenfassungsController zusammenfassungsController;

	/**
	 * Instantiates a new Epa controller.
	 */
	public EPAController() {
    	this.ePA=new EPA();
    	this.ueberweisungsController=new UeberweisungsController(this);
		this.untersuchungsberichtController=new UntersuchungsberichtController(this);
    }

	/**
	 * Setis arzt.
	 *
	 * @param b the b
	 */
	public void setisArzt(boolean b){this.isArzt=b;}

	/**
	 * Is arzt boolean.
	 *
	 * @return the boolean
	 */
	public boolean isArzt() {
		return isArzt;
	}

	/**
	 * Gets epa.
	 *
	 * @return the epa
	 * @throws UnsupportedOperationException the unsupported operation exception
	 */
	public EPA getEPA() throws UnsupportedOperationException {
        return ePA;
    }

	/**
	 * Set epa.
	 *
	 * @param epa the epa
	 */
	public void setEPA(EPA epa){
        this.ePA=epa;
    }

	/**
	 * Get time string.
	 *
	 * @return the string
	 */
	public String getTime(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
	}

	/**
	 * Gets io.
	 *
	 * @return the io
	 * @throws UnsupportedOperationException the unsupported operation exception
	 */
	public IOController getIO() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }


	/**
	 * Sets num.
	 *
	 * @throws UnsupportedOperationException the unsupported operation exception
	 */
	public void setNum() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

	/**
	 * Gets patient daten controller.
	 *
	 * @return the patient daten controller
	 * @throws UnsupportedOperationException the unsupported operation exception
	 */
	public PatientDatenController getPatientDatenController() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

	/**
	 * Gets akt anlegen controller.
	 *
	 * @return the akt anlegen controller
	 * @throws UnsupportedOperationException the unsupported operation exception
	 */
	public BenutzerAnlegenController getAktAnlegenController() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

	/**
	 * Gets untersuchungsberichtcontroller.
	 *
	 * @return the untersuchungsberichtcontroller
	 */
	public UntersuchungsberichtController getUntersuchungsberichtcontroller() {
        return untersuchungsberichtController;
    }

	/**
	 * Get ueberweisungs controller ueberweisungs controller.
	 *
	 * @return the ueberweisungs controller
	 */
	public UeberweisungsController getUeberweisungsController(){
        return ueberweisungsController;
    }

	/**
	 * Gets behandlungcontroller.
	 *
	 * @return the behandlungcontroller
	 * @throws UnsupportedOperationException the unsupported operation exception
	 */
	public int getBehandlungcontroller() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

	/**
	 * Gets zusammenfassungs controller.
	 *
	 * @return the zusammenfassungs controller
	 * @throws UnsupportedOperationException the unsupported operation exception
	 */
	public ZusammenfassungsController getZusammenfassungsController() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

	/**
	 * Set curr logged in.
	 *
	 * @param num the num
	 */
	public void setCurrLoggedIn(String num){currLoggedIn=num;}

	/**
	 * Gets curr logged in.
	 *
	 * @return the curr logged in
	 * @throws UnsupportedOperationException the unsupported operation exception
	 */
	public String getCurrLoggedIn() throws UnsupportedOperationException {
        return currLoggedIn;
    }
}

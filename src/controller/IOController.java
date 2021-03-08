package controller;

import model.EPA;

import java.io.*;
import java.lang.UnsupportedOperationException;

/**
 * The type Io controller.
 */
public class IOController {

    private  static final File SAVE= new File("SaveFile"); // File SAVE to save epa


    private EPAController ePAController;

	/**
	 * Instantiates a new Io controller.
	 *
	 * @param epaController the epaController
	 */
	public IOController(EPAController epaController) {
        this.ePAController=epaController;
    }

	/**
	 * load epa from save file
	 *
	 * @throws IOException the io exception
	 */
	public void load() throws IOException, ClassNotFoundException {
		if (!SAVE.exists()) { // no file
			return; // do nothing
		} // file exists
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(SAVE)); // get epa from SAVE and set epa
			EPA epa = (EPA) stream.readObject();
			ePAController.setEPA(epa);
			stream.close();
	}

	/**
	 * save epa to save file
	 *
	 * @throws IOException the io exception
	 */
	public void save() throws IOException {
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(SAVE));
		stream.writeObject(ePAController.getEPA()); // save epa to SAVE
		stream.close();
	}
}

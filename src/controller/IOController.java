package controller;

import model.EPA;

import java.io.*;
import java.lang.UnsupportedOperationException;

public class IOController {

    /**
 	 * 
 	 */
    private  static final File SAVE= new File("SaveFile");

    /**
 	 * 
 	 */
    private IOController iOController;

    /**
 	 * 
 	 */
    private EPAController ePAController;

    public IOController(EPAController e) {
        ePAController=e;
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @throws  Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void load() throws IOException, ClassNotFoundException {
		if (!SAVE.exists()) {
			return;
		}
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(SAVE));
			EPA epa = (EPA) stream.readObject();
			ePAController.setEPA(epa);
			stream.close();
	}

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @throws  Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void save() throws IOException {
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(SAVE));
		stream.writeObject(ePAController.getEPA());
		stream.close();
	}
}

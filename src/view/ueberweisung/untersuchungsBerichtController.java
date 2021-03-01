package view.ueberweisung;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class untersuchungsBerichtController extends TitledPane{

    @FXML
    private RadioButton ChooseButton;

    @FXML
    private Text Date;

    @FXML
    private Text Grund;

    @FXML
    private Text Symtome;

    @FXML
    private Text ICD;

    @FXML
    private TextFlow Behandlung;

    @FXML
    private TextFlow Medikamente;

    @FXML
    private TextFlow Notiz;
    private Untersuchungsbericht bericht;
    public untersuchungsBerichtController(Untersuchungsbericht u) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/ueberweisung/untersuchungBericht.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
            bericht=u;
            // load Date, Grund, Symtome, ICD of Untersuchungsbericht

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    private boolean isChecked(){return ChooseButton.isSelected();}
    public Untersuchungsbericht getBericht(){return bericht;}
}

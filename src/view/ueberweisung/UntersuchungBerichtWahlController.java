package view.ueberweisung;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TitledPane;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import model.Untersuchungsbericht;

import java.io.IOException;

public class UntersuchungBerichtWahlController extends TitledPane {
    @FXML
    private TitledPane Bericht1;

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
    private Untersuchungsbericht untersuchung;
    public UntersuchungBerichtWahlController(Untersuchungsbericht u){
        untersuchung=u;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ueberweisung/untersuchung.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void init(){
       Date.setText("");
       Date.setVisible(true);
       Symtome.setText("");
       Symtome.setVisible(true);
       ICD.setText("");
       ICD.setVisible(true);
       Behandlung.getChildren().add(new Text(""));
       Behandlung.setVisible(true);
       Medikamente.getChildren().add(new Text(""));
       Medikamente.setVisible(true);
       Notiz.getChildren().add(new Text(""));
       Notiz.setVisible(true);
    }
    public boolean isChoosen(){return ChooseButton.isSelected();}
    public Untersuchungsbericht getUntersuchung(){return untersuchung;}
    public void setButtonDisable(){ChooseButton.setDisable(true);ChooseButton.setVisible(false);}

}
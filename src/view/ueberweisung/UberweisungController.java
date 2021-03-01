package view.ueberweisung;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class UberweisungController extends BorderPane {

    @FXML
    private BorderPane MainPane1;

    @FXML
    private TextField Versicherungsnummer;

    @FXML
    private TextField ArztBezeich;

    @FXML
    private Button FortFahren;

    @FXML
    private Button CheckButton;

    @FXML
    private Text HiddenText;

    @FXML
    private TextArea Auftrag;

    @FXML
    private FlowPane Flow;
    private ArrayList<untersuchungsBerichtController> berichtList = new ArrayList<untersuchungsBerichtController>();
    private EPAController epa;
    public UberweisungController(EPAController e) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/ueberweisung/screen1.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            epa=e;
            loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    @FXML
    void checkClicked(ActionEvent event) {
        // prüfen gültigkeit von Versicherungsnummer  then load berichte
        if(!( Versicherungsnummer.getText() == null ||  Versicherungsnummer.getText().trim().isEmpty())){
            if(checkVNummer(Versicherungsnummer.getText())){
                // load berichte

                HiddenText.setVisible(false);
            }
            else{
                HiddenText.setText("Die Versicherungsnummer ist nicht gültig");
                HiddenText.setVisible(true);
            }
        }
        HiddenText.setText("Geben Sie die Versicherungsnummer ein");
        HiddenText.setVisible(true);
    }
    private boolean checkVNummer(String VNummer){
        //prüfen gültigkeit von Versicherungsnummer
    }
    private void loadBericht(String VNummer){
        // load Berichte von Versicherungsnummer
        // add to berichtlist
        // add to flow
    }
    private Ueberweisung makeUeberweisung(){
        //erstellt neue instanz der Klasse Ueberweisung

    }
    public  void nextStep(){
     // erstellt neue instanz der Klasse Ueberweisung mit eingegebenen Daten and choosen berichte, add to Artz daten und Patient Daten mithilfe EPaCOntroller

    }

}

package view.ueberweisung;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class UberweisungsDatenController {
    @FXML
    private BorderPane PatientPreviewPane;

    @FXML
    private Text Name;

    @FXML
    private Text Versicherungsnum;

    @FXML
    private Text BirthDay;

    @FXML
    private TextFlow Adress;

    @FXML
    private Text ArtzBez;

    @FXML
    private Text Sex;

    @FXML
    private FlowPane Flow;

    @FXML
    private Button Print;

    @FXML
    private Button Save;

    @FXML
    private Text ArtzNum;

    @FXML
    private Text Datum;
    private Ueberweisung ueberweisung;
    public UberweisungsDatenController(Ueberweisung u) {
        ueberweisung=u;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/ueberweisung/untersuchungBericht.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
            // load info by Uberweisungsdaten von u

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public void speichern(){
        //andern daten von Ueberweisung u


    }



}

package view.ueberweisung;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class UeberweisungsViewController {

    @FXML
    private BorderPane ArtzPreviewPane;

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
    private Button Bestaetigen;

    @FXML
    private Button Zurück;

    @FXML
    private Text ArtzNum;

    @FXML
    private Text Datum;

}


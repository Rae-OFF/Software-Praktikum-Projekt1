package view.ueberweisung;

import controller.EPAController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.Patient;
import model.Untersuchungsbericht;
import view.FunctionView.ArztMainViewController;

import java.io.IOException;
import java.util.ArrayList;

public class UeberweisungsViewController extends ScrollPane {

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
    private TextFlow Auftragtext;
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
    private ArrayList<Untersuchungsbericht> berichtliste;
    private Stage mainStage;
    private  EPAController EPAControl;
    private String neuArzt;
    private String pnum;
    private String Auftrag;
    public UeberweisungsViewController(String pnum, String Artzbezeich, String Auftrag, ArrayList<Untersuchungsbericht> berichtliste, Stage primaryStage, EPAController EPAControl) {
        mainStage= primaryStage;
        this.pnum=pnum;
        neuArzt= Artzbezeich;
        this.EPAControl=EPAControl;
        this.Auftrag=Auftrag;
        this.berichtliste=berichtliste;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ueberweisung/UeberweisungsView.fxml"));
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
        Patient p = EPAControl.getEPA().getPatient(pnum);
        Name.setText(p.getName());
        Name.setVisible(true);
        Adress.getChildren().add(new Text(p.getAddress()));
        Auftragtext.getChildren().add(new Text(Auftrag));
        Versicherungsnum.setText(p.getNum());
        Versicherungsnum.setVisible(true);
        BirthDay.setText(p.getGesburtsDatum());
        BirthDay.setVisible(true);
        Sex.setText(p.getGeschlecht());
        Sex.setVisible(true);
        ArtzNum.setText(EPAControl.getCurrLoggedIn());
        ArtzNum.setVisible(true);
        ArtzBez.setText(EPAControl.getEPA().getArzt(neuArzt).getName());
        ArtzBez.setVisible(true);
        // add element in berichtliste to flow
    }
    @FXML
    void ToMainView(ActionEvent e){
        mainStage.setScene(new Scene(new ArztMainViewController(mainStage,EPAControl)));
    }
    @FXML
    void ToCreateUeberweisung(ActionEvent e){
        // create new Ueberweisung with UeberweisungsController parameter ist atribute ()
        mainStage.setScene(new Scene(new UeberweisungCreateViewController(mainStage, EPAControl)));
    }


}


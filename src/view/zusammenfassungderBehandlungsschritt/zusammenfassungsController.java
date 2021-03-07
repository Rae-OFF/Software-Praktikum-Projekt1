package view.zusammenfassungderBehandlungsschritt;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.EPAController;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import model.Patient;
import model.Untersuchungsbericht;
import view.FunctionView.ArztMainViewController;

import javax.imageio.ImageIO;
import javafx.fxml.Initializable;


/**
 * The type Zusammenfassungs controller.
 */
public class zusammenfassungsController extends SplitPane{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TextFlow Vorname;

    @FXML
    private TextFlow Nachname;

    @FXML
    private TextFlow Geschlecht;

    @FXML
    private TextFlow Versicherungnummer;

    @FXML
    private Label pInfomation;

    @FXML
    private Text pVorname;

    @FXML
    private Text pNachname;

    @FXML
    private Text pGeschlecht;

    @FXML
    private Text pVersicherungsnum;

    @FXML
    private Button zumEinfabeSeite;

    @FXML
    private Button zumArztMainView;
    @FXML
    private FlowPane Flow;
    @FXML
    private ImageView PatientImage;
    @FXML
    private Text anzahl;

    @FXML
    private Text HiddenText;
    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        assert pInfomation != null : "fx:id=\"pInfomation\" was not injected: check your FXML file 'Zusammenfassung.fxml'.";
        assert pVorname != null : "fx:id=\"pVorname\" was not injected: check your FXML file 'Zusammenfassung.fxml'.";
        assert pNachname != null : "fx:id=\"pNachname\" was not injected: check your FXML file 'Zusammenfassung.fxml'.";
        assert pGeschlecht != null : "fx:id=\"pGeschlecht\" was not injected: check your FXML file 'Zusammenfassung.fxml'.";
        assert pVersicherungsnum != null : "fx:id=\"pVersicherungsnum\" was not injected: check your FXML file 'Zusammenfassung.fxml'.";

    }

    @FXML
    //private ImageView PatientImage;
    private Stage mainStage;
    private EPAController EPAControl;
    private Untersuchungsbericht Ub;
    private ArrayList<Untersuchungsbericht> berichtListe;
    private String versicherungnummer;
    /**
     * Instantiates a new Zusammenfassungs controller.
     *
     * @param primaryStage the primary stage.
     * @param EPAControl   the epa control.
     * @param
     */
    //
    public zusammenfassungsController(Stage primaryStage, EPAController EPAControl,ArrayList<Untersuchungsbericht> berichtListe, String Versicherungnummer) {
        mainStage = primaryStage;
        this.EPAControl = EPAControl;
        this.berichtListe=berichtListe;
        this.versicherungnummer=Versicherungnummer;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/zusammenfassungderBehandlungsschritt/Zusammenfassung.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
            init();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    private void init() throws IOException {
        Patient p= EPAControl.getEPA().getPatient(versicherungnummer);
        Image icon = SwingFXUtils.toFXImage(ImageIO.read(this.getClass().getClassLoader().getResource("view/image/patientimage.jpg")), null);
        PatientImage.setImage(icon);
        Vorname.getChildren().add(new Text(p.getVorname()));
        Nachname.getChildren().add(new Text(p.getNachname()));
        Geschlecht.getChildren().add(new Text(p.getGeschlecht()));
        Versicherungnummer.getChildren().add(new Text(versicherungnummer));
        anzahl.setText(String.valueOf(berichtListe.size()));
        anzahl.setVisible(true);
        if(berichtListe.size()!=0){Flow.getChildren().clear();}
        for(int i=0;i<berichtListe.size();i++){
            Button button=new Button(i+1+". Untersuchungsbericht am "+berichtListe.get(i).getDatum().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+" von Arzt(in) "+EPAControl.getEPA().getArzt(berichtListe.get(i).getBehandenderArzt()).getName());
            Untersuchungsbericht untersuchungsbericht=berichtListe.get(i);
            button.setOnAction(event -> {
                mainStage.setScene(new Scene(new UntersuchungBerichtViewController(berichtListe,untersuchungsbericht, EPAControl, mainStage)));
            });
            button.setPrefWidth(635.0);
            button.setPrefHeight(90.0);
            Flow.getChildren().add(button);
        }
    }


    /**
     * Zum arzt main view.
     *
     * @param actionEvent the action event.
     */
    @FXML
    void ZumArztMainView(ActionEvent actionEvent){
        mainStage.setScene(new Scene(new ArztMainViewController(mainStage, EPAControl)));
    }

    /**
     * Zum eingabe seite.
     *
     * @param actionEvent the action event.
     */
    @FXML
    void ZumEingabeSeite(ActionEvent actionEvent){
        mainStage.setScene(new Scene(new EingabeSeiteController(mainStage, EPAControl)));
    }

}
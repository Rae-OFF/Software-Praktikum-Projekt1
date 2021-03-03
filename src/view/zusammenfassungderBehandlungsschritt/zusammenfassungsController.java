package view.zusammenfassungderBehandlungsschritt;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import model.Patient;
import model.Untersuchungsbericht;
import view.FunctionView.ArztMainViewController;

import javax.imageio.ImageIO;
import javafx.fxml.Initializable;




public class zusammenfassungsController extends SplitPane{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    public zusammenfassungsController(Stage primaryStage, EPAController EPAControl) {
        mainStage = primaryStage;
        this.EPAControl = EPAControl;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/zusammenfassungderBehandlungsschritt/Zusammenfassung.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

/*
    private void init1() throws IOException {
        Patient p= EPAControl.getEPA().getPatient(EPAControl.getCurrLoggedIn());
        Image icon = SwingFXUtils.toFXImage(ImageIO.read(this.getClass().getClassLoader().getResource("view/image/patienteimage.jpg")), null);
        patienteImage.setImage(icon);
        pVorname.setText(p.getVorname());
        pNachname.setText(p.getNachname());
        pGeschlecht.setText(p.getGeschlecht());
        Ub.getICD();
        Ub.getPatientNum();
        Ub.setInfo();
    }*/


    @FXML
    void ZumArztMainView(ActionEvent actionEvent){
        mainStage.setScene(new Scene(new ArztMainViewController(mainStage, EPAControl)));
    }

    @FXML
    void ZumEingabeSeite(ActionEvent actionEvent){
        mainStage.setScene(new Scene(new EingabeSeiteController(mainStage, EPAControl)));
    }

}
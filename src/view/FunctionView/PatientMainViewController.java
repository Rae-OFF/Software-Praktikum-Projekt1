package view.FunctionView;
import controller.EPAController;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.Patient;
import view.StartView.LoginViewController;
import view.ueberweisung.UeberweisungsChooseController;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PatientMainViewController extends AnchorPane {
    @FXML
    private Text pVorname;

    @FXML
    private Text pNachname;

    @FXML
    private Text pBday;

    @FXML
    private Text pSex;

    @FXML
    private TextFlow pAdress;

    @FXML
    private Button pHausArzt;

    @FXML
    private Button pZumDataAndern;

    @FXML
    private Button pZumUntersuchungsberichte;

    @FXML
    private Button pZumUeberweisung;

    @FXML
    private Button pZumRevision;

    @FXML
    private Button PLogout;
    @FXML
    private ImageView PatientImage;
    private Stage mainStage;
    private EPAController EPAControl;
    public PatientMainViewController(Stage primaryStage, EPAController EPAControl) {
        mainStage= primaryStage;
        this.EPAControl=EPAControl;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FunctionView/PatientMainView.fxml"));
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
        Patient p=EPAControl.getEPA().getPatient(EPAControl.getCurrLoggedIn());
        Image icon = SwingFXUtils.toFXImage(ImageIO.read(this.getClass().getClassLoader().getResource("view/image/patientimage.jpg")), null);
        PatientImage.setImage(icon);
        pNachname.setText(p.getNachname());
        pNachname.setVisible(true);
        pVorname.setText(p.getVorname());
        pVorname.setVisible(true);
        pSex.setText(p.getGeschlecht());
        pSex.setVisible(true);
        pBday.setText(p.getGesburtsDatum());
        pBday.setVisible(true);
        pAdress.getChildren().add(new Text(p.getAddress()));
        pAdress.setVisible(true);
    }
    @FXML
    void zumLoginView(ActionEvent e){
        mainStage.setScene(new Scene(new LoginViewController(mainStage)));
    }
    @FXML
    void zumHausArzt(ActionEvent e){
        Patient p=EPAControl.getEPA().getPatient(EPAControl.getCurrLoggedIn());
        if(p.getBehandelnderArzt()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Error");
            String s ="Sie haben keinen Hausarzt ";
            alert.setContentText(s);
            alert.show();
        }
        else{
            mainStage.setScene(new Scene(new PatientArztViewController(mainStage, p.getBehandelnderArzt(),EPAControl)));
        }
    }
    @FXML
    void zumUeberweisungsAnsehen(){
        mainStage.setScene(new Scene(new UeberweisungsChooseController(mainStage, EPAControl)));

    }
}

package view.UntersuchungberichtEinstellen;

import controller.EPAController;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Arzt;
import model.Patient;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class PatientArztChooseViewController extends AnchorPane {


    @FXML
    private ImageView ArztImage;

    @FXML
    private Text aVorname;

    @FXML
    private Text aNachname;

    @FXML
    private Text aFach;

    @FXML
    private Text aNum;

    @FXML
    private Text aTel;

    @FXML
    private Button ChooseArzt;
    private Stage mainStage;
    private Arzt hausArzt;
    private  EPAController epaController;
    public PatientArztChooseViewController(Stage primaryStage, Arzt hausArzt, EPAController epaController){
        mainStage= primaryStage;
        this.hausArzt=hausArzt;
        this.epaController=epaController;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UntersuchungberichtEinstellen/PatientArztChoose.fxml"));
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
        aVorname.setText(hausArzt.getVorname());
        aVorname.setVisible(true);
        aNachname.setText(hausArzt.getNachname());
        aNachname.setVisible(true);
        aFach.setText(hausArzt.getFachrichtung());
        aFach.setVisible(true);
        aNum.setText(hausArzt.getNum());
        aNum.setVisible(true);
        aTel.setText(hausArzt.getTel());
        aTel.setVisible(true);
        Image icon =SwingFXUtils.toFXImage(ImageIO.read(this.getClass().getClassLoader().getResource("view/image/50115-200.png")), null);
        ArztImage.setImage(icon);
        Patient patient =epaController.getEPA().getPatient(epaController.getCurrLoggedIn());
        if(patient.getBehandelnderArzt()!=null && hausArzt.equals(patient.getBehandelnderArzt())){
            ChooseArzt.setText("Sie haben diesen Arzt als ihr Hausarzt gewählt");
            ChooseArzt.setDisable(true);
        }
    }




    @FXML
    void WahltDiesenArzt(ActionEvent event) throws IOException {
        epaController.getPatientDatenController().patientSetArzt(epaController.getCurrLoggedIn(),hausArzt.getNum());
        mainStage.setScene(new Scene(new ArztTabViewController(mainStage,epaController)));
    }


}

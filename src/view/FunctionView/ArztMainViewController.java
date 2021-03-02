package view.FunctionView;
import controller.EPAController;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Arzt;
import view.StartView.LoginViewController;
import view.ueberweisung.UeberweisungCreateViewController;
import view.untersuchungsbericht.UntersuchungsberichtEingabeController;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ArztMainViewController extends AnchorPane {

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
    private Button aZumZusammenfassung;

    @FXML
    private Button aBerichtErstellen;

    @FXML
    private Button aUeberweisungErstellen;

    @FXML
    private Button aZumRevisionen;
    @FXML
    private ImageView ArztImage;

    @FXML
    private Button aLogout;
    private Stage mainStage;
    private EPAController EPAControll;
    public ArztMainViewController(Stage primaryStage, EPAController EPAControll) {
        this.EPAControll= EPAControll;
        mainStage= primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FunctionView/ArztMainView.fxml"));
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
        Arzt a= EPAControll.getEPA().getArzt(EPAControll.getCurrLoggedIn());
        Image icon = SwingFXUtils.toFXImage(ImageIO.read(this.getClass().getClassLoader().getResource("view/image/50115-200.png")), null);
        ArztImage.setImage(icon);
        aVorname.setText(a.getVorname());
        aVorname.setVisible(true);
        aNachname.setText(a.getNachname());
        aNachname.setVisible(true);
        aFach.setText(a.getFachrichtung());
        aFach.setVisible(true);
        aNum.setText(a.getNum());
        aNum.setVisible(true);
        aTel.setText(a.getTel());
        aTel.setVisible(true);
    }
    @FXML
    void zumLoginView(){
        mainStage.setScene(new Scene(new LoginViewController(mainStage)));
    }
    @FXML
    void zumUeberweisungErstellen(){
        mainStage.setScene(new Scene(new UeberweisungCreateViewController(mainStage,EPAControll)));
    }
    @FXML
    void zumUntersuchungsbericht(){
        mainStage.setScene(new Scene(new UntersuchungsberichtEingabeController(mainStage,EPAControll)));
    }

}

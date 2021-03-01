package view.FunctionView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import view.StartView.LoginViewController;

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
    private Stage mainStage;
    private String pID;
    public PatientMainViewController(Stage primaryStage, String ID) {
        mainStage= primaryStage;
        pID=ID;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FunctionView/PatientMainView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    @FXML
    void zumLoginView(){
        mainStage.setScene(new Scene(new LoginViewController(mainStage)));
    }

}

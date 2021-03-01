package view.FunctionView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ArztFunctionViewController extends AnchorPane {

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
    private Button aLogout;
    private Stage mainStage;
    public ArztFunctionViewController(Stage primaryStage) {
        mainStage= primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FunctionView/ArztFunctionView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}

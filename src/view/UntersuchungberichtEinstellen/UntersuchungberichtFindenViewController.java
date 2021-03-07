package view.UntersuchungberichtEinstellen;

import controller.EPAController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Untersuchungsbericht;
import view.ueberweisung.UntersuchungBerichtWahlController;

import java.io.IOException;
import java.util.ArrayList;

public class UntersuchungberichtFindenViewController extends AnchorPane {
    @FXML
    private FlowPane berichtListeView;

    @FXML
    private Text HiddenText;

    @FXML
    private Button zuMainView;

    @FXML
    private DatePicker StartDate;

    @FXML
    private DatePicker EndDate;
    private Stage mainStage;
    private EPAController epaController;
    @FXML
    private Button Suchen;

    @FXML
    void BerichteSuchen(ActionEvent event) {
        if(StartDate.getValue()==null||EndDate.getValue()==null){}
        else{
            berichtListeView.getChildren().clear();
            String versicherungnummer= epaController.getCurrLoggedIn();
            ArrayList<Untersuchungsbericht> untersuchungsberichtsList= epaController.getPatientDatenController().getUntersuchungbericht(StartDate.getValue().atStartOfDay(),EndDate.getValue().atStartOfDay(),versicherungnummer);
            if(untersuchungsberichtsList.size()!=0){
                for(int i=0; i< untersuchungsberichtsList.size();i++){
                    UntersuchungBerichtWahlController uc = new UntersuchungBerichtWahlController(untersuchungsberichtsList.get(i));
                    berichtListeView.getChildren().add(uc);
                }
            }
            else{
                berichtListeView.getChildren().add(HiddenText);
            }
        }
    }
    public UntersuchungberichtFindenViewController(Stage mainStage, EPAController epaController){
        this.mainStage=mainStage;
        this.epaController=epaController;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UntersuchungberichtEinstellen/UntersuchungberichtFinden.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void zuMainView(ActionEvent event) {
        mainStage.setScene(new Scene(new UntersuchungberichtEinstellenViewController(mainStage,epaController)));
    }
}

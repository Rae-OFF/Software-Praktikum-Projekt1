package view.UntersuchungberichtEinstellen;
import controller.EPAController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Arzt;
import model.Untersuchungsbericht;
import view.zusammenfassungderBehandlungsschritt.UntersuchungBerichtViewController;

import java.io.IOException;
import java.util.ArrayList;

public class ArztTabViewController extends AnchorPane {

    @FXML
    private TabPane ArztTab;
    @FXML
    private Button zuUntersuchungberichtEinstellen;
    private Stage mainStage;
    private EPAController epaController;
    public ArztTabViewController(Stage primaryStage, EPAController epaController){
        this.mainStage=primaryStage;
        this.epaController=epaController;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UntersuchungberichtEinstellen/ArztTabView.fxml"));
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
        ArrayList<Arzt> arztList= epaController.getEPA().getArztList();
        for(int i=0; i< arztList.size(); i++){
            if(arztList.get(i).getFachrichtung().equals("Hausarzt")){
               Tab arzt= new Tab(arztList.get(i).getName());
               PatientArztChooseViewController p = new PatientArztChooseViewController(mainStage,arztList.get(i),epaController);
               arzt.setContent(p);
               ArztTab.getTabs().add(arzt);
            }
        }
    }
    @FXML
    void zuUntersuchungberichtEinstellen(ActionEvent event) {
        mainStage.setScene(new Scene(new UntersuchungberichtEinstellenViewController(mainStage,epaController)));
    }
}



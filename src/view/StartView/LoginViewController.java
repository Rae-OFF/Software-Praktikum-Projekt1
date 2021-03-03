package view.StartView;
import controller.BenutzerAnlegenController;
import controller.EPAController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.EPA;
import view.FunctionView.ArztMainViewController;
import view.FunctionView.PatientMainViewController;

import java.io.IOException;
//hi
public class LoginViewController extends TabPane {
    @FXML
    private TextField pNum;

    @FXML
    private Button pLogin;

    @FXML
    private PasswordField pPasswort;

    @FXML
    private TextField aNum;

    @FXML
    private Button aLogin;

    @FXML
    private PasswordField aPasswort;

    @FXML
    private TextField pVorname;

    @FXML
    private TextField pNachname;

    @FXML
    private DatePicker pBday;

    @FXML
    private RadioButton pIsmale;

    @FXML
    private ToggleGroup sex;

    @FXML
    private RadioButton pIsfemale;

    @FXML
    private TextArea pAdress;

    @FXML
    private TextField pSetnum;

    @FXML
    private TextField pAnum;

    @FXML
    private TextField pSetpass;

    @FXML
    private Button neuPatient;

    @FXML
    private TextField aVorname;

    @FXML
    private TextField aNachname;

    @FXML
    private DatePicker aBday;

    @FXML
    private RadioButton aIsmale;

    @FXML
    private RadioButton aIsfemale;

    @FXML
    private TextField aSetnum;

    @FXML
    private Button neuArzt;

    @FXML
    private TextField aSetpass;

    @FXML
    private TextField aTel;

    @FXML
    private Text ArztHiddenText;
    @FXML
    private Text PatientHiddenText;
    @FXML
    private Text NeuArztHiddenText;
    @FXML
    private Text PatientAnlegenHiddenText;
    @FXML
    private TextField aFach;
    private Stage mainStage;
    private EPAController EPAControl;
    public LoginViewController(Stage primaryStage) {
        mainStage= primaryStage;
        EPAControl= new EPAController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/StartView/LoginView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
     @FXML
     void showArztFunctionView(ActionEvent event){
        String aID= aNum.getText();
        String aPass=aPasswort.getText();
         if (aID != null && aPass != null) {
             EPA epa= EPAControl.getEPA();
             if(epa.checkNumArzt(aID)){
                 if(epa.getArzt(aID).getPasswort().equals(aPass)){
                     EPAControl.setCurrLoggedIn(aID);
                     mainStage.setScene(new Scene(new ArztMainViewController(mainStage,EPAControl)));
                 }
             }
         }
         else{
             ArztHiddenText.setVisible(true);
         }
     }
    @FXML
    void showPatientFunctionView(ActionEvent event){
        String pID= pNum.getText();
        String pPass=pPasswort.getText();
        EPA epa= EPAControl.getEPA();
        if(epa.checkNumPatient(pID)){
            if(epa.getPatient(pID).getPasswort().equals(pPass)){
                EPAControl.setCurrLoggedIn(pID);
                mainStage.setScene(new Scene(new PatientMainViewController(mainStage,EPAControl)));
            }
        }
        else{
            PatientHiddenText.setVisible(true);
        }
    }
    @FXML
    void neuPatientAnlegen(ActionEvent e){
        if(!(pAdress.getText().isEmpty()||pNachname.getText().isEmpty()||pSetnum.getText().isEmpty()||pVorname.getText().isEmpty()||pSetpass.getText().isEmpty()||pBday.getValue()==null||!(pIsfemale.isSelected()||pIsmale.isSelected())))
        {
          // nutzt BenuterAnlegenController und erzeugt neu PAtient Instanz
          mainStage.setScene(new Scene(new LoginViewController(mainStage)));
        }
        else
        {
            PatientAnlegenHiddenText.setVisible(true);
        }

    }
    @FXML
    void neuArztAnlegen(ActionEvent e){
        if(!(aFach.getText().isEmpty()||aNachname.getText().isEmpty()||aSetnum.getText().isEmpty()||aVorname.getText().isEmpty()||aSetpass.getText().isEmpty()||aTel.getText().isEmpty()||aBday.getValue()==null||!(aIsfemale.isSelected()||aIsmale.isSelected())))
        {
            // nutzt BenuterAnlegenController und erzeugt neu Arzt Instanz
            mainStage.setScene(new Scene(new LoginViewController(mainStage)));
        }
        else{
            NeuArztHiddenText.setVisible(true);
        }

    }

}

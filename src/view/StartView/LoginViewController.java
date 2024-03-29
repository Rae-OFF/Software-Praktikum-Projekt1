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
import java.time.format.DateTimeFormatter;

/**
 * The type Login view controller.
 */
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
    private EPAController epaController;

    /**
     * Instantiates a new Login view controller.
     *
     * @param primaryStage the primary stage
     */
    public LoginViewController(Stage primaryStage) {
        mainStage= primaryStage;
        epaController= new EPAController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/StartView/LoginView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Show arzt function view.
     *
     * @param event the event
     */
    @FXML
     void showArztFunctionView(ActionEvent event){
        String aID= aNum.getText();
        String aPass=aPasswort.getText();
         if (aID != null && aPass != null) {
             EPA epa= epaController.getEPA();
             if(epa.checkNumArzt(aID)){
                 if(epa.getArzt(aID).getPasswort().equals(aPass)){
                     epaController.setCurrLoggedIn(aID);
                     epaController.setisArzt(true);
                     mainStage.setScene(new Scene(new ArztMainViewController(mainStage,epaController)));
                 }
             }
         }
         ArztHiddenText.setVisible(true);
     }

    /**
     * Show patient function view.
     *
     * @param event the event
     */
    @FXML
    void showPatientFunctionView(ActionEvent event){
        String pID= pNum.getText();
        String pPass=pPasswort.getText();
        EPA epa= epaController.getEPA();
        if (pID != null && pPass != null){
            if(epa.checkNumPatient(pID)){
                if(epa.getPatient(pID).getPasswort().equals(pPass)){
                    epaController.setCurrLoggedIn(pID);
                    epaController.setisArzt(false);
                    mainStage.setScene(new Scene(new PatientMainViewController(mainStage,epaController)));
                }
            }
        }
        PatientHiddenText.setVisible(true);
    }

    /**
     * Neu patient anlegen.
     *
     * @param e the e
     */
    @FXML
    void neuPatientAnlegen(ActionEvent e) throws IOException {
        if(!(pAdress.getText().isEmpty()||pNachname.getText().isEmpty()||pSetnum.getText().isEmpty()||pVorname.getText().isEmpty()||pSetpass.getText().isEmpty()||pBday.getValue()==null||!(pIsfemale.isSelected()||pIsmale.isSelected())))
        {
            if(epaController.getEPA().checkNumPatient(pSetnum.getText())){
                PatientAnlegenHiddenText.setText("Versicherungsnummer schon vorhanden");
                PatientAnlegenHiddenText.setVisible(true);
            }
            else if(!isNumberString(pSetnum.getText())){
                PatientAnlegenHiddenText.setText("Versicherungsnummer Format ungültig");
                PatientAnlegenHiddenText.setVisible(true);
            }
            else if(!isAlphabetString(pNachname.getText())||!isAlphabetString(pVorname.getText())){
                PatientAnlegenHiddenText.setText("Name Format ungültig");
                PatientAnlegenHiddenText.setVisible(true);
            }
            else{
                if(!pAnum.getText().isEmpty()&&(!epaController.getEPA().checkNumArzt(pAnum.getText())||!epaController.getEPA().getArzt(pAnum.getText()).getFachrichtung().equals("Hausarzt"))){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Information");
                    String s ="Sie haben keine gültige HausarztID eingegeben , Sie werden keinen Hausarzt zugewiesen ";
                    alert.setContentText(s);
                    alert.show();
                    pAnum.setText("");
                }
                epaController.getAktAnlegenController().patientAnlegen(pSetnum.getText(),pVorname.getText(),pNachname.getText(),pAdress.getText(),pIsfemale.isSelected(),pBday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),pSetpass.getText(),pAnum.getText());
                mainStage.setScene(new Scene(new LoginViewController(mainStage)));
            }
        }
        else
        {
            PatientAnlegenHiddenText.setText("Felder mit (*) muss eingegeben werden");
            PatientAnlegenHiddenText.setVisible(true);
        }
    }

    /**
     * Neu arzt anlegen.
     *
     * @param e the e
     */
    @FXML
    void neuArztAnlegen(ActionEvent e) throws IOException {
        if(!(aFach.getText().isEmpty()||aNachname.getText().isEmpty()||aSetnum.getText().isEmpty()||aVorname.getText().isEmpty()||aSetpass.getText().isEmpty()||aTel.getText().isEmpty()||aBday.getValue()==null||!(aIsfemale.isSelected()||aIsmale.isSelected())))
        {
            if(!isAlphabetString(aNachname.getText())||!isAlphabetString(aVorname.getText())){
                NeuArztHiddenText.setText("Name Format ungültig");
                NeuArztHiddenText.setVisible(true);
            }
            else if(!isNumberString(aTel.getText())){
                NeuArztHiddenText.setText("Telefonenummer Format ungültig");
                NeuArztHiddenText.setVisible(true);
            }
            else if(!isNumberString(aSetnum.getText())){
                NeuArztHiddenText.setText("ArztID Format ungültig");
                NeuArztHiddenText.setVisible(true);
            }
            else if(epaController.getEPA().checkNumArzt(aSetnum.getText())){
                NeuArztHiddenText.setText("ArztID schon vorhanden");
                NeuArztHiddenText.setVisible(true);
            }
            else{
                epaController.getAktAnlegenController().arztAnlegen(aVorname.getText(),aNachname.getText(),aFach.getText(),aSetnum.getText(),aSetpass.getText(),aTel.getText());
                mainStage.setScene(new Scene(new LoginViewController(mainStage)));
            }
        }
        else{
            NeuArztHiddenText.setText("Felder mit (*) muss eingegeben werden");
            NeuArztHiddenText.setVisible(true);
        }
    }
    public boolean isNumberString(String s){
        return s.matches("[0-9]+");
    }
    public boolean isAlphabetString(String s){
        return s.matches("[a-zA-Z]+");
    }
}

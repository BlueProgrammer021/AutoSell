package autoferrari;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField userField;
    @FXML
    private PasswordField passField;
    @FXML
    private Button login;
    
    @FXML
    private void getLogIn(ActionEvent event) throws Exception {
        System.out.println("User: " + userField.getText() + "\nPassword: " + passField.getText());
        Parent root = FXMLLoader.load(getClass().getResource("FXMLwelcomeScene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

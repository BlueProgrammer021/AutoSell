package autoferrari;

import java.io.IOException;
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
import javafx.stage.Stage;

public class FXMLwelcomeSceneController implements Initializable {

    @FXML
    private Button payments;
    @FXML
    private Button logOutBtn;
    @FXML
    private Button clientsBtn;
    @FXML
    private Button carBtn;
    @FXML
    private Button clientUpdate;
    @FXML
    private Button carUpdate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clientsPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLClientScene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void carsPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLRandom.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void paymentsPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPaymentsScene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void logOff(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void clientUpdatePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ClientUpdateScene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void carUpdatePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CarUpdateScene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }
    
}

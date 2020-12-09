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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ClientUpdateSceneController implements Initializable {

    @FXML
    private RadioButton idRButton;
    @FXML
    private RadioButton nameRButton;
    @FXML
    private RadioButton surnameRButton;
    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private Label statusLabel;
    @FXML
    private TableView<?> clientTable;
    @FXML
    private TableColumn<?, ?> idColumn;
    @FXML
    private TableColumn<?, ?> nameColumn;
    @FXML
    private TableColumn<?, ?> surnameColumn;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField phoneField;
    @FXML
    private Button updateButton;
    @FXML
    private Button backButton;
    
    final ToggleGroup tg = new ToggleGroup();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idRButton.setToggleGroup(tg);
        idRButton.setSelected(true);
        nameRButton.setToggleGroup(tg);
        surnameRButton.setToggleGroup(tg);
    }    

    @FXML
    private void searchClient(ActionEvent event) {
    }

    @FXML
    private void getDataToForm(MouseEvent event) {
    }

    @FXML
    private void updateClient(ActionEvent event) {
    }

    @FXML
    private void backPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLwelcomeScene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }
    
}

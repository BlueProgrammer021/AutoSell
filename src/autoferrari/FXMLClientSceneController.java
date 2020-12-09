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
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLClientSceneController implements Initializable {

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
    private Button addClientBtn;
    @FXML
    private Button deleteClientBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button backBtn;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField phoneField;
    @FXML
    private MenuItem popupAdd;
    @FXML
    private MenuItem popupDel;
    @FXML
    private ContextMenu contextMenu1;
    @FXML
    private ContextMenu contextMenu2;
    @FXML
    private AnchorPane ancPane;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // fillTableClientMethod
    }    

    @FXML
    private void addClient(ActionEvent event) {
        if(idField.getText().equals("") || (idField.getText().matches("[0-9]"))) {
            popupAdd.setText("Empty or invalid value");
            contextMenu1.show(ancPane, 650, 300);
        } else if(nameField.getText().equals("") || (nameField.getText().matches("[A-Za-z]"))) {
            popupAdd.setText("Empty or invalid value");
            contextMenu1.show(ancPane, 650, 300);
        } else if(surnameField.getText().equals("") || (surnameField.getText().matches("[A-Za-z]"))) {
            popupAdd.setText("Empty or invalid value");
            contextMenu1.show(ancPane, 650, 300);
        } else if(phoneField.getText().equals("") || (phoneField.getText().matches("[0-9]"))) {
            popupAdd.setText("Empty or invalid value");
            contextMenu1.show(ancPane, 650, 300);
        } else
            //addClientMethod
            ;
    }

    @FXML
    private void deleteClient(ActionEvent event) {
        if((idField.getText().equals("")) || (idField.getText().matches("[0-9]"))) {
            popupDel.setText("Empty or invalid value");
            contextMenu2.show(ancPane, 650, 300);
        } else if((nameField.getText().equals("")) || (nameField.getText().matches("[A-Z]"))) {
            popupDel.setText("Empty or invalid value");
            contextMenu2.show(ancPane, 650, 300);
        } else if((surnameField.getText().equals("")) || (surnameField.getText().matches("[A-Z]"))) {
            popupDel.setText("Empty or invalid value");
            contextMenu2.show(ancPane, 650, 300);
        } else if((phoneField.getText().equals("")) || (phoneField.getText().matches("[0-9]"))) {
            popupDel.setText("Empty or invalid value");
            contextMenu2.show(ancPane, 650, 300);
        } else
            //deleteClientMethod
            ;
    }

    @FXML
    private void clearFields(ActionEvent event) {
        idField.setText("");
        nameField.setText("");
        surnameField.setText("");
        phoneField.setText("");
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

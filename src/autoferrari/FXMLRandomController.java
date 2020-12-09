package autoferrari;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLRandomController implements Initializable {

    @FXML
    private TableView<?> carTable;
    @FXML
    private TableColumn<?, ?> constructorColumn;
    @FXML
    private TableColumn<?, ?> modelColumn;
    @FXML
    private TableColumn<?, ?> releaseColumn;
    @FXML
    private TableColumn<?, ?> availabilityColumn;
    @FXML
    private TableColumn<?, ?> colorColumn;
    @FXML
    private TableColumn<?, ?> cubismColumn;
    @FXML
    private TableColumn<?, ?> fuelColumn;
    @FXML
    private TableColumn<?, ?> priceColumn;
    @FXML
    private TextField constructorField;
    @FXML
    private TextField modelField;
    @FXML
    private TextField availabilityField;
    @FXML
    private TextField colorField;
    @FXML
    private TextField cubismField;
    @FXML
    private ComboBox fuelComboBox;
    @FXML
    private TextField priceField;
    
    ObservableList<String> fuels = FXCollections.observableArrayList("DIESEL","GAS");
    @FXML
    private ContextMenu contextMenu1;
    @FXML
    private MenuItem popupAdd;
    @FXML
    private ContextMenu contextMenu2;
    @FXML
    private MenuItem popupDel;
    @FXML
    private AnchorPane arcPane;
    @FXML
    private TextField releaseDate;
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fuelComboBox.setItems(fuels);
        try {
            fillTableCars();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLRandomController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLRandomController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addCar(ActionEvent event) {
        if(constructorField.getText().equals("") || constructorField.getText().matches("[A-Za-z]")) {
            popupAdd.setText("Empty or invalid value");
            contextMenu1.show(arcPane, 650, 300);
        } else if(modelField.getText().equals("") || modelField.getText().matches("[a-zA-Z0-9]+")) {
            popupAdd.setText("Empty or invalid value");
            contextMenu1.show(arcPane, 650, 300);
        } else if(releaseDate.getText().equals("") || releaseDate.getText().matches("[0-9]")) {
            popupAdd.setText("Empty or invalid value");
            contextMenu1.show(arcPane, 650, 300);
        } else if(availabilityField.getText().equals("") || availabilityField.getText().matches("[0-9]")) {
            popupAdd.setText("Empty or invalid value");
            contextMenu1.show(arcPane, 650, 300);
        } else if(colorField.getText().equals("") || colorField.getText().matches("[A-Za-z]")) {
            popupAdd.setText("Empty or invalid value");
            contextMenu1.show(arcPane, 650, 300);
        } else if(cubismField.getText().equals("") || cubismField.getText().matches("[A-Za-z]")) {
            popupAdd.setText("Empty or invalid value");
            contextMenu1.show(arcPane, 650, 300);
        } else if(priceField.getText().equals("") || priceField.getText().matches("[0-9]")) {
            popupAdd.setText("Empty or invalid value");
            contextMenu1.show(arcPane, 650, 300);
        } else if(fuelComboBox.getEditor().getText().isEmpty()) {
            popupAdd.setText("Empty or invalid value");
            contextMenu1.show(arcPane, 650, 300);
        } else 
            // addCarMathod
            ;
    }

    @FXML
    private void deleteCar(ActionEvent event) {
        if(constructorField.getText().equals("") || constructorField.getText().matches("[A-Za-z]")) {
            popupDel.setText("Empty or invalid value");
            contextMenu2.show(arcPane, 650, 300);
        } else if(modelField.getText().equals("") || modelField.getText().matches("[a-zA-Z0-9]+")) {
            popupDel.setText("Empty or invalid value");
            contextMenu2.show(arcPane, 650, 300);
        } else if(releaseDate.getText().equals("") || releaseDate.getText().matches("[0-9]")) {
            popupDel.setText("Empty or invalid value");
            contextMenu2.show(arcPane, 650, 300);
        } else if(availabilityField.getText().equals("") || availabilityField.getText().matches("[0-9]")) {
            popupDel.setText("Empty or invalid value");
            contextMenu2.show(arcPane, 650, 300);
        } else if(colorField.getText().equals("") || colorField.getText().matches("[A-Za-z]")) {
            popupDel.setText("Empty or invalid value");
            contextMenu2.show(arcPane, 650, 300);
        } else if(cubismField.getText().equals("") || cubismField.getText().matches("[A-Za-z]")) {
            popupDel.setText("Empty or invalid value");
            contextMenu2.show(arcPane, 650, 300);
        } else if(priceField.getText().equals("") || priceField.getText().matches("[0-9]")) {
            popupDel.setText("Empty or invalid value");
            contextMenu2.show(arcPane, 650, 300);
        } else if(fuelComboBox.getEditor().getText().isEmpty()) {
            popupDel.setText("Empty or invalid value");
            contextMenu2.show(arcPane, 650, 300);
        } else 
            // delCarMathod
            ;
    }

    @FXML
    private void backPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLwelcomeScene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void clearFields(ActionEvent event) {
        constructorField.setText("");
        modelField.setText("");
        releaseDate.setText("");
        availabilityField.setText("");
        colorField.setText("");
        cubismField.setText("");
        priceField.setText("");
        fuelComboBox.getEditor().clear();
    }
    
    public void fillTableCars() throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = DBUtils.dbExecuteQueryCars();
        ObservableList list = FXCollections.observableArrayList();
        
        while(rs.next()) {
            list.add(new Car(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6)
            ,rs.getString(7),rs.getDouble(8)));
        }
        
        rs.close();
        
        constructorColumn.setCellValueFactory(new PropertyValueFactory<>("constructor"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("release_date"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        cubismColumn.setCellValueFactory(new PropertyValueFactory<>("cubism"));
        fuelColumn.setCellValueFactory(new PropertyValueFactory<>("fuel"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        carTable.setItems(list);
        
    }
}

package autoferrari;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CarUpdateSceneController implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private RadioButton constructorRButton;
    @FXML
    private RadioButton modelRButton;
    @FXML
    private Button searchButton;
    @FXML
    private Label statusLabel;
    @FXML
    private TableView<?> tableCar;
    @FXML
    private TableColumn<?, ?> constructorColumn;
    @FXML
    private TableColumn<?, ?> modelColumn;
    @FXML
    private TableColumn<?, ?> colorColumn;
    @FXML
    private TableColumn<?, ?> availability;
    @FXML
    private TextField constructorField;
    @FXML
    private TextField modelField;
    @FXML
    private TextField releaseDateField;
    @FXML
    private TextField availabilityField;
    @FXML
    private TextField colorField;
    @FXML
    private TextField cubismField;
    @FXML
    private ComboBox<?> fuelComboBox;
    @FXML
    private TextField priceField;
    @FXML
    private Button updateButton;
    @FXML
    private Button backButton;
    
    //past values
    String pstConstructor;
    String pstModel;
    String pstRelease;
    String pstColor;
    
    final ToggleGroup tg = new ToggleGroup();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        constructorRButton.setToggleGroup(tg);
        constructorRButton.setSelected(true);
        modelRButton.setToggleGroup(tg);
    }    

    @FXML
    private void searchCar(ActionEvent event) throws SQLException, ClassNotFoundException, InterruptedException {
        String opt = searchField.getText();
        ResultSet rs = dbSearchCarBy(opt);
        fillTableCars(rs);
        pstConstructor = constructorField.getText();
        pstModel = modelField.getText();
        pstRelease = releaseDateField.getText();
        pstColor = colorField.getText();
    }

    @FXML
    private void updateCar(ActionEvent event) throws SQLException, ClassNotFoundException {
        String squery = "update cars c set c.constructor="+constructorField.getText()
                +",c.model="+modelField.getText()
                +",c.release_date="+releaseDateField.getText()
                +",c.availability="+availabilityField.getText()
                +",c.color="+colorField.getText()
                +",c.cubism="+cubismField.getText()
                +",c.fuel="+fuelComboBox.getEditor().getText()
                +",c.price="+priceField.getText();
        DBUtils.dbExecuteUpdate(squery);
    }

    @FXML
    private void backPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLwelcomeScene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }
    
    private ResultSet dbSearchCarBy(String searchBy) throws SQLException, ClassNotFoundException, InterruptedException {
        ResultSet rs = null;
        if(constructorRButton.isSelected()){
            rs = DBUtils.dbSearchByConstr(searchBy);
        } else if(modelRButton.isSelected()) {
            rs = DBUtils.dbSearchByModel(searchBy);
        }
        return rs;
    }
    
    private void fillTableCars(ResultSet rs) throws SQLException {
        ObservableList list = FXCollections.observableArrayList();
        
        while(rs.next()) {
            list.add(new Car(rs.getString(1),rs.getString(2),rs.getString(4),rs.getInt(5)));
        }
        
        constructorColumn.setCellValueFactory(new PropertyValueFactory<>("constructor"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        availability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        
        tableCar.setItems(list);
    }
}

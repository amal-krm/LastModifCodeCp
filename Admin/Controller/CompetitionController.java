package Admin.Controller;

import static Admin.Controller.ListeUsersController.id;
import DaoObj.DaoCompetition;
import Enumeration.Level;
import Obj.Competition;
import Obj.User;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.S;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Amal
 */
public class CompetitionController implements Initializable {

    @FXML
    private Button AjoutCompt;
    @FXML
    private DatePicker Date_fin;

    @FXML
    private TextField Titre;

    @FXML
    private DatePicker Date_debut;

    @FXML
    private Button Annuler;

    @FXML
    private Button Enregistrer;
    private DaoCompetition daoC = new DaoCompetition(Layout_adminController.db);
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Competition> tableView;
    @FXML
    private TableColumn<Competition, String> col_username;
    @FXML
    private TableColumn<Competition, Level> col_nom;
    @FXML
    private TableColumn<Competition, Date> col_prenom;
    static String id;
    @FXML
    void AfficherComp(ActionEvent event) throws SQLException, IOException {
        Competition Comp = tableView.getSelectionModel().getSelectedItem();
        //System.out.println(Comp.getIdCompetition());
        ResultSet idi = daoC.find(Comp.getIdCompetition());
        //idi.next();
        this.id = idi.getString(1);
        //System.out.println("hna"+id);
//        //System.out.println(id);
        Parent root = FXMLLoader.load(getClass().getResource("/Admin/fxml/detail_competition.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void DeleteCompt(ActionEvent event) throws SQLException {
        Competition Comp = tableView.getSelectionModel().getSelectedItem();
        ResultSet idi = daoC.find(Comp.getIdCompetition());
        tableView.getItems().remove(Comp);
        
        
        if (daoC.delete(idi.getString(1))) {
            System.out.println("Competition supprimer");
        } else {
            System.out.println("errror");
        }
    }

    @FXML
    void AjoutCompetition(ActionEvent event) {
        //date
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date DD = Date.from(Date_debut.getValue().atStartOfDay(defaultZoneId).toInstant());
        System.out.println(DD);
        Date DF = Date.from(Date_fin.getValue().atStartOfDay(defaultZoneId).toInstant());
        if (DD.compareTo(DF) > 0) {
            //DD kbira men DF
        }
        Competition C = new Competition(Level.EASY, true, Titre.getText(), DD, DF);
        if (daoC.create(C)) {
            System.out.println("competition ajouter");
        } else {
            System.out.println("Fuck");
        }

    }

    private void initTable() {
        initcol();
    }

    private void initcol() {
        col_username.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("Level_Comp"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("Date_fin"));
        tableView.setItems(loadData());
    }

    @FXML
    void DemandeAjouterComp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Admin/fxml/Ajouter_Competition.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<Competition> loadData() {
        ObservableList<Competition> data_table = FXCollections.observableArrayList();
        ResultSet Rs = daoC.all();
        try {
            while (Rs.next()) {
                //System.out.println( Rs.getString(2));
                data_table.add(new Competition(Level.valueOf(Rs.getString(2)), Rs.getBoolean(3), Rs.getString(1), Rs.getString(6), Rs.getDate(4), Rs.getDate(5)));
            }
        } catch (SQLException ex) {
            System.out.println("Muchkil f load data");
        }
        return data_table;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initTable();
        loadData();
    }

    public static String getId() {
        return id;
    }

}

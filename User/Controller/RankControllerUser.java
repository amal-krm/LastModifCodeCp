/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import Admin.Controller.Alert;
import Admin.Controller.ListeUsersController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import DaoObj.daoParticipe;
import Obj.Participer;
import Obj.User;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Huawei
 */
public class RankControllerUser implements Initializable {

    daoParticipe daoP = new daoParticipe(layoutController.db);
    Alert Al = new Alert();
    static String id;
    
     @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<Participer> tableView;
    @FXML
    private TableColumn<Participer,String> col_username;

    @FXML
    private TableColumn<Participer,String> col_Comp;

    @FXML
    private TableColumn<Participer,Integer> col_Score;
     private void initTable() {
        initcol();
    }

    private void initcol() {
        col_username.setCellValueFactory(new PropertyValueFactory<Participer,String>("Id_User"));
        col_Score.setCellValueFactory(new PropertyValueFactory<Participer,Integer>("Score"));
       col_Comp.setCellValueFactory(new PropertyValueFactory<Participer,String>("Id_Competition"));
        tableView.setItems(loadData());
       
    }

    private ObservableList<Participer> loadData() {
        ObservableList<Participer> data_table = FXCollections.observableArrayList();
     //      data_table.add(new Participer("aa","ee",1));
        System.out.println("The iid is"+id);
       ResultSet Rs = daoP.all(id);
        try {
            while (Rs.next()) {
                data_table.add(new Participer(Rs.getString(1),  Rs.getString(2),Rs.getInt(3)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ListeUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data_table;
    }

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         System.out.println("hhhh");
         initTable();
       loadData();
//        
    }    
    
}


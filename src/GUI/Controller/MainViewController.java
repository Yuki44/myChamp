/*
 * Erhvervsakademi Sydvest, Computer Science 2016-2017, Carlos F. Ognissanti
 * To change this header, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
public class MainViewController implements Initializable
 {

   @FXML
   private TextField teamTextField;
   @FXML
   private Button addTeamButton;
   @FXML
   private Button editTeamButton;
   @FXML
   private Button removeTeamButton;
   @FXML
   private Button scheduleTournamentButton;
   @FXML
   private ListView<?> teamList;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb)
    {
      // TODO
    }

 }

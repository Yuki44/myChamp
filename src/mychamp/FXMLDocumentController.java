/*
 * Erhvervsakademi Sydvest, Computer Science 2016-2017, Carlos F. Ognissanti
 * To change this header, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Yuki
 */
public class FXMLDocumentController implements Initializable
 {

   @FXML
   private Label label;

   @FXML
   private void handleButtonAction(ActionEvent event)
    {
      System.out.println("You clicked me!");
      label.setText("Hello World!");
    }

   @Override
   public void initialize(URL url, ResourceBundle rb)
    {
      // TODO
    }

 }

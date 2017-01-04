/*
 * Erhvervsakademi Sydvest, Computer Science 2016-2017, Carlos F. Ognissanti
 * To change this header, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Yuki
 */
public class MyChamp extends Application
 {

   @Override
   public void start(Stage stage) throws Exception
    {
      Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

      Scene scene = new Scene(root);

      stage.setScene(scene);
      stage.show();
    }

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args)
    {
      launch(args);
    }

 }

/*
 * Erhvervsakademi Sydvest, Computer Science 2016-2017, Carlos F. Ognissanti
 * To change this header, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Main;

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
      Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/MainView.fxml"));

      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
      String title = "Esbjerg School Football Championship Management";
      stage.setTitle(title);
      stage.setResizable(false);
      stage.setMaximized(false);
//      stage.setMinWidth(1024);
//      stage.setMinHeight(768);
    }

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args)
    {
      launch(args);
    }

 }

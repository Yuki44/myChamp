package GUI.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BE.Team;
import Model.Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author MSI GS40 6QE
 */
public class MainViewController implements Initializable
 {

   @FXML
   private Label listSizeLabel;
   @FXML
   private TextField nameTxtField;
   @FXML
   private ListView<Team> teamList;
   @FXML
   private Button addTeamBtn;
   @FXML
   private Button editTeamButton;
   @FXML
   private Button makeGroupsBtn;
   @FXML
   private Button removeTeamButton;

   @Override
   public void initialize(URL url, ResourceBundle rb)
    {
      fixListView();
//      teamList.getItems().add(new Team(0, "name1"));
//      teamList.getItems().add(new Team(1, "name1"));
//      teamList.getItems().add(new Team(2, "name1"));
//      teamList.getItems().add(new Team(3, "name1"));
//      teamList.getItems().add(new Team(4, "name1"));
//      teamList.getItems().add(new Team(5, "name1"));
//      teamList.getItems().add(new Team(6, "name1"));
//      teamList.getItems().add(new Team(7, "name1"));
//      teamList.getItems().add(new Team(8, "name1"));
//      teamList.getItems().add(new Team(9, "name1"));
//      teamList.getItems().add(new Team(10, "name1"));
//      teamList.getItems().add(new Team(11, "name1"));
//      teamList.getItems().add(new Team(12, "name1"));
//      teamList.getItems().add(new Team(13, "name1"));
      disableButtons();
      disableAddTeamButton();
    }

   @FXML
   private void handleAddTeam(ActionEvent event)
    {
      addTeam();
    }

   private void addTeam()
    {
      if (!nameTxtField.getText().trim().isEmpty())
      {
         Model.getInstance().addNewTeam(nameTxtField.getText());
         updateText();
         nameTxtField.clear();
         nameTxtField.requestFocus();
         disableButtons();
         disableAddTeamButton();
      }
      nameTxtField.clear();
      nameTxtField.requestFocus();
      disableButtons();
      disableAddTeamButton();
    }

   private void disableButtons()
    {
      if (Model.getInstance().getAllTeamListSize() < 12)
      {
         makeGroupsBtn.setDisable(true);
      }
      else
      {
         makeGroupsBtn.setDisable(false);
      }

    }

   private void updateText()
    {
      if (Model.getInstance().getAllTeamListSize() < 2)
      {
         listSizeLabel.setText(Model.getInstance().getAllTeamListSize() + " Team on the list.");
      }
      else
      {
         listSizeLabel.setText(Model.getInstance().getAllTeamListSize() + " Teams on the list.");
      }
    }

   private void disableAddTeamButton()
    {
      if (Model.getInstance().getAllTeamListSize() >= 16)
      {
         addTeamBtn.setDisable(true);

      }
      else
      {
         addTeamBtn.setDisable(false);
      }
    }

   @FXML
   private void handleMakeGroups(ActionEvent event)
    {
      Model.getInstance().makeGroups();
      Model.getInstance().Sizes();
      Model.getInstance().createScheduleForGroup();
      try
      {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/setScoresView.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.setScene(new Scene(root1));
         stage.show();
         String title = "Esbjerg School Football Championship Management";
         stage.setTitle(title);
         stage.setResizable(false);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

    }

   @FXML
   private void handleRemoveTeam(ActionEvent event)
    {
      Model.getInstance().removeTeam(teamList.getSelectionModel().getSelectedIndex());
      disableAddTeamButton();
      updateText();
      disableButtons();
    }

   private void fixListView()
    {

      teamList.setItems(Model.getInstance().getAllTeamList());
      teamList.setCellFactory(new Callback<ListView<Team>, ListCell<Team>>()
       {

         @Override
         public ListCell<Team> call(ListView<Team> param)
          {
            ListCell<Team> cell = new ListCell<Team>()
             {

               @Override
               protected void updateItem(Team item, boolean empty)
                {
                  super.updateItem(item, empty);
                  if (item != null)
                  {
                     setText((item.getId() + 1) + ". " + item.getName());
                  }
                  else
                  {
                     setText("");
                  }
                }
             };
            return cell;
          }
       });
    }

   @FXML
   private void sendHandleAddTeam(KeyEvent event)
    {
      if (event.getCode() == KeyCode.ENTER && Model.getInstance().getAllTeamListSize() < 16)
      {
         addTeam();
      }
    }
 }

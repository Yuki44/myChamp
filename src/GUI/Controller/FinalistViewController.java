/*
 * Erhvervsakademi Sydvest, Computer Science 2016-2017, Carlos F. Ognissanti
 * To change this header, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Match;
import Model.Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
public class FinalistViewController implements Initializable
 {

   @FXML
   private TextField homeScoreTxtField;
   @FXML
   private TextField awayScoreTxtField;
   @FXML
   private Button setScoreBtn;
   @FXML
   private Label homeLbl;
   @FXML
   private Label awayLbl;
   @FXML
   private Button resetScoreBtn;
   @FXML
   private Label quarterFinalsTeam1Text;
   @FXML
   private Label quarterFinalsTeam1Score;
   @FXML
   private Label quarterFinalsTeam2Text;
   @FXML
   private Label quarterFinalsTeam2Score;
   @FXML
   private Label quarterFinalsTeam3Text;
   @FXML
   private Label quarterFinalsTeam3Score;
   @FXML
   private Label quarterFinalsTeam4Text;
   @FXML
   private Label quarterFinalsTeam4Score;
   @FXML
   private Label quarterFinalsTeam5Text;
   @FXML
   private Label quarterFinalsTeam5Score;
   @FXML
   private Label quarterFinalsTeam6Text;
   @FXML
   private Label quarterFinalsTeam6Score;
   @FXML
   private Label quarterFinalsTeam7Text;
   @FXML
   private Label quarterFinalsTeam7Score;
   @FXML
   private Label quarterFinalsTeam8Text;
   @FXML
   private Label quarterFinalsTeam8Score;
   @FXML
   private Label semiFinalsTeam1Text;
   @FXML
   private Label semiFinalsTeam1Score;
   @FXML
   private Label semiFinalsTeam2Text;
   @FXML
   private Label finalTeam1Text;
   @FXML
   private Label finalTeam1Score;
   @FXML
   private Label finalTeam2Text;
   @FXML
   private Label finalTeam2Score;
   @FXML
   private Button nextStageButton;
   @FXML
   private Label winnerTeamTextLabel;
   @FXML
   private TableView<Match> finalistMatchesTableView;
   @FXML
   private TableColumn<Match, String> playedColumn;
   @FXML
   private TableColumn<Match, String> matchesColumn;
   @FXML
   private Label semiFinalsTeam2Score;
   @FXML
   private Label semiFinalsTeam3Text;
   @FXML
   private Label semiFinalsTeam3Score;
   @FXML
   private Label semiFinalsTeam4Text;
   @FXML
   private Label semiFinalsTeam4Score;

   ObservableList<Match> currentFinalStageMatches = FXCollections.observableArrayList(Model.getInstance().matchesInQuarterFinals);
   int stage = 0;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb)
    {
      showQuarterTeamStages();
      matchesColumn.setCellValueFactory(new PropertyValueFactory<Match, String>("ColumnContent"));
      playedColumn.setCellValueFactory(new PropertyValueFactory<Match, String>("HadPlace"));
      finalistMatchesTableView.getItems().setAll(currentFinalStageMatches);
    }

   private void fixCurrentStageMatches(int stage1)
    {
//      s ObservableList<Match> tempList = FXCollections.observableArrayList(Model.getInstance().matchesInQuarterFinals);
      switch (stage1)
      {
         case 1:
            currentFinalStageMatches.setAll((Model.getInstance().semiFinalMatches(currentFinalStageMatches)));
            finalistMatchesTableView.getItems().setAll(currentFinalStageMatches);
            break;
         case 2:
            currentFinalStageMatches.setAll((Model.getInstance().FinalMatch(currentFinalStageMatches)));
            finalistMatchesTableView.getItems().setAll(currentFinalStageMatches);
            break;
         default:
            System.out.println("something went wrong");
            break;
      }
    }

   public void showQuarterTeamStages()
    {
      quarterFinalsTeam1Text.setText(Model.getInstance().quarterFinalTeamList.get(0).getName());
      quarterFinalsTeam2Text.setText(Model.getInstance().quarterFinalTeamList.get(3).getName());
      quarterFinalsTeam3Text.setText(Model.getInstance().quarterFinalTeamList.get(1).getName());
      quarterFinalsTeam4Text.setText(Model.getInstance().quarterFinalTeamList.get(2).getName());
      quarterFinalsTeam5Text.setText(Model.getInstance().quarterFinalTeamList.get(5).getName());
      quarterFinalsTeam6Text.setText(Model.getInstance().quarterFinalTeamList.get(7).getName());
      quarterFinalsTeam7Text.setText(Model.getInstance().quarterFinalTeamList.get(4).getName());
      quarterFinalsTeam8Text.setText(Model.getInstance().quarterFinalTeamList.get(6).getName());
    }

   public void showSemiFinalTeamStages()
    {
      semiFinalsTeam1Text.setText(Model.getInstance().semiFinalTeamList.get(0).getName());
      semiFinalsTeam2Text.setText(Model.getInstance().semiFinalTeamList.get(3).getName());
      semiFinalsTeam3Text.setText(Model.getInstance().semiFinalTeamList.get(1).getName());
      semiFinalsTeam4Text.setText(Model.getInstance().semiFinalTeamList.get(2).getName());
    }

   public void showFinalTeamStage()
    {
      finalTeam1Text.setText(Model.getInstance().finalTeamList.get(0).getName());
      finalTeam2Text.setText(Model.getInstance().finalTeamList.get(1).getName());
    }

   @FXML
   private void handleSetScore(ActionEvent event)
    {
      Match SelectedMatch = finalistMatchesTableView.getSelectionModel().getSelectedItem();

      SelectedMatch.setHScore(Integer.parseInt(homeScoreTxtField.getText()));
      SelectedMatch.setAScore(Integer.parseInt(awayScoreTxtField.getText()));
      SelectedMatch.setHadPlace(true);
      Model.getInstance().setMatch(SelectedMatch);
//      disableOrEnableButtons();
      refreshViews();
      boolean nextRound = true;
      for (Match match : currentFinalStageMatches)
      {
         if (match.isHadPlace() == false)
         {
            nextRound = false;
         }
      }
      if (nextRound == true)
      {
         stage++;

         fixCurrentStageMatches(stage);

      }
    }

   private void refreshViews()
    {
      finalistMatchesTableView.refresh();

    }

   private void disableOrEnableButtons()
    {
      Match SelectedMatch = finalistMatchesTableView.getSelectionModel().getSelectedItem();
      if (SelectedMatch.isHadPlace() == true)
      {
         setScoreBtn.setDisable(true);
         resetScoreBtn.setDisable(false);
      }
      else
      {
         setScoreBtn.setDisable(false);
         resetScoreBtn.setDisable(true);
      }
    }

   @FXML
   private void handleResetScore(ActionEvent event)
    {
    }

   @FXML
   private void handleNextStage(ActionEvent event)
    {

    }

 }

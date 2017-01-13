/*
 * Erhvervsakademi Sydvest, Computer Science 2016-2017, Carlos F. Ognissanti
 * To change this header, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Match;
import Model.Model;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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


   public void showQuarterTeamStages()
    {
      quarterFinalsTeam1Text.setText(Model.getInstance().AllFinalists.get(0).getName());
      quarterFinalsTeam2Text.setText(Model.getInstance().AllFinalists.get(3).getName());
      quarterFinalsTeam3Text.setText(Model.getInstance().AllFinalists.get(1).getName());
      quarterFinalsTeam4Text.setText(Model.getInstance().AllFinalists.get(2).getName());
      quarterFinalsTeam5Text.setText(Model.getInstance().AllFinalists.get(5).getName());
      quarterFinalsTeam6Text.setText(Model.getInstance().AllFinalists.get(7).getName());
      quarterFinalsTeam7Text.setText(Model.getInstance().AllFinalists.get(4).getName());
      quarterFinalsTeam8Text.setText(Model.getInstance().AllFinalists.get(6).getName());
    }

   @FXML
   private void handleSetScore(ActionEvent event)
    {

      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Add Score Confirmation");
      alert.setHeaderText("You are about to set a score that can't be changed later.");
      alert.setContentText("Are you sure you want to set that score?");

      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == ButtonType.OK)
      {
      Match SelectedMatch = finalistMatchesTableView.getSelectionModel().getSelectedItem();
      if(Integer.parseInt(homeScoreTxtField.getText())!=Integer.parseInt(awayScoreTxtField.getText())){
          
      SelectedMatch.setHScore(Integer.parseInt(homeScoreTxtField.getText()));
      SelectedMatch.setAScore(Integer.parseInt(awayScoreTxtField.getText()));
      SelectedMatch.setHadPlace(true);
      Model.getInstance().setMatch(SelectedMatch);
      refreshViews();
    FixGoalsInMatchesView();
      }
      else
      {
          Alert drawError = new Alert (Alert.AlertType.ERROR);
          drawError.setTitle("Draw Alert");
          drawError.setContentText("There has to be one winner!!!");
          drawError.setHeaderText(null);
          drawError.showAndWait();
                  
      }
      }
      else
      {
         System.out.println("Score setting aborted by user");
      }
      
    }

   private void refreshViews()
    {
      finalistMatchesTableView.refresh();

    }



   @FXML
   private void handleNextStage(ActionEvent event)
    {
       
//      s ObservableList<Match> tempList = FXCollections.observableArrayList(Model.getInstance().matchesInQuarterFinals);
      switch (stage)
      {
         case 0:
            currentFinalStageMatches.setAll((Model.getInstance().semiFinalMatches(currentFinalStageMatches)));
            finalistMatchesTableView.getItems().setAll(currentFinalStageMatches);
            break;
         case 1:
             System.out.println(currentFinalStageMatches.size());
            currentFinalStageMatches.setAll((Model.getInstance().FinalMatch(currentFinalStageMatches)));
            finalistMatchesTableView.getItems().setAll(currentFinalStageMatches);   
            break; 
         case 2:
             winnerTeamTextLabel.setText(Model.getInstance().GetWinnerOfTournament(currentFinalStageMatches).getName().toString());
            break;
         default:
            System.out.println("something went wrong");
            break;
      }

        if(stage==0)
        {
              semiFinalsTeam1Text.setText(currentFinalStageMatches.get(0).getHTeam().getName());
              semiFinalsTeam2Text.setText(currentFinalStageMatches.get(1).getHTeam().getName());
              semiFinalsTeam3Text.setText(currentFinalStageMatches.get(1).getATeam().getName());
              semiFinalsTeam4Text.setText(currentFinalStageMatches.get(0).getATeam().getName());
        }
        else if(stage==1)
        {
            finalTeam1Text.setText(currentFinalStageMatches.get(0).getHTeam().getName());
            finalTeam2Text.setText(currentFinalStageMatches.get(0).getATeam().getName());
        }
        else if(stage==2)
        {
            winnerTeamTextLabel.setText(Model.getInstance().GetWinnerOfTournament(currentFinalStageMatches).getName().toString());
        }

    stage++;
    }
   
   private void FixGoalsInMatchesView()
   {
             switch (stage)
      {
         case 0:
            quarterFinalsTeam1Score.setText(currentFinalStageMatches.get(0).getHScore()+"");
            quarterFinalsTeam2Score.setText(currentFinalStageMatches.get(0).getAScore()+"");                    
            quarterFinalsTeam3Score.setText(currentFinalStageMatches.get(1).getHScore()+"");                    
            quarterFinalsTeam4Score.setText(currentFinalStageMatches.get(1).getAScore()+"");                    
            quarterFinalsTeam5Score.setText(currentFinalStageMatches.get(2).getHScore()+"");                    
            quarterFinalsTeam6Score.setText(currentFinalStageMatches.get(2).getAScore()+"");                    
            quarterFinalsTeam7Score.setText(currentFinalStageMatches.get(3).getHScore()+"");                    
            quarterFinalsTeam8Score.setText(currentFinalStageMatches.get(3).getAScore()+"");                    
                    
            break;
         case 1:
             semiFinalsTeam1Score.setText(currentFinalStageMatches.get(0).getHScore()+"");
             semiFinalsTeam2Score.setText(currentFinalStageMatches.get(0).getAScore()+"");
             semiFinalsTeam3Score.setText(currentFinalStageMatches.get(1).getHScore()+"");
             semiFinalsTeam4Score.setText(currentFinalStageMatches.get(1).getAScore()+"");
            break; 
         case 2:
             finalTeam1Score.setText(currentFinalStageMatches.get(0).getHScore()+"");
             finalTeam2Score.setText(currentFinalStageMatches.get(0).getAScore()+"");
             winnerTeamTextLabel.setText(Model.getInstance().GetWinnerOfTournament(currentFinalStageMatches).getName().toString());
            break;
         default:
            System.out.println("something went wrong");
            break;
      }
   }
 }

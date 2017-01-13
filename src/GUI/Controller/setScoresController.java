/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Match;
import Model.Model;
import com.sun.java.swing.plaf.windows.WindowsBorders;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI GS40 6QE
 */
public class setScoresController implements Initializable {
    

    @FXML
    private TableView<Match> allMatchesTableView;
    @FXML
    private TextField homeScoreTxtField;
    @FXML
    private Button setScoreBtn;
    @FXML
    private Label homeLbl;
    @FXML
    private Label awayLbl;
    @FXML
    private Button resetScoreBtn;
    @FXML
    private TableView<Match> groupBTableView;
    @FXML
    private TableColumn<Match, String> ALLGroupCol;
    @FXML
    private TableColumn<Match, String> GroupBCol;
    @FXML
    private TableColumn<Match, String> GroupACol;
    @FXML
    private TableColumn<Match, String> GroupCCol;
    @FXML
    private TableColumn<Match, String> GroupDCol;
    @FXML
    private TextField awayScoreTxtField;
    @FXML
    private TableView<Match> groupATableView;
    @FXML
    private TableView<Match> groupCTableView;
    @FXML
    private TableView<Match> groupDTableView;
    
    private Match SelectedMatch;
    @FXML
    private TableColumn<Match, String> AllMatchesPlayedCol;
    @FXML
    private Button goToFinalsButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    fixTableViews();
    fixSelection(); 
    fixDesign();
    }
    private void fixDesign(){
        homeScoreTxtField.setAlignment(Pos.CENTER);
        awayScoreTxtField.setAlignment(Pos.CENTER);
    }
    private void refreshViews()
    {
        allMatchesTableView.refresh();
        groupATableView.refresh();
        groupBTableView.refresh();
        groupCTableView.refresh();
        groupDTableView.refresh();
    }
    private void fixSetScorePanel()
    {
        homeScoreTxtField.setText(SelectedMatch.getHScore()+"");
        awayScoreTxtField.setText(SelectedMatch.getAScore()+"");
        homeLbl.setText(SelectedMatch.getHTeam().getName());
        awayLbl.setText(SelectedMatch.getATeam().getName());
        
    }
    private void fixSelection()
    {
            allMatchesTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    if (newSelection != null) {
    groupATableView.getSelectionModel().clearSelection();
    groupBTableView.getSelectionModel().clearSelection();
    groupCTableView.getSelectionModel().clearSelection();
    groupDTableView.getSelectionModel().clearSelection();
    SelectedMatch=newSelection;
    fixSetScorePanel();
    disableOrEnableButtons();

    }
});
            groupATableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    if (newSelection != null) {
    allMatchesTableView.getSelectionModel().clearSelection();
    groupBTableView.getSelectionModel().clearSelection();
    groupCTableView.getSelectionModel().clearSelection();
    groupDTableView.getSelectionModel().clearSelection();
    SelectedMatch=newSelection;
        fixSetScorePanel();
        disableOrEnableButtons();
    }
});
                groupBTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    if (newSelection != null) {
    groupATableView.getSelectionModel().clearSelection();
    allMatchesTableView.getSelectionModel().clearSelection();
    groupCTableView.getSelectionModel().clearSelection();
    groupDTableView.getSelectionModel().clearSelection();
    SelectedMatch=newSelection;
    fixSetScorePanel();
    disableOrEnableButtons();
    }
});
                    groupCTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    if (newSelection != null) {
    groupATableView.getSelectionModel().clearSelection();
    groupBTableView.getSelectionModel().clearSelection();
    allMatchesTableView.getSelectionModel().clearSelection();
    groupDTableView.getSelectionModel().clearSelection();
    SelectedMatch=newSelection;
    fixSetScorePanel();
    disableOrEnableButtons();
    }
});
                        groupDTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    if (newSelection != null) {
    groupATableView.getSelectionModel().clearSelection();
    groupBTableView.getSelectionModel().clearSelection();
    groupCTableView.getSelectionModel().clearSelection();
    allMatchesTableView.getSelectionModel().clearSelection();
    SelectedMatch=newSelection;
    fixSetScorePanel();
    disableOrEnableButtons();
    }
});
    }
    private void fixTableViews()
    {
        ALLGroupCol.setCellValueFactory(new PropertyValueFactory<Match, String>("ColumnContent"));
        AllMatchesPlayedCol.setCellValueFactory(new PropertyValueFactory<Match, String>("HadPlace"));
        GroupACol.setCellValueFactory(new PropertyValueFactory<Match, String>("ColumnContent"));
        GroupBCol.setCellValueFactory(new PropertyValueFactory<Match, String>("ColumnContent"));
        GroupCCol.setCellValueFactory(new PropertyValueFactory<Match, String>("ColumnContent"));
        GroupDCol.setCellValueFactory(new PropertyValueFactory<Match, String>("ColumnContent"));

        allMatchesTableView.getItems().setAll(Model.getInstance().AllMatches);
        groupATableView.getItems().setAll(Model.getInstance().AllMatchesInGroupA);
        groupBTableView.getItems().setAll(Model.getInstance().AllMatchesInGroupB);
        groupCTableView.getItems().setAll(Model.getInstance().AllMatchesInGroupC);
        groupDTableView.getItems().setAll(Model.getInstance().AllMatchesInGroupD);
    }
        @FXML
    private void handleSetMatch(ActionEvent event) {
            SelectedMatch.setHadPlace(true);
            SelectedMatch.setHScore(Integer.parseInt(homeScoreTxtField.getText()));
            SelectedMatch.setAScore(Integer.parseInt(awayScoreTxtField.getText()));
            
            Model.getInstance().setMatch(SelectedMatch);       
            disableOrEnableButtons();
            refreshViews();
            System.out.println("HTeam Score: "+SelectedMatch.getHTeam().getPoints()+"GoalsScored: "+SelectedMatch.getHTeam().getGoalsScored()+" GoalsLost: "+SelectedMatch.getHTeam().getGoalsLost());
            System.out.println("ATeam Score: "+SelectedMatch.getATeam().getPoints()+"GoalsScored: "+SelectedMatch.getATeam().getGoalsScored()+" GoalsLost: "+SelectedMatch.getATeam().getGoalsLost());
    }

    @FXML
    private void handleResetMatch(ActionEvent event) {
         Model.getInstance().resetMatch(SelectedMatch);  
         SelectedMatch.setHadPlace(false);
         awayScoreTxtField.setText("0");
         homeScoreTxtField.setText("0");
         disableOrEnableButtons();  
         refreshViews();
          System.out.println("HTeam Score: "+SelectedMatch.getHTeam().getPoints()+"GoalsScored: "+SelectedMatch.getHTeam().getGoalsScored()+" GoalsLost: "+SelectedMatch.getHTeam().getGoalsLost());
            System.out.println("ATeam Score: "+SelectedMatch.getATeam().getPoints()+"GoalsScored: "+SelectedMatch.getATeam().getGoalsScored()+" GoalsLost: "+SelectedMatch.getATeam().getGoalsLost());
    }

private void disableOrEnableButtons()
{
    if(SelectedMatch.isHadPlace()==true)
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
   private void handleGoToFinals(ActionEvent event)
    {
        boolean go = true;
        for (Match match : Model.getInstance().AllMatches) {
            if(match.isHadPlace()==false)
                go = false;
        }
        if(go == true)
        {
        Model.getInstance().chooseFinalists();
        Model.getInstance().addQuarterFinalsMatches();
        System.out.println(Model.getInstance().AllFinalists.size());
      try
      {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/FinalistView.fxml"));
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
        else
        {
          Alert drawError = new Alert (Alert.AlertType.ERROR);
          drawError.setTitle("Dear teacher, I want to play a game");
          drawError.setContentText("Set scores for all the teams");
          drawError.setHeaderText(null);
          drawError.showAndWait();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Collections;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import BE.Group;
import BE.Match;
import BE.Team;
import java.util.ArrayList;

/**
 *
 * @author MSI GS40 6QE
 */
public class Model {
    private static Model instance;
    public static Model getInstance()
    {
        if(instance==null)
            instance = new Model();
        return instance;
    }
    
    private Group GroupA;
    private Group GroupB;
    private Group GroupC;
    private Group GroupD;
    
    public ObservableList<Match> AllMatchesInGroupA = FXCollections.observableArrayList();
    public ObservableList<Match> AllMatchesInGroupB = FXCollections.observableArrayList();
    public ObservableList<Match> AllMatchesInGroupC = FXCollections.observableArrayList();
    public ObservableList<Match> AllMatchesInGroupD = FXCollections.observableArrayList();
    public ObservableList<Match> AllMatches = FXCollections.observableArrayList();

    public ObservableList<Team> AllFinalists = FXCollections.observableArrayList();
    
    private ObservableList<Team> AllTeams = FXCollections.observableArrayList();


    public Model() {
        this.GroupA = new Group(0);
        this.GroupB = new Group(1);
        this.GroupC = new Group(2);
        this.GroupD = new Group(3);
        this.AllTeams = FXCollections.observableArrayList();
        this.AllMatches = FXCollections.observableArrayList();
    }
    public void addNewTeam(String name)
    {
        AllTeams.add(new Team(AllTeams.size(), name));
    }
     public void removeTeam(int teamId)
    {
        AllTeams.remove(teamId);
        int x = 0;
        for (Team team : AllTeams) {
            team.setId(x);
            x++;
        }
    }
    public void addTeamToGroup(int operator, Team team)
    {
        switch (operator){
            case 0: GroupA.addToTeamsList(team);
                break;
            case 1: GroupB.addToTeamsList(team);
                break;
            case 2: GroupC.addToTeamsList(team);
                break;
            case 3: GroupD.addToTeamsList(team);
                break;
            default: System.out.println("Invalid team name, choose from A,B,C,D");
                break;
        }
    }
    
    public int getAllTeamListSize()
    {
        return AllTeams.size();
    }
    
    public ObservableList<Team> getAllTeamList()
    {
        return AllTeams;
    }
    
    public void makeGroups()
    {

        ObservableList<Team> tempList = FXCollections.observableArrayList(AllTeams);
        long seed = System.nanoTime();
        Collections.shuffle(tempList, new Random(seed));
        int operator=0;
        for (Team team : tempList) {
            addTeamToGroup(operator, team);
            if(operator<3)
                operator++;
            else
                operator=0;
            }
        }
  
    
        
    public void createScheduleForGroup()
    {   int x;
        Group group = null;
        ObservableList<Match> matchesInGroup = FXCollections.observableArrayList();
        
        for(x=0;x<4;x++)
        {
        switch (x)
        {
            case 0: group=GroupA;
                    matchesInGroup=AllMatchesInGroupA;
                     break;
            case 1: group=GroupB;
                    matchesInGroup=AllMatchesInGroupB;
                     break;
            case 2: group=GroupC;
                    matchesInGroup=AllMatchesInGroupC;
                     break;
            case 3: group=GroupD;
                    matchesInGroup=AllMatchesInGroupD;
                     break;
            default: System.out.println("Something went wrong while scheduling");;
                     break;
        }
        Match match = null;
        if(group.getNumberOfTeamsInGroup()==3)
        {
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(2), group.getTeam(1), 1));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(1), group.getTeam(0), 2));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(2), group.getTeam(0), 3));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(0), group.getTeam(1), 4));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(0), group.getTeam(2), 5));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(1), group.getTeam(2), 6));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            
        }
        else if (group.getNumberOfTeamsInGroup()==4)
        {
            
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(0), group.getTeam(2), 1));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(1), group.getTeam(3), 1));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(0), group.getTeam(3), 2));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(2), group.getTeam(1), 2));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(0), group.getTeam(1), 3));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(3), group.getTeam(2), 3));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(3), group.getTeam(0), 4));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(1), group.getTeam(2), 4));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(1), group.getTeam(0), 5));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(2), group.getTeam(3), 5));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(2), group.getTeam(0), 6));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(3), group.getTeam(1), 6));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size()-1)));
        }
        }
    }
    
    public void setMatch(Match match)
    {
        Team teamH = match.getHTeam();
        Team teamA = match.getATeam();
        int TeamHGoals = match.getHScore();
        int TeamAGoals = match.getAScore();

        if(TeamHGoals==TeamAGoals){
            teamH.setPoints(teamH.getPoints()+1);
            teamA.setPoints(teamA.getPoints()+1);
            teamH.setMatchesDrawn(teamH.getMatchesDrawn()+1);
            teamA.setMatchesDrawn(teamA.getMatchesDrawn()+1);
        }
        else if(TeamHGoals>TeamAGoals)
        {
            teamH.setPoints(teamH.getPoints()+3);
            teamH.setMatchesWon(teamH.getMatchesWon()+1);
            teamA.setMatchesLost(teamA.getMatchesLost()+1);
        }
        else if(TeamHGoals<TeamAGoals)
        {
            teamA.setPoints(teamA.getPoints()+3);
            teamA.setMatchesWon(teamA.getMatchesWon()+1);
            teamH.setMatchesLost(teamH.getMatchesLost()+1);
        }       
        teamH.setGoalsScored(teamH.getGoalsScored()+TeamHGoals);
        teamA.setGoalsScored(teamA.getGoalsScored()+TeamAGoals);
        teamH.setGoalsLost(teamH.getGoalsLost()+TeamAGoals);
        teamA.setGoalsLost(teamA.getGoalsLost()+TeamHGoals);
    }
    
    public void resetMatch(Match match)
    {
        Team teamH = match.getHTeam();
        Team teamA = match.getATeam();
        int TeamHGoals = match.getHScore();
        int TeamAGoals = match.getAScore();

        if(TeamHGoals==TeamAGoals){
            teamH.setPoints(teamH.getPoints()-1);
            teamA.setPoints(teamA.getPoints()-1);
            teamH.setMatchesDrawn(teamH.getMatchesDrawn()-1);
            teamA.setMatchesDrawn(teamA.getMatchesDrawn()-1);
        }
        else if(TeamHGoals>TeamAGoals)
        {
            teamH.setPoints(teamH.getPoints()-3);
            teamH.setMatchesWon(teamH.getMatchesWon()-1);
            teamA.setMatchesLost(teamA.getMatchesLost()-1);
        }
        else if(TeamHGoals<TeamAGoals)
        {
            teamA.setPoints(teamA.getPoints()-3);
            teamA.setMatchesWon(teamA.getMatchesWon()-1);
            teamH.setMatchesLost(teamH.getMatchesLost()-1);
        }       
        teamH.setGoalsScored(teamH.getGoalsScored()-TeamHGoals);
        teamA.setGoalsScored(teamA.getGoalsScored()-TeamAGoals);
        teamH.setGoalsLost(teamH.getGoalsLost()-TeamAGoals);
        teamA.setGoalsLost(teamA.getGoalsLost()-TeamHGoals);
    }
    
    public void chooseFinalists()
    {
       ObservableList<Team> teamsInGroupList = FXCollections.observableArrayList();
       
        for (int groupNumber = 0; groupNumber < 4; groupNumber++) {
        switch (groupNumber)
        {
            case 0: teamsInGroupList=GroupA.getAllTeamsInGroup();
                     break;
            case 1: teamsInGroupList=GroupB.getAllTeamsInGroup();
                     break;
            case 2: teamsInGroupList=GroupC.getAllTeamsInGroup();
                     break;
            case 3: teamsInGroupList=GroupD.getAllTeamsInGroup();
                     break;
            default: System.out.println("Something went wrong while getting finalists");;
                     break;
        }
        ObservableList<Team> tempList = FXCollections.observableArrayList(teamsInGroupList); 
        

     
     //now tempList is sorted by scores, lets see if there is one maximum value or more
     int numberOfTeamsWithHighestScore=0;
     int highestScore;
      boolean flag = true;  
    Team tempTeam=null;  
     while ( flag )
     {
            flag= false;    //set flag to false awaiting a possible swap
            for(int j=0;  j < tempList.size() -1;  j++ )
            {
                   if ( tempList.get(j).getPoints() < tempList.get(j+1).getPoints() )   // change to > for ascending sort
                   {
                           tempTeam = tempList.get(j);          //swap elements
                           tempList.set(j, tempList.get(j+1));
                           tempList.set(j+1, tempTeam);
                           flag = true;              //shows a swap occurred 
                  }
            }
      }     
     
     highestScore = tempList.get(0).getPoints();
            for (Team team : tempList) {
                if(team.getPoints()==highestScore)numberOfTeamsWithHighestScore++;
            }
    if(numberOfTeamsWithHighestScore==1)
    {
        numberOfTeamsWithHighestScore=0;
        AllFinalists.add(tempList.get(0));
        highestScore=tempList.get(1).getPoints();
         for (Team team : tempList) {
                if(team.getPoints()==highestScore)numberOfTeamsWithHighestScore++;
            }
        if(numberOfTeamsWithHighestScore==1)
        {
        AllFinalists.add(tempList.get(1));    
        continue;
        }
        else
        {
            tempList.clear();
            for (Team team : teamsInGroupList) {
                if(team.getPoints()==highestScore)
                    tempList.add(team);
            }
            //now check second rule
    boolean flag1 = true;  
    Team tempTeam1=null;  
     while ( flag1 )
     {
            flag1= false;    //set flag to false awaiting a possible swap
            for(int j=0;  j < tempList.size() -1;  j++ )
            {
                   if ((tempList.get(j).getGoalsScored() - tempList.get(j).getGoalsLost()) <( tempList.get(j+1).getGoalsScored() - tempList.get(j+1).getGoalsLost()) )   // change to > for ascending sort
                   {
                           tempTeam1 = tempList.get(j);          //swap elements
                           tempList.set(j, tempList.get(j+1));
                           tempList.set(j+1, tempTeam1);
                           flag1 = true;              //shows a swap occurred 
                  }
            }
      }    
            numberOfTeamsWithHighestScore=0;
            highestScore=(tempList.get(0).getGoalsScored() - tempList.get(0).getGoalsLost());
            for (Team team : tempList) {
                if((team.getGoalsScored()-team.getGoalsLost())==highestScore)numberOfTeamsWithHighestScore++;
            }
            if(numberOfTeamsWithHighestScore==1)
            {
                AllFinalists.add(tempList.get(0));
                continue;
            }
            else // check 3rd rule
            {
                tempList.clear();
                for (Team team : teamsInGroupList) {
                    if((team.getGoalsScored()-team.getGoalsLost())==highestScore)
                        tempList.add(team);
                }
                highestScore=0;
                numberOfTeamsWithHighestScore=0;
     boolean flag2 = true;  
    Team tempTeam2=null;  
     while ( flag2 )
     {
            flag2= false;    //set flag to false awaiting a possible swap
            for(int j=0;  j < tempList.size() -1;  j++ )
            {
                   if ( tempList.get(j).getGoalsScored() < tempList.get(j+1).getGoalsScored() )   // change to > for ascending sort
                   {
                           tempTeam2 = tempList.get(j);          //swap elements
                           tempList.set(j, tempList.get(j+1));
                           tempList.set(j+1, tempTeam2);
                           flag2 = true;              //shows a swap occurred 
                  }
            }
      }     
     highestScore=tempList.get(0).getGoalsScored();
                for (Team team : tempList) {
                    if(team.getGoalsScored()==highestScore)numberOfTeamsWithHighestScore++;
                }
                if(numberOfTeamsWithHighestScore==1)
                {
                    AllFinalists.add(tempList.get(0));
                    continue;
                }
                else //get randomly
                {
                    tempList.clear();
                    for (Team team : teamsInGroupList) {
                        if(team.getGoalsScored()==highestScore)
                            tempList.add(team);
                    }
                    long seed = System.nanoTime();
                    Collections.shuffle(tempList, new Random(seed));
                    AllFinalists.add(tempList.get(0));
                }
            }
        }
            
           
      
        }
    else //execute if there is more than 1 team with max score
    {
        tempList.clear();
        tempList=FXCollections.observableArrayList(teamsInGroupList); 
        
            for (Team team : teamsInGroupList) {
                if(team.getPoints()==highestScore)
                    tempList.add(team);
            }
        boolean flag1 = true;  
        Team tempTeam1=null;  

     while ( flag1 )
     {
            flag1= false;    //set flag to false awaiting a possible swap
            for(int j=0;  j < tempList.size() -1;  j++ )
            {
                   if (( tempList.get(j).getGoalsScored() - tempList.get(j).getGoalsLost()) <( tempList.get(j+1).getGoalsScored() - tempList.get(j+1).getGoalsLost()) )   // change to > for ascending sort
                   {
                           tempTeam1 = tempList.get(j);          //swap elements
                           tempList.set(j, tempList.get(j+1));
                           tempList.set(j+1, tempTeam1);
                           flag1 = true;              //shows a swap occurred 
                  }
            }
      } 
     numberOfTeamsWithHighestScore=0;   
     highestScore=(tempList.get(0).getGoalsScored() - tempList.get(0).getGoalsLost());
        for (Team team : tempList) {
            
        }
    }
    }
         for (Team team : AllFinalists) {
                System.out.println(team.getName()+" "+team.getPoints());
            }
}
// merging sht
    public ObservableList<Match> matchesInQuarterFinals = FXCollections.observableArrayList();

   public void addQuarterFinalsMatches()
    {
      matchesInQuarterFinals.add(new Match(AllMatches.size(), AllFinalists.get(0), AllFinalists.get(3))); //Team 1 vs Team 4
      matchesInQuarterFinals.add(new Match(AllMatches.size(), AllFinalists.get(1), AllFinalists.get(2))); //Team 2 vs Team 3
      matchesInQuarterFinals.add(new Match(AllMatches.size(), AllFinalists.get(5), AllFinalists.get(7))); //Team 5 vs Team 8
      matchesInQuarterFinals.add(new Match(AllMatches.size(), AllFinalists.get(4), AllFinalists.get(6))); //Team 6 vs Team 7
    }
   public ObservableList<Match> matchesInSemiFinals = FXCollections.observableArrayList();
public ObservableList<Match> semiFinalMatches(ObservableList<Match> list)
    {

      ObservableList<Team> winnersList = FXCollections.observableArrayList();

      for (Match match : list)
      {

         if (match.getHScore() > match.getAScore())
         {
            winnersList.add(match.getHTeam());
         }
         else
         {
            winnersList.add(match.getATeam());
         }
      }
      
      matchesInSemiFinals.add(new Match(AllMatches.size(), winnersList.get(0), winnersList.get(3))); //Team 1 vs Team 4
      matchesInSemiFinals.add(new Match(AllMatches.size(), winnersList.get(1), winnersList.get(2))); //Team 2 vs Team 3
      return matchesInSemiFinals;
    }
     ObservableList<Match> finalMatch = FXCollections.observableArrayList();
public ObservableList<Match> FinalMatch(ObservableList<Match> list)
    {

      ObservableList<Team> winnersList = FXCollections.observableArrayList();
      
      for (Match match : list)
      {
         if (match.getHScore() > match.getAScore())
         {
            winnersList.add(match.getHTeam());
         }
         else
         {
            winnersList.add(match.getATeam());
         }
      }
      finalMatch.add(new Match(AllMatches.size(), winnersList.get(0), winnersList.get(1))); //Team 1 vs Team 4

      return finalMatch;
    }
    public Team GetWinnerOfTournament(ObservableList<Match> list)
    {

      Match match = list.get(0);
      
         if (match.getHScore() > match.getAScore())
         {
           return match.getHTeam();
         }
         else
         {
            return match.getATeam();
         }

    }
}

                     
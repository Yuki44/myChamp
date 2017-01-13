/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BE.Group;
import BE.Match;
import BE.Team;
import java.util.Collections;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MSI GS40 6QE
 */
public class Model
 {

   private static Model instance;

   public static Model getInstance()
    {
      if (instance == null)
      {
         instance = new Model();
      }
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

   private ObservableList<Team> AllTeams = FXCollections.observableArrayList();

   public Model()
    {
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
      for (Team team : AllTeams)
      {
         team.setId(x);
         x++;
      }
    }

   public void addTeamToGroup(int operator, Team team)
    {
      switch (operator)
      {
         case 0:
            GroupA.addToTeamsList(team);
            break;
         case 1:
            GroupB.addToTeamsList(team);
            break;
         case 2:
            GroupC.addToTeamsList(team);
            break;
         case 3:
            GroupD.addToTeamsList(team);
            break;
         default:
            System.out.println("Invalid team name, choose from A,B,C,D");
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
      int operator = 0;
      for (Team team : tempList)
      {
         addTeamToGroup(operator, team);
         if (operator < 3)
         {
            operator++;
         }
         else
         {
            operator = 0;
         }
      }
    }

   public void Sizes()
    {
      System.out.println(GroupA.getNumberOfTeamsInGroup() + " " + GroupB.getNumberOfTeamsInGroup() + " "
              + GroupC.getNumberOfTeamsInGroup() + " " + GroupD.getNumberOfTeamsInGroup());
    }

   public void createScheduleForGroup()
    {
      int x;
      Group group = null;
      ObservableList<Match> matchesInGroup = FXCollections.observableArrayList();

      for (x = 0; x < 4; x++)
      {
         switch (x)
         {
            case 0:
               group = GroupA;
               matchesInGroup = AllMatchesInGroupA;
               break;
            case 1:
               group = GroupB;
               matchesInGroup = AllMatchesInGroupB;
               break;
            case 2:
               group = GroupC;
               matchesInGroup = AllMatchesInGroupC;
               break;
            case 3:
               group = GroupD;
               matchesInGroup = AllMatchesInGroupD;
               break;
            default:
               System.out.println("Something went wrong while scheduling");
               ;
               break;
         }
         Match match = null;
         if (group.getNumberOfTeamsInGroup() == 3)
         {
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(2), group.getTeam(1), 1));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(1), group.getTeam(0), 2));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(2), group.getTeam(0), 3));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(0), group.getTeam(1), 4));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(0), group.getTeam(2), 5));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(1), group.getTeam(2), 6));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));

         }
         else if (group.getNumberOfTeamsInGroup() == 4)
         {

            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(0), group.getTeam(2), 1));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(1), group.getTeam(3), 1));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(0), group.getTeam(3), 2));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(2), group.getTeam(1), 2));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(0), group.getTeam(1), 3));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(3), group.getTeam(2), 3));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(3), group.getTeam(0), 4));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(1), group.getTeam(2), 4));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(1), group.getTeam(0), 5));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(2), group.getTeam(3), 5));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(2), group.getTeam(0), 6));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
            matchesInGroup.add(new Match(AllMatches.size(), group.getTeam(3), group.getTeam(1), 6));
            AllMatches.add(matchesInGroup.get((matchesInGroup.size() - 1)));
         }
      }
    }

   public void setMatch(Match match)
    {
      Team teamH = match.getHTeam();
      Team teamA = match.getATeam();
      int TeamHGoals = match.getHScore();
      int TeamAGoals = match.getAScore();

      if (TeamHGoals == TeamAGoals)
      {
         teamH.setPoints(teamH.getPoints() + 1);
         teamA.setPoints(teamA.getPoints() + 1);
         teamH.setMatchesDrawn(teamH.getMatchesDrawn() + 1);
         teamA.setMatchesDrawn(teamA.getMatchesDrawn() + 1);
      }
      else if (TeamHGoals > TeamAGoals)
      {
         teamH.setPoints(teamH.getPoints() + 3);
         teamH.setMatchesWon(teamH.getMatchesWon() + 1);
         teamA.setMatchesLost(teamA.getMatchesLost() + 1);
      }
      else if (TeamHGoals < TeamAGoals)
      {
         teamA.setPoints(teamA.getPoints() + 3);
         teamA.setMatchesWon(teamA.getMatchesWon() + 1);
         teamH.setMatchesLost(teamH.getMatchesLost() + 1);
      }
      teamH.setGoalsScored(teamH.getGoalsScored() + TeamHGoals);
      teamA.setGoalsScored(teamA.getGoalsScored() + TeamAGoals);
      teamH.setGoalsLost(teamH.getGoalsLost() + TeamAGoals);
      teamA.setGoalsLost(teamA.getGoalsLost() + TeamHGoals);
    }

   public void resetMatch(Match match)
    {
      Team teamH = match.getHTeam();
      Team teamA = match.getATeam();
      int TeamHGoals = match.getHScore();
      int TeamAGoals = match.getAScore();

      if (TeamHGoals == TeamAGoals)
      {
         teamH.setPoints(teamH.getPoints() - 1);
         teamA.setPoints(teamA.getPoints() - 1);
         teamH.setMatchesDrawn(teamH.getMatchesDrawn() - 1);
         teamA.setMatchesDrawn(teamA.getMatchesDrawn() - 1);
      }
      else if (TeamHGoals > TeamAGoals)
      {
         teamH.setPoints(teamH.getPoints() - 3);
         teamH.setMatchesWon(teamH.getMatchesWon() - 1);
         teamA.setMatchesLost(teamA.getMatchesLost() - 1);
      }
      else if (TeamHGoals < TeamAGoals)
      {
         teamA.setPoints(teamA.getPoints() - 3);
         teamA.setMatchesWon(teamA.getMatchesWon() - 1);
         teamH.setMatchesLost(teamH.getMatchesLost() - 1);
      }
      teamH.setGoalsScored(TeamHGoals - TeamHGoals);
      teamA.setGoalsScored(TeamAGoals - TeamHGoals);
      teamH.setGoalsLost(TeamHGoals - TeamAGoals);
      teamA.setGoalsLost(TeamAGoals - TeamHGoals);
    }

   public ObservableList<Team> quarterFinalTeamList = FXCollections.observableArrayList();

   public void quarterFinalistTeamList()
    {
      quarterFinalTeamList.add(new Team(0, "Team 1"));
      quarterFinalTeamList.add(new Team(1, "Team 2"));
      quarterFinalTeamList.add(new Team(2, "Team 3"));
      quarterFinalTeamList.add(new Team(3, "Team 4"));
      quarterFinalTeamList.add(new Team(4, "Team 5"));
      quarterFinalTeamList.add(new Team(5, "Team 6"));
      quarterFinalTeamList.add(new Team(6, "Team 7"));
      quarterFinalTeamList.add(new Team(7, "Team 8"));
    }
   public ObservableList<Match> matchesInQuarterFinals = FXCollections.observableArrayList();

   public void addQuarterFinalsMatches()
    {
      matchesInQuarterFinals.add(new Match(AllMatches.size(), quarterFinalTeamList.get(0), quarterFinalTeamList.get(3))); //Team 1 vs Team 4
      matchesInQuarterFinals.add(new Match(AllMatches.size(), quarterFinalTeamList.get(1), quarterFinalTeamList.get(2))); //Team 2 vs Team 3
      matchesInQuarterFinals.add(new Match(AllMatches.size(), quarterFinalTeamList.get(5), quarterFinalTeamList.get(7))); //Team 5 vs Team 8
      matchesInQuarterFinals.add(new Match(AllMatches.size(), quarterFinalTeamList.get(4), quarterFinalTeamList.get(6))); //Team 6 vs Team 7
    }

   public ObservableList<Team> semiFinalTeamList = FXCollections.observableArrayList();

   public void semiFinalistTeamList()
    {
      semiFinalTeamList.add(new Team(0, "Team 1"));
      semiFinalTeamList.add(new Team(1, "Team 2"));
      semiFinalTeamList.add(new Team(2, "Team 3"));
      semiFinalTeamList.add(new Team(3, "Team 4"));

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

   public ObservableList<Match> FinalMatch(ObservableList<Match> list)
    {

      ObservableList<Team> winnersList = null;

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

   public ObservableList<Team> finalTeamList = FXCollections.observableArrayList();

   public void finalistTeamList()
    {
      finalTeamList.add(new Team(0, "Team 1"));
      finalTeamList.add(new Team(1, "Team 2"));

    }
   public ObservableList<Match> finalMatch = FXCollections.observableArrayList();
 }

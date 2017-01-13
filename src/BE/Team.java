/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author MSI GS40 6QE
 */
public class Team
 {

   private int id;
   String name;
   int goalsScored;
   int goalsLost;
   int matchesWon;
   int matchesLost;
   int matchesDrawn;
   int points;

   public Team(int id, String name)
    {
      this.id = id;
      this.name = name;
      this.goalsScored = 0;
      this.goalsLost = 0;
      this.matchesWon = 0;
      this.matchesLost = 0;
      this.matchesDrawn = 0;
      this.points = 0;
    }

   public void setMatchesWon(int matchesWon)
    {
      this.matchesWon = matchesWon;
    }

   public void setMatchesLost(int matchesLost)
    {
      this.matchesLost = matchesLost;
    }

   public void setMatchesDrawn(int matchesDrawn)
    {
      this.matchesDrawn = matchesDrawn;
    }

   public void setPoints(int points)
    {
      this.points = points;
    }

   public void setGoalsScored(int goalsScored)
    {
      this.goalsScored = goalsScored;
    }

   public void setGoalsLost(int goalsLost)
    {
      this.goalsLost = goalsLost;
    }

   public int getPoints()
    {
      return points;
    }

   public int getGoalsScored()
    {
      return goalsScored;
    }

   public int getGoalsLost()
    {
      return goalsLost;
    }

   public int getMatchesWon()
    {
      return matchesWon;
    }

   public int getMatchesLost()
    {
      return matchesLost;
    }

   public int getMatchesDrawn()
    {
      return matchesDrawn;
    }

   public String getName()
    {
      return name;
    }

   public int getId()
    {
      return id;
    }

   public void setId(int id)
    {
      this.id = id;
    }

 }

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
public class Match {
    private int MatchId;
    private Team HTeam;
    private Team ATeam;
    private int HScore;
    private int AScore;
    private int round;
    boolean hadPlace;

    public Match(int MatchId, Team HTeam, Team ATeam) {
        this.MatchId = MatchId;
        this.HTeam = HTeam;
        this.ATeam = ATeam;
        this.HScore = 0;
        this.AScore = 0;
        this.hadPlace=false;
    }
    
    public Match(int MatchId, Team HTeam, Team ATeam, int round) {
        this.MatchId = MatchId;
        this.HTeam = HTeam;
        this.ATeam = ATeam;
        this.HScore = 0;
        this.AScore = 0;
        this.round = round;
        this.hadPlace=false;
    }

    public void setHadPlace(boolean hadPlace) {
        this.hadPlace = hadPlace;
    }

    public String getHadPlace() {
        if(hadPlace==true)
        return "  Yes";
        else
        return  "  No";
    }
    
    public boolean isHadPlace() {
        return hadPlace;
    }

    
    public String getATeamName() {
     return this.ATeam.getName();
    }
    public String getColumnContent()
    {
        
        return "Round "+this.round+".       "+this.HTeam.getName()+"      "+this.HScore+" : "+this.AScore+"      "+this.ATeam.getName();
        

    }
    public void setHTeam(Team HTeam) {
        this.HTeam = HTeam;
    }
    
    public void setRound(int round) {
        this.round = round;
    }

    public void setATeam(Team ATeam) {
        this.ATeam = ATeam;
    }

    public void setHScore(int HScore) {
        this.HScore = HScore;
    }

    public void setAScore(int AScore) {
        this.AScore = AScore;
    }

    public int getMatchId() {
        return MatchId;
    }

    public Team getHTeam() {
        return HTeam;
    }

    public Team getATeam() {
        return ATeam;
    }

    public int getHScore() {
        return HScore;
    }

    public int getAScore() {
        return AScore;
    }
    public int getRound() {
        return round;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MSI GS40 6QE
 */
public class Group {
    public final int id;
    private ObservableList<Team> allTeamsInGroup; 
    
    public Group(int id) {
        this.id = id;
        this.allTeamsInGroup = FXCollections.observableArrayList();
    }

    public void addToTeamsList(Team team)
    {
        allTeamsInGroup.add(team);
    }
    public int getNumberOfTeamsInGroup()
    {
        return allTeamsInGroup.size();
    }
    public Team getTeam(int index)
    {
        return allTeamsInGroup.get(index);
    }

    public ObservableList<Team> getAllTeamsInGroup() {
        return allTeamsInGroup;
    }
    
}

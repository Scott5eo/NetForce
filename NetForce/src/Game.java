/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dongjin Seo
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Game {
    /*Statistics
    Opponent: name
    Game: date, team score, opponent score, ????, players
    */
    private String opponentName;
    private Date now;
    private int teamScore;
    private int opponentScore;
    private List<String> roster; //contains names of players that played in this game
    
    //constructor
    Game(String n){
        this.opponentName = n;
        this.now = new Date();
        this.teamScore = 0;
        this.opponentScore = 0;
        this.roster = new ArrayList<>();
    }
    
    
    //accessors
    public String getOpponentName(){
        return opponentName;
    }
    public Date getDate(){
        return now;
    }
    public int getTeamScore(){
        return teamScore;
    }
    public int getOpponentScore(){
        return opponentScore;
    }
    public List<String> getRoster(){
        return roster;
    }
    
    //mutators
    public void setOpponentName(String name){
        this.opponentName = name;
    }
    public void setTeamScore(int n){
        this.teamScore = n;
    }
    public void setOpponentScore(int n){
        this.opponentScore = n;
    }
    public void addToRoster(Player p){
        roster.add(p.getName());
    }
    public void removeFromRoster(Player p){
        roster.remove(p.getName());
    }
}

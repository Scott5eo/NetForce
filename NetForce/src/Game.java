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
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {
    /*Statistics
    Opponent: name
    Game: date, team score, opponent score, ????, players
    */
    private String opponentName;
    private String date;
    private int teamScore;
    private int opponentScore;
    private List<String> roster; //contains names of players that played in this game
    private Deque<Command> history; //contains history of executed commands for undo function.
    
    //constructor for new game
    Game(String n){
        this.opponentName = n;
        this.date = new Date().toString();
        this.teamScore = 0;
        this.opponentScore = 0;
        this.roster = new ArrayList<>();
        this.history = new LinkedList<>();
    }
    
    //constructor for loaded game
    Game(String on, String d, int ts, int os, List<String> r){
        this.opponentName = on;
        this.date = d;
        this.teamScore = ts;
        this.opponentScore = os;
        this.roster = r;
    }
    
    //accessors
    public String getOpponentName(){
        return opponentName;
    }
    public String getDate(){
        return date;
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
    public Deque<Command> getHistory(){
        return history;
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
    public void setDate(String s){
        this.date = s;
    }
    public void addToRoster(Player p){
        roster.add(p.getName());
    }
    public void removeFromRoster(Player p){
        roster.remove(p.getName());
    }
    
    //push and execute command
    public void executeCommand(Command cmd){
        history.push(cmd);
        cmd.execute();
    }
    //pop and undo command
    public void undoCommand(){
        history.pop().undo();
    }
}

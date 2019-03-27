/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dongjin Seo
 */
public class Momento {
    private Player previousPlayerState;
    private Game previousGameState;
    
    Momento(Player p, Game g){
        this.previousPlayerState = new Player(p);
        this.previousGameState = new Game(g);
    }
    
    public Player getPlayerState(){
        return previousPlayerState;
    }
    
    public Game getGameState(){
        return previousGameState;
    }
    
    public void setPlayerState(Player p){
        this.previousPlayerState =p;
    }
    
    public void setGameState(Game g){
        this.previousGameState = g;
    }
}

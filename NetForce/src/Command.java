/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dongjin Seo
 */
public  class Command {
    private final Momento momento;
    private final String type;
    private Player invoker;
    private Game reciever;
    
    Command(Player p, Game g, String t){
        this.momento = new Momento(p,g);
        this.type = t;
        this.invoker = p;
        this.reciever = g;
    }
    
    public void execute(){
        switch (type) {
            case "kill":
                invoker.setKill(invoker.getKill()+1);
                reciever.setTeamScore(reciever.getTeamScore()+1);
                break;
            case "attack error":
                invoker.setAttackError(invoker.getAttackError()+1);
                reciever.setOpponentScore(reciever.getOpponentScore()+1);
                break;
            case "zero attack":
                invoker.setZeroAttack(invoker.getZeroAttack()+1);
                break;
            case "assist":
                invoker.setAssist(invoker.getAssist()+1);
                break;
            case "assist error":
                invoker.setAssistError(invoker.getAssistError()+1);
                reciever.setOpponentScore(reciever.getOpponentScore()+1);
                break;
            case "zero assist":
                invoker.setZeroAssist(invoker.getZeroAssist()+1);
                break;
            case "ace":
                invoker.setAce(invoker.getAce()+1);
                break;
            case "service error":
                invoker.setServiceError(invoker.getServiceError()+1);
                reciever.setOpponentScore(reciever.getOpponentScore()+1);
                break;
            case "zero serve":
                invoker.setZeroServe(invoker.getZeroServe()+1);
                break;
            case "successful dig":
                invoker.setSuccessfulDig(invoker.getSuccessfulDig()+1);
                break;
            case "defense error":
                invoker.setDefenseError(invoker.getDefenseError()+1);
                reciever.setOpponentScore(reciever.getOpponentScore()+1);
                break;
            case "block":
                invoker.setBlock(invoker.getBlock()+1);
                reciever.setTeamScore(reciever.getTeamScore()+1);
                break;
            case "block error":
                invoker.setBlockError(invoker.getBlockError()+1);
                reciever.setOpponentScore(reciever.getOpponentScore()+1);
                break;
            case "zero block":
                invoker.setZeroBlock(invoker.getZeroBlock()+1);
                break;
            default:
                break;
        }
    }
    
    public void undo(){
        invoker = momento.getPlayerState();
        reciever = momento.getGameState();
    }
    
    public String actionToString(){
        return(invoker.getName() + " " + type +".");
    }
    
    public Player getInvoker(){
        return invoker;
    }
    
    public Game getReciever(){
        return reciever;
    }
}

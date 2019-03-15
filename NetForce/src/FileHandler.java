

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dongjin Seo
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

   
public class FileHandler {
    //json file addresses
    private final String playersFileAddress = "players.json";
    private final String gamesFileAddress = "games.json";
    
    //write Player into json object
    //String name, int number, int grade, String email, int kill, int attackE, int zeroAttack, int assist, int assistE, int zeroAssist, int ace, int serviceE, int zeroS, int successfulDig, int defenseE, int block, int blockE, int zeroB
    public JSONObject playerToJSON(Player p){
        JSONObject jsonPlayer = new JSONObject();
        jsonPlayer.put("name",p.getName());
        jsonPlayer.put("number",p.getNumber());
        jsonPlayer.put("grade",p.getGrade());
        jsonPlayer.put("email",p.getEmail());
        jsonPlayer.put("kill",p.getKill());
        jsonPlayer.put("attack error",p.getAttackError());
        jsonPlayer.put("zero attack",p.getZeroAttack());
        jsonPlayer.put("assist",p.getAssist());
        jsonPlayer.put("assist error",p.getAssistError());
        jsonPlayer.put("zero assist",p.getZeroAssist());
        jsonPlayer.put("ace",p.getAce());
        jsonPlayer.put("service error",p.getServiceError());
        jsonPlayer.put("zero serve",p.getZeroServe());
        jsonPlayer.put("successful dig",p.getSuccessfulDig());
        jsonPlayer.put("defense error",p.getDefenseError());
        jsonPlayer.put("block",p.getBlock());
        jsonPlayer.put("block error",p.getBlockError());
        jsonPlayer.put("zero block", p.getZeroBlock());
        return jsonPlayer;
    }
    
    //saves JSON array of players to a file named players.json
    public void savePlayers(List<Player>ps){
        JSONArray jsonPlayers = new JSONArray();
        ps.forEach((p) -> {
            jsonPlayers.add(playerToJSON(p));
        });
        try (FileWriter file = new FileWriter(playersFileAddress,false)) {

            file.write(jsonPlayers.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Player JSONToPlayer(JSONObject j){
        String name = j.get("name").toString();
        int number = Integer.parseInt(j.get("number").toString());
        int grade = Integer.parseInt(j.get("grade").toString());
        String email = j.get("email").toString();
        int kill = Integer.parseInt(j.get("kill").toString());
        int attackE = Integer.parseInt(j.get("attack error").toString());
        int zeroAttack = Integer.parseInt(j.get("zero attack").toString());
        int assist = Integer.parseInt(j.get("assist").toString());
        int assistE = Integer.parseInt(j.get("assist error").toString());
        int zeroAssist = Integer.parseInt(j.get("zero assist").toString());
        int ace = Integer.parseInt(j.get("ace").toString()); 
        int serviceE = Integer.parseInt(j.get("service error").toString());
        int zeroS = Integer.parseInt(j.get("zero serve").toString());
        int successfulDig = Integer.parseInt(j.get("successful dig").toString());
        int defenseE = Integer.parseInt(j.get("defense error").toString());
        int block = Integer.parseInt(j.get("block").toString());
        int blockE = Integer.parseInt(j.get("block error").toString());
        int zeroB = Integer.parseInt(j.get("zero block").toString());
        Player p = new Player(name, number, grade, email, kill, attackE, zeroAttack, assist, assistE, zeroAssist, ace, serviceE, zeroS, successfulDig, defenseE, block, blockE, zeroB);
        return p;
    }
    
    public List<Player> loadPlayers(){
        List<Player> ps = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader(playersFileAddress));

            JSONArray JSONPlayers = (JSONArray) obj;
            Iterator<JSONObject> iterator = JSONPlayers.iterator();
            while (iterator.hasNext()) {
                ps.add(JSONToPlayer(iterator.next()));
            }
        } catch (FileNotFoundException e) {
            try (FileWriter file = new FileWriter(playersFileAddress,false)) {

            file.write("");
            file.flush();
            return loadPlayers();

            } catch (IOException xD) {
            xD.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } 
        
        return ps;
    }
    
    //game to jsonGame 
    public JSONObject gameToJSON(Game g){
        JSONObject jsonGame = new JSONObject();
        jsonGame.put("opponent name",g.getOpponentName());
        jsonGame.put("date",g.getDate());
        jsonGame.put("team score",g.getTeamScore());
        jsonGame.put("opponent score", g.getOpponentScore());
        JSONArray roster = new JSONArray();
        g.getRoster().forEach((name) -> {
            roster.add(name);
        });
        jsonGame.put("roster", roster);
        return jsonGame;
    }
    
    //jsonGame to game
    public Game JSONToGame(JSONObject j){
        String opponentName = (String) j.get("opponent name");
        String date =(String)  j.get("date");
        int teamScore = (int) j.get("team score");
        int opponentScore = (int) j.get("opponent score");
        List<String> roster = new ArrayList<>();
        JSONArray JSONroster = (JSONArray) j.get("roster");
        Iterator<String> iterator = JSONroster.iterator();
        while (iterator.hasNext()) {
            roster.add(iterator.next());
         }
        Game game = new Game(opponentName, date, teamScore, opponentScore, roster);
        return game;
    }
    
    //todo: save games
    public void saveGames(List<Game> gs){
        JSONArray jsonGames = new JSONArray();
        gs.forEach((g) -> {
            jsonGames.add(gameToJSON(g));
        });
        try (FileWriter file = new FileWriter(gamesFileAddress,false)) {

            file.write(jsonGames.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //todo: load games
    public List<Game> loadGames(){
        List<Game> gs = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader(gamesFileAddress));

            JSONArray JSONGames = (JSONArray) obj;
            Iterator<JSONObject> iterator = JSONGames.iterator();
            while (iterator.hasNext()) {
                gs.add(JSONToGame(iterator.next()));
            }
        } catch (FileNotFoundException e) {
            try (FileWriter file = new FileWriter(gamesFileAddress,false)){
            file.write("");
            file.flush();
            }
            catch(IOException xD){
                xD.printStackTrace();
            }
            return loadGames();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("oops");
        }
        return gs;
    }
}

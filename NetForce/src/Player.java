/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dongjin Seo
 */
public class Player {
    /* Player's statistics:
    Identification: Name, Back number, Grade level, Email address
    Attack: Kill, Attack error, Zero attack
    Setting: Assist, Assist error, Zero assist
    Serving: Ace, Service error, Zero serve 
    Defense: Successful dig, Defense error, Block, Block error, zero Block
    */
  private int kill;
  private int attackError;
  private int zeroAttack;
  private int assist;
  private int assistError;
  private int zeroAssist;
  private int ace;
  private int serviceError;
  private int zeroServe;
  private int successfulDig;
  private int defenseError;
  private int block;
  private int blockError;
  private int zeroBlock;
  private String name;
  private int number;
  private int grade;
  private String email;
  
  Player(String n, int b, int g, String e){
      this.name = n;
      this.number = b;
      this.grade = g;
      this.email = e;
      //set every stat zero for start
      this.kill = 0;
      this.attackError = 0;
      this.zeroAttack = 0;
      this.assist = 0;
      this.assistError = 0;
      this.zeroAssist = 0;
      this.ace = 0;
      this.serviceError = 0;
      this.zeroServe = 0;
      this.successfulDig = 0;
      this.defenseError = 0;
      this.block = 0;
      this.blockError = 0;
      this.zeroBlock =0;
  }
  
  Player(String name, int number, int grade, String email, int kill, int attackE, int zeroAttack, int assist, int assistE, int zeroAssist, int ace, int serviceE, int zeroS, int successfulDig, int defenseE, int block, int blockE, int zeroB){
      //used when loading player from saved file
      this.name = name;
      this.number = number;
      this.grade = grade;
      this.email = email;
      this.kill = kill;
      this.attackError = attackE;
      this.zeroAttack = zeroAttack;
      this.assist = assist;
      this.assistError = assistE;
      this.zeroAssist = zeroAssist;
      this.ace = ace;
      this.serviceError = serviceE;
      this.zeroServe = zeroS;
      this.successfulDig = successfulDig;
      this.defenseError = defenseE;
      this.block = block;
      this.blockError = blockE;
      this.zeroBlock = zeroB;
  }
  
  Player(Player p){
      //used when cloning to support undo function
      this.name = p.getName();
      this.number = p.getNumber();
      this.grade = p.getGrade();
      this.email = p.getEmail();
      this.kill = p.getKill();
      this.attackError = p.getAttackError();
      this.zeroAttack = p.zeroAttack;
      this.assist = p.getAssist();
      this.assistError = p.getAssistError();
      this.zeroAssist = p.getZeroAssist();
      this.ace = p.getAce();
      this.serviceError = p.getServiceError();
      this.zeroServe = p.getZeroServe();
      this.successfulDig = p.getSuccessfulDig();
      this.defenseError = p.getDefenseError();
      this.block = p.getBlock();
      this.blockError = p.getBlockError();
      this.zeroBlock = p.getZeroBlock();
  }
  
  //accessors
  public String getName(){
      return this.name;
  }
  public int getNumber(){
      return this.number;
  }
  public int getGrade(){
      return this.grade;
  }
  public String getEmail(){
      return this.email;
  }
  public int getKill(){
      return this.kill;
  }
  public int getAttackError(){
      return this.attackError;
  }
  public int getZeroAttack(){
      return this.zeroAttack;
  }
  public int getAssist(){
      return this.assist;
  }
  public int getAssistError(){
      return this.assistError;
  }
  public int getZeroAssist(){
      return this.zeroAssist;
  }
  public int getAce(){
      return this.ace;
  }
  public int getServiceError(){
      return this.serviceError;
  }
  public int getZeroServe(){
      return this.zeroServe;
  }
  public int getSuccessfulDig(){
      return this.successfulDig;
  }
  public int getDefenseError(){
      return this.defenseError;
  }
  public int getBlock(){
      return this.block;
  }
  public int getBlockError(){
      return this.blockError;
  }
  public int getZeroBlock(){
      return this.zeroBlock;
  }
  
  //mutators
  public void setName(String n){
      this.name = n;
  }
  public void setNumber(int n){
      this.number = n;
  }
  public void setGrade(int n){
      this.grade = n;
  }
  public void setEmail(String e){
      this.email = e;
  }
  public void setKill(int k){
      this.kill = k;
  }
  public void setAttackError(int e){
      this.attackError = e;
  }
  public void setZeroAttack(int z){
      this.zeroAttack = z;
  }
  public void setAssist(int a){
      this.assist = a;
  }
  public void setAssistError(int e){
      this.assistError = e;
  }
  public void setZeroAssist(int z){
      this.zeroAssist = z;
  }
  public void setAce(int a){
      this.ace = a;
  }
  public void setServiceError(int e){
      this.serviceError = e;
  }
  public void setZeroServe(int z){
      this.zeroServe = z;
  }
  public void setSuccessfulDig(int s){
      this.successfulDig = s;
  }
  public void setDefenseError(int e){
      this.defenseError = e;
  }
  public void setBlock(int b){
      this.block = b;
  }
  public void setBlockError(int e){
      this.blockError = e;
  }
  public void setZeroBlock(int z){
      this.zeroBlock = z;
  }
  
  /*Statistics Calculation
  Attack: Total attacks = kill + attack error + zero attack, hitting percentage = (kills - errors)/totalAttack
  Setting: Total settings = Assist + Assist error + Zero assist, setting percentage = (assist - errors)/totalSetting
  Serving: Total serves = ace + service error + zero serves, service percentage = (ace - service error)/totalService
  Defense: Total defense = Successful dig + Defense error + Block + Block error, defense percentage = (successful dig + block - block error - defense error)/total defense
  */
  public int getTotalAttacks(){
      int total = kill + attackError + zeroAttack;
      return total;
  }
  public double getHittingPercentage(){
      double percentage;
      try{
      percentage = (kill - attackError)/getTotalAttacks();    
      }
      catch(ArithmeticException ae){ // happens when division by 0
          return 0;
      }
      return percentage;
  }
  public int getTotalSettings(){
      int total = assist + assistError + zeroAssist;
      return total;
  }
  public double getSettingPercentage(){
      double percentage;
      try{
      percentage = (assist - assistError)/getTotalSettings();
      }
      catch(ArithmeticException ae){
          return 0;
      }
      return percentage;
  }
  public int getTotalServings(){
      int total = ace + serviceError + zeroServe;
      return total;
  }
  public double getServicePercentage(){
      double percentage;
      try{
      percentage = (ace - serviceError)/getTotalServings();
      }
      catch(ArithmeticException ae){
          return 0;
      }
      return percentage;
  }
  public int getTotalDefense(){
      int total = successfulDig + defenseError + block + blockError + zeroBlock;
      return total;
  }
  public double getDefensePercentage(){
      double percentage;
      try{
      percentage = (successfulDig + block - defenseError - blockError)/getTotalDefense();
      }
      catch(ArithmeticException ae){
          return 0;
      }
      return percentage;
  }
  public int getPoints(){
      int points = kill + ace + block;
      return points;
  }
}


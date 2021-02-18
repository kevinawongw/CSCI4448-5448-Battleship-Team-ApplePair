package edu.colorado.applepear;
//Yubin part
public class Game {
    public int hitCount, missCount;


    // Kevina was here
    // Private Variables
    private Player p1;
    private Player p2;
    private GameBoard g1;
    private GameBoard g2;

    //constructor
    public Game(Player p1, Player p2, GameBoard g1, GameBoard g2){
        this.p1 = p1;
        this.p2 = p2;
        this.g1 = g1;
        this.g2 = g2;
    }

    // Function 1: Update Map
    // Param:
    // 1. Current Player's Game Board
    // 2. Opponent's Game Board
    // 3. Player input X coord
    // 4. Player input y coord
    // Returns: boolean & updates attackMap within gameBoard directly
    // Returns: boolean & updates attackMap within gameBoard directly
    public static boolean updateMap(GameBoard myMap, GameBoard oppMap, String myX, String myY) {
        if (oppMap.getShipMap()[Integer.parseInt(myY)][Integer.parseInt(myX)] == 1){
            myMap.attackMap[Integer.parseInt(myY)][Integer.parseInt(myX)] = 2;
            return true;
        }
        else if (oppMap.getShipMap()[Integer.parseInt(myY)][Integer.parseInt(myX)] == 0){
            myMap.attackMap[Integer.parseInt(myY)][Integer.parseInt(myX)] = 1;
            return false;
        }
        return false;
    }

    //1: keeps track of and displays the winner
    public void winner(){
//
//        if(/*player who gets higher score from Gameboard*/){
//            System.out.println(/*player*/," Win the Game! Congratulations!");
//        }

    }
    //2: determines which player's turn it is
    public void determinateTurn(){

    }
    //3: creates an object of each class to interact with each other
    public void classInteraction(){

    }
    //4: begin and end the game
    public void beginGame(){
//        display = new Display(this);
        System.out.println("Start Game!");
    }
    public void isGameOver() //return true when game is over
    {
        System.out.println("=============GAME OVER==============");
        System.exit(0);
    }
    //5: asks for inputs from the players
    public void playerInput(){
//        public Player getPlayer(){return player;}
    }
    //6: displays information to the players (like hit or miss)
    public void hitOrMiss(){
        char hit = '+';
        char miss = 'o';



    }

}

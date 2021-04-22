package edu.colorado.applepear.classes;

/**
 * Game Class
 */
public class Game {

    /**
     * Game's Attributes
     */
    private final GameBoard g1 = new GameBoard();
    private final GameBoard g2 = new GameBoard();
    private Player p1 = new Player(g1);
    private Player p2 = new Player(g2);


    /**
     * Game Constructor
     * @param p1 - Player 1
     * @param p2 - Player 2
     */
    public Game(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Hit Or Miss
     * @param p  - Attack Point
     * @param p1 - Attacker
     * @param p2 - Attacked Player
     * @return boolean
     *      // p1 hits p2
     *      // Check if p2 has a ship at the location of the ship map
     *      // If Yes, Return True
     *      // Else, Return False
     */
    public Boolean hitOrMiss(Point p, Player p1, Player p2){

        if (p2.getGb().getShipMap()[p.getY()][p.getX()] == 1){
            return true;
        }
        else if (p2.getGb().getShipMap()[p.getY()][p.getX()] == 0){
            return false;

        }
        return false;
    }


    /**
     * Is Game Over
     * @return boolean
     *      // Checks if either player has 0 ships left.
     */
    public boolean isGameOver()
    {
        return (p1.getGb().getShips().size() == 0 || p2.getGb().getShips().size() == 0);
    }

}

package pack;

import java.awt.Point;

public interface IPlayer {
    
    public Point getMove(String feld);
    /**
     * @param String containing the Fieldstate for the Player.
     * @return Point to change for Player.
     */
}

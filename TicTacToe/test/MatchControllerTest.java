import java.awt.Point;
import pack.IPlayer;
import pack.MatchController;

public class MatchControllerTest {
    public static void main(String[] args) {
        
        IPlayer playerOne = new IPlayer() {
            @Override
            public Point getMove(String feld) {
                return new Point(1,1);
            }
        };
        IPlayer playerTwo = new IPlayer() {
            @Override
            public Point getMove(String feld) {
                return new Point(2,2);
            }
        };
        
        MatchController testController = new MatchController(playerOne, playerTwo);
        testController.play();
    }
}
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import pack.*;

public class MatchControllerTest {
    public static void main(String[] args) {
        
//        IPlayer playerOne = new IPlayer() {
//            @Override
//            public Point getMove(String feld) {
//                return new Point(1,1);
//            }
//        };
//        IPlayer playerTwo = new IPlayer() {
//            @Override
//            public Point getMove(String feld) {
//                return new Point(2,2);
//            }
//        };
        
        IModel model = new Model();
        IView view = new ConsoleView(model);
        TicTacToeBordPanel tttBordPanel = new TicTacToeBordPanel(model);
        List<IView> views = new ArrayList<>();
        views.add(view);
        views.add(tttBordPanel);
        new JComponentTestFrame((JComponent) tttBordPanel);
        
        // Paapes Server : mpaap.mooo.com
        //IPlayer playerOne = new NetworkPlayer("localhost");
        //IPlayer playerTwo = new NetworkPlayer("localhost");
        IPlayer playerOne = new HumanPlayer(tttBordPanel);
        IPlayer playerTwo = new HumanPlayer(tttBordPanel);
        MatchController testController = new MatchController(playerOne, playerTwo, model, views);
        testController.play();
        System.out.println("end");
    }
}

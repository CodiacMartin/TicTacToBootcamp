package pack;

import java.awt.Point;
import java.util.List;

public class MatchController {
    private IPlayer playerOne, playerTwo;
    private IModel model;
    private List<IView> views;

    public MatchController(IPlayer playerOne, IPlayer playerTwo, IModel model, List<IView> views) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.model = model;
        this.views = views;
    }

    public void play() {
        for (int i = 0; i < 9; i++) {
            boolean even = i % 2 == 0;
            IPlayer currentPlayer = even ? playerOne : playerTwo;
            try {
                Point move = currentPlayer.getMove(model.toServerString()); //TODO Korrekten String Übergeben
                
                EFieldState currentState = even ? EFieldState.CROSS : EFieldState.CIRCLE;
                model.setFieldState(move.x, move.y, currentState);
                
                for (IView view : views) {
                    view.refresh();
                }
            } catch (PlayerException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}

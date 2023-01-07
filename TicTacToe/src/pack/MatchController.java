package pack;

import java.awt.Point;

public class MatchController {
    private IPlayer playerOne, playerTwo;
    private IModel model;

    public MatchController(IPlayer playerOne, IPlayer playerTwo, IModel model) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.model = model;
    }

    public void play() {
        for (int i = 0; i < 9; i++) {
            boolean even = i % 2 == 0;
            IPlayer currentPlayer = even ? playerOne : playerTwo;
            Point move = currentPlayer.getMove(model.toServerString()); //TODO Korrekten String Übergeben
            
            EFieldState currentState = even ? EFieldState.CROSS : EFieldState.CIRCLE;
            model.setFieldState(move.x, move.y, currentState);
            
            System.out.println(model);
        }
    }
}

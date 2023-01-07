package pack;

import java.awt.Point;

public class MatchController {
    private IPlayer playerOne, playerTwo;

    public MatchController(IPlayer playerOne, IPlayer playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void play() {
        for (int i = 0; i < 9; i++) {
            boolean even = i % 2 == 0;
            IPlayer currentPlayer = even ? playerOne : playerTwo;
            Point move = currentPlayer.getMove(""); //TODO Korrekten String Übergeben
            System.out.println(move);
        }
    }
}

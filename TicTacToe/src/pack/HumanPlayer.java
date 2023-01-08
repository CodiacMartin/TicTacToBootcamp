package pack;

import java.awt.Point;

public class HumanPlayer implements IPlayer, IMoveListener {
    IInputDevice inputDev;
    Point move;
    
    public HumanPlayer(IInputDevice inputDev) {
        this.inputDev = inputDev;
    }
    @Override
    public void moveOccurred(int row, int column) {
        move = new Point(row, column);
    }

    @Override
    public Point getMove(String feld) throws PlayerException {
        move = null;
        inputDev.setMoveListener(this);
        while (move==null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        }
        return move;
    }
}

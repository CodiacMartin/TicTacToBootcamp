package pack;

import java.awt.Point;

public class NetworkPlayer implements IPlayer {
    private Communicator myCom;
    
    public NetworkPlayer(String host) {
        myCom = new Communicator("localhost", 7890, "UTF-8");
    }

    @Override
    public Point getMove(String feld) throws PlayerException {
        try {
            String response = myCom.communicate(feld);
            int intResponse = Integer.parseInt(response.trim()) - 1;
            return new Point(intResponse/3,intResponse%3);
        }catch(CommunicatorException e){
            throw new PlayerException(e);
        }
    }
}

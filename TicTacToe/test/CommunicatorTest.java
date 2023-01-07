import pack.Communicator;
import pack.CommunicatorException;

public class CommunicatorTest {
    public static void main (String[] args) throws CommunicatorException{
        Communicator testCom = new Communicator("localhost", 7890, "UTF-8");
        String response = testCom.communicate("xox_xox_x\n");
        int res = Integer.parseInt(response.trim()) - 1;
        int row = res/3;
        int column = res%3;
        System.out.println(res+" gives x: "+row+" and y: "+column);
    }
}

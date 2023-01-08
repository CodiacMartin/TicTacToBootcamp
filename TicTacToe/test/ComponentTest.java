import javax.swing.*;

import pack.JComponentTestFrame;
import pack.TicTacToeBordPanel;

public class ComponentTest extends JComponent {
    public static void main(String[] args) {
        TicTacToeBordPanel tPanel = new TicTacToeBordPanel();
        new JComponentTestFrame(tPanel);
    }
    
}

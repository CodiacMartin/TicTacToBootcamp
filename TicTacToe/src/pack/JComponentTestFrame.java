package pack;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class JComponentTestFrame extends JFrame {
    public JComponentTestFrame(JComponent jComp) {
        add(jComp);
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

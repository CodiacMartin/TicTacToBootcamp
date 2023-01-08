import javax.swing.*;

import pack.*;

public class ComponentTest extends JComponent {
    public static void main(String[] args) {
        IModel model = new Model();
        model.setFieldState(1, 2, EFieldState.CROSS);
        model.setFieldState(0, 2, EFieldState.CIRCLE);
        TicTacToeBordPanel tPanel = new TicTacToeBordPanel(model);
        System.out.println(model);
        new JComponentTestFrame(tPanel);
    }
    
}

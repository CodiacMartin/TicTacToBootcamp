package pack;
import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class TicTacToeBordPanel extends JPanel {
    private IModel model;
    
    public TicTacToeBordPanel(IModel model) {
        this.model = model;
       setBackground(Color.YELLOW);
       setPreferredSize(new Dimension(250, 250));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        configureGraphicsForUsageOfUserCoordinateSystem(g2d);
        
        g2d.setColor(Color.BLACK);
        drawGrid(g2d);
        drawFieldStates(g2d);
        
    }

    private void drawFieldStates(Graphics2D g2d) {
        final int offset = 10;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (model.getFieldState(j, i)) {
                case CROSS:
                    g2d.drawLine(i*100+offset, j*100+offset, i*100+100-offset, j*100+100-offset);
                    g2d.drawLine(i*100+offset, j*100+100-offset, i*100+100-offset, j*100+offset);
                    break;
                case CIRCLE:
                    g2d.drawOval(i*100+offset, j*100+offset, 100-2*offset, 100-2*offset);
                    break;
                default:
                    break;
                }
            }
        }
    }

    private void drawGrid(Graphics2D g2d) {
        g2d.drawRect(0, 0, 300, 300);
        g2d.drawLine(100, 0, 100, 300);
        g2d.drawLine(200, 0, 200, 300);   
        g2d.drawLine(0, 100, 300, 100);
        g2d.drawLine(0, 200, 300, 200);
    }

    private void configureGraphicsForUsageOfUserCoordinateSystem(Graphics2D g2d) {
        double scale = Math.min(getHeight(), getWidth()) / 300.0;
        AffineTransform at = AffineTransform.getScaleInstance(scale, scale);
        if (getHeight()<getWidth()) {
            double move = (getWidth()-getHeight())/2.0;
            at.translate(move, 0);
        } else {
            double move = (getHeight()-getWidth())/2.0;
            at.translate(0 , move);
        }
        
        g2d.transform(at);
    }
}

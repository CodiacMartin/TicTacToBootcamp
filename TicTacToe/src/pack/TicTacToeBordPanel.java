package pack;
import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class TicTacToeBordPanel extends JPanel {
    
    public TicTacToeBordPanel() {
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
        
        int x = 0, y = 0;
        g2d.drawLine(x+10, y+10, x+90, y+90);
        g2d.drawLine(x+10, y+90, x+90, y+10);
        x=100;
        g2d.drawOval(x+10, y+10, 80, 80);
        
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

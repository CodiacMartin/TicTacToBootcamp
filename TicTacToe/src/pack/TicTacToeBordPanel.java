package pack;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class TicTacToeBordPanel extends JPanel implements IView, IInputDevice {
    private IModel model;
    private double scale;
    private double move;
    private IMoveListener iml;

    public TicTacToeBordPanel(IModel model) {
        this.model = model;
        setBackground(Color.YELLOW);
        setPreferredSize(new Dimension(250, 250));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                double mvX = getHeight() < getWidth() ? move : 0.0;
                double mvY = getHeight() < getWidth() ? 0.0 : move;
                int row = (int) ((e.getX()-mvX) / scale / 100);
                int column = (int) ((e.getY()-mvY) / scale / 100);
                if (row >= 0 && column >= 0 && row < 3 && column < 3&&iml!=null) {
                    System.out.println("Maus geklickt in Reihe: " + row + " Spalte: " + column);
                    iml.moveOccurred(row, column);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        configureGraphicsForUsageOfUserCoordinateSystem(g2d);
        g2d.setColor(Color.BLACK);
        drawGrid(g2d);
        drawFieldStates(g2d);
    }

    private void drawFieldStates(Graphics2D g2d) {
        final int offset = 10;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (model.getFieldState(i, j)) {
                case CROSS:
                    g2d.drawLine(i * 100 + offset, j * 100 + offset, i * 100 + 100 - offset, j * 100 + 100 - offset);
                    g2d.drawLine(i * 100 + offset, j * 100 + 100 - offset, i * 100 + 100 - offset, j * 100 + offset);
                    break;
                case CIRCLE:
                    g2d.drawOval(i * 100 + offset, j * 100 + offset, 100 - 2 * offset, 100 - 2 * offset);
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
        scale = Math.min(getHeight(), getWidth()) / 300.0;
        AffineTransform at = AffineTransform.getScaleInstance(scale, scale);
        move = Math.abs(getWidth() - getHeight()) / 2.0;
        if (getHeight() < getWidth()) {
            at.translate(move, 0);
        } else {
            at.translate(0, move);
        }
        g2d.transform(at);
    }

    @Override
    public void refresh() {
        repaint();
    }

    @Override
    public void setMoveListener(IMoveListener iml) {
        this.iml = iml;
    }
}

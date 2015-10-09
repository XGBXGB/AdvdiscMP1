package Driver;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPaint extends JFrame {

    public MainPaint() {
        setTitle("test paint");
        setSize(400, 400);
        setLayout(new BorderLayout());

        final PaintPanel paintPan = new PaintPanel();
        JButton testButon = new JButton("Display shape");
        add(paintPan, BorderLayout.CENTER);
        add(testButon, BorderLayout.PAGE_END);

        testButon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                paintPan.updateGraphics(50, 50);
                repaint();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainPaint();
    }
}

class PaintPanel extends JPanel {

    private int x, y;
    private Color color = null;

    public PaintPanel() {
        setBackground(Color.ORANGE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D drawImage = (Graphics2D) g;
        if (color != null) {
            drawImage.setColor(color);
            drawImage.drawRect(100, 150, x, y);
        }
    }

    public void updateGraphics(int length, int width) {
        color = Color.RED;
        x = length;
        y = width;
        repaint();
    }
}
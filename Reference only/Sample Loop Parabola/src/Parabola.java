
import javax.swing.JFrame;

public class Parabola {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setTitle("Parabola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(new DrawingComponent());
        frame.setVisible(true);
        
    }
    
}

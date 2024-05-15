import javax.swing.*;

public class ColorGameMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("The Color Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new ColorPanel();
        frame.getContentPane().add(panel);

        frame.setSize(400,400);
        frame.setVisible(true);

    }
}
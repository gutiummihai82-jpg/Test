import javax.swing.*;
import java.awt.*;

public class GifBackgroundExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("GIF Background Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // 1. JLabel cu GIF
        ImageIcon gifIcon = new ImageIcon("C:\\work\\video1.gif"); // GIF-ul tău
        JLabel backgroundLabel = new JLabel(gifIcon);
        backgroundLabel.setLayout(new GridBagLayout()); // pentru a centra butonul

        // 2. Buton Start
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.BOLD, 24));
        startButton.setBackground(new Color(255, 255, 255, 200)); // semi-transparent
        startButton.setOpaque(true);
        startButton.setBorderPainted(false);

        // Centrare buton
        backgroundLabel.add(startButton, new GridBagConstraints());



        frame.add(backgroundLabel);
        frame.setVisible(true);

        // Acțiune buton
        startButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Start clicked!"));
    }
}







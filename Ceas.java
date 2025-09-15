import javax.swing.*;
import java.awt.*;


public class Ceas {

    public static void main(String[] args) {


        JFrame frame = new JFrame("Top Secret");
        frame.setSize(1080,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel text = new JLabel();
        text.setFont(new Font("Colibri", Font.TYPE1_FONT, 67));
        text.setHorizontalAlignment(SwingConstants.SOUTH_EAST);

        frame.add(text);
        frame.setVisible(true);

        text.setText("Opa ");
        }
    }




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GifFullScreenMenu {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GifFullScreenMenu::createMainMenu);
    }

    private static void createMainMenu() {
        JFrame frame = new JFrame("GIF Fullscreen Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);                 // fără titlu / margini
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // fullscreen

        // GIF încărcat
        ImageIcon gifIcon = new ImageIcon("C:\\work\\video1.gif");

        // Panou custom care scalează GIF-ul pe tot ecranul
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(gifIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout()); // pentru centrare componente

        // Panou pentru butonul START
        JPanel startPanel = new JPanel(new GridBagLayout());
        startPanel.setOpaque(false);

        JButton startButton = new JButton("START");
        styleTransparentButton(startButton);
        startPanel.add(startButton);

        backgroundPanel.add(startPanel, new GridBagConstraints());
        frame.setContentPane(backgroundPanel);

        // ESC pentru ieșire
        frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("ESCAPE"), "EXIT");
        frame.getRootPane().getActionMap().put("EXIT", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Acțiune buton START → apare meniul secundar
        startButton.addActionListener(e -> {
            backgroundPanel.removeAll();

            JPanel menuPanel = new JPanel(new GridLayout(2, 1, 20, 20));
            menuPanel.setOpaque(false);

            JButton infoButton = new JButton("INFO");
            JButton exitButton = new JButton("EXIT");
            styleMenuButton(infoButton);
            styleMenuButton(exitButton);

            infoButton.addActionListener(ev -> JOptionPane.showMessageDialog(frame,
                    "Acesta este meniul INFO!", "INFO", JOptionPane.INFORMATION_MESSAGE));
            exitButton.addActionListener(ev -> System.exit(0));

            menuPanel.add(infoButton);
            menuPanel.add(exitButton);

            backgroundPanel.add(menuPanel, new GridBagConstraints());
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        // Timer pentru a redesena GIF-ul scalat (altfel rămâne static)
        new Timer(40, e -> backgroundPanel.repaint()).start(); // ~25 FPS

        frame.setVisible(true);
    }

    // === Stil pentru START ===
    private static void styleTransparentButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 48));
        button.setForeground(Color.WHITE);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.YELLOW);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.WHITE);
            }
        });
    }

    // === Stil pentru INFO și EXIT ===
    private static void styleMenuButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 36));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 0, 0, 120));
        button.setOpaque(true);
        button.setBorderPainted(false);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(255, 255, 255, 180));
                button.setForeground(Color.BLACK);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 0, 0, 120));
                button.setForeground(Color.WHITE);
            }
        });
    }
}







package part3.app.components;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    public MainFrame() {
        SwingUtilities.invokeLater(() -> {
            ImageIcon img = new ImageIcon(getClass().getResource("../images/frameIcon.png"));
            setIconImage(img.getImage());

            setTitle("Card Game");
            setSize(600,600);

            ScorePanel sp = new ScorePanel();
            GameBoard gb = new GameBoard(sp);

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setResizable(false);

            add(gb, BorderLayout.CENTER);
            add(sp, BorderLayout.SOUTH);

            setVisible(true);
        });
    }
}

package part2.app;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private ShowPanel showPanel;   // Panel for displaying the image
    private ControlPanel controlPanel; // Panel for controlling the image size

    public MainFrame() {
        setTitle("Image Scaler");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        showPanel = new ShowPanel();
        controlPanel = new ControlPanel(showPanel);

        add(showPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
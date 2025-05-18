package part2.app;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ShowPanel showPanel;   // Panel for displaying the image
    private ControlPanel controlPanel; // Panel for controlling the image size

    public MainFrame() {
        setTitle("Image Scaler");
        setSize(600, 600); // Set window size
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit
        setLayout(new BorderLayout()); // Use BorderLayout for panels

        // Initialize the panels
        showPanel = new ShowPanel();
        controlPanel = new ControlPanel(showPanel);

        // Add panels to the frame
        add(showPanel, BorderLayout.CENTER);  // Add the ShowPanel to the center
        add(controlPanel, BorderLayout.SOUTH); // Add the ControlPanel to the bottom

        setVisible(true); // Make the frame visible
    }
}
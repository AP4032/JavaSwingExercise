package part1.app;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class CalculatorApp extends JFrame{
    public CalculatorApp(){
        // Create main window
        setTitle("Graphical Calculator");

        // Configure window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);

        // Initialize components
        DisplayPanel displayPanel = new DisplayPanel();
        ButtonPanel buttonPanel = new ButtonPanel(displayPanel);

        // Layout setup
        setLayout(new BorderLayout());
        add(displayPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Show window
        setVisible(true);
    }
}

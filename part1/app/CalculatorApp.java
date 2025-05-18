package part1.app;

import javax.swing.JFrame;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class CalculatorApp extends JFrame{
    public CalculatorApp() {
        // Create main window
        setTitle("Graphical Calculator");

        // Configure window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        // Initialize components
        DisplayPanel display = new DisplayPanel();
        ButtonPanel buttons = new ButtonPanel(display);

        // Layout setup
        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);

        // Show window
        setVisible(true);
    }
}

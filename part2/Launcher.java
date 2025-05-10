package part2;

// Import necessary classes for Swing utilities and MainFrame
import javax.swing.SwingUtilities;
import part2.app.MainFrame;

public class Launcher {
    public static void main(String[] args) {
        // Launch the MainFrame on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new MainFrame(); // Create and show the main frame
        });
    }
}
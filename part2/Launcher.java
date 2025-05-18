package part2;

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

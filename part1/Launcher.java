package part1;
import part1.app.CalculatorApp;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculatorApp();
        });
    }

}

package part1.app;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private static final String[] BUTTONS = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "(", ")", "b"
    };

    public ButtonPanel(DisplayPanel display) {
        setLayout(new GridLayout(5, 4, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ActionListener listener = e -> {
            JButton source = (JButton) e.getSource();
            String cmd = source.getText();

            if ("=".equals(cmd)) {
                // Evaluate expression and display result
                String expr = display.getExpression();
                String result = EvalUtil.eval(expr); // Ensure EvalUtil exists
                display.setExpression(result);
            } else if ("C".equals(cmd)) {
                // Clear the display
                display.setExpression("");
            } else if ("b".equals(cmd)) {
                String currentExpr = display.getExpression();
                if (!currentExpr.isEmpty()) {
                    display.setExpression(currentExpr.substring(0, currentExpr.length() - 1));
                }
            } else {
                // Append digit/operator to display
                display.setExpression(display.getExpression() + cmd);
            }
        };

        // Create and add buttons
        for (String label : BUTTONS) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(listener);
            add(button);
        }
    }
}

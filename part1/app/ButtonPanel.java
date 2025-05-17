package part1.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel{

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
            String cmd = ((JButton) e.getSource()).getText();

            if ("=".equals(cmd)) {
                // Evaluate expression and display result
                String expr = display.getExpression();
                String result = EvalUtil.eval(expr);
                display.setExpression(result);
            } else if ("C".equals(cmd)) {
                // Clear the display
                display.setExpression("");
            } else if ("b".equals(cmd)){
                if (display.getExpression().length() > 0){
                    display.setExpression(display.getExpression().substring(0, display.getExpression().length() - 1));
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

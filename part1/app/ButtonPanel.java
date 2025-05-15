package part1.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private final String[] BUTTONS = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "(", ")", "b"
    };

    public ButtonPanel(DisplayPanel displayPanel) {
        setLayout(new GridLayout(5, 4, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));


        ActionListener listener = e -> {
            String exp = ((JButton) e.getSource()).getText();

            if (exp.equalsIgnoreCase("c")) {
                displayPanel.setTextField("");
            } else if (exp.equalsIgnoreCase("b")) {
                displayPanel.setTextField(displayPanel.getTextField().substring(0, displayPanel.getTextField().length() - 1));
            } else if (exp.equalsIgnoreCase("=")) {
                String expression = displayPanel.getTextField();
                String result = EvalUtil.eval(expression);
                displayPanel.setTextField(result);
            } else {
                displayPanel.setTextField(displayPanel.getTextField() + exp);
            }
        };

        for (String button : BUTTONS) {
            JButton btn = new JButton(button);
            new Font("Arial", Font.PLAIN, 20);
            btn.addActionListener(listener);
            add(btn);
        }
    }

}

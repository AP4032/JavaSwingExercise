package part1.app;

import javax.swing.JPanel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;


public class ButtonPanel extends JPanel{
    private static final String[] BUTTONS = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "(", ")", "b"
    };

    private boolean justEvaluated = false;

    public ButtonPanel(DisplayPanel display) {
        setLayout(new GridLayout(5, 4, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ActionListener listener = e -> {
            String cmd = ((JButton) e.getSource()).getText();

            switch (cmd) {
                case "=":
                    String expr = display.getExpression();
                    String result = EvalUtil.eval(expr);
                    display.setExpression(result);
                    justEvaluated = true;
                    break;
                case "C":
                    display.setExpression("");
                    justEvaluated = false;
                    break;
                case "b":
                    if (!display.getExpression().isEmpty()){
                        display.setExpression(display.getExpression().substring(0, display.getExpression().length() - 1));
                    }
                    justEvaluated = false;
                    break;
                default:
                    if (justEvaluated && (
                            cmd.matches("[0-9]") || ".".equals(cmd) || "(".equals(cmd) || ")".equals(cmd)))
                    {
                        display.setExpression("");
                    }
                    justEvaluated = false;

                    display.setExpression(display.getExpression() + cmd);
                    break;
            }
        };

        for (String label : BUTTONS) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(listener);
            add(button);
        }
    }
}
    


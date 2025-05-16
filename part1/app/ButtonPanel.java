package part1.app;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel{
    private static final String[] BUTTONS = { "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "(", ")", "b"};


    public ButtonPanel(DisplayPanel display) {
        setLayout(new GridLayout(5,4,5,5));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        ActionListener listener = e -> {
            String command = ((JButton)e.getSource()).getText();
            if(command.equals("=")) {
                String command2 = display.getDisplay();
                String result = EvalUtil.eval(command2);
                display.setDisplay(result);

            }else if (command.equals("C")) {
                display.setDisplay("");
            }else if (command.equals("b")) {
                if (display.getDisplay().length() > 0) {
                    display.setDisplay(display.getDisplay().substring(0, display.getDisplay().length() - 1));

                }
            }else{
                display.setDisplay(display.getDisplay() + command);
            }
        };

        for(String button : BUTTONS) {
            JButton b = new JButton(button);
            b.addActionListener(listener);
            b.setFont( new Font("Arial", Font.PLAIN,24));
            add(b);
        }

    }
}

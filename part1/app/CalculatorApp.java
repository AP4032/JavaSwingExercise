package part1.app;

import javax.swing.JFrame;
import java.awt.*;

public class CalculatorApp extends JFrame{

    public CalculatorApp(){
        setTitle("Calculator App");
        setSize(350,500);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DisplayPanel displayPanel = new DisplayPanel();

        ButtonPanel buttonPanel = new ButtonPanel(value -> {
            switch (value) {
                case "C" -> displayPanel.clearText();
                case "b" -> displayPanel.backspace();  // If you have a backspace button
                case "=" -> {
                    String result = EvalUtil.eval(displayPanel.getText());
                    displayPanel.setText(result);
                }
                default -> displayPanel.appendText(value);
            }
        });

        setLayout(new BorderLayout());

        add(displayPanel, BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.SOUTH);

        setVisible(true);
    }
}

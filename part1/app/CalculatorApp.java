package part1.app;

import javax.swing.JFrame;
import java.awt.*;
import java.util.List;

public class CalculatorApp extends JFrame{

    public CalculatorApp(){
        setTitle("Calculator App");
        setSize(350,420);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        DisplayPanel displayPanel = new DisplayPanel();

        ButtonPanel buttonPanel = new ButtonPanel(value -> {
            switch (value) {
                case "C" -> displayPanel.clearText();
                case "b" -> displayPanel.backspace();  // If you have a backspace button
                case "=" -> {
                    List<String> postFix = EvalUtil.eval(displayPanel.getText());
                    displayPanel.setText(EvalUtil.calculatePostfix(postFix));
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

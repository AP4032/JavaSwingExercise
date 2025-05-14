package part1.app;

import javax.swing.JFrame;

public class CalculatorApp extends JFrame{

    public CalculatorApp(){
        setTitle("Calculator");
        setSize(300,400);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DisplayPanel displayPanel = new DisplayPanel();
        ButtonPanel btnPanel = new ButtonPanel();

        setVisible(true);
    }
}

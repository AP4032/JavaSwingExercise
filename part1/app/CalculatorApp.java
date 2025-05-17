package part1.app;

import javax.swing.*;

public class CalculatorApp extends JFrame{
    public CalculatorApp() {
        JPanel panel = new JPanel();

        DisplayPanel displayPanel = new DisplayPanel();
        ButtonPanel buttonPanel=new ButtonPanel(displayPanel);
        panel.add(displayPanel);
        panel.add(buttonPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Graphical Calculator");
        this.setSize(300, 350);
        this.add(panel);
        this.setVisible(true);
    }

    
}

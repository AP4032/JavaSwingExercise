package part1.app;

import javax.swing.JFrame;
import java.awt.*;
import java.beans.Visibility;

public class CalculatorApp extends JFrame {
    public CalculatorApp() {
        setTitle("CalculatorApp");
        setSize(300,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

     DisplayPanel displayPanel=new DisplayPanel();
     ButtonPanel buttonPanel=new ButtonPanel(displayPanel);
     setLayout(new BorderLayout());
     add(displayPanel,BorderLayout.NORTH);
     add(buttonPanel,BorderLayout.CENTER);
     setVisible(true);
    }
}
package part1.app;

import javax.swing.JFrame;
import java.awt.*;

public class CalculatorApp extends JFrame{

    public CalculatorApp(){
        this.setTitle(" Graphical Calculator ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(300 , 400);
        this.setLocationRelativeTo(null);
          DisplayPanel display = new DisplayPanel();
          ButtonPanel buttons = new ButtonPanel(display);
          setLayout(new BorderLayout());
          add( display, BorderLayout.NORTH);
          add(buttons, BorderLayout.CENTER);
          this.setVisible(true);


    }
    
}

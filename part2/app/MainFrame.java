package part2.app;

import javax.swing.JFrame;
import java.awt.*;

public class MainFrame extends JFrame {
    int Max=600,May=600;
    public MainFrame(){
        setTitle("Salah");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(Max,May);
        setLocationRelativeTo(null);
        ShowPanel showPanel= new ShowPanel();
        ControlPanel controlPanel= new ControlPanel(showPanel,Max,May);
        setLayout(new BorderLayout());
        add(showPanel,BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);

    }

}


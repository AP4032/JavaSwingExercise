package part2.app;

import javax.swing.JFrame;
import java.awt.*;

public class MainFrame extends JFrame {
    private ShowPanel showPanel;
    private ControlPanel controlPanel;
    public MainFrame() {
        this.setTitle("Image Scaler");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(600,600);

        setLayout(new BorderLayout());
        showPanel = new ShowPanel();
        controlPanel = new ControlPanel(showPanel);
        add(showPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);



        this.setVisible(true);

    }
    
}


package part2.app;

import javax.swing.JFrame;
import java.awt.*;

public class MainFrame extends JFrame {
    private ShowPanel showPanel;
    private ControlPanel controlPanel;

    public MainFrame() {
        setTitle("IMAGE SCALER");

        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        showPanel = new ShowPanel();
        controlPanel = new ControlPanel(showPanel);

        add(showPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.NORTH);
    }
}


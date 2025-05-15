package part2.app;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    ShowPanel sp;
    ControlPanel cp;
    public MainFrame(){
        setTitle("Image Resizing App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        sp = new ShowPanel();
        cp = new ControlPanel(this::onSubmit);

        add(sp , BorderLayout.CENTER);
        add(cp, BorderLayout.SOUTH);
        setVisible(true);
    }
    private void onSubmit(ActionEvent e) {
        try {
            int width = cp.getImageWidth();
            int height = cp.getImageHeight();
            sp.updateImageSize(width, height);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input");
        }
    }
}


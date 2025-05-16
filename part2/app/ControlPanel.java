package part2.app;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private JTextField width, height ;
    private JButton scaleButton;
    private ShowPanel showPanel;

    public ControlPanel(ShowPanel showPanel) {
        this.showPanel = showPanel;
        setLayout(new FlowLayout());
        setBackground(new Color (122,135,100));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        width = new JTextField(15);
        height = new JTextField(15);
        scaleButton = new JButton("Scale Image");
        add(new JLabel("Width: "));
        add(new JLabel("Height: "));
        add(width);
        add(height);
        add(scaleButton);
        scaleButton.addActionListener(e -> {

            try {
                int widthScale = Integer.parseInt(width.getText());
                int heightScale = Integer.parseInt(height.getText());
                int maxWidth = showPanel.getWidth();
                int maxHeight = showPanel.getHeight();

                if ( widthScale > maxWidth || heightScale > maxHeight){
                    JOptionPane.showMessageDialog(null,"Entered size cannot be larger than the panel size");
                }else {
                    showPanel.loadImage();
                    showPanel.scaleImage(widthScale,heightScale);
                }
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"Please enter a valid width or height");

            }

        });

    }


    
}

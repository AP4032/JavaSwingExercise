package part2.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private JTextField widthField, heightField;
    private JButton scale;
    private ShowPanel showPanel;

    public ControlPanel(ShowPanel showPanel) {
        this.showPanel = showPanel;

        setLayout(new FlowLayout());
        setBackground(new Color(150, 150, 150));
        setBorder(BorderFactory.createEmptyBorder(5,10,5,10));

        add(new JLabel("width"));
        add(widthField = new JTextField(5));
        add(new JLabel("height"));
        add(heightField = new JTextField(5));
        add(scale = new JButton("scale"));


        scale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int width = Integer.parseInt(widthField.getText()); // Get the entered width
                    int height = Integer.parseInt(heightField.getText()); // Get the entered height

                    // Get the dimensions of the ShowPanel
                    int maxWidth = showPanel.getWidth();
                    int maxHeight = showPanel.getHeight();

                    // Check if the entered size is larger than the panel's size
                    if (width > maxWidth || height > maxHeight) {
                        JOptionPane.showMessageDialog(null, "Entered size cannot be larger than the panel size!");
                    } else {
                        // Reload the image and scale it
                        showPanel.loadImage(); // Reload the image
                        showPanel.scaleImage(width, height); // Scale the image
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for width and height"); // Show error message
                }
            }
        });
    }
    
}

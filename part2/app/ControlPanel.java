package part2.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private JTextField widthField;
    private JTextField heightField;

    public ControlPanel(ActionListener submitListener) {
        // init widthField and heightField
        Font font = new Font("Arial", Font.PLAIN, 25);
        widthField = new JTextField(5);
        heightField = new JTextField(5);
        widthField.setFont(font);
        heightField.setFont(font);

        JButton submitButton = new JButton("Resize");
        submitButton.setFont(font);
        submitButton.addActionListener(submitListener);

        add(new JLabel("Width:"));
        add(widthField);
        add(new JLabel("Height:"));
        add(heightField);
        add(submitButton);
    }

    public int getImageWidth() {
        return Integer.parseInt(widthField.getText().trim());
    }

    public int getImageHeight() {
        return Integer.parseInt(heightField.getText().trim());
    }
}

package part1.app;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel{
    private JTextField textField;

    public DisplayPanel() {
        textField = new JTextField();
        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(280, 70));
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.LEFT);
        add(textField, BorderLayout.CENTER);
    }

    public void setTextField(String exp) {
        this.textField.setText(exp);
    }

    public String getTextField() {
        return textField.getText();
    }
}

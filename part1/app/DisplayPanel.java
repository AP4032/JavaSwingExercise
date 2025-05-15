package part1.app;


import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel{
    private JTextField textField;

    public DisplayPanel(){
        textField = new JTextField(20);
        textField.setEditable(false);
        textField.setFont(new Font("Monospaced", Font.BOLD, 28));
        textField.setHorizontalAlignment(JTextField.LEFT);

        add(textField);
    }
    public void appendText(String s) {
        textField.setText(textField.getText() + s);
    }

    public void clearText() {
        textField.setText("");
    }

    public void backspace() {
        String current = textField.getText();
        if (!current.isEmpty()) {
            textField.setText(current.substring(0, current.length() - 1));
        }
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String s) {
        textField.setText(s);
    }
}

package part1.app;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel{
    private JTextField TextTop;
    DisplayPanel(){
        setBackground(Color.ORANGE);
        setLayout(new BorderLayout());
        TextTop = new JTextField();
        TextTop.setBackground(new Color(255, 200, 120));
        setPreferredSize(new Dimension(280, 70));
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        TextTop.setFont(new Font("Arial", Font.PLAIN, 24));
        TextTop.setHorizontalAlignment(JTextField.LEFT);
        add(TextTop, BorderLayout.CENTER);
    }
    public String getField(){
        return TextTop.getText();
    }
    public void setField(String Field){
        TextTop.setText(Field);
    }

}
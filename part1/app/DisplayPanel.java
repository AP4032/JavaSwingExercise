package part1.app;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel{

    private JTextField displayField;

    public DisplayPanel(){

        displayField = new JTextField();
        this.setPreferredSize(new Dimension(280,70));
        this.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        this.setFont(new Font("Arial",Font.PLAIN,24));
        displayField.setHorizontalAlignment(SwingConstants.LEFT);
        this.setLayout(new BorderLayout());
        this.add(displayField, BorderLayout.CENTER);

    }
    public String getDisplay(){
        return displayField.getText();
    }
    public void setDisplay(String display){
        this.displayField.setText(display);
    }
    
}

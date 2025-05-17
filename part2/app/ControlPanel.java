package part2.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class ControlPanel extends JPanel {
    private JButton button;
    private JTextField textFieldX;
    private JTextField textFieldY;
    private GridBagConstraints gbc;
    ControlPanel (ShowPanel showPanel, int Max, int May){
        ActionListener DetailsButton = e -> {

            try {
                int X = Integer.parseInt(textFieldX.getText());
                int Y = Integer.parseInt(textFieldY.getText());
                if(X>=Max || Y>=May){
                    JOptionPane.showMessageDialog(null,"Entered size cannot be larger than the panel size!");
                }else {
                    showPanel.setXAndY(X,Y);

                }
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for width and height");
            }
        };
        button=new JButton("Scale Image");
        button.addActionListener(DetailsButton);
        textFieldX=new JTextField(5);
        textFieldY=new JTextField(5);
        gbc=new GridBagConstraints();
        gbc.insets=new Insets(10,10,10,10);
        gbc.fill =GridBagConstraints.HORIZONTAL;
        gbc.gridx=0; gbc.gridy=0;
        add(new JLabel("width: "));
        gbc.gridx=1;
        add(textFieldX,gbc);
        gbc.gridx=2;
        add(new JLabel("height: "),gbc);
        gbc.gridx=3;
        add(textFieldY,gbc);
        gbc.gridx=4;
        add(button,gbc);


    }

}

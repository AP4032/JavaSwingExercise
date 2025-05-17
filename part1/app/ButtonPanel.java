package part1.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private GridBagConstraints gbc;
    private final static String[][] ButtonNames={
            {"7","8","9","/"},
            {"6","5","4","*"},
            {"3","2","1","-"},
            {"0",".","=","+"},
            {"C","(",")","B"},
            {"cos","sin","tan","π"}
    };
    ButtonPanel(DisplayPanel display){
        setBackground(Color.ORANGE);
        ActionListener DetailsButton =e -> {
        String cmd = ((JButton) e.getSource()).getText();
        switch(cmd){
            case "=" : {
                String expr = display.getField();
                String result = EvalUtil.eval(expr);
                display.setField(result);
                break;
            }
            case "C" :{
                display.setField("");
                break;
            }
            case "B" :{
                if (display.getField().length() > 0){
                    display.setField(display.getField().substring(0, display.getField().length() - 1));
                }
                break;
            }
            case "cos":{
                String expr = display.getField();
                String result = EvalUtil.eval(expr);
                if(!(result.equals("Error"))) {
                    result = String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(result))));
                }
                display.setField(result);
                break;
            }
            case "sin":{
                String expr = display.getField();
                String result = EvalUtil.eval(expr);
                if(!(result.equals("Error"))) {
                    result = String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(result))));
                }
                display.setField(result);
                break;
            }
            case "tan":{
                String expr = display.getField();
                String result = EvalUtil.eval(expr);
                if(!(result.equals("Error"))) {
                    result = String.valueOf(Math.tan(Math.toRadians(Double.parseDouble(result))));
                }
                display.setField(result);

              break;
            }
            default :{
                display.setField(display.getField() + cmd);
                break;
            }
        }
        };
        gbc=new GridBagConstraints();
        setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx=9;
        gbc.weighty=9;
        gbc.insets= new Insets(2,2,2,2);
        for (int i=0;i<6;i++){
            for (int j=0;j<4;j++){
             gbc.gridx=j; gbc.gridy=i;
             JButton button=new JButton(ButtonNames[i][j]);
             button.addActionListener(DetailsButton);
             button.setBackground(new Color(255, 140, 0));
             button.setFont(new Font("Arial", Font.PLAIN, 18));
             add(button,gbc);
            }
        }

    }


}


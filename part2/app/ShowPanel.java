package part2.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ShowPanel extends JPanel {
    int X=250,Y=300;
    JLabel imageIcon;
    ImageIcon image=new ImageIcon("part2/app/images/img.png");
    ShowPanel(){
        imageIcon=new JLabel(new ImageIcon(image.getImage().getScaledInstance(X, Y, Image.SCALE_SMOOTH)));
        setLayout(new GridBagLayout());
        add(imageIcon);

    }

    public void setXAndY(int x,int y){
        Image scaledImage = image.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
        imageIcon.setIcon(new ImageIcon(scaledImage));
    }
}



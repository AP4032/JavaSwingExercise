// CardButton.java
package part3.app.components;

import java.awt.Dimension;
import javax.swing.*;

public class CardButton extends JButton {
    private Icon img;
    private Icon back;
    private boolean isFlipped;
    private boolean isMatched;
    private int width,height;

    public CardButton(Icon front, Icon back){
        this.img = front;
        this.back = back;
        this.width = 145;
        this.height = 145;

        setPreferredSize(new Dimension(width, height));

        this.isFlipped = false;
        this.isMatched = false;

        setIcon(back);
        revalidate();
        repaint();

        System.out.println("Front icon: " + img);
        System.out.println("Back icon: " + back);


    }
    public Icon getFrontIcon (){
        return img;
    }

    public boolean isFlipped(){
        return isFlipped;
    }
    public boolean isMatched(){
        return isMatched;
    }
    public void showImage(){
        if(!isMatched){
            setIcon(img);
            isFlipped = true;
        }
    }
    public void hideImage(){
        if (!isMatched){
           setIcon(back);
           isFlipped = false;
        }
    }
    public void setMatched(boolean matched){
        isMatched = matched;
        if (matched) setEnabled(false);
    }
}
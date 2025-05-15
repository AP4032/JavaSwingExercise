package part1.app;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
    private GridBagConstraints gbc;

    private JButton[] numberButtons;

    //Operation buttons , * / - + =
    private JButton equalBtn;
    private JButton plusBtn;
    private JButton minusBtn;
    private JButton divBtn;
    private JButton multiplayBtn;

    private JButton clearBtn;
    //the P stands for parentheses
    private JButton openP;
    private JButton closeP;
    private JButton backBtn;

    private JButton decimalPointBtn;

    public ButtonPanel(Consumer<String> buttonClickHandler) {
        numberButtons = new JButton[10];
        //initialize the numbers btns.
        for (int i = 0; i <= 9; i++) {
            final int digit = i; // Capture the current value
            numberButtons[i] = new JButton(String.valueOf(digit));
            numberButtons[i].addActionListener(e -> buttonClickHandler.accept(String.valueOf(digit)));
        }

        equalBtn = new JButton("=");
        minusBtn = new JButton("-");
        plusBtn = new JButton("+");
        divBtn = new JButton("/");
        multiplayBtn = new JButton("*");

        minusBtn.addActionListener(e -> buttonClickHandler.accept("-"));
        plusBtn.addActionListener(e -> buttonClickHandler.accept("+"));
        divBtn.addActionListener(e -> buttonClickHandler.accept("/"));
        multiplayBtn.addActionListener(e -> buttonClickHandler.accept("*"));


        clearBtn = new JButton("C");
        backBtn = new JButton("b");
        openP = new JButton("(");
        closeP = new JButton(")");
        decimalPointBtn = new JButton(".");

        closeP.addActionListener(e -> buttonClickHandler.accept(")"));
        openP.addActionListener(e -> buttonClickHandler.accept("("));
        decimalPointBtn.addActionListener(e -> buttonClickHandler.accept("."));

        equalBtn.addActionListener(e -> buttonClickHandler.accept("="));
        clearBtn.addActionListener(e -> buttonClickHandler.accept("C"));
        backBtn.addActionListener(e -> buttonClickHandler.accept("b"));

        this.setLayout(new GridBagLayout());

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //First row
        placeBtn(0, 0, numberButtons[7]);
        placeBtn(0, 1, numberButtons[8]);
        placeBtn(0, 2, numberButtons[9]);
        placeBtn(0, 3, divBtn);

        //Second row
        placeBtn(1, 0, numberButtons[4]);
        placeBtn(1, 1, numberButtons[5]);
        placeBtn(1, 2, numberButtons[6]);
        placeBtn(1, 3, multiplayBtn);

        //Thirth row
        placeBtn(2, 0, numberButtons[1]);
        placeBtn(2, 1, numberButtons[2]);
        placeBtn(2, 2, numberButtons[3]);
        placeBtn(2, 3, minusBtn);

        //Fourth row
        placeBtn(3, 0, numberButtons[0]);
        placeBtn(3, 1, decimalPointBtn);
        placeBtn(3, 2, equalBtn);
        placeBtn(3, 3, plusBtn);

        //Fifth row
        placeBtn(4, 0, clearBtn);
        placeBtn(4, 1, openP);
        placeBtn(4, 2, closeP);
        placeBtn(4, 3, backBtn);
    }

    //helper method for adding btns
    public void placeBtn(int x, int y, JButton btn) {
        gbc.gridx = y;
        gbc.gridy = x;
        add(btn, gbc);
    }
}

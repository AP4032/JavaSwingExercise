package part1.app;

import java.awt.*;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
    private GridBagConstraints gbc;

    private JButton[] numberButtons;

    private JButton equalBtn, plusBtn, minusBtn, divBtn, multiplayBtn;
    private JButton clearBtn, openP, closeP, backBtn;
    private JButton decimalPointBtn;
    //Operation buttons , * / - + =

    private final Dimension BUTTON_SIZE = new Dimension(70, 50);  // Adjust as needed
    private final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 18);


    public ButtonPanel(Consumer<String> buttonClickHandler) {
        numberButtons = new JButton[10];
        //initialize the numbers btns.
        for (int i = 0; i <= 9; i++) {
            final int digit = i; // Capture the current value
            numberButtons[i] = new JButton(String.valueOf(digit));
            numberButtons[i].addActionListener(e -> buttonClickHandler.accept(String.valueOf(digit)));
            numberButtons[i].setPreferredSize(BUTTON_SIZE);
            numberButtons[i].setFont(BUTTON_FONT);
        }
        //Creating operating buttons
        equalBtn = createStyledButton("=");
        minusBtn = createStyledButton("-");
        plusBtn = createStyledButton("+");
        divBtn = createStyledButton("/");
        multiplayBtn = createStyledButton("*");

        clearBtn = createStyledButton("C");
        backBtn = createStyledButton("b");
        openP = createStyledButton("(");
        closeP = createStyledButton(")");
        decimalPointBtn = createStyledButton(".");

        minusBtn.addActionListener(e -> buttonClickHandler.accept("-"));
        plusBtn.addActionListener(e -> buttonClickHandler.accept("+"));
        divBtn.addActionListener(e -> buttonClickHandler.accept("/"));
        multiplayBtn.addActionListener(e -> buttonClickHandler.accept("*"));

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
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(BUTTON_SIZE);
        button.setFont(BUTTON_FONT);
        return button;
    }
}

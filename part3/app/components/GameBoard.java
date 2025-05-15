package part3.app.components;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GameBoard extends JPanel {
    private static final int NUM_PAIRS = 8;

    private List<CardButton> cards = new ArrayList<>();
    private CardButton firstSelected = null;
    private CardButton secondSelected = null;
    private Timer flipBackTimer;
    private ScorePanel scorePanel;
    private int moves = 0;

    public GameBoard(ScorePanel scorePanel) {
        this.scorePanel = scorePanel;

        setLayout(new GridLayout(4, 4, 0, 0));
        setBackground(Color.DARK_GRAY);

        Icon backIcon = new ImageIcon(getClass().getResource("/part3/app/images/back.png"));
        ArrayList<Icon> icons = loadIcons();

        for (Icon icon : icons) {
            CardButton card = new CardButton(icon, backIcon);
            card.addActionListener(e -> handleCardClick(card));
            cards.add(card);
            add(card);
        }

        flipBackTimer = new Timer(800, e -> {
            if (firstSelected != null && secondSelected != null) {
                firstSelected.hideImage();
                secondSelected.hideImage();
                firstSelected = null;
                secondSelected = null;
            }
        });
        flipBackTimer.setRepeats(false);
    }

    private void handleCardClick(CardButton card) {
        if (card.isMatched() || card.isFlipped() || flipBackTimer.isRunning()) return;

        card.showImage();

        if (firstSelected == null) {
            firstSelected = card;
        } else if (secondSelected == null && card != firstSelected) {
            secondSelected = card;

            moves++;
            scorePanel.updateMoves(moves);

            if (firstSelected.getFrontIcon().equals(secondSelected.getFrontIcon())) {
                firstSelected.setMatched(true);
                secondSelected.setMatched(true);
                firstSelected = null;
                secondSelected = null;

                if (allMatched()) {
                    JOptionPane.showMessageDialog(this, "Congratulations! You won in " + moves + " moves.");
                }
            } else {
                flipBackTimer.start();
            }
        }
    }

    private boolean allMatched() {
        return cards.stream().allMatch(CardButton::isMatched);
    }

    private ArrayList<Icon> loadIcons() {
        ArrayList<Icon> icons = new ArrayList<>();
        for (int i = 1; i <= NUM_PAIRS; i++) {
            Image img = new ImageIcon(getClass().getResource("/part3/app/images/img" + i + ".png")).getImage();
            Image scaled = img.getScaledInstance(145, 145, Image.SCALE_SMOOTH);
            Icon icon = new ImageIcon(scaled);
            icons.add(icon);
            icons.add(icon);
        }
        Collections.shuffle(icons);
        return icons;
    }
}

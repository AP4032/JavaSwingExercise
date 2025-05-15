package part2.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class ShowPanel extends JPanel {
    private JLabel imageLabel;
    private BufferedImage originalImage;

    public ShowPanel() {
        setLayout(new GridBagLayout());

        try {
            originalImage = ImageIO.read(
                    getClass().getResourceAsStream("/part2/app/images/img.png")
            );

            imageLabel = new JLabel();
            add(imageLabel);

            // Initially show at default size
            updateImageSize(150, 150);

        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void updateImageSize(int width, int height) {
        if (originalImage != null) {
            Image scaled = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaled));
            revalidate();
            repaint();
        }
    }
}

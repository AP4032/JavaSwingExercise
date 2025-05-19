package part2.app;

import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class ShowPanel extends JPanel {
    private Image image;
    private String imagePath = "./images/img.png";

    public ShowPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        loadImage();
    }

    public void loadImage() {
        try {
            image = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint(); // Redraw the panel
    }

    public void scaleImage(int width, int height) {
        if (image != null) {
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Scale image
            image = scaledImage;
            repaint(); // Redraw the panel
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            // Calculate the x and y coordinates to center the image
            int x = (getWidth() - image.getWidth(null)) / 2;
            int y = (getHeight() - image.getHeight(null)) / 2;
            g.drawImage(image, x, y, this); // Draw the image at the calculated position
        }
    }
}



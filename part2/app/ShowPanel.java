package part2.app;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class ShowPanel extends JPanel {
    private Image image; // Image object to hold the loaded image
    private String imagePath = "./images/img.png"; // Path to the image file

    public ShowPanel() {
        setLayout(new BorderLayout()); // Set layout to BorderLayout
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Add border to the panel

        loadImage(); // Load the image initially
    }

    // Method to load the image from the specified path
    public void loadImage() {
        try {
            // Load the image from the file system
            image = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException e) {
            e.printStackTrace(); // Print any error encountered during loading
        }
        repaint(); // Redraw the panel
    }

    // Method to scale the image to a specified width and height
    public void scaleImage(int width, int height) {
        if (image != null) {
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Scale image
            image = scaledImage;
            repaint(); // Redraw the panel
        }
    }
    // Override the paintComponent method to center the image on the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass method
        if (image != null) {
            // Calculate the x and y coordinates to center the image
            int x = (getWidth() - image.getWidth(null)) / 2;
            int y = (getHeight() - image.getHeight(null)) / 2;
            g.drawImage(image, x, y, this); // Draw the image at the calculated position
        }
    }
}


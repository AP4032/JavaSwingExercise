package part2.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ShowPanel extends JPanel {
    private Image image;
    private String imagePAth = "./images/H2R.png";

    public ShowPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        loadImage();
    }

    public void loadImage() {
      try {
          image = ImageIO.read(getClass().getResource(imagePAth));
      } catch (IOException e) {
          e.printStackTrace();
      }
      repaint();
    }

    public void scaleImage(int width, int height) {
        if (image != null) {
            Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            image = newImage;
        }
    }

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



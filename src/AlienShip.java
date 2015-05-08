import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AlienShip {

	BufferedImage image;
	int x;
	int y;

	public AlienShip(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}

	public BufferedImage getImage() {
		try {
			image = ImageIO.read(new File("space-invader.jpg"));

		} catch (IOException ex) {
			System.out.println("missing starship");
		}

		return image;

	}

	public void addToThisGraphics(Graphics g, JPanel j) {
		g.drawImage(this.getImage(), x, y, j);

	}
}

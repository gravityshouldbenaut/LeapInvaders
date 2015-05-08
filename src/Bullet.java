import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Bullet {

	BufferedImage image;
	private static int yBullet = 90;
	private static int xBullet = 20;

	public Bullet(Graphics g, JPanel j, int startX) {

		g.drawImage(this.getImage(), xBullet + startX, yBullet, j);
	}

	public BufferedImage getImage() {
		try {
			image = ImageIO.read(new File("bullet.png"));

		} catch (IOException ex) {
			System.out.println("missing bullet");
		}

		return image;

	}

	public void addY(int x) {
		yBullet += x;
	}

	public int getY() {
		return yBullet;
	}
}

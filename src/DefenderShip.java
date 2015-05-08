import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DefenderShip {
	private static int DEF_START_X = 100;
	private static int DEF_START_Y = 625;
	private BufferedImage image;

	public DefenderShip(Graphics g, JPanel j) {
		g.drawImage(this.getImage(), DEF_START_X, DEF_START_Y, j);

	}

	public BufferedImage getImage() {
		try {
			image = ImageIO.read(new File("IS_Spaceship.png"));

		} catch (IOException ex) {
			System.out.println("missing starship");
		}

		return image;

	}

	public int getX() {
		return DEF_START_X;
	}

	public int getY() {
		return DEF_START_Y;
	}

	public void addX(int x) {
		DEF_START_X += x;
	}

	public void subtractX(int x) {
		DEF_START_X -= x;

	}
}

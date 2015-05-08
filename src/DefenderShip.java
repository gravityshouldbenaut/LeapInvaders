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

	// public static final int LEFT = 0;
	// public static final int RIGHT = 1;
	// public static final int UP = 2;
	// public static final int DOWN = 3;
	// private double x;
	// private double y;
	// private double stepSize;
	// public DefenderShip(double x ,double y ){
	// this.x = x;
	// this.y = y;
	// stepSize = 0.05;
	// }
	// public void move(int direction) {
	// switch (direction) {
	// case LEFT:
	// x -= stepSize;
	// break;
	// case RIGHT:
	// x += stepSize;
	// break;
	// case UP:
	// y += stepSize;
	// break;
	// case DOWN:
	// y -= stepSize;
	// break;
	// }
	// }
	//
	//
	// public void draw(){
	// StdDraw.picture(x, y, "IS_Spaceship.jpg");
	// }
	//
}

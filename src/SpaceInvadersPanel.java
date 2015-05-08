import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class SpaceInvadersPanel extends JPanel implements ActionListener {

	private static int ALIEN1_START_X = 100;

	private static int ALIEN2_START_X = 350;

	private static int ALIEN3_START_X = 550;

	private static int ALIEN4_START_X = 800;

	DefenderShip defShip;
	AlienShip alien1;
	AlienShip alien2;
	AlienShip alien3;
	AlienShip alien4;
	Bullet b1;

	List<Bullet> alienBullets = new ArrayList<Bullet>(),
			defenderBullets = new ArrayList<Bullet>();

	List<Shield> shieldList = new ArrayList<Shield>();
	List<AlienShip> alienList = new ArrayList<AlienShip>();

	int x, y;
	int numClicks = 0;
	Timer gameTimer;

	private int circleX;
	private int circleY;
	private Timer timer;
	double count = 0;

	private class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			count++;
			System.out.println(count);

		}

	}

	public SpaceInvadersPanel() {
		this.setPreferredSize(new Dimension(1000, 800));

		gameTimer = new Timer(10, this);
		setUpKeyBindings();
		setUpDefender();
		timer = new Timer(1000, new TimerListener());
		timer.start();
		// gameTimer.start();
	}

	private void setUpAliens() {

		for (int x = 0; x < 11; x++) {
			for (int y = 0; y < 5; y++) {
				alienList.add(new AlienShip(x * 80, y * 50));
			}
		}

	}
	
	private void setUpKeyBindings() {
		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "fire");
		this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");
		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");
		this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "down");
		this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
		this.getActionMap().put("fire", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				launchWeapon();
			}
		});
		this.getActionMap().put("right", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefenderDir(1);// 1 moves right, 0 moves left
			}

		});
		this.getActionMap().put("left", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefenderDir(0);// 1 moves right, 0 moves left
			}

		});

	}

	protected void setDefenderDir(int i) {
		if (i == 0) {
			System.out.println("Ship will move left");
			defShip.subtractX(10);
			repaint();
		} else if (i == 1) {
			System.out.println("Ship will move right");
			defShip.addX(10);
			repaint();
		}

	}

	protected void launchWeapon() {
		System.out.println("Launching weapon now!!");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// what do you want to do every 10th of a second?
		System.out.println("just clicked! " + numClicks);
		moveEverything();
		checkForCollision();
		repaint();
	}

	private boolean checkForCollision() {
		return true;
	}

	private void moveEverything() {

	}

	private void alienBulletAction() {

	}

	private BufferedImage image;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			image = ImageIO.read(new File("starsbg.jpg"));

		} catch (IOException ex) {
			System.out.println("missing background");
		}
		g.drawImage(image, 0, 0, null);
		defShip = new DefenderShip(g, this);
		setUpAliens();
		for (AlienShip a : alienList) {
			a.addToThisGraphics(g, this);
		}

	}

	public void start() {
		System.out.println("Just started a new game...");
		this.gameTimer.start();

	}

}

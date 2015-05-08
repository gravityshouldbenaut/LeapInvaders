import javax.swing.JFrame;

public class Main {
	static JFrame j;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpaceInvadersPanel panel = new SpaceInvadersPanel();
		j = new JFrame();
		j.setVisible(true);
		j.setSize(1000, 800);
		j.add(panel);

	}

}

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class information {
	private Rectangle information;

	private int RectX = 700;
	private int RectY = 780;
	private int grid = 50;
	private int width = 100;
	private int height = 50;

	private int lives;
	private int time;

	private World game;

	public information(int lives, int time, World game) {

		this.lives = lives;
		this.game = game;
		this.time = time;

	}

	public Rectangle getRect() {

		return new Rectangle(RectX, RectY, width, height);
	}

	public void drawOn(Graphics2D g2) {
		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.magenta);

//		information = new Rectangle(RectX, RectY, width, height);
		g.drawString("Life: " + lives, 700, 830);
//		g.fill(information);

	}

}

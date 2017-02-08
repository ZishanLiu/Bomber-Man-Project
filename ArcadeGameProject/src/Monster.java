import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Monster {
	private Rectangle rect;
	private double RectX;
	private double RectY;
	private Hero myhero;
	private World myWorld;
	private int grid = 50;
	private int side = 30;

	public Monster(Hero myhero, World myWorld) {
		rect = new Rectangle();
		this.myhero = myhero;
		this.myWorld = myWorld;
		rect.height = this.side;
		rect.width = this.side;
		int x = -10;
		int y = -10;

		this.RectX = (x * grid) + grid / 2;
		this.RectY = (y * grid) + grid / 2;

	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.RED);

		Rectangle myMonster = new Rectangle((int) RectX + 10, (int) RectY + 10, 20, 30);

		g.fill(myMonster);
	}

	public void set(int x, int y) {

		this.RectX = (x * grid) + grid / 2;
		this.RectY = (y * grid) + grid / 2;

	}

	public void stop() {

		;

	}

	public void moveUpandDown() {
		RectY -= 1;

	}

	public void moveLeftandRight() {
		RectX += 1;

	}

	public void moveForMonster3() {

		RectY -= 1;

	}

}

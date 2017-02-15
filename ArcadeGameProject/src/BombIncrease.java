import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BombIncrease implements PowerUps {
	private Rectangle moreBomb;
	private Hero myHero;

	private int RectX = 400;
	private int RectY = 287;
	private int grid = 50;
	private int side = 25;
	private WorldComponent myComponent;

	public BombIncrease(Hero myHero, WorldComponent myComponent) {
		this.moreBomb = moreBomb;
		this.myHero = myHero;
		this.myComponent = myComponent;
	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.pink);

		moreBomb = new Rectangle(RectX, RectY, side, side);

		g.fill(moreBomb);
	}

	public Rectangle getRect() {

		return new Rectangle(RectX, RectY, side, side);

	}

	public void set(int x, int y) {

		this.RectX = (x * grid) + grid / 2 + 10;
		this.RectY = (y * grid) + grid / 2 + 10;

	}

	public boolean getPowerup() {

		if (myHero.getBounds2D().intersects(this.getRect())) {
			myComponent.newBomb();
			side = 0;
			System.out.println("More!");
			return true;

		}

		return false;
	}
}

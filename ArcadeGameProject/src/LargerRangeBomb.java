import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class LargerRangeBomb implements PowerUps{

	private Rectangle RangeBomb;
	private Hero myHero;

	private int RectX = 240;
	private int RectY = 287;
	private int grid = 50;
	private int side = 25;
	private WorldComponent myComponent;

	public LargerRangeBomb(Hero myHero, WorldComponent myComponent) {
		this.RangeBomb = RangeBomb;
		this.myHero = myHero;
		this.myComponent = myComponent;

	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.WHITE);

		RangeBomb = new Rectangle(RectX, RectY, side, side);

		g.fill(RangeBomb);
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
			myComponent.increaseRange();
			side = 0;
			System.out.println("big");
			return true;

		}

		return false;
	}

	public void setHero(Hero hero) {
		this.myHero = hero;
		
	}

}

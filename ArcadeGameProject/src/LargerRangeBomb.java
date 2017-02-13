import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class LargerRangeBomb {

	private Rectangle RangeBomb;
	private Hero myHero;

	private int RectX = 238;
	private int RectY = 285;

	public LargerRangeBomb(Hero myHero) {
		this.RangeBomb = RangeBomb;
		this.myHero = myHero;
		
	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.WHITE);

		Rectangle Bomb = new Rectangle(RectX, RectY, 25, 25);

		g.fill(Bomb);
	}

	public Rectangle getRect() {

		return new Rectangle(238,285,25,25);

	}
	
}

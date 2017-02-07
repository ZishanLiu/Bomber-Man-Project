import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Monster  {

	private int x = 500;
	private int y = 110;
	private Hero myhero;
	private World myWorld;

	public Monster(Hero myhero, World myWorld) {
		System.out.println("Creating monster");
		this.myhero = myhero;
		this.myWorld = myWorld;

	}

	public void drawOn(Graphics2D g2) {
		//System.out.println("drawing " + y);
		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.RED);

		Rectangle myMonster = new Rectangle(x, y, 20, 30);

		g.fill(myMonster);
	}

	public void moveUpandDown() {
		//System.out.println("move " + y);
		this.y = this.y + 20;
	}
}

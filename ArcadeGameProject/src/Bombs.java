import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Bombs extends JComponent {

	private int x = 0;
	private int y = 0;
	private Rectangle myBomb;
	private Color color;
	private Hero myHero;
	private World game;
	private int start;
	private int end;

	public Bombs(Hero myHero, World game) {

		this.myBomb = new Rectangle(0, 0, 0, 0);
		this.color = Color.black;
		this.myHero = myHero;
		this.game = game;
	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.black);

		myBomb = new Rectangle(x - 10, y - 10, 10, 10);

		g.fill(myBomb);

	}

	public void drop() {
		if (this.CanReplace()) {
			x = myHero.getX();
			y = myHero.getY();
			start = this.game.myworld.getCount();
			end = start + 100;
		}

	}

	public boolean explode(int current) {
		if (end == current) {
			return true;
		} else
			return false;

	}

	public boolean CanReplace() {
		if (this.game.myworld.getCount() > end) {
			return true;
		} else {
			return false;
		}

	}

	public void move() {
		x = -10;
		y = -10;

	}

}

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Bombs extends JComponent {

	private int x = 0;
	private int y = 0;
	private int radius = 10;
	private Color color;
	private Hero myHero;
	private World game;
	private int start;
	private int end;
	private ArrayList<Walls> WB;

	public Bombs(Hero myHero, World game) {

		this.color = Color.black;
		this.myHero = myHero;
		this.game = game;
		this.WB = game.WB;
	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.black);

		Rectangle myBomb = new Rectangle(x, y, radius, radius);

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
		radius = 10;

	}

	public void grow() {
		radius = 100;
		for (Walls wallb : WB) {
			if (wallb.getRect().intersects(this.getBounds())) {
				wallb.die(wallb);
			}
		}
	}

}

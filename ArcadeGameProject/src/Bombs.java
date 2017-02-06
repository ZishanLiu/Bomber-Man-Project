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

	public Bombs(Hero myHero) {

		this.myBomb = new Rectangle(0, 0, 0, 0);
		this.color = Color.black;
		this.myHero = myHero;
	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.black);

		myBomb = new Rectangle(x - 10, y - 10, 10, 10);

		g.fill(myBomb);

	}

	public void drop() {
		x = myHero.getX();
		y = myHero.getY();
		this.explode();

	}

	public boolean explode() {
		x = -10;
		y = -10;
		return true;
	}

}

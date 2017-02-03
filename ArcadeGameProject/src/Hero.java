import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Hero extends JComponent {

	private int x = 0;
	private int y = 0;
	private Rectangle rect;
	private Rectangle rect2;
	private Color color;

	public Hero() {

		this.color = Color.black;
		rect = new Rectangle(0, 0, 30, 30);
		rect2 = new Rectangle(0, 0, 15, 15);

	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.blue);
		rect = new Rectangle(x, y, 30, 30);
		rect2 = new Rectangle(x, y, 20, 20);
		g.fill(rect);
		g.fill(rect2);
	}

	public void moveRight() {

		x = x + 10;

	}

	public void moveLeft() {
		x = x - 10;
	}

	public void moveUp() {
		y = y - 10;

	}

	public void moveDown() {
		y = y + 10;

	}

	public int getX() {
		return rect.x + 20;
	}

	public int getY() {
		return rect.y + 20;
	}

}
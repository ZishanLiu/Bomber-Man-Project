import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Hero extends JComponent {

	// private int x = 0;
	// private int y = 0;
	private Rectangle rect;
	private double RectX;
	private double RectY;
	private int grid = 50;

	private Color color;
	private int side = 30;
	private ArrayList<Walls> WI;
	private ArrayList<Walls> WB;

	// public Hero(int x, int y) {
	// rect = new Rectangle();
	// rect.height = this.side;
	// rect.width = this.side;
	//
	// this.RectX = (x * grid) + grid / 2;
	// this.RectY = (y * grid) + grid / 2;
	//
	// this.color = Color.black;
	//
	// }
	public Hero(ArrayList<Walls> WI, ArrayList<Walls> WB) {
		rect = new Rectangle();
		rect.height = this.side;
		rect.width = this.side;
		int x = -10;
		int y = -10;

		this.RectX = (x * grid) + grid / 2;
		this.RectY = (y * grid) + grid / 2;

		this.color = Color.black;

		this.WI = WI;
		this.WB = WB;

	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.blue);
		rect = new Rectangle((int) RectX + 10, (int) RectY + 10, side, side);

		g.fill(rect);

	}

	public void set(int x, int y) {

		this.RectX = (x * grid) + grid / 2;
		this.RectY = (y * grid) + grid / 2;

	}

	public void moveRight() {

		RectX = RectX + 2;

	}

	public void moveLeft() {
		RectX = RectX - 2;
	}

	public void moveUp() {
		RectY = RectY - 2;

	}

	public void moveDown() {
		RectY = RectY + 2;

	}

	public int getX() {
		return (int) rect.getCenterX();
	}

	public int getY() {
		return (int) rect.getCenterY();
	}

	public Rectangle2D getBounds2D() {
		return rect;
	}

	public boolean checkContact() {
		for (Walls wall : WI) {
			if (wall.getRect().intersects(this.getBounds2D())) {
				//System.out.println(WI.get(.getRect().getMinX());
				//System.out.println(this.getBounds2D().getMaxX());
				return true;
			}

		}
		return false;
	}
}

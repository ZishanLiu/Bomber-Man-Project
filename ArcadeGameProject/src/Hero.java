import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Hero {

	private Rectangle rect;
	private int RectX;
	private int RectY;
	private int grid = 50;

	private Color color;
	private int side = 30;
	private ArrayList<Walls> WI;
	private ArrayList<Walls> WB;
	private Bombs myBomb;
	private char bombPlacement;
	private World game;

	public Hero(ArrayList<Walls> WI, ArrayList<Walls> WB, Bombs myBomb, World mygame) {
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
		this.myBomb = myBomb;
		this.bombPlacement = 'u';
		this.game = mygame;

		rect = new Rectangle(this.RectX, this.RectY, side, side);

	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.blue);
		rect = new Rectangle(RectX, RectY, side, side);

		g.fill(rect);

	}

	public void set(int x, int y) {

		this.RectX = (x * grid) + grid / 2 + 10;
		this.RectY = (y * grid) + grid / 2 + 10;

	}

	public void stuck(int x, int y) {

		this.RectX = x;
		this.RectY = y;

	}

	public char whereToPlaceBomb() {

		return bombPlacement;
	}

	public void moveRight() {
		if (!game.isPaused) {
			RectX = RectX + 5;
			bombPlacement = 'r';
		}
	}

	public void moveLeft() {
		if (!game.isPaused) {
			RectX = RectX - 5;
			bombPlacement = 'l';
		}
	}

	public void moveUp() {
		if (!game.isPaused) {
			RectY = RectY - 5;
			bombPlacement = 'u';
		}
	}

	public void moveDown() {
		if (!game.isPaused) {
			RectY = RectY + 5;
			bombPlacement = 'd';
		}

	}

	public int getX() {
		return RectX;
	}

	public int getY() {
		return RectY;
	}

	public void setBomb(Bombs mybomb) {
		this.myBomb = mybomb;

	}

	public Rectangle2D getBounds2D() {
		return new Rectangle(RectX, RectY, side, side);
	}

	public boolean checkContact() {
		if (myBomb.getRectangle().intersects(this.getBounds2D())) {
			return true;
		}
		for (Walls walli : WI) {
			if (walli.getRect().intersects(this.getBounds2D())) {
				return true;
			}
		}
		for (Walls wallb : WB) {
			if (wallb.getRect().intersects(this.getBounds2D())) {
				return true;
			}

		}

		return false;
	}


}

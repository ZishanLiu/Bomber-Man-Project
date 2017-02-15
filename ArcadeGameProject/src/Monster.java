import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;

public class Monster {

	private int RectX;
	private int RectY;
	private Hero myhero;
	private World myWorld;
	private int grid = 50;
	private int side = 30;
	private int counter = 0;
	private int moveXby = 5;
	private int moveYby = 5;

	private int type;

	private ArrayList<Walls> WI;
	private ArrayList<Walls> WB;

	public Monster(Hero myhero, World myWorld, ArrayList<Walls> WI, ArrayList<Walls> WB, int type) {
		this.myhero = myhero;
		this.myWorld = myWorld;
		int x = -10;
		int y = -10;
		this.type = type;
		this.WI = WI;
		this.WB = WB;

		this.RectX = (x * grid) + grid / 2;
		this.RectY = (y * grid) + grid / 2;

	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.RED);

		Rectangle myMonster = new Rectangle((int) RectX, (int) RectY, 20, 30);

		g.fill(myMonster);
	}

	public void set(int x, int y) {

		this.RectX = (x * grid) + grid / 2 + 10;
		this.RectY = (y * grid) + grid / 2 + 10;

	}

	public int getX() {
		return RectX;
	}

	public int getY() {
		return RectY;
	}

	public void stuck(int x, int y) {

		this.RectX = x;
		this.RectY = y;

	}

	public void move(int x, int y, int direction) {
		moveYby = moveYby * direction;
		moveXby = moveXby * direction;
		RectY = RectY + moveYby * y;
		RectX = RectX + moveXby * x;
	}

	public Rectangle2D getBounds2D() {
		return new Rectangle(RectX, RectY, side, side);
	}

	public boolean checkContact() {
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

	public Rectangle getRect() {

		return new Rectangle(RectX, RectY, 20, 30);

	}

	public void die() {

		this.RectX = -50;
		this.RectY = -50;

	}

	public void setHero(Hero hero) {
		this.myhero = hero;
	}

	public boolean checkHero() {
		try {
			if (myhero.getBounds2D().intersects(this.getRect())) {
				System.out.println("die");
				myWorld.retry();
				return true;
			}
		} catch (IOException exception) {
			throw new RuntimeException("failed checking hero vs monster");
		}

		return false;
	}

	public void disappear() {

		this.side = 0;

	}

	public int getType() {

		return this.type;

	}

}

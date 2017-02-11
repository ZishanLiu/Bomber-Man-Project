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

	private ArrayList<Walls> WI;
	private ArrayList<Walls> WB;

	public Monster(Hero myhero, World myWorld, ArrayList<Walls> WI, ArrayList<Walls> WB) {
		this.myhero = myhero;
		this.myWorld = myWorld;
		int x = -10;
		int y = -10;

		this.WI = WI;
		this.WB = WB;

		this.RectX = (x * grid) + grid / 2;
		this.RectY = (y * grid) + grid / 2;

	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.RED);

		Rectangle myMonster = new Rectangle((int) RectX + 10, (int) RectY + 10, 20, 30);

		g.fill(myMonster);
	}

	public void set(int x, int y) {

		this.RectX = (x * grid) + grid / 2;
		this.RectY = (y * grid) + grid / 2;

	}

	public void stop() {

		;

	}

	public void moveUpandDown() {
		if (!myWorld.myMonster.checkContact()) {

			RectY = RectY + moveXby;

		} else if (myWorld.myMonster.checkContact()) {
			moveYby = moveYby * -1;
			RectY = RectY + moveYby;
		}

	}

	public void moveLeftandRight() {
		counter = 0;
		if (!myWorld.myMonster.checkContact()) {

			RectX = RectX + moveXby;

		} else if (myWorld.myMonster.checkContact()) {
			moveXby = moveXby * -1;
			RectX = RectX + moveXby;
		}
	}

	public void moveForMonster3() {

		RectY -= 1;

	}

	public void hit() {
		this.RectX -= 5;

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

		return new Rectangle(RectX + 10, RectY + 10, 20, 30);

	}

	public void die() {

		this.RectX = -50;
		this.RectY = -50;

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

	{

	}

}

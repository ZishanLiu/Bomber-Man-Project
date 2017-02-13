import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Bombs {

	private int x = 0;
	private int y = 0;
	private int side;
	private Color color;
	private Hero myHero;
	private World game;
	private int start;
	private int end;
	private ArrayList<Walls> WB;
	private ArrayList<Monster> Monsters;
	private Rectangle myBomb;

	public Bombs(Hero myHero, World game) {
		
		this.myBomb = new Rectangle(-10, -10, 10, 10);
		this.color = Color.black;
		this.myHero = myHero;
		this.game = game;
		this.WB = game.WB;
		this.side = 10;
		this.Monsters = game.Monsters;
	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.black);

		myBomb = new Rectangle(x, y, side, side);

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
		side = 10;

	}

	public void grow() {
		myBomb = new Rectangle((int)myBomb.getX(), (int)myBomb.getY(), 100, 100);
		
		System.out.println("looking");
		for (int w=0; w<WB.size();w++) {
			System.out.println("scanning walls ");
			if (WB.get(w).getRect().intersects(myBomb)) {
				System.out.println("found!" + WB.get(w));
				WB.remove(w);
			}
		}
		for (int m=0; m<Monsters.size();m++) {
			System.out.println("scanning monster ");
			if (Monsters.get(m).getRect().intersects(myBomb)) {
				System.out.println("killed monster" + Monsters.get(m));
				this.Monsters.remove(m);
			}
		}
//		if (myHero.getRect().intersects(this.getBounds())) {
//			myHero.die();
//		}
	}

}

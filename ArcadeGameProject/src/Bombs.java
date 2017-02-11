import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Bombs extends JComponent {

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

	public Bombs(Hero myHero, World game) {

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

		Rectangle myBomb = new Rectangle(x, y, side, side);

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
		side = 100;
		System.out.println("looking");
		for (Walls wallb : WB) {
			System.out.println("scanning walls " + wallb);
			if (wallb.getRect().intersects(this.getBounds())) {
				System.out.println("found!" + wallb);
				wallb.die(wallb);
				System.out.println("killed wall" + wallb);
			}
		}
		for (Monster monster : Monsters) {
			System.out.println("scanning monster " + monster);
			if (monster.getRect().intersects(this.getBounds())) {
				System.out.println("killed monster" + monster);
				monster.die();
			}
		}
//		if (myHero.getRect().intersects(this.getBounds())) {
//			myHero.die();
//		}
	}

}

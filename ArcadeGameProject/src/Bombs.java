import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
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
	private boolean status;
	private int range;

	public Bombs(Hero myHero, World game, int range) {

		this.myBomb = new Rectangle(-10, -10, 10, 10);
		this.color = Color.black;
		this.myHero = myHero;
		this.game = game;
		this.WB = game.WB;
		this.side = 10;
		this.Monsters = game.Monsters;
		this.range = 40;
		this.status = false;
	}

	public void drawOn(Graphics2D g2) {

		Graphics2D g = (Graphics2D) g2;
		if (this.status) {
			g.setColor(new Color(204, 81, 0));
		} else {
			g.setColor(Color.black);
		}

		this.myBomb = new Rectangle(this.x, this.y, this.side, this.side);

		g.fill(this.myBomb);

		if (this.status) {
			g.fill(new Rectangle(this.x - range, this.y - range, (range * 2) + side, (range * 2) + side));
		}
	}

	public void drop() {
		if (!game.isPaused) {
			int HeroCenterX = this.myHero.getX() + 10;
			int HeroCenterY = this.myHero.getY() + 10;
			if (this.CanReplace()) {
				if (this.myHero.whereToPlaceBomb() == 'u') {
					this.x = HeroCenterX;
					this.y = HeroCenterY - 30;
				}
				if (this.myHero.whereToPlaceBomb() == 'd') {
					this.x = HeroCenterX;
					this.y = HeroCenterY + 30;
				}
				if (this.myHero.whereToPlaceBomb() == 'l') {
					this.x = HeroCenterX - 30;
					this.y = HeroCenterY;
				}
				if (this.myHero.whereToPlaceBomb() == 'r') {
					this.x = HeroCenterX + 30;
					this.y = HeroCenterY;
				}
				this.start = this.game.myworld.getCount();
				this.end = this.start + 100;
			}
		}

	}

	public boolean explode(int current) {
		if (this.end == current && !game.isPaused) {
			return true;
		}
		return false;

	}

	public boolean CanReplace() {
		if (this.game.myworld.getCount() > this.end) {
			return true;
		} else {
			return false;
		}

	}

	public void move() {
		this.status = false;
		this.x = -10;
		this.y = -10;
		this.side = 10;

	}

	public Rectangle getRectangle() {
		this.myBomb = new Rectangle((int) this.myBomb.getX(), (int) this.myBomb.getY(), side, side);
		return this.myBomb;
	}

	public boolean checkHero() {
		if (this.status == true) {
			System.out.println(this.status);
			try {
				if (this.myHero.getBounds2D().intersects(this.myBomb)) {
					System.out.println("die");
					this.game.retry();
					return true;
				}
			} catch (IOException exception) {
				throw new RuntimeException("failed checking hero vs bomb");
			}
		}

		return false;
	}

	public void grow() {
		this.status = true;
		this.myBomb = new Rectangle((int) this.myBomb.getX() - range, (int) this.myBomb.getY() - range,
				(range * 2) + side, (range * 2) + side);

	}

	public void check() {
		for (int w = 0; w < this.WB.size(); w++) {
			if (this.WB.get(w).getRect().intersects(this.myBomb)) {
				this.WB.remove(w);
				w--;
			}
		}
		for (int m = 0; m < this.Monsters.size(); m++) {
			if (this.Monsters.get(m).getRect().intersects(this.myBomb)) {
				this.Monsters.remove(m);
				m--;
			}
		}
	}

	public void largerRange() {

		this.range = 80;

	}

}

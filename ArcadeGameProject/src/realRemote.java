import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

public class realRemote {

	private int x = -10;
	private int y = -10;
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

	private int count = 0;

	public realRemote(Hero myHero, World game, int range) {

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
			char c = this.myHero.whereToPlaceBomb();
			if (c == 'u') {
				this.x = HeroCenterX;
				this.y = HeroCenterY - 30;
			}
			if (c == 'd') {
				this.x = HeroCenterX;
				this.y = HeroCenterY + 30;
			}
			if (c == 'l') {
				this.x = HeroCenterX - 30;
				this.y = HeroCenterY;
			}
			if (c == 'r') {
				this.x = HeroCenterX + 30;
				this.y = HeroCenterY;
			}

		}

	}

	public void explode() {
		this.status = true;

	}

	public boolean canExplode() {
		return this.status;

	}

	public boolean explodeLimit(int current) {
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

	public void setEnd(int end) {
		this.end = end;
	}

	public int getCount() {
		return this.game.myworld.getCount();
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

	public boolean explodeWait() {
		if (this.end + 2 == this.game.myworld.getCount()) {
			return true;
		}
		return false;
	}

}

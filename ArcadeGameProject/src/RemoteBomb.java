import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class RemoteBomb implements PowerUps {
	private Rectangle remoteBomb;
	private Hero myHero;

	private int RectX = 650;
	private int RectY = 287;
	private int grid = 50;
	private int side = 25;
	
	private realRemote realRemote;
	
	private ArrayList<Walls> WB;
	private ArrayList<Monster> Monsters;
	
	private int range = 80;
	
	private World game;
	
	
	public RemoteBomb(Hero myHero,World game, realRemote realRemote){
		
		this.myHero = myHero;
		this.game = game;
		this.realRemote = realRemote;
		this.remoteBomb = remoteBomb;
		
	}

	@Override
	public boolean getPowerup() {
		if (myHero.getBounds2D().intersects(this.getRect())) {
			side = 0;
			System.out.println("Remote");
			return true;
		}

		return false;
	}

	@Override
	public void set(int x, int y) {
		this.RectX = (x * grid) + grid / 2 + 10;
		this.RectY = (y * grid) + grid / 2 + 10;
		
	}

	@Override
	public Rectangle getRect() {
		
		return new Rectangle(RectX, RectY, side, side);
	}

	@Override
	public void drawOn(Graphics2D g2) {
		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.magenta);

		remoteBomb = new Rectangle(RectX, RectY, side, side);

		g.fill(remoteBomb);
		
	}
	


}

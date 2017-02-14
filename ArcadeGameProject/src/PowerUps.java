import java.awt.Graphics2D;
import java.awt.Rectangle;

public class PowerUps {

	private Rectangle myPowerUp;
	private World game;
	private int side = 30;
	
	public PowerUps(int x, int y, char type, World game) {
		myPowerUp = new Rectangle();
		myPowerUp.height = side;
		myPowerUp.width = side;
		myPowerUp.setLocation(x, y);
		
		this.game = game;
		
		myPowerUp = new Rectangle(x, y, side, side);
	}
	public void drawOn(Graphics2D g2) {
		g2.fill(myPowerUp);
	}
	
	
}

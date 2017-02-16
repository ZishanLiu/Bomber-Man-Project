import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface PowerUps {
	public boolean getPowerup();

	public void set(int x, int y);

	public Rectangle getRect();

	public void drawOn(Graphics2D g2);

}

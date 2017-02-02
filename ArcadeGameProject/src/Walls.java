import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Walls {
	
	private Rectangle rect;
	private double rectCenterX;
	private double rectCenterY;
	private int side = 50;
	private Color rectColor = Color.GRAY;
	
	public Walls(int x, int y) {
		rect = new Rectangle();
		rect.height = side;
		rect.width = side;
		rectCenterX = x * (side/2);
		rectCenterY = 250 + (y + (side/2));
	}
	
	public void drawOn(Graphics2D graphics2) {
		graphics2.setColor(rectColor);
		graphics2.fillRect(
				(int)rectCenterX, 
				(int)rectCenterY, 
				side, 
				side);
	}
}

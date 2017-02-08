import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Walls extends JComponent {

	private Rectangle rect;
	private double rectCenterX;
	private double rectCenterY;
	private int side = 50;
	private Color wallColor = Color.GRAY;
	private Color brickColor = Color.ORANGE;
	private World game;
	private Hero hero;

	/*
	 * This is the constructor for the each individual wall
	 * 
	 * @param x and y - Sets the center of each wall based on our coded coordinate
	 * 		system.
	 * 		
	 */
	public Walls(int x, int y, World game) {
		rect = new Rectangle();
		rect.height = side;
		rect.width = side;
		rectCenterX = (x * side) + side / 2;
		rectCenterY = (y * side) + side / 2;
		this.game = game;
		this.hero = game.hero;
	}

	/*
	 * This is the function that draws each wall as desired by each particular
	 * level layout.
	 * 
	 * @param graphics2 - The graphics object on which to draw
	 * 		b - determines if the wall is brick or concrete
	 * 
	 */
	public void drawOn(Graphics2D g2, char b) {
		if(b == 'b') {
			g2.setColor(brickColor);
		} else {
			g2.setColor(wallColor);
		}
		g2.fillRect((int) rectCenterX, (int) rectCenterY, side, side);
	}
	
	public void die(Walls wall) {
		rect.setSize(0, 0);
	}
}


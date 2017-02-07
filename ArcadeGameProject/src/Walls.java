import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Walls {

	private Rectangle rect;
	private double rectCenterX;
	private double rectCenterY;
	private int side = 50;
	private Color wallColor = Color.GRAY;
	private Color brickColor = Color.ORANGE;

	/*
	 * This is the constructor for the each individual wall
	 * 
	 * @param x and y - Sets the center of each wall based on our coded coordinate
	 * 		system.
	 * 		
	 */
	public Walls(int x, int y) {
		rect = new Rectangle();
		rect.height = side;
		rect.width = side;
		rectCenterX = (x * side) + side / 2;
		rectCenterY = (y * side) + side / 2;
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
	
	/*
	 * This function is used to tell the hero whether he is able to move in the direction the 
	 * user has requested.
	 * 
	 * @param hero - gives our hero and his positions and width
	 * 
	 * @return - False if within the borders of the walls
	 */
	public boolean checkContact(Hero hero, String str) {
		int heroCenterX = hero.getX();
		int heroCenterY = hero.getY();
		if(str.equals("Right")) {
			heroCenterX += .1;
		} else if(str.equals("Left")) {
			heroCenterX -= .1;
		} else if(str.equals("Up")) {
			heroCenterY -= .1;
		} else {
			heroCenterY += .1;
		}
		return rect.getBounds2D().intersects(hero.getBounds2D());
	}
//			int heroCenterX = hero.getX();
//			int heroCenterY = hero.getY();
//			int heroSide = hero.getWidth();
//			if(str.equals("Right")) {
//				heroCenterX += 10;
//			} else if(str.equals("Left")) {
//				heroCenterX -= 10;
//			} else if(str.equals("Up")) {
//				heroCenterY -= 10;
//			} else {
//				heroCenterY += 10;
//			}
//			if(heroCenterX + heroSide/2 > rectCenterX - side/2 || heroCenterX - heroSide/2 < rectCenterX + side/2) {
//				if(heroCenterY - heroSide/2 < rectCenterY + side/2 || heroCenterY + heroSide/2 > rectCenterY - side/2) {
//					return false;
//				}
//			}
//			if(heroCenterY - heroSide/2 < rectCenterY + side/2 || heroCenterY + heroSide/2 > rectCenterY - side/2) {
//				if(heroCenterX + heroSide/2 > rectCenterX - side/2 || heroCenterX - heroSide/2 < rectCenterX + side/2) {
//					return false;
//				}
//			}
}


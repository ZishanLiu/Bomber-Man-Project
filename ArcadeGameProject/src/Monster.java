import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Monster extends JComponent implements Runnable {

	private int x = 500;
	private int y = 110;
	private Rectangle myMonster;
	private Hero myhero;
	private World myWorld;

	public Monster(Hero myhero,World myWorld) {
		this.myhero = myhero;
		this.myWorld = myWorld;
		this.myMonster = new Rectangle(500, 110, 20, 30);

	}

	public void drawOn(Graphics2D g2) {
		
		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.RED);

		myMonster = new Rectangle(x, y, 20, 30);
		
		g.fill(myMonster);
		repaint();
	
	}


	@Override
	public void run() {

		try {
			while (true) {

				moveUpandDown();
				Thread.sleep(10);

				
			}
		} catch (InterruptedException exception) {
			// TODO Auto-generated catch-block stub.
			throw new RuntimeException(" ");
		}

	}

	public void moveUpandDown() {
		System.out.println("move");
		y = y + 20;
	}
}

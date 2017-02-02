import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Hero extends Applet implements KeyListener {

	private Rectangle rect;
	private Rectangle rect2;

	public Hero() {

		rect = new Rectangle(0, 0, 50, 50);
		rect2 = new Rectangle(0, 0, 20, 20);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rect.setLocation(rect.x + 2, rect.y);

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			rect.setLocation(rect.x - 2, rect.y);

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			rect.setLocation(rect.x, rect.y + 2);

		} else if (e.getKeyCode() == KeyEvent.VK_UP) {

			rect.setLocation(rect.x, rect.y - 2);

		} else if (e.getKeyCode() == KeyEvent.VK_Z) {

			rect2.setLocation(rect.getLocation());

		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	public void drawOn(Graphics2D g2) {

		g2.setColor(Color.blue);
		rect = new Rectangle(0, 0, 50, 50);
		rect2 = new Rectangle(0, 0, 20, 20);
		g2.fill(rect);
		g2.fill(rect2);

	}

}

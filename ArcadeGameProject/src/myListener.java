import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class myListener implements KeyListener {

	private Hero myHero;

	public myListener(Hero myHero) {

		this.myHero = myHero;

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			myHero.moveRright();

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			myHero.moveLeft();

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			myHero.moveDown();

		} else if (e.getKeyCode() == KeyEvent.VK_UP) {

			myHero.moveUp();

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub.

	}

}
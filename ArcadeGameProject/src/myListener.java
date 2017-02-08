import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class myListener implements KeyListener {

	private Hero myHero;
	private World game;
	

	public myListener(Hero myHero, World game) {
		this.myHero = myHero;
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			myHero.moveRight();

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
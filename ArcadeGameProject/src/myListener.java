import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class myListener implements KeyListener {

	private Hero myHero;
	private World game;
	int startX;
	int startY;

	public myListener(Hero myHero, World game) {
		this.myHero = myHero;
		this.game = game;
		startX = myHero.getX();
		startY = myHero.getY();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			myHero.moveRight();
			System.out.println(game.hero.checkContact());
			if (!game.hero.checkContact()) {
				startX = myHero.getX();
				startY = myHero.getY();

			} else if (game.hero.checkContact()) {
				myHero.stuck(startX, startY);

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			myHero.moveLeft();
			if (!game.hero.checkContact()) {
				startX = myHero.getX();
				startY = myHero.getY();

			} else if (game.hero.checkContact()) {
				myHero.stuck(startX, startY);

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			myHero.moveDown();
			if (!game.hero.checkContact()) {
				startX = myHero.getX();
				startY = myHero.getY();

			} else if (game.hero.checkContact()) {
				myHero.stuck(startX, startY);

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			myHero.moveUp();
			if (!game.hero.checkContact()) {
				startX = myHero.getX();
				startY = myHero.getY();

			} else if (game.hero.checkContact()) {
				myHero.stuck(startX, startY);

			}
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
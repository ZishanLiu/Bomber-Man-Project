import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class myListener implements KeyListener {

	private Hero myHero;
	private World game;
	int startX;
	int startY;
	private Monster myMonster;

	public myListener(Hero myHero, World game, Monster myMonster) {
		this.myHero = myHero;
		this.game = game;
		startX = myHero.getX();
		startY = myHero.getY();
		this.myMonster = myMonster;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			myHero.moveRight();
			if (!game.hero.checkContact() && (!game.myMonster.checkHero())) {
				startX = myHero.getX();
				startY = myHero.getY();

			} else if (game.hero.checkContact()) {
				myHero.stuck(startX, startY);

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			myHero.moveLeft();
			if (!game.hero.checkContact() && (!game.myMonster.checkHero())) {
				startX = myHero.getX();
				startY = myHero.getY();

			} else if (game.hero.checkContact()) {
				myHero.stuck(startX, startY);

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			myHero.moveDown();
			if (!game.hero.checkContact() && (!game.myMonster.checkHero())) {
				startX = myHero.getX();
				startY = myHero.getY();

			} else if (game.hero.checkContact()) {
				myHero.stuck(startX, startY);

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			myHero.moveUp();
			if (!game.hero.checkContact() && (!game.myMonster.checkHero())) {
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
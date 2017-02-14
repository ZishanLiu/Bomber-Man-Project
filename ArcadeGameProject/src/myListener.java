import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class myListener implements KeyListener {

	private Hero myHero;
	private World game;
	int startX;
	int startY;
	// private Monster myMonster;

	public myListener(Hero myHero, World game) {
		this.myHero = myHero;
		this.game = game;
		startX = myHero.getX();
		startY = myHero.getY();
		// this.myMonster = myMonster;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			myHero.moveRight();

		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			myHero.moveLeft();

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			myHero.moveDown();

		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			myHero.moveUp();

		}
		for (int i = 0; i < game.Monsters.size(); i++) {
			game.Monsters.get(i).checkHero();
		}

		if (!game.hero.checkContact()) {
			startX = myHero.getX();
			startY = myHero.getY();

		} else {
			myHero.stuck(startX, startY);

		}

		if (game.rangeBomb.getPowerup()) {

			System.out.println("get");

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
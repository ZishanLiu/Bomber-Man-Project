import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class myListener implements KeyListener {

	private Hero myHero;
	private World game;

	public myListener(Hero myHero) {
		this.game = game;
		this.myHero = myHero;

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			for(int i = 0; i < game.WI.size() - 1; i++) {
				if(game.WI.get(i).checkContact(myHero, "Right")) {
					myHero.moveRight();
				} else {
					continue;
				}
			}

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			for(int i = 0; i < game.WI.size() - 1; i++) {
				if(game.WI.get(i).checkContact(myHero, "Left")) {
					myHero.moveLeft();
				} else {
					continue;
				}
			}
			
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			for(int i = 0; i < game.WI.size() - 1; i++) {
				if(game.WI.get(i).checkContact(myHero, "")) {
					myHero.moveDown();
				} else {
					continue;
				}
			}
			
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			for(int i = 0; i < game.WI.size() - 1; i++) {
				if(game.WI.get(i).checkContact(myHero, "Up")) {
					myHero.moveUp();
				} else {
					continue;
				}
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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BombListener implements KeyListener {

	private Bombs myBomb;
	private Hero myHero;

	public BombListener(Bombs myBomb) {

		this.myBomb = myBomb;

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_Z) {

			try {
				myBomb.drop();
			} catch (InterruptedException exception) {
				throw new RuntimeException("Failed bomb drop");
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

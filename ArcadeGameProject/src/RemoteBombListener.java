import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RemoteBombListener implements KeyListener {

	private RemoteBomb myRemote;
	private realRemote myReal;

	public RemoteBombListener(RemoteBomb remotebomb, realRemote realRemote) {
		this.myReal = realRemote;
		this.myRemote = remotebomb;
		// TODO Auto-generated constructor stub.
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_A) {
			if (myReal.CanReplace()) {

				myReal.drop();

			}
		}

		if (e.getKeyCode() == KeyEvent.VK_B) {

			myReal.grow();
			myReal.check();
			myReal.checkHero();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub.

	}

}

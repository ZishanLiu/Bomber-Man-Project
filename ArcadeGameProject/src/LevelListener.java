import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class LevelListener implements KeyListener {

	private World game;
	private String Level;

	public LevelListener(World game, String Level) {
		this.game = game;
		this.Level = Level;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_U) {
			if (this.Level == "Level1") {
				try {
					this.game.ChangeLevel("Level2");
				} catch (IOException exception) {
					throw new RuntimeException("Failed Level Load");
				}
			} else if (this.Level == "Level2") {
				try {
					this.game.ChangeLevel("Level3");
				} catch (IOException exception) {
					throw new RuntimeException("Failed Level Load");
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			if (this.Level == "Level3") {
				try {
					this.game.ChangeLevel("Level2");
				} catch (IOException exception) {
					throw new RuntimeException("Failed Level Load");
				}
			} else if (this.Level == "Level2") {
				try {
					this.game.ChangeLevel("Level1");
				} catch (IOException exception) {
					throw new RuntimeException("Failed Level Load");
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

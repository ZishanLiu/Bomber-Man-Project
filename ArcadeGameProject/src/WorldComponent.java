import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class WorldComponent extends JComponent {

	private ArrayList<Walls> WI;
	private Hero myhero;
	private Bombs myBomb;

	public void sethero(Hero myhero) {
		this.myhero = myhero;
	}

	public void setWI(ArrayList<Walls> WI) {
		this.WI = WI;
	}

	public void setBombs(Bombs myBomb) {
		this.myBomb = myBomb;
	}

	public WorldComponent() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.green);
		g2.fillRect(0, 0, 1100, 900);
		myhero.drawOn(g2);
		myBomb.drawOn(g2);

		for (int i = 0; i < WI.size(); i++) {
			WI.get(i).drawOn(g2);
		}
		repaint();

	}
}

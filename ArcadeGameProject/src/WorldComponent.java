import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class WorldComponent extends JComponent {

	private ArrayList<Walls> WI;

	public WorldComponent(ArrayList<Walls> WI) {
		this.WI = WI;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.green);
		g2.fillRect(0, 0, 1000, 1000);

		for (int i = 0; i < WI.size(); i++) {
			WI.get(i).drawOn(g2);
		}

	}
}

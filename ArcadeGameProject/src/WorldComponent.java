import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class WorldComponent extends JComponent implements Runnable {

	private ArrayList<Walls> WI;
	private Hero myhero;
	private Bombs myBomb;
	private ArrayList<Monster> Monsters;
	private ArrayList<Walls> WB;
	private int count = 0;
	private World myworld;

	public void sethero(Hero myhero) {
		this.myhero = myhero;
	}

	public void setWI(ArrayList<Walls> WI) {
		this.WI = WI;
	}

	public void setBombs(Bombs myBomb) {
		this.myBomb = myBomb;
	}

	public void setWB(ArrayList<Walls> WB) {
		this.WB = WB;
	}

	public void setMonster(ArrayList<Monster> myMonster) {

		this.Monsters = myMonster;

	}

	public int getCount() {

		return count;

	}

	public void setworld(World myworld) {
		this.myworld = myworld;
	}

	public WorldComponent() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.green);
		g2.fillRect(0, 0, 1100, 900);
		myworld.myMonster.checkHero();
		myhero.drawOn(g2);
		myBomb.drawOn(g2);

		for (int i = 0; i < Monsters.size(); i++) {
			Monsters.get(i).drawOn(g2);
		}

		for (int i = 0; i < WI.size(); i++) {
			WI.get(i).drawOn(g2, ' ');
		}
		for (int i = 0; i < WB.size(); i++) {
			WB.get(i).drawOn(g2, 'b');
		}
		// repaint();

	}

	@Override
	public void run() {
		try {
			while (true) {
				for (int i = 0; i < Monsters.size(); i++) {
					if (i == 0) {
						int startX = Monsters.get(i).getX();
						int startY = Monsters.get(i).getY();
						if (!Monsters.get(i).checkContact()) {

							Monsters.get(i).move(1, 0, 1);

							if (Monsters.get(i).checkContact()) {
								Monsters.get(i).stuck(startX, startY);
								Monsters.get(i).move(1, 0, -1);
							}
							// Monsters.get(i).moveLeftandRight();

						}
					}
					if (i == 1) {
						int startX = Monsters.get(i).getX();
						int startY = Monsters.get(i).getY();
						if (!Monsters.get(i).checkContact()) {

							Monsters.get(i).move(0, 1, 1);

							if (Monsters.get(i).checkContact()) {
								Monsters.get(i).stuck(startX, startY);
								Monsters.get(i).move(0, 1, -1);
							}
						}
						// Monsters.get(i).moveUpandDown();

					}
					if (i == 2) {
						int startX = Monsters.get(i).getX();
						int startY = Monsters.get(i).getY();
						int k = (int) (Math.round((Math.random())));
						if (!Monsters.get(i).checkContact()) {

							Monsters.get(i).move(k, 1 - k, 1);
							if (Monsters.get(i).checkContact()) {
								Monsters.get(i).stuck(startX, startY);
								Monsters.get(i).move(k, 1 - k, -1);
							}
						}
						if (!Monsters.get(i).checkContact()) {

							Monsters.get(i).move(k, 1 - k, 1);
							if (Monsters.get(i).checkContact()) {
								Monsters.get(i).stuck(startX, startY);
								Monsters.get(i).move(k, 1 - k, -1);
							}
						}
						if (!Monsters.get(i).checkContact()) {

							Monsters.get(i).move(k, 1 - k, 1);
							if (Monsters.get(i).checkContact()) {
								Monsters.get(i).stuck(startX, startY);
								Monsters.get(i).move(k, 1 - k, -1);
							}
						}

					}
				}
				if (myBomb.explode(count)) {
					myBomb.grow();
					System.out.println("growing started");
					myBomb.move();
					System.out.println("move started");

				} 
				if (Monsters.size() == 0) {
					myworld.next();
				}
				if (myworld.Lives == 0) {
					System.exit(0);
				}
				count++;
				repaint();
				Thread.sleep(20);

			}
		} catch (InterruptedException exception) {
			// TODO Auto-generated catch-block stub.
			throw new RuntimeException(exception.toString());
		}

	}
}

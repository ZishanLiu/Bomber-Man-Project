import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class WorldComponent extends JComponent implements Runnable {

	private ArrayList<Walls> WI;
	private Hero myhero;
	private Bombs myBomb;
	ArrayList<Monster> Monsters;
	private ArrayList<Walls> WB;
	private int count = 0;
	private World myworld;
	private LargerRangeBomb rangeBomb;

	private int range;

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

	public void setLargerRangeBomb(LargerRangeBomb rangeBomb) {

		this.rangeBomb = rangeBomb;

	}

	public int getCount() {

		return count;

	}

	public void increaseRange() {

		range = 200;
		this.myBomb.largerRange();

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
		for (int i = 0; i < Monsters.size(); i++) {
			this.myworld.Monsters.get(i).checkHero();

		}

		myworld.CheckWin();
		myBomb.checkHero();
		myhero.drawOn(g2);
		myBomb.drawOn(g2);
		rangeBomb.drawOn(g2);

		for (int i = 0; i < Monsters.size(); i++) {
			Monsters.get(i).drawOn(g2);
		}

		for (int i = 0; i < WI.size(); i++) {
			WI.get(i).drawOn(g2, ' ');
		}
		for (int i = 0; i < WB.size(); i++) {
			WB.get(i).drawOn(g2, 'b');
		}

	}

	@Override
	public void run() {
		System.out.println(myworld.isPaused);
		try {
			while (true) {
				for (int i = 0; i < Monsters.size(); i++) {
					if (!myworld.isPaused) {
						if (i == 0) {
							int startX = Monsters.get(i).getX();
							int startY = Monsters.get(i).getY();
							if (!Monsters.get(i).checkContact()) {

								Monsters.get(i).move(1, 0, 1);

								if (Monsters.get(i).checkContact()) {
									Monsters.get(i).stuck(startX, startY);
									Monsters.get(i).move(1, 0, -1);
								}

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
				}
				if (myBomb.explode(count)) {
					myBomb.grow();
					System.out.println("growing started");
					myBomb.checkHero();
					myBomb.check();
				}
				if (myBomb.explode(count - 5)) {
					System.out.println("move started");
					myBomb.move();

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

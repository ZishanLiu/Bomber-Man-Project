import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class World {
	private final JFileChooser chooser;
	private String level;
	private int time;
	ArrayList<Walls> WI = new ArrayList<Walls>();
	ArrayList<Walls> WB = new ArrayList<Walls>();
	// private Hero myHero = new Hero(0, 0);
	// private Bombs myBomb = new Bombs(myHero);
	JFrame myWindow = new JFrame();
	WorldComponent myworld = new WorldComponent();
	KeyListener change;
	Hero hero;
	Monster myMonster;

	public World(String level) {
		this.level = level;
		this.chooser = new JFileChooser();
		this.time = 200;
		change = new LevelListener(this, this.level);
		myWindow.addKeyListener(this.change);

	}

	public void load() throws IOException {

		myWindow.removeKeyListener(this.change);

		myWindow.setSize(1100, 900);
		myWindow.setTitle("BomberMan");

		File inputFile = new File(level);
		Scanner inScanner = new Scanner(inputFile);
		for (int y = 0; y < 15; y++) {
			if (inScanner.hasNextLine()) {
				String line = inScanner.nextLine();
				hero = new Hero();
				myMonster = new Monster(hero, this);
				for (int x = 0; x < 19; x++) {
					if (line.charAt(x) == ' ') {
						continue;
					} else if (line.charAt(x) == 'w') {
						Walls wall = new Walls(x, y, this);
						this.WI.add(wall);
					} else if (line.charAt(x) == 'h') {
						System.out.println("found hero " + x + " " + y);
						hero.set(x, y);
						Bombs myBomb = new Bombs(hero);
						KeyListener mykey = new myListener(hero, this);
						KeyListener myBombs = new BombListener(myBomb);
						myWindow.addKeyListener(mykey);
						myWindow.addKeyListener(myBombs);
						myworld.sethero(hero);
						myworld.setWI(WI);
						myworld.setWB(WB);
						myworld.setBombs(myBomb);
						// KeyListener myMonster = new MonsterListener(monster);
						// myWindow.addKeyListener(myMonster);

					} else if (line.charAt(x) == 'e') {

						myMonster.set(x, y);
						myworld.setMonster(myMonster);

						Thread t1 = new Thread(myworld);
						t1.start();

					} else if (line.charAt(x) == 'b') {
						Walls wall = new Walls(x, y, this);
						this.WB.add(wall);
					} else {
						throw new RuntimeException("Invalid Character in World Text File");

					}
				}
			}
		}

		// WorldComponent myworld = new WorldComponent(this.WI);
		change = new LevelListener(this, this.level);
		myWindow.addKeyListener(change);
		myWindow.add(myworld);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setVisible(true);
		inScanner.close();
	}

	public void ChangeLevel(String level) throws IOException {
		WI.clear();
		WB.clear();
		this.level = level;
		this.time = 200;
		this.load();
		System.out.println(level + " has loaded!");

	}

	public void reDraw() {

		myworld.repaint();

	}

}

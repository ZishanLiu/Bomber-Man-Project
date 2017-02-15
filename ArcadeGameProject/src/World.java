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
	ArrayList<Bombs> Bombs = new ArrayList<Bombs>();
	ArrayList<Monster> Monsters = new ArrayList<Monster>();

	JFrame myWindow = new JFrame();
	WorldComponent myworld = new WorldComponent();
	KeyListener change;
	Hero hero;
	Thread t1;
	Walls wall;
	int Lives;
	LargerRangeBomb rangeBomb;
	Bombs myBomb;
	Boolean isPaused;
	int range = 80;
	private BombIncrease moreBomb;

	public World(String level) {
		this.Lives = 3;
		this.level = level;
		this.chooser = new JFileChooser();
		this.time = 200;
		this.isPaused = false;
		change = new LevelListener(this, this.level);
		myWindow.addKeyListener(this.change);
		t1 = new Thread(myworld);

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
				for (int x = 0; x < 19; x++) {
					if (line.charAt(x) == ' ') {
						continue;
					} else if (line.charAt(x) == 'w') {
						wall = new Walls(x, y, this);
						this.WI.add(wall);
					} else if (line.charAt(x) == 'h') {
						hero = new Hero(WI, WB, Bombs, this);
						rangeBomb = new LargerRangeBomb(hero, myworld);
						hero.set(x, y);
						myBomb = new Bombs(hero, this, range);
						Bombs.add(myBomb);
						hero.setBomb(Bombs);
						moreBomb = new BombIncrease(hero, myworld);

						KeyListener mykey = new myListener(hero, this);
						KeyListener myBombs = new BombListener(Bombs);
						myWindow.addKeyListener(mykey);
						myWindow.addKeyListener(myBombs);
						myworld.setBombs(Bombs);
						myworld.sethero(hero);
						myworld.setworld(this);
						myworld.setBombIncrease(moreBomb);

					} else if (line.charAt(x) == 'e') {

						Monster myMonster = new Monster(hero, this, WI, WB, Monsters.size());
						myMonster.set(x, y);
						Monsters.add(myMonster);

					} else if (line.charAt(x) == 'b') {
						wall = new Walls(x, y, this);
						this.WB.add(wall);

					} else {
						throw new RuntimeException("Invalid Character in World Text File");

					}
				}
			}
		}
		if (myworld.getCount() < 1) {
			t1.start();
		}
		for (int m = 0; m < Monsters.size(); m++) {
			Monsters.get(m).setHero(hero);
		}
		myworld.setMonster(Monsters);
		myworld.setLargerRangeBomb(rangeBomb);
		myworld.setWI(WI);
		myworld.setWB(WB);
		change = new LevelListener(this, this.level);
		myWindow.addKeyListener(change);
		myWindow.add(myworld);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setVisible(true);
		inScanner.close();
	}

	public void ChangeLevel(String level) throws IOException {
		Monsters.clear();
		Bombs.clear();
		WI.clear();
		WB.clear();
		this.level = level;
		this.time = 200;
		this.load();
		System.out.println(level + " has loaded!");

	}

	public void retry() throws IOException {
		Lives -= 1;
		Monsters.clear();
		Bombs.clear();
		WI.clear();
		WB.clear();
		this.time = 200;
		this.load();
		System.out.println("You died! You have " + Lives + " left! Press any key to restart");

	}

	public void win() throws IOException {
		Monsters.clear();
		Bombs.clear();
		WI.clear();
		WB.clear();
		this.time = 200;
		this.level = next();
		this.load();
		System.out.println("Congradulations! You have " + Lives + "left!");

	}

	public String next() {
		if (this.level == "Level1") {
			return "Level2";
		} else {
			return "Level3";

		}

	}

	public void pause() {
		if (this.isPaused == false) {
			this.isPaused = true;
		} else {
			this.isPaused = false;
		}
	}

	public void CheckWin() {
		if (this.Monsters.size() == 0) {
			try {
				this.win();
			} catch (IOException exception) {

			}
		}

	}
}

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
	ArrayList<Monster> Monsters = new ArrayList<Monster>();
	// private Hero myHero = new Hero(0, 0);
	// private Bombs myBomb = new Bombs(myHero);
	JFrame myWindow = new JFrame();
	WorldComponent myworld = new WorldComponent();
	KeyListener change;
	Hero hero;
	Monster myMonster;
	Thread t1;
	Walls wall;
	int Lives;

	public World(String level) {
		this.Lives = 3;
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
				for (int x = 0; x < 19; x++) {
					if (line.charAt(x) == ' ') {
						continue;
					} else if (line.charAt(x) == 'w') {
						wall = new Walls(x, y, this);
						this.WI.add(wall);
					} else if (line.charAt(x) == 'h') {
						hero = new Hero(WI, WB);
						hero.set(x, y);
						Bombs myBomb = new Bombs(hero, this);
						KeyListener mykey = new myListener(hero, this);
						KeyListener myBombs = new BombListener(myBomb);
						myWindow.addKeyListener(mykey);
						myWindow.addKeyListener(myBombs);
						myworld.setBombs(myBomb);
						myworld.sethero(hero);
						myworld.setworld(this);
						// KeyListener myMonster = new MonsterListener(monster);
						// myWindow.addKeyListener(myMonster);

					} else if (line.charAt(x) == 'e') {

						myMonster = new Monster(hero, this, WI, WB);
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

		// WorldComponent myworld = new WorldComponent(this.WI);
		t1 = new Thread(myworld);
		t1.start();
		myworld.setMonster(Monsters);
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
		t1.stop();
		Monsters.clear();
		WI.clear();
		WB.clear();
		this.level = level;
		this.time = 200;
		this.load();
		System.out.println(level + " has loaded!");

	}

	public void retry() throws IOException {
		Lives -= 1;
		t1.stop();
		Monsters.clear();
		WI.clear();
		WB.clear();
		this.time = 200;
		this.load();
		System.out.println("You died! You have " + Lives + "left!");

	}

	public void win() throws IOException {
		t1.stop();
		Monsters.clear();
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
}

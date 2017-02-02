import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class World {
	private final JFileChooser chooser;
	private String level;
	private int time;
	ArrayList<Walls> WI = new ArrayList<Walls>();
	ArrayList<Walls> WB = new ArrayList<Walls>();
	private Hero myHero = new Hero();
	// ArrayList<Enemy> E = new ArrayList<Enemy>();

	public World(String level) {
		this.level = level;
		this.chooser = new JFileChooser();
		this.time = 200;

	}

	public void load() throws IOException {

		JFrame myWindow = new JFrame();
		JPanel myPanel = new JPanel();

		myWindow.setSize(1000, 1000);
		myWindow.setTitle("BomberMan");

		WorldComponent myworld = new WorldComponent();
		KeyListener mykey = new myListener(myHero);

		myWindow.addKeyListener(mykey);

		File inputFile = new File(level);
		Scanner inScanner = new Scanner(inputFile);
		for (int y = 0; y < 15; y++) {
			if (inScanner.hasNextLine()) {
				String line = inScanner.nextLine();
				for (int x = 0; x < 20; x++) {
					if (line.charAt(x) == ' ') {
						continue;
					} else if (line.charAt(x) == 'w') {
						Walls wall = new Walls(x, y);
						this.WI.add(wall);
					} else if (line.charAt(x) == 'h') {
						Hero hero = new Hero();
					} else if (line.charAt(x) == 'e') {
						continue;
					} else if (line.charAt(x) == 'b') {
						continue;
					} else {
						throw new RuntimeException("Invalid Character in World Text File");

					}
				}
			}
		}

		myworld.sethero(myHero);
		myworld.setWI(WI);

		// WorldComponent myworld = new WorldComponent(this.WI);
		myWindow.add(myworld);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setVisible(true);
		inScanner.close();
	}

}
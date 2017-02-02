import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class World {
	private final JFileChooser chooser;
	private String level;
	private int time;

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
		myWindow.add(new WorldComponent());

		// Hero myHero = new Hero();
		//
		// myWindow.add(myHero);

		File inputFile = new File(level);
		Scanner inScanner = new Scanner(inputFile);
		for (int x = 0; x < 15; x++) {
			if (inScanner.hasNextLine()) {
				String line = inScanner.nextLine();
				for (int y = 0; y < 20; y++) {
					if (line.charAt(y) == ' ') {
						return;
					} else if (line.charAt(y) == 'w') {
						return;
					} else if (line.charAt(y) == 'h') {
						return;
					} else if (line.charAt(y) == 'e') {
						return;
					} else if (line.charAt(y) == 'b') {
						return;
					} else {
						throw new RuntimeException("Invalid Character in World Text File");

					}
				}
			}
		}

		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setVisible(true);
		inScanner.close();
	}

}

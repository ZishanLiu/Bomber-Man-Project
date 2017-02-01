import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

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
		File inputFile = new File(level);
		Scanner inScanner = new Scanner(inputFile);
		while (inScanner.hasNext()) {
			String next = inScanner.next();
			if (next == " ") {
				return;
			} else if (next == "w") {
				return;
			} else if (next == "h") {
				return;
			} else if (next == "e") {
				return;
			} else if (next == "b") {
				return;
			} else {
				throw new RuntimeException("Invalid Character in World Text File");

			}
		}
		inScanner.close();
	}

}

package reader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import collect.CounterBrowser;

public class ReaderFile {

	String LINE;

	Scanner read;

	public void readFile() throws IOException {
		try {
			String userhome = System.getProperty("user.home");
			File folder = new File(userhome + File.separator + "data" + File.separator + "in");

			for (File file : folder.listFiles()) {
				if (file.getName().endsWith(".log")) {
					read = new Scanner(file);
					read.useDelimiter("\\n");
					while (read.hasNextLine()) {

						String line = read.nextLine();
						String[] allRest = line.split(" - - ");
						String newLine = allRest[0];
						CounterBrowser collect = new CounterBrowser();
						collect.collectInformation(newLine);

					}

				}
			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			read.close();
		}

	}
}

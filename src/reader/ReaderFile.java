package reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import collect.CounterBand;
import collect.CounterBrowser;
import collect.CounterDystinctIP;
import collect.CounterSystem;
import collect.NoAcessCounter;

public class ReaderFile {

	private List<dataManager.Analysis> mainList = new ArrayList<>();
	private Chronometer c = new Chronometer();

	public static void main(String[] args) throws IOException {

		new ReaderFile();
	}

	public ReaderFile() throws IOException {

		List<String> fileLines;
		fileLines = Files.readAllLines(Paths.get(new File("").getAbsolutePath().concat("\\LOGfile"), "access.log"));
		readAllFiles();

		c.printCurrentTime("Start");

		mainList.forEach(analysis -> {
			new Thread(() -> {
				fileLines.forEach(line -> analysis.collectInformation(line));

				analysis.showInformations();
				c.printCurrentTime(analysis.getClass().getSimpleName());
			}).start();
		});
	}

	public void readAllFiles() {
		mainList.add(new CounterSystem());
		mainList.add(new CounterBrowser());
		mainList.add(new NoAcessCounter());
		mainList.add(new CounterBand());
		mainList.add(new CounterDystinctIP());
	}
}

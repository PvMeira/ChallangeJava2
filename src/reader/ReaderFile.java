package reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import collect.CounterBrowser;
import collect.CounterSystem;
import collect.NoAcessCounter;

public class ReaderFile {

	private List<dataManager.Analysis> mainList = new ArrayList<>();
	private Chronometer c = new Chronometer();

	public static void main(String[] args) throws IOException {

		new ReaderFile();
	}

	public ReaderFile() throws IOException {
		mainList.add(new CounterSystem());
		mainList.add(new CounterBrowser());
		mainList.add(new NoAcessCounter());

		c.begin();

		List<String> FileLines = Files
				.readAllLines(Paths.get(new File("").getAbsolutePath().concat("\\LOGfile"), "access.log"));

		FileLines.forEach(line -> {
			mainList.forEach(analysis -> analysis.collectInformation(line));
		});

		mainList.forEach(analysis -> analysis.showInformations());
		c.close();
	}
}

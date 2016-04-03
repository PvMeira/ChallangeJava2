package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import collect.Browsercounter;
import collect.SystemCounter;
import dataManager.BandWidth;
import dataManager.DateIP;
import dataManager.Ip;

public class ReaderFile {

	private SystemCounter system1;
	private Browsercounter browser1;

	public void readFile() throws IOException {

		String userhome = System.getProperty("user.home");
		File folder = new File(userhome + File.separator + "data" + File.separator + "in");

		for (File file : folder.listFiles()) {
			if (file.getName().endsWith(".txt")) {
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(new FileReader(file));
				List<Ip> IP = new ArrayList<Ip>();
				List<DateIP> DATA = new ArrayList<DateIP>();

				while (br.ready()) {

					String line = br.readLine();

					String[] ip = line.split(" - - ");
					String IpEndress = ip[0];
					Ip ipList = new Ip(IpEndress);
					IP.add(ipList);

					String[] data = line.split("\"");
					String dataLine = data[0];
					DateIP date = new DateIP();
					DATA.add(date);
					this.system1 = new SystemCounter(dataLine);
					this.browser1 = new Browsercounter(dataLine);

				}

			}
		}
		System.out.println(system1);
		System.out.println(browser1);
	}
}

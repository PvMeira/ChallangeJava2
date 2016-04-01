package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dataManager.BandWidth;
import dataManager.DateIP;
import dataManager.Ip;

public class ReaderFile {

	public void readFile() throws IOException {

		String userhome = System.getProperty("user.home");
		File folder = new File(userhome + File.separator + "data" + File.separator + "in");

		for (File file : folder.listFiles()) {
			if (file.getName().endsWith(".txt")) {
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(new FileReader(file));
				List<Ip> IP = new ArrayList<Ip>();
				List<DateIP> DATA = new ArrayList<DateIP>();
				List<BandWidth> BAND = new ArrayList<BandWidth>();
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

					String[] bandwidth = line.split("\"-");
					String typyFile = bandwidth[0];
					int numberband = Integer.parseInt(bandwidth[1]);
					BandWidth band = new BandWidth(typyFile, numberband);
					BAND.add(band);

				}

			}
		}
	}
}

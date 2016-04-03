package collect;

import java.util.Arrays;

public class SystemCounter {
	private int countWin, countIphone, countLinux, countAndroid, countMac;

	public SystemCounter(String line) {
		if (line.indexOf("Windows") != -1) {
			countWin++;
		}
		if (line.indexOf("iPhone") != -1) {
			countIphone++;
		}
		if (line.indexOf("Linux") != -1) {
			countLinux++;
		}
		if (line.indexOf("Android") != -1) {
			countAndroid++;
		}
		if (line.indexOf("Macintosh") != -1) {
			countMac++;
		}
	}

	public String systemString() {
		StringBuilder systemBuilder = new StringBuilder();
		systemBuilder.append("O.System on the log are :\n");

		int[] systemList = { countWin, countIphone, countLinux, countAndroid, countMac };

		Arrays.sort(systemList);
		for (int i = 0; i < systemList.length; i++) {
			System.out.println("-----------------");
			if (systemList[i] == countWin)
				systemBuilder.append("Windows :" + countWin + "\n");

			if (systemList[i] == countIphone)
				systemBuilder.append("iPhone :" + countIphone + "\n");
			if (systemList[i] == countLinux)
				systemBuilder.append("Linux :" + countLinux + "\n");
			if (systemList[i] == countAndroid)
				systemBuilder.append("Android :" + countAndroid + "\n");
			if (systemList[i] == countMac)
				systemBuilder.append("MacinTosh :" + countMac + "\n");
		}

		return systemBuilder.toString();
	}

}

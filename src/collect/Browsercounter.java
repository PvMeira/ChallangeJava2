package collect;

import java.util.Arrays;

public class Browsercounter {
	private int countMozzila, countChrome, countMSIE, countSafari, countOpera;

	public Browsercounter(String line) {
		if (line.indexOf("Mozzila") != -1) {
			countMozzila++;
		}
		if (line.indexOf("Chrome") != -1) {
			countChrome++;
		}
		if (line.indexOf("MSIE") != -1) {
			countMSIE++;
		}
		if (line.indexOf("Safari") != -1) {
			countSafari++;
		}
		if (line.indexOf("Opera") != -1) {
			countOpera++;
		}
	}

	public String BrowserString() {
		StringBuilder browserBuilder = new StringBuilder();
		browserBuilder.append("Browser on the log are :\n");

		int[] BrowserList = { countMozzila, countChrome, countMSIE, countSafari, countOpera };

		Arrays.sort(BrowserList);
		for (int i = 0; i < BrowserList.length; i++) {
			System.out.println("-----------------");
			if (BrowserList[i] == countMozzila)
				browserBuilder.append("Mozzila :" + countMozzila + "\n");
			if (BrowserList[i] == countChrome)
				browserBuilder.append("Chrome :" + countChrome + "\n");
			if (BrowserList[i] == countMSIE)
				browserBuilder.append("MSIE :" + countMSIE + "\n");
			if (BrowserList[i] == countSafari)
				browserBuilder.append("Safari :" + countSafari + "\n");
			if (BrowserList[i] == countOpera)
				browserBuilder.append("Opera :" + countOpera + "\n");
		}

		return browserBuilder.toString();
	}
}

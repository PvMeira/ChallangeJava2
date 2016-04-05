package collect;

import dataManager.Analysis;
import dataManager.Constants;

public class CounterBand extends AbstractCountMap implements Analysis, Constants {

	private void addBandInMap(String line, String pattern) {
		int positionPattern = line.indexOf(pattern) + pattern.length();
		int positionBeginBand = positionPattern + 15;

		try {
			if (line.substring(positionPattern, positionBeginBand).contains("200")) {
				String bandWidth = line.substring(positionBeginBand, line.length()).split(" ")[0];
				addToKey(pattern, Integer.valueOf(bandWidth));
			}
		} catch (Exception e) {
		}
	}

	@Override
	String toStringTitle() {

		return "BAND WIDTH";
	}

	@Override
	String toStringMessagePattern() {

		return "Largest band ";
	}

	@Override
	public void collectInformation(String line) {
		if (line.indexOf(DOCX_PATTERN) != -1) {
			increment(DOCX_PATTERN);
		}
		if (line.indexOf(Constants.TXT_PATTERN) != -1) {
			addBandInMap(line, Constants.TXT_PATTERN);
		}
		if (line.indexOf(Constants.CSV_PATTERN) != -1) {
			addBandInMap(line, Constants.CSV_PATTERN);
		}
		if (line.indexOf(Constants.PNG_PATTERN) != -1) {
			addBandInMap(line, Constants.PNG_PATTERN);
		}
		if (line.indexOf(Constants.JPG_PATTERN) != -1) {
			addBandInMap(line, Constants.JPG_PATTERN);
		}
		if (line.indexOf(Constants.GIF_PATTERN) != -1) {
			addBandInMap(line, Constants.GIF_PATTERN);
		}
		if (line.indexOf(Constants.CSS_PATTERN) != -1) {
			addBandInMap(line, Constants.CSS_PATTERN);
		}
		if (line.indexOf(Constants.JS_PATTERN) != -1) {
			addBandInMap(line, Constants.JS_PATTERN);
		}
		if (line.indexOf(Constants.I_PATTERN) != -1) {
			addBandInMap(line, Constants.I_PATTERN);
		}
	}

	@Override
	public void showInformations() {
		System.out.println(toString());
	}

}

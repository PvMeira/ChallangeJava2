package collect;

import dataManager.Constants;

public class CounterBrowser extends AbstractCountMap implements Constants, dataManager.Analysis {

	@Override
	public void collectInformation(String line) {
		if (line.indexOf(CHROME_PATTERN) != -1) {
			increment(CHROME_PATTERN);
		}
		if (line.indexOf(MOZILLA_PATTERN) != -1) {
			increment(MOZILLA_PATTERN);
		}
		if (line.indexOf(SAFARI_PATTERN) != -1) {
			increment(SAFARI_PATTERN);
		}
		if (line.indexOf(MSIE_PATTERN) != -1) {
			increment(MSIE_PATTERN);
		}
		if (line.indexOf(OPERA_PATTERN) != -1) {
			increment(OPERA_PATTERN);
		}

	}

	@Override
	public void showInformations() {
		System.out.println(toString());
	}

	@Override
	String toStringTitle() {

		return "\nTop Brpwsers : \n";
	}

	@Override
	String toStringMessagePattern() {

		return "The browser was useed ";
	}

}

// String toStringMessagePattern() {
// return "* The browser %s was used %s times.\n";

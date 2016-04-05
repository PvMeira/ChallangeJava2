package collect;

import dataManager.Analysis;
import dataManager.Constants;

public class CounterSystem extends AbstractCountMap implements Constants, Analysis {
	@Override
	public void collectInformation(String line) {
		if (line.indexOf(WINDOWS_PATTERN) != -1) {
			increment(WINDOWS_PATTERN);
		}
		if (line.indexOf(LINUX_PATTERN) != -1) {
			increment(LINUX_PATTERN);
		}
		if (line.indexOf(MAC_PATTERN) != -1) {
			increment(MAC_PATTERN);
		}
		if (line.indexOf(ANDROID_PATTERN) != -1) {
			increment(ANDROID_PATTERN);
		}
		if (line.indexOf(IPHONE_PATTERN) != -1) {
			increment(IPHONE_PATTERN);
		}
	}

	@Override
	public void showInformations() {
		System.out.println(toString());
	}

	@Override
	String toStringTitle() {
		return "TOP USED operational system: \n";
	}

	@Override
	String toStringMessagePattern() {
		return " The System %s was used %s times.\n";
	}
}

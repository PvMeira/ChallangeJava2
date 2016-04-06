package collect;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import dataManager.Analysis;

public class CounterDystinctIP implements Analysis {
	private int counterIP = 0;
	private Map<String, LocalDateTime> visit = new HashMap<String, LocalDateTime>();

	@Override
	public void collectInformation(String line) {
		String[] ipsValid = line.split("- -")[0].split(" ");
		String ipValidLine = ipsValid[ipsValid.length - 1];
		String date = line.split(" - - ")[1].substring(1, 21);
		LocalDateTime stringToDate = LocalDateTime.parse(date,
				DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss").withLocale(Locale.ENGLISH));

		LocalDateTime firstAcess = visit.get(ipValidLine);

		if (firstAcess == null) {
			visit.put(ipValidLine, stringToDate);
			counterIP++;
		} else {
			if (takeDiferenceInMinutes(firstAcess, stringToDate)) {
				visit.put(ipValidLine, stringToDate);
				counterIP++;
			} 
		}
	}

	private boolean takeDiferenceInMinutes(LocalDateTime firstAcess, LocalDateTime stringToDate) {
		Duration duration = Duration.between(firstAcess, stringToDate);
		return (duration.toMillis() > 1800000);
	}

	@Override
	public void showInformations() {
		System.out.println("Counter : " + counterIP);
	}

}

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
	private Map<String, Date> visit = new HashMap<String, Date>();

	@Override
	public void collectInformation(String line) {
		String ip = line;

		String[] ipsValid = line.split("- -")[0].split(" ");
		@SuppressWarnings("unused")
		String ipValidLine = ipsValid[ipsValid.length - 1];
		String date = line.split(" - - ")[1].substring(1, 21);
		LocalDateTime stringToDate = LocalDateTime.parse(date,
				DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss").withLocale(Locale.ENGLISH));

		Date firstAcess = visit.get(ip);

		if (firstAcess == null) {
			visit.put(ip, firstAcess);
			counterIP++;
		} else {
			@SuppressWarnings("unused")
			boolean diferenceInMinutes = takeDiferenceInMinutes(firstAcess, stringToDate);
			if (diferenceInMinutes = true) {
				visit.put(ip, firstAcess);
				counterIP++;
			}
		}
	}

	private boolean takeDiferenceInMinutes(Date firstAcess, LocalDateTime stringToDate) {
		Duration duration = Duration.between((Temporal) firstAcess, stringToDate);

		return (duration.toMillis() > 1800000);
	}

	@Override
	public void showInformations() {
		System.out.println("Counter : " + counterIP);
	}

}

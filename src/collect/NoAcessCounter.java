package collect;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class NoAcessCounter implements dataManager.Analysis {
	private List<TimeInterval> IntervalList = new ArrayList<>();
	private LocalDateTime OldDate = null;

	public Long durationBetweenDates(LocalDateTime oldDate, LocalDateTime newDate) {
		Duration dur = Duration.between(oldDate, newDate);
		return dur.toMillis();
	}

	@Override
	public void collectInformation(String line) {
		String date = line.split(" - - ")[1].substring(1, 21);
		LocalDateTime dateNow = LocalDateTime.parse(date,
				DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss").withLocale(Locale.ENGLISH));

		if (OldDate != null) {
			long duration = (durationBetweenDates(OldDate, dateNow));
			IntervalList.add(new TimeInterval(duration, OldDate));
		}

		OldDate = dateNow;
	}

	@Override
	public void showInformations() {
		System.out.println(toString());
	}

	public final String toString() {
		return IntervalList.stream().sorted(Comparator.comparing(TimeInterval::getInterval).reversed()).limit(3)
				.collect(Collectors.toList()).toString();
	}
}

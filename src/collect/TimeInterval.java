package collect;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeInterval {
	private long interval;
	private LocalDateTime date;

	public TimeInterval(long interval, LocalDateTime DATE) {
		this.interval = interval;
		this.date = DATE;
	}

	public long getInterval() {
		return interval;
	}

	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "\nInterval time in minutes: " + (interval / 60000) + " and date: "
				+ date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}
}

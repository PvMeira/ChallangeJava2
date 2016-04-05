package reader;

import java.time.Duration;
import java.time.LocalDateTime;

public class Chronometer {
	private LocalDateTime timeStart;
	private LocalDateTime timeEnd;

	public Chronometer() {
	}

	public final void begin() {
		timeStart = timeNow("BEGIN");
	}

	public final void close() {
		timeEnd = timeNow("END");
		printDuration();
	}

	private LocalDateTime timeNow(String inf) {
		return LocalDateTime.now();
	}

	private void printDuration() {

		result();

	}

	private void result() {
		Duration duration = Duration.between(timeStart, timeEnd);
		System.out.println("Time in sec:\n" + duration);
	}

}

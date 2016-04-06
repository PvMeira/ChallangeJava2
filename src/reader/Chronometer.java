package reader;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Chronometer {
	private long timeStart;
	private long timeEnd;

	public Chronometer() {
	}

	public final void begin() {
		timeStart = timeNow("BEGIN");
	}

	public final void close() {
		timeEnd = timeNow("END");
		printDuration();
	}

	private long timeNow(String inf) {
		return Calendar.getInstance().getTimeInMillis();
	}

	private void printDuration() {
		printTime("\nBEGIN:", timeStart);
		printTime("END:", timeEnd);
	}

	public void printCurrentTime(String simpleName) {
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")) + " " + simpleName);
	}

	private void printTime(String inf, long timeInMillis) {
		System.out.println(inf + ": " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(timeInMillis));
	}

}

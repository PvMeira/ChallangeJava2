package collect;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractCountMap {
	
	
	
	private Map<String, Integer> dataAnalisys = new HashMap<>();

	final void addToKey(String key, Integer value) {
		Integer currentValue = dataAnalisys.get(key);
		dataAnalisys.put(key, (currentValue != null ? currentValue : 0) + value);
	}

	final void increment(String key) {
		Integer currentValue = dataAnalisys.get(key);
		dataAnalisys.put(key, (currentValue != null ? currentValue : 0) + 1);
	}

	abstract String toStringTitle();

	abstract String toStringMessagePattern();

	@Override
	public final String toString() {
		StringBuilder builderMap = new StringBuilder(toStringTitle());

		builderMap.append(
				dataAnalisys.entrySet().stream().sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
						.map(e -> (e.getKey() + ": " + e.getValue())).collect(Collectors.toList()));

		return builderMap.toString();
	}
}

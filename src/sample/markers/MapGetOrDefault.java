package sample.markers;

import java.util.concurrent.ConcurrentHashMap;

public class MapGetOrDefault {
	
	void sample() {
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		String value = map.getOrDefault("key", "default");
	}

}

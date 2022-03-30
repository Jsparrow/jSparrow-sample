package sample.loops.streamforeach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterizedSampler {

	public void ceate() {
		final List<? extends Rule> rules = new ArrayList<>();
		final Map<String, String> map = new HashMap<>();
		for (Rule rule : rules) {
			map.put(rule.matcher, rule.sampler);
		}
	}

	public Map<String, String> create2(List<? extends Rule> rules) {
		final Map<String, String> map = new HashMap<>();
		rules.forEach((Rule rule) -> {
			map.put(rule.matcher, rule.sampler);
		});
		return map;
	}

	class R {
		final String matcher = "matcher";
		final String sampler = "sampler";
	}

	class Rule extends R {

	}
}

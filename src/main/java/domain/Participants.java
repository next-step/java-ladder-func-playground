package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Participants {
    private final List<String> names;

    private Participants(List<String> names) {
        this.names = Collections.unmodifiableList(new ArrayList<>(names));
    }

    public static Participants of(List<String> rawNames) {
		List<String> names = normalizeNames(rawNames);
		requireNonEmpty(names);
		requireMaxLength(names, 5);
		return new Participants(names);
    }

	private static List<String> normalizeNames(List<String> rawNames) {
		List<String> result = new ArrayList<>();
		for (String n : rawNames) {
			String v = n == null ? "" : n.trim();
			if (!v.isEmpty()) { result.add(v); }
		}
		return result;
	}

	private static void requireNonEmpty(List<String> names) {
		if (names.isEmpty()) { throw new IllegalArgumentException("이름을 한 개 이상 입력해 주세요"); }
	}

	private static void requireMaxLength(List<String> names, int max) {
		boolean tooLongExists = names.stream().anyMatch(n -> n.length() > max);
		if (tooLongExists) {
			throw new IllegalArgumentException("각 이름은 최대 " + max + "글자까지 가능합니다");
		}
	}

    public int size() {
        return names.size();
    }

    public int indexOf(String name) {
        return names.indexOf(name);
    }

    public String get(int index) {
        return names.get(index);
    }

    public List<String> names() {
        return names;
    }
}



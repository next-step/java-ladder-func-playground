package model;

import java.util.*;

public class LadderResult {
    private final Map<String, String> results;

    public LadderResult(Map<String, String> results) {
        this.results = results;
    }

    public String getResult(String name) {
        return results.get(name);
    }

    public Map<String, String> getAllResults() {
        return results;
    }
}
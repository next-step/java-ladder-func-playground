package service;

import domain.*;

public class LadderService {
    private static final String ALL_QUERY = "all";

    public Names createNames(String input) {
        return Names.from(input);
    }

    public Results createResults(String input) {
        return Results.from(input);
    }

    public Height createHeight(int value) {
        return new Height(value);
    }

    public Name createName(String input) {
        return new Name(input);
    }

    public LadderGame createLadderGame(Names names, Results results, Height height) {
        Ladder ladder = LadderGenerator.generate(names.size(), height);
        return new LadderGame(names, results, ladder);
    }

    public boolean isAllQuery(String input) {
        return ALL_QUERY.equals(input);
    }
}

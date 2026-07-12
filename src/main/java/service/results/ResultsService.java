package service.results;

import domain.results.Results;

import java.util.List;

public interface ResultsService {
    void saveResults(final List<String> results);

    Results getResults();
}

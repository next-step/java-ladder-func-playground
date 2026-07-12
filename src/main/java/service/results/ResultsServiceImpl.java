package service.results;

import domain.results.Results;
import repository.results.ResultsRepository;

import java.util.List;

public class ResultsServiceImpl implements ResultsService {

    private final ResultsRepository resultsRepository;

    public ResultsServiceImpl(final ResultsRepository resultsRepository) {
        this.resultsRepository = resultsRepository;
    }

    @Override
    public void saveResults(final List<String> results) {
        resultsRepository.setResults(new Results(results));
    }

    @Override
    public Results getResults() {
        return resultsRepository.getResults();
    }
}

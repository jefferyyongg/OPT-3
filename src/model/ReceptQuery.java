package model;

import java.util.ArrayList;
import java.util.List;

public class ReceptQuery {
    private List<ReceptQueryResult> results;

    public ReceptQuery() {
        this.results = new ArrayList<>();
    }

    public List<ReceptQueryResult> getResults() {
        if (results == null) {
            results = new ArrayList<>();
        }
        return results;
    }

    public void setResults(List<ReceptQueryResult> results) {
        this.results = results;
    }
}

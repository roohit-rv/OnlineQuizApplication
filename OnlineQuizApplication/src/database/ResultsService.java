package database;

import java.util.ArrayList;
import java.util.List;

public class ResultsService {
    private List<String> userResults;

    public ResultsService() {
        userResults = new ArrayList<>();
    }

    public void addResult(String result) {
        userResults.add(result);
    }
    public List<String> getUserResults() {
        return new ArrayList<>(userResults);
    }

    public void simulateQuizCompletion(String username, int score) {
        String result = username + ": " + score + " points";
        addResult(result);
    }
}

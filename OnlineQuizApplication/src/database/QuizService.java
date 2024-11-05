package database;

import java.util.HashMap;
import java.util.Map;

public class QuizService {
    private Map<String, String> quizzes = new HashMap<>();

    public boolean createQuiz(String quizName) {
        if (quizzes.containsKey(quizName)) {
            return false;
        }
        quizzes.put(quizName, "Quiz content goes here...");
        return true;
    }

    public boolean editQuiz(String quizName) {
        if (!quizzes.containsKey(quizName)) {
            return false;
        }
        quizzes.put(quizName, "Updated quiz content.");
        return true;
    }

    public boolean deleteQuiz(String quizName) {
        if (!quizzes.containsKey(quizName)) {
            return false;
        }
        quizzes.remove(quizName);
        return true;
    }
}

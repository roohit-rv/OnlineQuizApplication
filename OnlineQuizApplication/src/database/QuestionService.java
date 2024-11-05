package database;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestionService {
    private Map<String, Map<String, String>> questions;
    public List<String> getQuestionsForQuiz(String quizName) {
        List<String> quizQuestions = new ArrayList<>();
        Map<String, String> questionsForQuiz = questions.get(quizName);

        if (questionsForQuiz != null) {
            quizQuestions.addAll(questionsForQuiz.keySet());
        }

        return quizQuestions;
    }
    public QuestionService() {
        questions = new HashMap<>();
    }

    public boolean addQuestion(String quizName, String question) {
        questions.putIfAbsent(quizName, new HashMap<>());
        Map<String, String> quizQuestions = questions.get(quizName);
        if (quizQuestions.containsValue(question)) {
            return false;
        }
        quizQuestions.put(question, question);
        return true;
    }

    public boolean editQuestion(String quizName, String oldQuestion, String newQuestion) {
        Map<String, String> quizQuestions = questions.get(quizName);
        if (quizQuestions == null || !quizQuestions.containsValue(oldQuestion)) {
            return false;
        }
        quizQuestions.remove(oldQuestion);
        quizQuestions.put(newQuestion, newQuestion);
        return true;
    }


    public boolean deleteQuestion(String quizName, String question) {
        Map<String, String> quizQuestions = questions.get(quizName);
        if (quizQuestions == null || !quizQuestions.containsValue(question)) {
            return false;
        }
        quizQuestions.remove(question);
        return true;
    }
}

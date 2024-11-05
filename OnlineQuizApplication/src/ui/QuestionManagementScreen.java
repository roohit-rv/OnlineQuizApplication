package ui;

import database.QuestionService;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class QuestionManagementScreen {
    private ComboBox<String> questionComboBox;
    private TextField questionField;
    private TextField quizNameField;
    private Button editButton;
    private QuestionService questionService;

    public QuestionManagementScreen(QuestionService questionService) {
        this.questionService = questionService;
    }

    public VBox getLayout() {
        questionComboBox = new ComboBox<>();
        questionField = new TextField();
        quizNameField = new TextField();
        editButton = new Button("Edit Question");

        editButton.setOnAction(event -> {
            String oldQuestion = questionComboBox.getValue();
            String newQuestion = questionField.getText();
            String quizName = quizNameField.getText();

            boolean isEdited = questionService.editQuestion(quizName, oldQuestion, newQuestion);
            if (isEdited) {
                System.out.println("Question edited successfully!");
            } else {
                System.out.println("Failed to edit the question.");
            }
            updateQuestionComboBox();
        });

        // Set up layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(quizNameField, questionComboBox, questionField, editButton);

        updateQuestionComboBox();

        return layout;
    }

    private void updateQuestionComboBox() {
        String quizName = quizNameField.getText();
        questionComboBox.getItems().clear();
        questionComboBox.getItems().addAll(questionService.getQuestionsForQuiz(quizName));
    }
}

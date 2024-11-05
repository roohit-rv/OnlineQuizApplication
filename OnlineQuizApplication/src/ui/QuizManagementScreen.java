package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class QuizManagementScreen {
    private MainApp mainApp;
    private VBox layout;
    public QuizManagementScreen(MainApp mainApp) {
        this.mainApp = mainApp;
        layout = createLayout();
    }

    public VBox getLayout() {
        return layout;
    }

    private VBox createLayout() {
        VBox vbox = new VBox(10);

        Label titleLabel = new Label("Quiz Management");

        Button createQuizButton = new Button("Create Quiz");
        createQuizButton.setOnAction(event -> {
            System.out.println("Creating quiz...");
        });

        Button editQuizButton = new Button("Edit Quiz");
        editQuizButton.setOnAction(event -> {
            System.out.println("Editing quiz...");
        });

        Button deleteQuizButton = new Button("Delete Quiz");
        deleteQuizButton.setOnAction(event -> {
            System.out.println("Deleting quiz...");
        });

        Button backButton = new Button("Back to Login");
        backButton.setOnAction(event -> {
            mainApp.showLoginScreen();
        });

        vbox.getChildren().addAll(titleLabel, createQuizButton, editQuizButton, deleteQuizButton, backButton); // Add elements
        return vbox;
    }
}

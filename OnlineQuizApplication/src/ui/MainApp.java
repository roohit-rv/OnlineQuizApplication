package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showLoginScreen();
    }

    public void showLoginScreen() {
        LoginScreen loginScreen = new LoginScreen(this);
        Scene scene = new Scene(loginScreen.getLayout(), 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    public void showRegistrationScreen() {
        RegistrationScreen registrationScreen = new RegistrationScreen(this);
        Scene scene = new Scene(registrationScreen.getLayout(), 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Registration");
        primaryStage.show();
    }

    // Method to display the quiz management screen
    public void showQuizManagementScreen() {
        QuizManagementScreen quizManagementScreen = new QuizManagementScreen(this);
        Scene scene = new Scene(quizManagementScreen.getLayout(), 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quiz Management");
        primaryStage.show();
    }

    public void showResultsScreen() {
        ResultsScreen resultsScreen = new ResultsScreen(this);
        Scene scene = new Scene(resultsScreen.getLayout(), 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Results Management");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

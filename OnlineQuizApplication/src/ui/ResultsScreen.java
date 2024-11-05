package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ResultsScreen {
    private MainApp mainApp;
    private VBox layout;

    public ResultsScreen(MainApp mainApp) {
        this.mainApp = mainApp;
        layout = createLayout();
    }

    public VBox getLayout() {
        return layout;
    }

    private VBox createLayout() {
        VBox vbox = new VBox(10);

        Label resultsLabel = new Label("User Scores/Results:");

        Button backButton = new Button("Back to Quiz Management");
        backButton.setOnAction(event -> {
            mainApp.showQuizManagementScreen();
        });

        vbox.getChildren().addAll(resultsLabel, backButton);
        return vbox;
    }
}

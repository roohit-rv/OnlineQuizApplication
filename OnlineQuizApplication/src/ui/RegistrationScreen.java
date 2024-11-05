package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegistrationScreen {
    private MainApp mainApp;
    private VBox layout;

    public RegistrationScreen(MainApp mainApp) {
        this.mainApp = mainApp;
        layout = createLayout();
    }

    public VBox getLayout() {
        return layout;
    }

    private VBox createLayout() {
        VBox vbox = new VBox(10);

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button registerButton = new Button("Register");
        registerButton.setOnAction(event -> {
            // Handle registration logic here
            System.out.println("Registration successful!");
            mainApp.showLoginScreen();
        });

        vbox.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, registerButton); // Add elements
        return vbox;
    }
}

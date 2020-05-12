package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginSingUpButton;

    @FXML
    void initialize() {
        authSignInButton.setOnAction(event -> {
            String loginText = loginField.getText().trim();
            String loginPassword = passwordField.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else
                System.out.println("Login or password empty");
        });
        loginSingUpButton.setOnAction(event -> {
            loginSingUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/signUp.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void loginUser(String loginText, String loginPassword) {

    }
}


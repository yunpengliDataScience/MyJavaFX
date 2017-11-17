package org.dragon.yunpeng;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FormSubmission extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    Label nameLabel = new Label("Name : ");

    TextField nameField = new TextField();

    Text responseText = new Text();

    Button submitButton = new Button();

    submitButton.setText("Submit");
    submitButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {

        String response = "Hello " + nameField.getText() + "!";
        System.out.println(response);

        responseText.setFill(Color.FIREBRICK);
        responseText.setText(response);
      }
    });

    GridPane gridPane = new GridPane();

    // Add component node to root container
    gridPane.add(nameLabel, 0, 0);
    gridPane.add(nameField, 1, 0);

    GridPane.setHalignment(submitButton, HPos.CENTER);
    gridPane.add(submitButton, 0, 1, 2, 1);

    GridPane.setHalignment(responseText, HPos.CENTER);
    gridPane.add(responseText, 0, 2, 2, 1);

    // Add layout root to Scene
    Scene scene = new Scene(gridPane, 300, 250);

    primaryStage.setTitle("My JavaFX Form");

    // Add Scene to Stage
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}

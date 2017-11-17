package org.dragon.yunpeng;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    Button btn = new Button();

    btn.setText("Say 'Hello World'");
    btn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        System.out.println("Hello World!");
      }
    });

    StackPane root = new StackPane();

    // Add component node to root container
    root.getChildren().add(btn);

    // Add layout root to Scene
    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Hello World!");

    // Add Scene to Stage
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}

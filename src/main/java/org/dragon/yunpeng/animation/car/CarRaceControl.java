package org.dragon.yunpeng.animation.car;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class CarRaceControl extends Application {

	@Override
	public void start(Stage primaryStage) {

		double sceneWidth = 600;
		double sceneHeight = 400;

		CarPane carPane = new CarPane(sceneWidth, sceneHeight);

		// Pause and resume animation
		carPane.setOnMousePressed(e -> carPane.pause());
		carPane.setOnMouseReleased(e -> carPane.play());

		// Increase and decrease animation
		carPane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				carPane.increaseSpeed();
			} else if (e.getCode() == KeyCode.DOWN) {
				carPane.decreaseSpeed();
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(carPane, sceneWidth, sceneHeight);
		primaryStage.setTitle("Car Race"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		// Must request focus after the primary stage is displayed
		carPane.requestFocus();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

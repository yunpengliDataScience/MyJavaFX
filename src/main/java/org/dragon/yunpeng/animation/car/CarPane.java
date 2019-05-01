package org.dragon.yunpeng.animation.car;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class CarPane extends Pane {

	private TranslateTransition animation;

	private double width;
	private double height;

	public CarPane(double sceneWidth, double sceneHeight) {

		width = sceneWidth;
		height = sceneHeight;

		Group car = createCarShape();

		// Add car to the pane
		getChildren().add(car);

		// Create an animation for moving the car
		animation = new TranslateTransition();

		// Set the node for the transition
		animation.setNode(car);

		// Set the value of the transition along the x axis.
		animation.setByX(sceneWidth);
		animation.setByY(0);

		// Set initial speed
		animation.setRate(0.1);

		// Set the cycle count for the transition
		animation.setCycleCount(Timeline.INDEFINITE);

		// Set auto reverse value to false
		animation.setAutoReverse(false);

		// Playing the animation
		animation.play();

	}

	public void play() {
		animation.play();
	}

	public void pause() {
		animation.pause();
	}

	public void increaseSpeed() {
		animation.setRate(animation.getRate() + 0.1);
	}

	public void decreaseSpeed() {
		animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
	}

	// Create the car shape by grouping different shapes together, so they can move altogether.
	private Group createCarShape() {

		Rectangle body = new Rectangle(0, height - 20, 50, 10);
		body.setFill(Color.LIGHTBLUE);

		Polygon top = new Polygon();

		top.getPoints().addAll(new Double[] { 20.0, height - 30, 30.0, height - 30, 40.0, height - 20, 10.0, height - 20

		});

		top.setFill(Color.BLUE);

		Circle wheel1 = new Circle(15, height - 5, 5);
		Circle wheel2 = new Circle(35, height - 5, 5);

		List shapes = new ArrayList();

		shapes.add(body);
		shapes.add(top);
		shapes.add(wheel1);
		shapes.add(wheel2);

		Group group = new Group(shapes);

		return group;
	}

}

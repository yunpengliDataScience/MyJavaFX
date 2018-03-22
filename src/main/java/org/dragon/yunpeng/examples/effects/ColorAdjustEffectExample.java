package org.dragon.yunpeng.examples.effects;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ColorAdjustEffectExample extends Application {
  @Override
  public void start(Stage stage) {
    
    // Creating an image
    Image image = null;

    String imageResource = "android.jpg";

    if (imageResource.startsWith("file:")) {
      image = new Image(imageResource);
    } else if (imageResource.startsWith("http:")) {
      image = new Image(imageResource);
    } else {
      image = new Image(getClass().getResourceAsStream(imageResource));
    }

    // Setting the image view
    ImageView imageView = new ImageView(image);

    // Setting the position of the image
    imageView.setX(100);
    imageView.setY(70);

    // setting the fit height and width of the image view
    imageView.setFitHeight(200);
    imageView.setFitWidth(400);

    // Setting the preserve ratio of the image view
    imageView.setPreserveRatio(true);

    // Instantiating the ColorAdjust class
    ColorAdjust colorAdjust = new ColorAdjust();

    // Setting the contrast value
    colorAdjust.setContrast(0.5);

    // Setting the hue value
    colorAdjust.setHue(-0.05);

    // Setting the brightness value
    colorAdjust.setBrightness(-0.5);

    // Setting the saturation value
    colorAdjust.setSaturation(0.8);

    // Applying coloradjust effect to the ImageView node
    imageView.setEffect(colorAdjust);

    // Creating a Group object
    Group root = new Group(imageView);

    // Creating a scene object
    Scene scene = new Scene(root, 600, 300);

    // Setting title to the Stage
    stage.setTitle("Coloradjust effect example");

    // Adding scene to the stage
    stage.setScene(scene);

    // Displaying the contents of the stage
    stage.show();
  }

  public static void main(String args[]) {
    launch(args);
  }

}

package org.dragon.yunpeng.examples.cellSelection;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author yunpeng.li
 */
public class CommonCellSelectorTest extends Application {

  @Override
  public void start(Stage stage) throws Exception {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("CommonCellSelector.fxml"));

    // Use ControllerFactory to create the controller of a particular constructor.
    loader.setControllerFactory(c -> {
      return new CommonCellSelectorController(1);
    });

    Parent root = loader.load();

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}


package Nathan;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Main game class to run
 * source files
 * @author everyone
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        VBox root = new VBox();
        primaryStage.setTitle("Character");
        Rectangle character = new Rectangle(30,30,200,200);
        character.setFill(new Color(1,0.5,0.5,1));
        Image skin = new Image("Nathan/Frogger_Icon.png");
        ImageView viewer = new ImageView(skin);
        viewer.setFitHeight(200);
        viewer.setFitWidth(200);
        root.getChildren().add(character);
        root.getChildren().add(viewer);
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }
/**
 * called on update of frame
 */
    public static void update(){

    }
/**
 * launch arguments
 * @param args 
 */
    public static void main(String[] args) {
        launch(args);
    }
}

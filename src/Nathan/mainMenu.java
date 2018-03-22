package Nathan;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class mainMenu extends Application {
    @Override
    public void start(Stage primarystage) {
        VBox root = new VBox();
        Button btn = new Button("Test");
        btn.setAlignment(Pos.CENTER);
        root.getChildren().add(btn);
        primarystage.setScene(new Scene(root, 100, 100));
        primarystage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
//fdafadfad
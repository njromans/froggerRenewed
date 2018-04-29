package Nathan;


import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that is responsible for creating animation timer, the pane, parent
 * and child objects.
 * @author dflan
 */
public class FroggerApp extends Application {

    private AnimationTimer timer;

    private Pane root;

    private List<Node> cars = new ArrayList<>();
    private List<Node> boats = new ArrayList<>();
    private Node frog;
/**
 * creation of the root pane and animation timer.
 * @return returns the size of the pane
 */
    private Parent createContent() {
        root = new Pane();
        root.setPrefSize(800, 600);

        frog = initFrog();

        root.getChildren().add(frog);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();

        return root;
    }
/**
 * Creates the frogger character.
 * @return returns the rect responsible for frogger character.
 */
    private Node initFrog() {
        Rectangle rect = new Rectangle(38, 38, Color.GREEN);
        Image Frog = new Image("file:Frog.png", 250, 250, false, false);
        rect.setFill(new ImagePattern(Frog));
        rect.setTranslateY(600 - 39);

        return rect;
    }
/**
 * Spawns an enemy character on the pane.
 * @return returns the rectangle responsible for the enemy character.
 */
    private Node spawnCar() {
        Rectangle rect = new Rectangle(40, 40, Color.RED);
        Image underWaterGator = new Image("file:UnderWaterGator.png", 250, 250, false, false);
        rect.setFill(new ImagePattern(underWaterGator));
        rect.setTranslateY((int)(Math.random() * 14) * 40);

        root.getChildren().add(rect);
        return rect;
    }
/**
 * Spawns an enemy character on the pane.
 * @return returns the rectangle responsible for the enemy character.
 */
    private Node spawnBoat() {
        Rectangle rect = new Rectangle(40, 40, Color.RED);
        Image Boat = new Image("file:LillyPadBase.png", 250, 250, false, false);
        rect.setFill(new ImagePattern(Boat));
        rect.setTranslateY((int)(Math.random() * 14) * 40);

        root.getChildren().add(rect);
        return rect;
    }
/**
 * Updates the locations of enemies.
 */
    private void onUpdate() {
        for (Node car : cars)
            car.setTranslateX(car.getTranslateX() + Math.random() * 6);
        for (Node boat : boats)
            boat.setTranslateX(boat.getTranslateX() + Math.random()*6);
        if (Math.random() < 0.070) {
            cars.add(spawnCar());
        }
        if (Math.random() < 0.070) {
            boats.add(spawnBoat());
        }

        checkState();
    }
/**
 * Checks the location of the frogger character and enemy characters.
 */
    private void checkState() {
        for (Node car : cars) {
            if (car.getBoundsInParent().intersects(frog.getBoundsInParent())) {
                frog.setTranslateX(0);
                frog.setTranslateY(600 - 39);
                return;
            }
        }
        for (Node boat : boats) {
            if (boat.getBoundsInParent().intersects(frog.getBoundsInParent())){
                frog.setTranslateX(boat.getTranslateX());
                frog.setTranslateY(boat.getTranslateY());
            }
        }

        if (frog.getTranslateY() <= 0) {
            timer.stop();
            String win = "YOU WIN";

            HBox hBox = new HBox();
            hBox.setTranslateX(300);
            hBox.setTranslateY(250);
            root.getChildren().add(hBox);

            for (int i = 0; i < win.toCharArray().length; i++) {
                char letter = win.charAt(i);

                Text text = new Text(String.valueOf(letter));
                text.setFont(Font.font(48));
                text.setOpacity(0);

                hBox.getChildren().add(text);

                FadeTransition ft = new FadeTransition(Duration.seconds(0.66), text);
                ft.setToValue(1);
                ft.setDelay(Duration.seconds(i * 0.15));
                ft.play();
            }
        }
    }

    @Override
    /**
     * Responsible for W,A,S, and D key movement translations.
     */
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));

        stage.getScene().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    frog.setTranslateY(frog.getTranslateY() - 40);
                    break;
                case S:
                    frog.setTranslateY(frog.getTranslateY() + 40);
                    break;
                case A:
                    frog.setTranslateX(frog.getTranslateX() - 40);
                    break;
                case D:
                    frog.setTranslateX(frog.getTranslateX() + 40);
                    break;
                default:
                    break;
            }
        });

        stage.show();
    }
/**
 * launch arguments
 * @param args - arguments for launch
 */
    public static void main(String[] args) {
        launch(args);
    }
}

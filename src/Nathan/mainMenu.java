package Nathan;

import LevelTwoBackground.LevelTwoBackground;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class mainMenu extends Application {

    Stage froggerRenewed, gameLevel;
    Scene mainMenu, rules, controls, level, win, lose;
    Button startButton, helpButton, quitButton, nextButton, backButton; //quitButton2

    @Override
    public void start(Stage primaryStage) throws Exception{
        froggerRenewed = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        froggerRenewed.setTitle("Frogger Renewed");
        froggerRenewed.setScene(new Scene(root, 400, 400));

        //Generate buttons with labels
        Image button1 = new Image("Nathan/froggerButtonStart.png");
        Image button2 = new Image("Nathan/froggerButtonQuit.png");
        Image button3 = new Image("Nathan/froggerButtonHelp.png");
        Image button4 = new Image("Nathan/froggerButtonNext.png");
        Image button5 = new Image("Nathan/froggerButtonBack.png");
        //Start
        startButton = new Button();
        startButton.setGraphic(new ImageView(button1));
        startButton.setLayoutX(275);
        startButton.setLayoutY(300);
        //Quit
        quitButton = new Button();
        quitButton.setGraphic(new ImageView(button2));
        quitButton.setLayoutX(275);
        quitButton.setLayoutY(400);
        //Quit2 for win/lose screen
       /* quitButton2 = new Button();
        quitButton2.setGraphic(new ImageView(button2));
        quitButton2.setLayoutX(550);
        quitButton2.setLayoutY(725);*/
        //Help
        helpButton = new Button();
        helpButton.setGraphic(new ImageView(button3));
        helpButton.setLayoutX(275);
        helpButton.setLayoutY(500);
        //Next
        nextButton = new Button();
        nextButton.setGraphic(new ImageView(button4));
        nextButton.setLayoutX(550);
        nextButton.setLayoutY(725);
        //Back
        backButton = new Button();
        backButton.setGraphic(new ImageView(button5));
        backButton.setLayoutX(550);
        backButton.setLayoutY(725);


        //Allow for press of button
        startButton.setOnAction(pressEvent -> {
            System.out.println("Starting Frogger");
            System.out.println("Loading the level.");
            gameLevel = new Stage();
            gameLevel.setTitle("Level 2 - Traffic Trouble");
            gameLevel.setScene(level);
            gameLevel.show();
        });

        quitButton.setOnAction(pressEvent -> {
            System.out.println("Quitting Frogger");
            System.out.println("Closing the application.");
            froggerRenewed.close();
        });

        /*quitButton2.setOnAction(pressEvent -> {
            System.out.println("Quitting Frogger");
            System.out.println("Closing the application.");
            froggerRenewed.close();
        });*/

        helpButton.setOnAction(pressEvent -> {
            System.out.println("Frogger Help");
            System.out.println("Here are the rules");
            froggerRenewed.setScene(rules);
        });

        nextButton.setOnAction(pressEvent -> {
            System.out.println("Frogger Help");
            System.out.println("Here are the controls");
            froggerRenewed.setScene(controls);
        });

        backButton.setOnAction(pressEvent -> {
            System.out.println("Frogger Main Menu");
            System.out.println("Here is the Main Menu");
            froggerRenewed.setScene(mainMenu);
        });

        //Draw Main Menu Background
        Group menuScreen = new Group();
        Canvas mainMenuScreen = new Canvas(800, 800);

        GraphicsContext menuBG = mainMenuScreen.getGraphicsContext2D();
        Image menu = new Image("Nathan/MainMenuBG.png", 800, 800, true, true);

        menuBG.drawImage(menu, 0, 0);

        //Add buttons to main menu
        menuScreen.getChildren().addAll(mainMenuScreen);
        menuScreen.getChildren().add(startButton);
        menuScreen.getChildren().add(helpButton);
        menuScreen.getChildren().add(quitButton);

        mainMenu = new Scene(menuScreen, 800, 800);

        //Layout rules scene
        Group helpScreen1 = new Group();
        Canvas rulesScreen = new Canvas(800, 800);

        GraphicsContext helpScreenBG1 = rulesScreen.getGraphicsContext2D();
        Image rule = new Image("Nathan/Rules.png", 800, 800, true, true);

        helpScreenBG1.drawImage(rule, 0, 0);

        helpScreen1.getChildren().addAll(rulesScreen);
        helpScreen1.getChildren().add(nextButton);

        rules = new Scene(helpScreen1, 800, 800);

        //Layout controls scene
        Group helpScreen2 = new Group();
        Canvas controlsScreen = new Canvas(800, 800);

        GraphicsContext helpScreenBG2 = controlsScreen.getGraphicsContext2D();
        Image control = new Image("Nathan/Controls.png", 800, 800, true, true);

        helpScreenBG2.drawImage(control, 0, 0);

        helpScreen2.getChildren().addAll(controlsScreen);
        helpScreen2.getChildren().add(backButton);

        controls = new Scene(helpScreen2, 800, 800);

        //Layout win scene
        Group winScreen = new Group();
        Canvas winScreenMessage = new Canvas(800, 800);

        GraphicsContext winScreenDisplay = winScreenMessage.getGraphicsContext2D();
        Image winMessage = new Image("Nathan/youwin.png", 800, 800, true, true);

        winScreenDisplay.drawImage(winMessage, 0, 0);

        winScreen.getChildren().addAll(winScreenMessage);
        //winScreen.getChildren().add(quitButton2);

        win = new Scene(winScreen, 800, 800);
        //gameLevel.setScene(win);

        //Layout lose scene
        Group loseScreen = new Group();
        Canvas loseScreenMessage = new Canvas(800, 800);

        GraphicsContext loseScreenDisplay = loseScreenMessage.getGraphicsContext2D();
        Image loseMessage = new Image("Nathan/GameOver.png", 800, 800, true, true);

        loseScreenDisplay.drawImage(loseMessage, 0, 0);

        loseScreen.getChildren().addAll(loseScreenMessage);
        //loseScreen.getChildren().add(quitButton2);

        lose = new Scene(loseScreen, 800, 800);
        //gameLevel.setScene(lose);

        //Setting up level scene
        // set up canvas
        Group levelTwoBackground = new Group();
        Canvas levelTwoCanvas = new Canvas(1275,5250);
        Canvas levelTwoCanvasLayerTwo = new Canvas(1275,5250);

        //add Perks
        //find random Y start value for perk ((0.0 to 1.0) * 5000 +375)
        Random randomYValue = new Random();
        double Yvalue;
        Yvalue = randomYValue.nextDouble() * /*5000*/ 900 + 375;

        Image perk = LevelTwoBackground.Perks.loadPerk();

        ImageView perkView = new ImageView();
        perkView.setImage(perk);
        perkView.setX(0.0);
        perkView.setY(Yvalue);


        TranslateTransition movePerk = new TranslateTransition();
        movePerk.setDuration(Duration.seconds(15.0));
        movePerk.setNode(perkView);
        movePerk.setToX(1275);
        movePerk.setCycleCount(1);
        movePerk.play();

        // layer one
        GraphicsContext levelTwoBackgroundGc = levelTwoCanvas.getGraphicsContext2D();
        drawBackground(levelTwoBackgroundGc);


        levelTwoBackground.getChildren().addAll(levelTwoCanvas);

        // layer two
        GraphicsContext levelTwoBackgroundLayerTwoGc = levelTwoCanvas.getGraphicsContext2D();
        drawBackgroundLayerTwo(levelTwoBackgroundLayerTwoGc);
        LevelTwoBackground.TopPlayerInfo.setScore(levelTwoBackgroundGc, levelTwoBackgroundGc); // include the Player info
        levelTwoCanvasLayerTwo.toFront();
        levelTwoBackground.getChildren().addAll(perkView,levelTwoCanvasLayerTwo);

        level = new Scene(levelTwoBackground, 1275, 1275);

        //Set primary stage to main menu
        froggerRenewed.setScene(mainMenu);
        froggerRenewed.show();
    }

    public static void main(String[] args) {
        launch(args);
        //new Thread(() -> Application.launch(LevelTwoBackground.class)).start();

    }

    private void drawBackground(GraphicsContext levelTwoBackgroundGc ){

        // Draw the water
        levelTwoBackgroundGc.setFill(Color.BLUE);
        levelTwoBackgroundGc.fillRect(0, 125, 1275, 2250);

        // Draw the grass sections
        levelTwoBackgroundGc.setFill(Color.GREEN);
        levelTwoBackgroundGc.fillRect(0, 2501, 1275, 250);
        levelTwoBackgroundGc.fillRect(0, 5000, 1275, 250);

        //Draw road section
        levelTwoBackgroundGc.setFill(Color.BLACK);
        levelTwoBackgroundGc.fillRect(0, 2750, 1275, 2250);


    }
    private void drawBackgroundLayerTwo( GraphicsContext levelTwoBackgroundLayerTwoGc) {

        // Draw solid yellow lines
        levelTwoBackgroundLayerTwoGc.setStroke(Color.YELLOW);
        levelTwoBackgroundLayerTwoGc.setLineWidth(62.5);
        levelTwoBackgroundLayerTwoGc.strokeLine(0, 3500, 1275, 3500);
        levelTwoBackgroundLayerTwoGc.strokeLine(0, 4250, 1275, 4250);

        // Draw solid white lines.
        levelTwoBackgroundLayerTwoGc.setStroke(Color.WHITESMOKE);
        levelTwoBackgroundLayerTwoGc.strokeLine(0, 2717.75, 1275, 2717.75);
        levelTwoBackgroundLayerTwoGc.strokeLine(0, 4967.75, 1275, 4967.75);

        // Draw solid brown line
        levelTwoBackgroundLayerTwoGc.setStroke(Color.BURLYWOOD);
        levelTwoBackgroundLayerTwoGc.strokeLine(0, 2467.75, 1275, 2467.75);

        // Draw dashed lines
        levelTwoBackgroundLayerTwoGc.setStroke(Color.YELLOW);
        levelTwoBackgroundLayerTwoGc.setLineDashes(62.5);
        levelTwoBackgroundLayerTwoGc.setLineDashOffset(200);
        levelTwoBackgroundLayerTwoGc.strokeLine(0, 3125, 1275, 3125);
        levelTwoBackgroundLayerTwoGc.strokeLine(0, 4625, 1275, 4625);

        //Draw emergency lane markings
        levelTwoBackgroundLayerTwoGc.setFill(Color.WHITESMOKE);
        levelTwoBackgroundLayerTwoGc.fillText("EMERGENCY LANE", 200, 3875);
        levelTwoBackgroundLayerTwoGc.fillText("EMERGENCY LANE", 600, 3875);
        levelTwoBackgroundLayerTwoGc.fillText("EMERGENCY LANE", 1100, 3875);

        // Place Lilly Pad and Danger Gators
        Image lillyPad = new Image("file:LillyPadBase.png", 250, 250, false, false);
        Image underWaterGator = new Image("file:UnderWaterGator.png", 250, 250, false, false);

        //Safe Zone - Win the Level
        levelTwoBackgroundLayerTwoGc.drawImage(lillyPad, 512.5, 125);

        //Danger Zone - Lose Life
        levelTwoBackgroundLayerTwoGc.drawImage(underWaterGator, 0, 125);
        levelTwoBackgroundLayerTwoGc.drawImage(underWaterGator, 255, 125);
        levelTwoBackgroundLayerTwoGc.drawImage(underWaterGator, 774, 125);
        levelTwoBackgroundLayerTwoGc.drawImage(underWaterGator, 1025, 125);
    }
}

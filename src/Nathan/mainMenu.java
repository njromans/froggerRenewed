package Nathan;

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

    Stage froggerRenewed, gameOver;
    Scene mainMenu, rules, controls, gameLevel, win, lose;
    Button startButton, helpButton, quitButton, nextButton, backButton; //quitButton2

    @Override
    public void start(Stage primaryStage) throws Exception{
        froggerRenewed = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        froggerRenewed.setTitle("Frogger Renewed");
        froggerRenewed.setScene(new Scene(root, 400, 400));

        //Generate buttons with labels
        Image button1 = new Image("Nathan/Images/froggerButtonStart.png");
        Image button2 = new Image("Nathan/Images/froggerButtonQuit.png");
        Image button3 = new Image("Nathan/Images/froggerButtonHelp.png");
        Image button4 = new Image("Nathan/Images/froggerButtonNext.png");
        Image button5 = new Image("Nathan/Images/froggerButtonBack.png");
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
            //froggerRenewed.setScene(gameLevel.LevelTwoBackground.levelTwoBackground);
            gameOver = new Stage();
            gameOver.setScene(gameLevel);
            gameOver.setTitle("Frogger Renewed Level");
            gameOver.show();
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
        Image menu = new Image("Nathan/Images/MainMenuBG.png", 800, 800, true, true);

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
        Image rule = new Image("Nathan/Images/Rules.png", 800, 800, true, true);

        helpScreenBG1.drawImage(rule, 0, 0);

        helpScreen1.getChildren().addAll(rulesScreen);
        helpScreen1.getChildren().add(nextButton);

        rules = new Scene(helpScreen1, 800, 800);

        //Layout controls scene
        Group helpScreen2 = new Group();
        Canvas controlsScreen = new Canvas(800, 800);

        GraphicsContext helpScreenBG2 = controlsScreen.getGraphicsContext2D();
        Image control = new Image("Nathan/Images/Controls.png", 800, 800, true, true);

        helpScreenBG2.drawImage(control, 0, 0);

        helpScreen2.getChildren().addAll(controlsScreen);
        helpScreen2.getChildren().add(backButton);

        controls = new Scene(helpScreen2, 800, 800);

        //Layout win scene
        Group winScreen = new Group();
        Canvas winScreenMessage = new Canvas(800, 800);

        GraphicsContext winScreenDisplay = winScreenMessage.getGraphicsContext2D();
        Image winMessage = new Image("Nathan/Images/youwin.png", 800, 800, true, true);

        winScreenDisplay.drawImage(winMessage, 0, 0);

        winScreen.getChildren().addAll(winScreenMessage);
        //winScreen.getChildren().add(quitButton2);

        win = new Scene(winScreen, 800, 800);
        //gameOver.setScene(win);


        //Layout lose scene
        Group loseScreen = new Group();
        Canvas loseScreenMessage = new Canvas(800, 800);

        GraphicsContext loseScreenDisplay = loseScreenMessage.getGraphicsContext2D();
        Image loseMessage = new Image("Nathan/Images/GameOver.png", 800, 800, true, true);

        loseScreenDisplay.drawImage(loseMessage, 0, 0);

        loseScreen.getChildren().addAll(loseScreenMessage);
        //loseScreen.getChildren().add(quitButton2);

        lose = new Scene(loseScreen, 800, 800);
        //gameOver.setScene(lose);

        //Set up Level background
        //Layout lose scene
        Group levelScreen = new Group();
        Canvas levelScreenDisplay = new Canvas(800, 800);

        GraphicsContext levelScreenShow = levelScreenDisplay.getGraphicsContext2D();
        Image levelShow= new Image("Nathan/Images/levelBG.png", 800, 800, true, true);

        levelScreenShow.drawImage(levelShow, 0, 0);

        // Place Lilly Pad and Danger Gators
        Image lillyPad = new Image("Nathan/Images/LillyPadBase.png", 70, 70, true,true);
        Image underWaterGator = new Image("Nathan/Images/UnderWaterGator.png", 100, 100, true, true);

        //Safe Zone - Win the Level
        levelScreenShow.drawImage(lillyPad,125,100);

        //Danger Zone - Lose Life
        levelScreenShow.drawImage(underWaterGator,0,100);
        levelScreenShow.drawImage(underWaterGator,50,100);
        levelScreenShow.drawImage(underWaterGator,175,100);
        levelScreenShow.drawImage(underWaterGator,225,100);

        levelScreen.getChildren().addAll(levelScreenDisplay);

        gameLevel = new Scene(levelScreen, 800, 800);

        //add Perks
        //find random Y start value for perk ((0.0 to 1.0) * 5000 +375)
        Random randomYValue = new Random();
        double Yvalue;
        Yvalue = randomYValue.nextDouble() * /*5000*/ 900 + 375;

        Image perk = Perks.loadPerk();

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


        //Set primary stage to main menu
        froggerRenewed.setScene(mainMenu);
        froggerRenewed.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

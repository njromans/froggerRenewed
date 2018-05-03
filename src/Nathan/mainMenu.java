package Nathan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class mainMenu extends Application {

    private Stage froggerRenewed, gameLevel;
    private Scene mainMenu, rules, controls, level, win, lose;
    private Button startButton, helpButton, quitButton, nextButton, backButton, quitButton2, endButton;

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
        Image button6 = new Image("Nathan/Images/froggerButtonMini.png",100,200,true,true);
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
        quitButton2 = new Button();
        quitButton2.setGraphic(new ImageView(button2));
        quitButton2.setLayoutX(550);
        quitButton2.setLayoutY(725);
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
        //Eng game
        endButton = new Button();
        endButton.setGraphic(new ImageView(button6));
        endButton.setLayoutX(205);
        endButton.setLayoutY(765);

        //Allow for press of button
        startButton.setOnAction(pressEvent -> {
            System.out.println("Starting Frogger");
            System.out.println("Loading the level.");
            //froggerRenewed.setScene(gameLevel.LevelTwoBackground.levelTwoBackground);
            gameLevel = new Stage();
            gameLevel.setScene(level);
            gameLevel.setTitle("Frogger Renewed Level");
            gameLevel.show();
        });

        quitButton.setOnAction(pressEvent -> {
            System.out.println("Quitting Frogger");
            System.out.println("Closing the application.");
            froggerRenewed.close();
        });

        quitButton2.setOnAction(pressEvent -> {
            System.out.println("Quitting Frogger");
            System.out.println("Closing the application.");
            gameLevel.close();
        });

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

        endButton.setOnAction(pressEvent -> {
            System.out.println("You have lost the game.");
            System.out.println("Game Over");
            gameLevel.setScene(lose);
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
        //gameLevel.setScene(win);


        //Layout lose scene
        Group loseScreen = new Group();
        Canvas loseScreenMessage = new Canvas(800, 800);

        GraphicsContext loseScreenDisplay = loseScreenMessage.getGraphicsContext2D();
        Image loseMessage = new Image("Nathan/Images/GameOver.png", 800, 800, true, true);

        loseScreenDisplay.drawImage(loseMessage, 0, 0);

        loseScreen.getChildren().addAll(loseScreenMessage);
        loseScreen.getChildren().add(quitButton2);

        lose = new Scene(loseScreen, 800, 800);
        //gameLevel.setScene(lose);

        //Set up Level background
        Group levelBG = new Group();
        Canvas levelScreenDisplay = new Canvas(800, 800);

        GraphicsContext levelScreenShow = levelScreenDisplay.getGraphicsContext2D();
        Image levelShow = new Image("Nathan/Images/levelBG.png", 800, 800, true, true);

        levelScreenShow.drawImage(levelShow, 0, 0);

        // Place Lilly Pad and Danger Gators
        Image lillyPad = new Image("Nathan/Images/LillyPadBase.png", 70, 70, true,true);
        Image underWaterGator = new Image("Nathan/Images/UnderWaterGator.png", 100, 100, true, true);
        //Image sidewaysGator = new Image("Nathan/Images/UnderWaterGatorSide.png", 100, 100, true, true);

        //Safe Zone - Win the Level
        levelScreenShow.drawImage(lillyPad,125,100);

        //Danger Zone - Lose Life
        levelScreenShow.drawImage(underWaterGator,0,100);
        levelScreenShow.drawImage(underWaterGator,50,100);
        levelScreenShow.drawImage(underWaterGator,175,100);
        levelScreenShow.drawImage(underWaterGator,225,100);

         //Safe Zone - Win the Level
         levelScreenShow.drawImage(lillyPad,125,625);

         //Danger Zone - Lose Life
         levelScreenShow.drawImage(underWaterGator,0,625);
         levelScreenShow.drawImage(underWaterGator,50,625);
         levelScreenShow.drawImage(underWaterGator,175,625);
         levelScreenShow.drawImage(underWaterGator,225,625);

         //Display player stats
        TopPlayerInfo.setScore(levelScreenShow, levelScreenShow); // include the Player info
        
        levelBG.getChildren().addAll(levelScreenDisplay);

        //Level obstacles
        Group levelObstacles = new Group();
        Canvas levelObstaclesDisplay = new Canvas(800, 800);

        GraphicsContext levelObstaclesShow = levelObstaclesDisplay.getGraphicsContext2D();

         //Spawn Obstacles
        int obstacleCount = 0;
        if(obstacleCount <= 7)
        {
            for(int x=0; x<=250; x+=50)
            {
                Image obstacle = loadObstacle();
                levelObstaclesShow.drawImage(obstacle, x, 125);
            }
            obstacleCount++;
        }

        if(obstacleCount <= 7)
        {
            for(int x=0; x<=250; x+=50)
            {
                Image obstacle = loadObstacle();
                levelObstaclesShow.drawImage(obstacle, x, 175);
            }
            obstacleCount++;
        }

        if(obstacleCount <= 7)
        {
            for(int x=0; x<=250; x+=50)
            {
                Image obstacle = loadObstacle();
                levelObstaclesShow.drawImage(obstacle, x, 225);
            }
            obstacleCount++;
        }

        if(obstacleCount <= 7)
        {
            for(int x=0; x<=250; x+=50)
            {
                Image obstacle = loadObstacle();
                levelObstaclesShow.drawImage(obstacle, x, 275);
            }
            obstacleCount++;
        }

        if(obstacleCount <= 7)
        {
            for(int x=0; x<=250; x+=50)
            {
                Image obstacle = loadObstacle();
                levelObstaclesShow.drawImage(obstacle, x, 400);
            }
            obstacleCount++;
        }

        if(obstacleCount <= 7)
        {
            for(int x=0; x<=250; x+=50)
            {
                Image obstacle = loadObstacle();
                levelObstaclesShow.drawImage(obstacle, x, 450);
            }
            obstacleCount++;
        }

        if(obstacleCount <= 7)
        {
            for(int x=0; x<=300; x+=50)
            {
                Image obstacle = loadObstacle();
                levelObstaclesShow.drawImage(obstacle, x, 500);
            }
            obstacleCount++;
        }

        if(obstacleCount <= 7)
        {
            for(int x=0; x<=250; x+=50)
            {
                Image obstacle = loadObstacle();
                levelObstaclesShow.drawImage(obstacle, x, 550);
            }
            obstacleCount++;
        }

        levelObstacles.getChildren().addAll(levelObstaclesDisplay);

        Group levelDisplay = new Group();

        Group levelCharacter = new Group();
        Canvas levelCharacterDisplay = new Canvas(800, 800);

        GraphicsContext levelCharacterShow = levelObstaclesDisplay.getGraphicsContext2D();

        Image character = loadFrog();
        levelCharacterShow.drawImage(character,100,700);
        levelDisplay.getChildren().addAll(levelBG, levelObstacles,levelCharacter);
        levelDisplay.getChildren().add(endButton);

        level = new Scene(levelDisplay, 325, 800);

        //Set primary stage to main menu
        froggerRenewed.setScene(mainMenu);
        froggerRenewed.show();
        }

    public static Image loadFrog(){
        Image frog = new Image("Nathan/Images/Frog.png", 50, 50, true, true);
        return frog;
    }
    public static Image loadObstacle(){
        Image sidewaysGator = new Image("Nathan/Images/UnderWaterGatorSide.png", 100, 100, true, true);
        Image pirateShip = new Image("Nathan/Images/PirateShip.png", 50, 150, true, true);
        Image smallRaft = new Image("Nathan/Images/SmallRaft.png", 50, 150, true, true);
        Image turtle = new Image("Nathan/Images/Turtle.png", 50, 150, true, true);
        Image speedBoat = new Image("Nathan/Images/Turtle.png", 50, 150, true, true);

        pickObstacle randomImage = pickObstacle.getRandomObstacle();

        switch(randomImage.toString()){
            case "SIDEWAYSGATOR":
                return sidewaysGator;
            case "PIRATESHIP":
                return pirateShip;
            case "SMALLRAFT":
                return smallRaft;
            case "TURTLE":
                return turtle;
            case "SPEEDBOAT":
                return speedBoat;
            default:
                break;
        }
        return null;
    }

    private enum pickObstacle{
        SIDEWAYSGATOR,
        PIRATESHIP,
        SMALLRAFT,
        TURTLE,
        SPEEDBOAT;

        public static pickObstacle getRandomObstacle(){
            Random obstacleGenerator = new Random();
            return values()[obstacleGenerator.nextInt(values().length)];
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
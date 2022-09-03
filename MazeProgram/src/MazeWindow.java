import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.util.Duration;
import java.util.ArrayList;


public class MazeWindow extends Application {

    private Maze mazze, BlankMaze;
    private Robot bot;
    private MazePane pane;
    private Boolean isInMaze;
    private Timeline timeline;
    private List<String> result;
    private MenuItem red, orange, yellow, green, blue, purple, maze1, maze2, maze3, maze4, maze5, loadMaze, write, rhlar, lhlar, rhr, lhr, rr, rlahr, rmr, lmr, rlhmr, llhmr, dfsr, mc;

    public void setMaze(Maze maze) {
        this.mazze = maze;
    }

    public Maze getMaze() {
        return mazze;
    }

    public static void main(String[] args) {
        launch(args);
    }

    //This will run the GUI Maze Solver
    @Override
    public void start(Stage primaryStage) throws Exception {
        pane = new MazePane();
        MenuBar mazeMenu = new MenuBar();
        Menu file = new Menu("File");
        MenuItem solve = new MenuItem("Solve");
        MenuItem about = new MenuItem("About");
        MenuItem exit = new MenuItem("Exit");
        Menu maze = new Menu("Maze");
        maze1 = new MenuItem("Maze One");
        maze2 = new MenuItem("Maze Two");
        maze3 = new MenuItem("Maze Three");
        maze4 = new MenuItem("Maze Four");
        maze5 = new MenuItem("Maze Five");
        loadMaze = new MenuItem("Load Maze");
        Menu robot = new Menu("Robot");
        rhlar = new MenuItem("Right Hand Look Ahead Robot");
        lhlar = new MenuItem("Left Hand Look Ahead Robot");
        rhr = new MenuItem("Right Hand Robot");
        lhr = new MenuItem("Left Hand Robot");
        rr = new MenuItem("Random Robot");
        rlahr = new MenuItem("Random Look Ahead Robot");
        rmr = new MenuItem("Right Hand Memory Robot");
        lmr = new MenuItem("Left Hand Memory Robot");
        rlhmr = new MenuItem("Right Hand Look Ahead Memory Robot");
        llhmr = new MenuItem("Left Hand Look Ahead Memory Robot");
        dfsr = new MenuItem("Depth First Search Robot");
        Menu create = new Menu("Create");
        write = new MenuItem("Write");
        Menu color = new Menu("Robot Color");
        red = new MenuItem("Red");
        orange = new MenuItem("Orange");
        yellow = new MenuItem("Yellow");
        green = new MenuItem("Green");
        blue = new MenuItem("Blue");
        purple = new MenuItem("Purple");
        mc = new MenuItem("Multi-Color");
        color.getItems().addAll(red, orange, yellow, green, blue, purple, mc);
        create.getItems().add(write);
        file.getItems().addAll(solve, new SeparatorMenuItem(), about, new SeparatorMenuItem(), exit);
        maze.getItems().addAll(maze1, maze2, maze3, maze4, maze5, loadMaze);
        robot.getItems().addAll(rhr, lhr, rr, rhlar, lhlar, rlahr, rmr, lmr, rlhmr, llhmr, dfsr);
        mazeMenu.getMenus().addAll(file, maze, robot, color, create);
        solve.setDisable(true);
        closeBots();
        closeColors();
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(mazeMenu);
        borderPane.setCenter(pane);
        borderPane.setBackground(null);
        Scene scene = new Scene(borderPane);
        scene.setFill(Color.IVORY);
        primaryStage.setTitle("Maze Solver");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("./robot.jpg"));
        primaryStage.show();

        //////////////////////////////////////////////////////////
        //Dr. Harms Code for reading the files within the mazes folder
        //get the mazes folder and walks through each element of the folder
        //storing it into a Stream containing each of the files path.
        //then storing each path name as a string into a string list
        // and printing the strings to the console log.
        try {
            Path p = Paths.get("mazes");
            Stream<Path> walk = Files.walk(p);
            result = walk.map(Path::toString).collect(Collectors.toList());
        } catch (IOException e) { e.printStackTrace(); }
        /////////////////////////////////////////////////////////

        maze1.setOnAction(event ->
        {
            openBots();
            File mazeFile = new File(result.get(1));
            try {
                mazze = new Maze(mazeFile);
                result.forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BlankMaze = new Maze(mazeFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            pane.setMaze(mazze);
            pane.paint();
            primaryStage.setHeight(mazze.getRows() * 30 + 66);
            primaryStage.setWidth(mazze.getCols() * 30 + 18);
        });

        maze2.setOnAction(event ->
        {
            openBots();
            File mazeFile = new File(result.get(2));
            try {
                mazze = new Maze(mazeFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BlankMaze = new Maze(mazeFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            pane.setMaze(mazze);
            pane.paint();
            primaryStage.setHeight(mazze.getRows() * 30 + 66);
            primaryStage.setWidth(mazze.getCols() * 30 + 18);
        });

        maze3.setOnAction(event ->
        {
            openBots();
            File mazeFile = new File(result.get(3));
            try {
                mazze = new Maze(mazeFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BlankMaze = new Maze(mazeFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            pane.setMaze(mazze);
            pane.paint();
            primaryStage.setHeight(mazze.getRows() * 30 + 66);
            primaryStage.setWidth(mazze.getCols() * 30 + 18);
        });

        maze4.setOnAction(event ->
        {
            openBots();
            File mazeFile = new File(result.get(4));
            try {
                mazze = new Maze(mazeFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BlankMaze = new Maze(mazeFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            pane.setMaze(mazze);
            pane.paint();
            primaryStage.setHeight(mazze.getRows() * 30 + 66);
            primaryStage.setWidth(mazze.getCols() * 30 + 18);
        });

        maze5.setOnAction(event ->
        {
            openBots();
            File mazeFile = new File(result.get(5));
            try {
                mazze = new Maze(mazeFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BlankMaze = new Maze(mazeFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            pane.setMaze(mazze);
            pane.paint();
            primaryStage.setHeight(mazze.getRows() * 30 + 66);
            primaryStage.setWidth(mazze.getCols() * 30 + 18);
        });

        loadMaze.setOnAction(event ->
        {
            FileChooser mazeFile = new FileChooser();
            mazeFile.setInitialDirectory(new File("./existingMazes"));
            File result = mazeFile.showOpenDialog(null);
            try {
                mazze = new Maze(result);

            } catch (IOException e) {
                mazeFile.setInitialDirectory(new File("./existingMazes"));
            }
            try {
                BlankMaze = new Maze(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
            openBots();
            pane.setMaze(mazze);
            pane.paint();
            primaryStage.setHeight(mazze.getRows() * 30 + 66);
            primaryStage.setWidth(mazze.getCols() * 30 + 18);
        });

        //This event allows the user to exit the program when they click on the exit menu item
        exit.setOnAction(event ->
        {
            primaryStage.close();
        });

        rhlar.setOnAction(event ->
        {
            openColors();
            solve.setDisable(false);
            bot = new RightHandLookAheadRobot(mazze);
            pane.setMaze(mazze);
            pane.setRobot(bot);
            pane.paint();
        });

        lhlar.setOnAction(event ->
        {
            openColors();
            solve.setDisable(false);
            bot = new LeftHandLookAheadRobot(mazze);
            pane.setMaze(mazze);
            pane.setRobot(bot);
            pane.paint();
        });

        rhr.setOnAction(event ->
        {
            openColors();
            solve.setDisable(false);
            bot = new RightHandRobot(mazze);
            pane.setMaze(mazze);
            pane.setRobot(bot);
            pane.paint();
        });

        lhr.setOnAction(event ->
        {
            openColors();
            solve.setDisable(false);
            bot = new LeftHandRobot(mazze);
            pane.setMaze(mazze);
            pane.setRobot(bot);
            pane.paint();
        });

        rr.setOnAction(event ->
        {
            openColors();
            solve.setDisable(false);
            bot = new RandomRobot(mazze);
            pane.setMaze(mazze);
            pane.setRobot(bot);
            pane.paint();
        });

        rlahr.setOnAction(event ->
        {
            openColors();
            solve.setDisable(false);
            bot = new BestSolutionRobot(mazze);
            pane.setMaze(mazze);
            pane.setRobot(bot);
            pane.paint();
        });

        rmr.setOnAction(event ->
        {
            openColors();
            solve.setDisable(false);
            bot = new rightHandMemoryRobot(mazze);
            while (!bot.solved()) {
                int direction = bot.chooseMoveDirection();
                if (direction >= 0)
                    bot.move(direction);
                System.out.println(mazze);
            }
            for (int i = 0; i < mazze.getMaze().length; i++) {
                for (int j = 0; j < mazze.getMaze()[i].length; j++) {
                    if (mazze.getCell(i, j) == 'o') {
                        mazze.setCell(i, j,  ' ');
                    }
                }
            }
            mazze.setCell(mazze.getExitRow(), mazze.getExitCol(), 'X');
            System.out.println(mazze);
            bot = new rightHandMemoryRobot(mazze);
            bot.setMaze(mazze);
            pane.setMaze(mazze);
            pane.setRobot(bot);
            pane.paint();
        });

        lmr.setOnAction(event ->
        {
            openColors();
            solve.setDisable(false);
            bot = new leftHandMemoryRobot(mazze);
            while (!bot.solved()) {
                int direction = bot.chooseMoveDirection();
                if (direction >= 0)
                    bot.move(direction);
                System.out.println(mazze);
            }
            for (int i = 0; i < mazze.getMaze().length; i++) {
                for (int j = 0; j < mazze.getMaze()[i].length; j++) {
                    if (mazze.getCell(i, j) == 'o') {
                        mazze.setCell(i, j,  ' ');
                    }
                }
            }
            mazze.setCell(mazze.getExitRow(), mazze.getExitCol(), 'X');
            System.out.println(mazze);
            bot = new leftHandMemoryRobot(mazze);
            bot.setMaze(mazze);
            pane.setMaze(mazze);
            pane.setRobot(bot);
            pane.paint();
        });

        rlhmr.setOnAction(event ->
        {
            openColors();
            solve.setDisable(false);
            bot = new rightHandLookAheadMemoryRobot(mazze);
            while (!bot.solved()) {
                int direction = bot.chooseMoveDirection();
                if (direction >= 0)
                    bot.move(direction);
                System.out.println(mazze);
            }
            for (int i = 0; i < mazze.getMaze().length; i++) {
                for (int j = 0; j < mazze.getMaze()[i].length; j++) {
                    if (mazze.getCell(i, j) == 'o') {
                        mazze.setCell(i, j,  ' ');
                    }
                }
            }
            mazze.setCell(mazze.getExitRow(), mazze.getExitCol(), 'X');
            System.out.println(mazze);
            bot = new rightHandLookAheadMemoryRobot(mazze);
            bot.setMaze(mazze);
            pane.setMaze(mazze);
            pane.setRobot(bot);
            pane.paint();
        });

        dfsr.setOnAction(event -> {
            openColors();
            solve.setDisable(false);
            bot = new depthFirstSearchRobot(mazze);
            ArrayList<Integer> direction = bot.getMoves();
            bot.setMaze(mazze);
            pane.setMaze(mazze);
            pane.setRobot(bot);
            pane.paint();
        });

        llhmr.setOnAction(event ->
        {
            openColors();
            solve.setDisable(false);
            bot = new leftHandLookAheadMemoryRobot(mazze);
            while (!bot.solved()) {
                int direction = bot.chooseMoveDirection();
                if (direction >= 0)
                    bot.move(direction);
                System.out.println(mazze);
            }
            for (int i = 0; i < mazze.getMaze().length; i++) {
                for (int j = 0; j < mazze.getMaze()[i].length; j++) {
                    if (mazze.getCell(i, j) == 'o') {
                        mazze.setCell(i, j,  ' ');
                    }
                }
            }
            mazze.setCell(mazze.getExitRow(), mazze.getExitCol(), 'X');
            System.out.println(mazze);
            bot = new leftHandLookAheadMemoryRobot(mazze);
            bot.setMaze(mazze);
            pane.setMaze(mazze);
            pane.setRobot(bot);
            pane.paint();
        });

        solve.setOnAction(event ->
        {
            solve.setDisable(true);
            pane.setMaze(mazze);
            pane.paint();
            closeBots();
            closeColors();
            closeMazes();
            write.setDisable(true);
            isInMaze = true;
            timeline = new Timeline(new KeyFrame(Duration.millis(100), event1 -> move()));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        });

        write.setOnAction(event ->
        {
            MenuBar writeBar = new MenuBar();
            Menu fileMazetxt = new Menu("File");
            MenuItem load = new MenuItem("Load");
            MenuItem save = new MenuItem("Save");
            MenuItem exittxt = new MenuItem("Exit");
            MenuItem help = new MenuItem("Help");
            fileMazetxt.getItems().addAll(load, save, help, new SeparatorMenuItem(), exittxt);
            writeBar.getMenus().addAll(fileMazetxt);
            TextArea writetxt = new TextArea();
            writetxt.setWrapText(true);
            BorderPane borderPane1 = new BorderPane();
            borderPane1.setTop(writeBar);
            borderPane1.setCenter(writetxt);
            Scene scene2 = new Scene(borderPane1);
            primaryStage.setScene(scene2);
            primaryStage.show();
            primaryStage.setTitle("Maze Creator");

            exittxt.setOnAction(event1 ->
            {
                primaryStage.setScene(scene);
            });

            save.setOnAction(event1 ->
            {
                FileChooser mazeTxtFile = new FileChooser();
                mazeTxtFile.setInitialDirectory(new File("./existingMazes"));
                File result = mazeTxtFile.showOpenDialog(null);
                String content = writetxt.getText();
                try {
                    FileWriter outFile = new FileWriter(result);
                    outFile.write(content);
                    outFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            load.setOnAction(event1 ->
            {
                FileChooser mazeTxtFile = new FileChooser();
                mazeTxtFile.setInitialDirectory(new File("./existingMazes"));
                File result = mazeTxtFile.showOpenDialog(null);
                try {
                    String content = "";
                    Scanner mazeScan = new Scanner(result);
                    while (mazeScan.hasNextLine()) {
                        content += mazeScan.nextLine() + "\n";
                    }
                    writetxt.setText(content);
                } catch (FileNotFoundException e) {
                    mazeTxtFile.setInitialDirectory(new File("./existingMazes"));
                } catch (Exception a) {
                    System.out.println("You didn't select a file");
                }
            });
            help.setOnAction(event1 ->
            {
                MenuBar helpMenuBar = new MenuBar();
                Menu helpFile = new Menu("File");
                MenuItem helpExitMenuItem = new MenuItem("Exit");
                helpFile.getItems().addAll(helpExitMenuItem);
                helpMenuBar.getMenus().addAll(helpFile);
                BorderPane helpBPane = new BorderPane();
                Label helptxt = new Label("In order to correctly create a maze, it must be in this format: " +
                        "\n5 5 (Dimensions of the maze you're creating)" +
                        "\n0 1 (The position you wish to start your robot, don't forget that java starts counting from 0, mark this spot with a S)" +
                        "\n4 3 (The position you want the exit to be located, mark this spot with a X)" +
                        "\n*S***" +
                        "\n* ***" +
                        "\n* ***" +
                        "\n*   *" +
                        "\n***X*" +
                        "\nWhen you want to save you maze, hit 'file', 'save', and then create a new .txt file to save to." +
                        "\nOnce you created the .txt file, select it, then click open. It will then save your maze to that .txt file." +
                        "\nYou can then use the Maze menu and click the 'Load Maze' tab and select your maze." +
                        "\nYou are also able to load in an existing maze and edit it as well.");
                helptxt.setPadding(new Insets(5,5,5,5));
                helpBPane.setTop(helpMenuBar);
                helpBPane.setCenter(helptxt);
                Scene scene1 = new Scene(helpBPane);
                primaryStage.setScene(scene1);

                helpExitMenuItem.setOnAction(event2 -> {
                    primaryStage.setScene(scene2);
                });
            });
        });

        red.setOnAction(event ->
        {
            pane.setMaze(mazze);
            pane.setRobotColor(1);
            pane.paint();
        });

        orange.setOnAction(event ->
        {
            pane.setMaze(mazze);
            pane.setRobotColor(2);
            pane.paint();
        });

        yellow.setOnAction(event ->
        {
            pane.setMaze(mazze);
            pane.setRobotColor(3);
            pane.paint();
        });

        green.setOnAction(event ->
        {
            pane.setMaze(mazze);
            pane.setRobotColor(4);
            pane.paint();
        });

        blue.setOnAction(event ->
        {
            pane.setMaze(mazze);
            pane.setRobotColor(5);
            pane.paint();
        });

        purple.setOnAction(event ->
        {
            pane.setMaze(mazze);
            pane.setRobotColor(6);
            pane.paint();
        });

        mc.setOnAction(event ->
        {
            pane.setMaze(mazze);
            pane.setRobotColor(7);
            pane.paint();
        });

        about.setOnAction(event ->
        {
            MenuBar about1 = new MenuBar();
            Menu file1 = new Menu("File");
            MenuItem exit1 = new MenuItem("Exit");
            file1.getItems().addAll(exit1);
            about1.getMenus().addAll(file1);
            Label about2 = new Label("This program is designed to solve a maze using various different methods." +
                    "\n\nThis program was created by Ethan Christensen in CSIT 150 at the University of Nebraska at Kearney." +
                    "\nSome portions of code were created and provided by Dr. Sherri Harms.");
            BorderPane pane1 = new BorderPane();
            pane1.setTop(about1);
            pane1.setCenter(about2);
            Scene scene1 = new Scene(pane1);
            primaryStage.setScene(scene1);

            exit1.setOnAction(event1 ->
            {
                primaryStage.setScene(scene);
            });
        });
    }

    private void openBots() {
        rhlar.setDisable(false);
        lhlar.setDisable(false);
        rhr.setDisable(false);
        lhr.setDisable(false);
        rr.setDisable(false);
        rlahr.setDisable(false);
        rmr.setDisable(false);
        lmr.setDisable(false);
        rlhmr.setDisable(false);
        llhmr.setDisable(false);
    }

    private void closeBots() {
        rhlar.setDisable(true);
        lhlar.setDisable(true);
        rhr.setDisable(true);
        lhr.setDisable(true);
        rr.setDisable(true);
        rlahr.setDisable(true);
        rmr.setDisable(true);
        lmr.setDisable(true);
        rlhmr.setDisable(true);
        llhmr.setDisable(true);
    }

    public void closeColors() {
        red.setDisable(true);
        orange.setDisable(true);
        yellow.setDisable(true);
        green.setDisable(true);
        blue.setDisable(true);
        purple.setDisable(true);
        mc.setDisable(true);
    }

    public void openColors(){
        red.setDisable(false);
        orange.setDisable(false);
        yellow.setDisable(false);
        green.setDisable(false);
        blue.setDisable(false);
        purple.setDisable(false);
        mc.setDisable(false);
    }

    public void closeMazes() {
        maze1.setDisable(true);
        maze2.setDisable(true);
        maze3.setDisable(true);
        maze4.setDisable(true);
        maze5.setDisable(true);
        loadMaze.setDisable(true);
    }

    public void openMazes() {
        maze1.setDisable(false);
        maze2.setDisable(false);
        maze3.setDisable(false);
        maze4.setDisable(false);
        maze5.setDisable(false);
        loadMaze.setDisable(false);
    }

    public void move() {
        if (!bot.solved()) {
            int direction = bot.chooseMoveDirection();
            if (direction >= 0) {  //invalid direction is -1
                bot.move(direction);
                if (bot.solved()) {
                    pane.paintFinal();
                    isInMaze = false;
                } else {
                    pane.paint();
                }
                if (!isInMaze) {
                    timeline.pause();
                    pane.setMaze(BlankMaze);
                    mazze = new Maze(BlankMaze);
                    openBots();
                    openMazes();
                    write.setDisable(false);
                }
            }
        }
    }
}


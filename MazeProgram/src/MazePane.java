import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;


public class MazePane extends Pane {
    private Maze maze;
    private Robot bot;
    private int robotColor;

    /**
     * This method allows the pane's maze to be updated
     *
     * @param inMaze inputted maze
     */
    public void setMaze(Maze inMaze) {
        maze = inMaze;
    }

    /**
     * This method allows the pane's robot to be updated
     *
     * @param inBot inputted robot
     */
    public void setRobot(Robot inBot) {
        bot = inBot;
    }

    /**
     * This method will use the panes maze, and extract the char maze from within the maze object and use
     * it to paint the maze with 30x30 squares for each item in the char maze
     */

    public void setRobotColor(int inColor) {
        robotColor = inColor;
    }

    public void paint() {
        int x;
        int y = 0;
        getChildren().clear();
        char[][] mazeLayout = maze.getMaze();
        for (int i = 0; i < mazeLayout.length; i++) {
            x = 0;
            for (int j = 0; j < mazeLayout[i].length; j++) {
                switch (mazeLayout[i][j]) {
                    case 'v':
                    case 'D':
                        Rectangle visited = new Rectangle(x, y, 30, 30);
                        Rectangle visitedInner = new Rectangle(x + 3, y + 3, 24, 24);
                        Rectangle visitedColor = new Rectangle(x + 6, y + 6, 18, 18);
                        visited.setFill(Color.BLACK);
                        visitedInner.setFill(Color.WHITE);
                        visitedColor.setFill(Color.RED);
                        x += 30;
                        getChildren().addAll(visited, visitedInner, visitedColor);
                        break;
                    case ' ':
                        Rectangle openSpace = new Rectangle(x, y, 30, 30);
                        Rectangle openSpaceInner = new Rectangle(x + 3, y + 3, 24, 24);
                        openSpace.setFill(Color.BLACK);
                        openSpaceInner.setFill(Color.WHITE);
                        x += 30;
                        getChildren().addAll(openSpace, openSpaceInner);
                        break;
                    case '*':
                        Rectangle wall = new Rectangle(x, y, 30, 30);
                        Rectangle wallInner = new Rectangle(x + 3, y + 3, 24, 24);
                        wall.setFill(Color.BLACK);
                        wallInner.setFill(Color.GRAY);
                        x += 30;
                        getChildren().addAll(wall, wallInner);
                        break;
                    case 'R':
                        Rectangle robotTile = new Rectangle(x, y, 30, 30);
                        Rectangle robotInner = new Rectangle(x + 3, y + 3, 24, 24);
                        Circle eye1 = new Circle(x + 11, y + 13, 4);
                        Circle eye2 = new Circle(x + 23, y + 13, 4);
                        eye1.setFill(Color.BLACK);
                        eye2.setFill(Color.BLACK);
                        robotTile.setFill(Color.BLACK);
                        if (robotColor == 1) {
                            robotInner.setFill(Color.RED);
                        } else if (robotColor == 2) {
                            robotInner.setFill(Color.ORANGE);
                        } else if (robotColor == 3) {
                            robotInner.setFill(Color.YELLOW);
                        } else if (robotColor == 4) {
                            robotInner.setFill(Color.GREEN);
                        } else if (robotColor == 5) {
                            robotInner.setFill(Color.BLUE);
                        } else if (robotColor == 6) {
                            robotInner.setFill(Color.PURPLE);
                        } else if (robotColor == 7) {
                            int color = (int) (Math.random() * 6);
                            if (color == 0) {
                                robotInner.setFill(Color.RED);
                            } else if (color == 1) {
                                robotInner.setFill(Color.ORANGE);
                            } else if (color == 2) {
                                robotInner.setFill(Color.YELLOW);
                            } else if (color == 3) {
                                robotInner.setFill(Color.GREEN);
                            } else if (color == 4) {
                                robotInner.setFill(Color.BLUE);
                            } else if (color == 5) {
                                robotInner.setFill(Color.PURPLE);
                            }
                        }
                        x += 30;
                        getChildren().addAll(robotTile, robotInner, eye1, eye2);
                        break;
                    case 'X':
                        Rectangle end = new Rectangle(x, y, 30, 30);
                        Rectangle endInner = new Rectangle(x + 3, y + 3, 24, 24);
                        end.setFill(Color.BLACK);
                        endInner.setFill(Color.GREEN);
                        x += 30;
                        getChildren().addAll(end, endInner);
                        break;
                    case 'o':
                        Rectangle traveled = new Rectangle(x, y, 30, 30);
                        Rectangle traveledInner = new Rectangle(x + 3, y + 3, 24, 24);
                        traveled.setFill(Color.BLACK);
                        if (robotColor == 1) {
                            traveledInner.setFill(Color.RED);
                        } else if (robotColor == 2) {
                            traveledInner.setFill(Color.ORANGE);
                        } else if (robotColor == 3) {
                            traveledInner.setFill(Color.YELLOW);
                        } else if (robotColor == 4) {
                            traveledInner.setFill(Color.GREEN);
                        } else if (robotColor == 5) {
                            traveledInner.setFill(Color.BLUE);
                        } else if (robotColor == 6) {
                            traveledInner.setFill(Color.PURPLE);
                        } else if (robotColor == 7) {
                            int color = (int) (Math.random() * 6);
                            if (color == 0) {
                                traveledInner.setFill(Color.RED);
                            } else if (color == 1) {
                                traveledInner.setFill(Color.ORANGE);
                            } else if (color == 2) {
                                traveledInner.setFill(Color.YELLOW);
                            } else if (color == 3) {
                                traveledInner.setFill(Color.GREEN);
                            } else if (color == 4) {
                                traveledInner.setFill(Color.BLUE);
                            } else if (color == 5) {
                                traveledInner.setFill(Color.PURPLE);
                            }
                        }
                        x += 30;
                        getChildren().addAll(traveled, traveledInner);
                        break;

                    case 'S':
                        Rectangle start = new Rectangle(x, y, 30, 30);
                        Rectangle startInner = new Rectangle(x + 3, y + 3, 24, 24);
                        start.setFill(Color.BLACK);
                        startInner.setFill(Color.RED);
                        x += 30;
                        getChildren().addAll(start, startInner);
                        break;
                }
            }
            y += 30;
        }
    }

    public void paintFinal() {
        int x;
        int y = 0;
        getChildren().clear();
        char[][] mazeLayout = maze.getMaze();
        for (int i = 0; i < mazeLayout.length; i++) {
            x = 0;
            for (int j = 0; j < mazeLayout[i].length; j++) {
                switch (mazeLayout[i][j]) {
                    case 'v':
                    case 'D':
                    case ' ':
                        Rectangle visited = new Rectangle(x, y, 30, 30);
                        Rectangle visitedInner = new Rectangle(x + 3, y + 3, 24, 24);
                        visited.setFill(Color.BLACK);
                        visitedInner.setFill(Color.WHITE);
                        x += 30;
                        getChildren().addAll(visited, visitedInner);
                        break;
                    case '*':
                        Rectangle wall = new Rectangle(x, y, 30, 30);
                        Rectangle wallInner = new Rectangle(x + 3, y + 3, 24, 24);
                        wall.setFill(Color.BLACK);
                        wallInner.setFill(Color.GRAY);
                        x += 30;
                        getChildren().addAll(wall, wallInner);
                        break;
                    case 'R':
                        Rectangle robotTile = new Rectangle(x, y, 30, 30);
                        Rectangle robotInner = new Rectangle(x + 3, y + 3, 24, 24);
                        Circle eye1 = new Circle(x + 11, y + 13, 4);
                        Circle eye2 = new Circle(x + 23, y + 13, 4);
                        eye1.setFill(Color.BLACK);
                        eye2.setFill(Color.BLACK);
                        robotTile.setFill(Color.BLACK);
                        if (robotColor == 1) {
                            robotInner.setFill(Color.RED);
                        } else if (robotColor == 2) {
                            robotInner.setFill(Color.ORANGE);
                        } else if (robotColor == 3) {
                            robotInner.setFill(Color.YELLOW);
                        } else if (robotColor == 4) {
                            robotInner.setFill(Color.GREEN);
                        } else if (robotColor == 5) {
                            robotInner.setFill(Color.BLUE);
                        } else if (robotColor == 6) {
                            robotInner.setFill(Color.PURPLE);
                        } else if (robotColor == 7) {
                            int color = (int) (Math.random() * 6);
                            if (color == 0) {
                                robotInner.setFill(Color.RED);
                            } else if (color == 1) {
                                robotInner.setFill(Color.ORANGE);
                            } else if (color == 2) {
                                robotInner.setFill(Color.YELLOW);
                            } else if (color == 3) {
                                robotInner.setFill(Color.GREEN);
                            } else if (color == 4) {
                                robotInner.setFill(Color.BLUE);
                            } else if (color == 5) {
                                robotInner.setFill(Color.PURPLE);
                            }
                        }
                        x += 30;
                        getChildren().addAll(robotTile, robotInner, eye1, eye2);
                        break;
                    case 'X':
                    case 'o':
                        Rectangle end = new Rectangle(x, y, 30, 30);
                        Rectangle endInner = new Rectangle(x + 3, y + 3, 24, 24);
                        end.setFill(Color.BLACK);
                        endInner.setFill(Color.GREEN);
                        x += 30;
                        getChildren().addAll(end, endInner);
                        break;

                    case 'S':
                        Rectangle start = new Rectangle(x, y, 30, 30);
                        Rectangle startInner = new Rectangle(x + 3, y + 3, 24, 24);
                        start.setFill(Color.BLACK);
                        startInner.setFill(Color.RED);
                        x += 30;
                        getChildren().addAll(start, startInner);
                        break;
                }
            }
            y += 30;
        }
    }
}

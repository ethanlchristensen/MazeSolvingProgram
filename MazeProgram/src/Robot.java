import java.util.ArrayList;

/**
 * This class creates a robot that will be used to solve a given maze
 *
 * @author Ethan Christensen
 * CSIT 150
 */
public abstract class Robot {
    protected Maze robMaze;
    private int direction;
    private int robotRow;
    private int robotCol;

    /**
     * This creates a robot that is given a maze as a parameter to solve
     *
     * @param maze that the robot must solve
     */
    Robot(Maze maze) {
        robMaze = maze;
        robMaze.setCell(robMaze.getStartRow(), robMaze.getStartCol(), 'R');
        robotRow = robMaze.getStartRow();
        robotCol = robMaze.getStartCol();
    }

    /**
     * @return the robots current row position
     */
    int getRobotRow() {
        return robotRow;
    }

    /**
     * @return returns robots current col position
     */
    int getRobotCol() {
        return robotCol;
    }

    public int getDirection() {
        return direction;
    }

    /**
     * Sets the direction of the robot
     *
     * @param d int 0-3
     */
    public void setDirection(int d) {
        if (d < 0) {
            direction = 0;
        } else if (d > 3) {
            direction = 3;
        } else
            direction = d;
    }

    /**
     * This will change the row variable associated with the robot based on its direction
     *
     * @param move either 1 or -1 based on its direction
     */
    void setRobotRow(int move) {
        robotRow = robotRow + move;
    }

    /**
     * This will change the col variable associated with the robot based on its direction
     *
     * @param move either 1 or -1 based on its direction
     */
    void setRobotCol(int move) {
        robotCol = robotCol + move;
    }

    /**
     * Must be in all sub-classes of robot
     *
     * @return a number 0-3 corresponding to the cardinal directions
     */
    public abstract int chooseMoveDirection();

    /**
     * Must be in all sub-classes of robot
     *
     * @param direction an int 0-3 indicating the direction of the robot
     * @return true if the robot moved or false if it was unable to move
     */
    public abstract boolean move(int direction);

    /**
     * if the position of the robot is equal the the position of the exit position then the robot solve the maze
     *
     * @return true if solved, false if not solved
     */
    boolean solved() {
        return (robMaze.getExitCol() == getRobotCol() && robMaze.getExitRow() == getRobotRow());
    }

    /**
     * This method allows the robots maze to be updated so it can can be
     * changed outside the robot constructor
     * @param inMaze a maze object
     */
    public void setMaze(Maze inMaze) {
        robMaze = inMaze;
    }

    public ArrayList<Integer> getMoves() {
        return new ArrayList<>();
    }
}
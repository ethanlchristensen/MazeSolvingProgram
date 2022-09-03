/**
 * This robot will solve the maze by doing random moves
 *
 * @author Ethan Christensen
 * CSIT 150
 */

public class RandomRobot extends Robot {

    /**
     * Randomrobot is a robot that extends all the methods of a robot.
     * However, random robot creates its own choose direction and move methods based on its purpose.
     *
     * @param maze a maze object
     */
    RandomRobot(Maze maze) {
        super(maze);
    }

    /**
     * @return a direction 0-3 randomly
     */
    @Override
    public int chooseMoveDirection() {
        return (int) (Math.random() * 4);
    }

    /**
     * After the robot moves it will set the start position to '*'
     * This method will move the robot left right up or down if there is a space available
     * It will then set the open spot to 'R' and then set the spot that the robot was previously at to ' '
     *
     * @param direction an int 0-3 indicating the direction of the robot
     * @return true if the robot moved, false if the robot is unable to move the specified direction
     */
    @Override
    public boolean move(int direction) {
        int row = getRobotRow();
        int col = getRobotCol();
        switch (direction) {
            case 0:
                if (robMaze.openCell(row - 1, col)) {
                    robMaze.setCell(row - 1, col, 'R');
                    robMaze.setCell(row, col, 'o');
                    robMaze.setCell(0, 1, '*');
                    setRobotRow(-1);
                    return true;
                } else
                    return false;
            case 1:
                if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) {
                    robMaze.setCell(row, col + 1, 'R');
                    robMaze.setCell(row, col, 'o');
                    robMaze.setCell(0, 1, '*');
                    setRobotCol(1);
                    return true;
                } else
                    return false;
            case 2:
                if (robMaze.openCell(row + 1, col)) {
                    robMaze.setCell(row + 1, col, 'R');
                    robMaze.setCell(row, col, 'o');
                    robMaze.setCell(0, 1, '*');
                    setRobotRow(1);
                    return true;
                } else
                    return false;
            case 3:
                if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) {
                    robMaze.setCell(row, col - 1, 'R');
                    robMaze.setCell(row, col, 'o');
                    robMaze.setCell(0, 1, '*');
                    setRobotCol(-1);
                    return true;
                } else
                    return false;
        }
        return false;
    }
}
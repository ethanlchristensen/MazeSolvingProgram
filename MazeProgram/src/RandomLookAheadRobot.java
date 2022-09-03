/**
 * This class creates a robot that will recursively move forward until it comes forward. Once it hits an intersection
 * it will randomly decided what direction to go.
 *
 * @author Ethan Christensen
 * CSIT 150
 */

public class RandomLookAheadRobot extends RandomRobot {
    /**
     * Randomrobot is a robot that extends all the methods of a RandomRobot.
     * @param maze a maze object
     */
    RandomLookAheadRobot(Maze maze) {
        super(maze);
        setDirection(2);
    }

    /**
     * This method will move the robot forward recursively until it comes to an intersection.
     * @param direction an int 0-3 indicating the direction of the robot
     * @return true if it moved, false if it didn't move
     */
    @Override
    public boolean move(int direction) {
        if (getRobotRow() == robMaze.getExitRow() && getRobotCol() == robMaze.getExitCol()) {
            return false;
        }
        switch (direction) {
            case 0:
                if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) {
                    if (robMaze.getCell(getRobotRow() - 1, getRobotCol()) == 'o' || robMaze.getCell(getRobotRow() - 1, getRobotCol()) == 'v') {
                        robMaze.setCell(getRobotRow() - 1, getRobotCol(), 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'v');
                        robMaze.setCell(0, 1, '*');
                        setRobotRow(-1);
                    } else {
                        robMaze.setCell(getRobotRow() - 1, getRobotCol(), 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'o');
                        robMaze.setCell(0, 1, '*');
                        setRobotRow(-1);
                    }
                    break;
                }
                else { return false; }
            case 1:
                if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) {
                    if (robMaze.getCell(getRobotRow(), getRobotCol() + 1) == 'o' || robMaze.getCell(getRobotRow(), getRobotCol() + 1) == 'v') {
                        robMaze.setCell(getRobotRow(), getRobotCol() + 1, 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'v');
                        robMaze.setCell(0, 1, '*');
                        setRobotCol(1);
                    } else {
                        robMaze.setCell(getRobotRow(), getRobotCol() + 1, 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'o');
                        robMaze.setCell(0, 1, '*');
                        setRobotCol(1);
                    }
                    break;
                }
                else { return false; }
            case 2:
               if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) {
                   if (robMaze.getCell(getRobotRow() + 1, getRobotCol()) == 'o' || robMaze.getCell(getRobotRow() + 1, getRobotCol()) == 'v') {
                       robMaze.setCell(getRobotRow() + 1, getRobotCol(), 'R');
                       robMaze.setCell(getRobotRow(), getRobotCol(), 'v');
                       robMaze.setCell(0, 1, '*');
                       setRobotRow(1);
                   } else {
                       robMaze.setCell(getRobotRow() + 1, getRobotCol(), 'R');
                       robMaze.setCell(getRobotRow(), getRobotCol(), 'o');
                       robMaze.setCell(0, 1, '*');
                       setRobotRow(1);
                   }
                    break;
                }
                else { return false; }
            case 3:
                if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) {
                    if (robMaze.getCell(getRobotRow(), getRobotCol() - 1) == 'o' || robMaze.getCell(getRobotRow(), getRobotCol() - 1) == 'v') {
                        robMaze.setCell(getRobotRow(), getRobotCol() - 1, 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'v');
                        robMaze.setCell(0, 1, '*');
                        setRobotCol(-1);
                    } else {
                        robMaze.setCell(getRobotRow(), getRobotCol() - 1, 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'o');
                        robMaze.setCell(0, 1, '*');
                        setRobotCol(-1);
                    }
                    break;
                }
                else { return false; }
        }
        if (direction == 0) {
            if (robMaze.openCell(getRobotRow()  - 1, getRobotCol())) {
                if (isIntersection(0)) {
                    return false;
                }
                else {
                    return move(0);
                }
            }
        }
        else if (direction == 1) {
            if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) {
                if (isIntersection(1)) {
                    return false;
                }
                else {
                    return move(1);
                }
            }
        }
        else if (direction == 2) {
            if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) {
                if (isIntersection(2)) {
                    return false;
                }
                else {
                    return move(2);
                }
            }
        }
        else if (direction == 3) {
            if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) {
                if (isIntersection(3)) {
                    return false;
                }
                else {
                    return move(3);
                }
            }
        }
        return false;
    }

    /**
     * This method will let the robot know if it hit an intersection
     * @param direction an int based on the robots facing
     * @return true if it is an intersection, false if it isn't an intersection
     */
    private boolean isIntersection(int direction) {
        if (direction == 0 || direction == 2) {
            return (robMaze.openCell(getRobotRow(), getRobotCol() + 1) || robMaze.openCell(getRobotRow(), getRobotCol() - 1));
        }
        if (direction == 1 || direction == 3) {
            return (robMaze.openCell(getRobotRow() + 1, getRobotCol()) || robMaze.openCell(getRobotRow() - 1, getRobotCol()));
        }
        return false;
    }
}
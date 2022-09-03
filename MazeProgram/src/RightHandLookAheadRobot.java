/**
 * This is a recursive robot that will move forward, so long that there isn't a right turn.
 *
 * @author Ethan Christensen
 * CSIT 150
 */

public class RightHandLookAheadRobot extends RightHandRobot {
    /**
     * This creates a robot that is given a maze as a parameter to solve
     * @param maze that the robot must solve
     */
    RightHandLookAheadRobot(Maze maze) {
        super(maze);
        setDirection(0);
    }

    /**
     * This method will first move the robot forward one. Then if there isn't a right turn then the robot will recurse
     * the move method until a right turn is available.
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
                if (robMaze.getCell(getRobotRow() - 1, getRobotCol()) == 'o') {
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
            case 1:
                if (robMaze.getCell(getRobotRow(), getRobotCol() + 1) == 'o') {
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
            case 2:
                if (robMaze.getCell(getRobotRow() + 1, getRobotCol()) == 'o') {
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
            case 3:
                if (robMaze.getCell(getRobotRow(), getRobotCol() - 1) == 'o') {
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
     * If the robot hits a dead end, this method is called. This will flip the robot 180 degrees
     */
    public void turnAround() {
        if (getDirection() == 0) {
            setDirection(2);
        } else if (getDirection() == 1) {
            setDirection(3);
        } else if (getDirection() == 2) {
            setDirection(0);
        } else if (getDirection() == 3) {
            setDirection(1);
        }
    }

    /**
     * This method allows the robot to see if it is in a dead end. It is only a dead end if the spot in front, to the
     * left, and to the right is taken
     * @param direction an int corresponding to the robots facing
     * @return true if it is a dead end, false if it isn't a dead end
     */
    public boolean deadEnd(int direction) {
        if (direction == 0) {
            return !robMaze.openCell(getRobotRow() - 1, getRobotCol()) && !robMaze.openCell(getRobotRow(), getRobotCol() - 1) && robMaze.openCell(getRobotRow(), getRobotCol() + 1);
        }
        if (direction == 1) {
            return !robMaze.openCell(getRobotRow(), getRobotCol() + 1) && !robMaze.openCell(getRobotRow() + 1, getRobotCol()) && robMaze.openCell(getRobotRow() - 1, getRobotCol());
        }
        if (direction == 2) {
            return !robMaze.openCell(getRobotRow() + 1, getRobotCol()) && !robMaze.openCell(getRobotRow(), getRobotCol() - 1) && robMaze.openCell(getRobotRow(), getRobotCol() + 1);
        }
        if (direction == 3) {
            return !robMaze.openCell(getRobotRow(), getRobotCol() - 1) && !robMaze.openCell(getRobotRow() + 1, getRobotCol()) && robMaze.openCell(getRobotRow() - 1, getRobotCol());
        }
        return false;
    }

    /**
     * This method checks to see if the robot is in an intersection. It is only considered an intersection if it can
     * turn right.
     * @param direction int corresponding to the robots facing
     * @return true if it is an intersection, false if it isn't an intersection
     */
    public boolean isIntersection(int direction) {
        if (direction == 0) {
            return robMaze.openCell(getRobotRow(), getRobotCol() + 1);
        }
        if (direction == 1) {
            return robMaze.openCell(getRobotRow() + 1, getRobotCol());
        }
        if (direction == 2) {
            return robMaze.openCell(getRobotRow(), getRobotCol() - 1);
        }
        if (direction == 3) {
            return robMaze.openCell(getRobotRow() - 1, getRobotCol());
        }
        return false;
    }
}
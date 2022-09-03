/**
 * This robot will solve the maze by strictly following the right hand wall
 *
 * @author Ethan Christensen
 * CSIT 150
 */

public class RightHandRobot extends FacingRobot {
    /**
     * This will create a robot will a maze to solve also
     *
     * @param maze that is solved by the right hand robot
     */
    RightHandRobot(Maze maze) {
        super(maze);
        setDirection(2);
    }

    /**
     * this method chooses the moves in a way that will allow the robot to hug the right wall
     *
     * @return 0-3 based on if a position is open
     */
    @Override
    public int chooseMoveDirection() {
        if (getDirection() == 0) {
            if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) {
                setDirection(1);
            } else if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) {
                setDirection(0);
            } else if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) {
                setDirection(3);
            } else if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) {
                setDirection(2);
            }
        } else if (getDirection() == 1) {
            if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) {
                setDirection(2);
            } else if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) {
                setDirection(1);
            } else if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) {
                setDirection(0);
            } else if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) {
                setDirection(3);
            }
        } else if (getDirection() == 2) {
            if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) {
                setDirection(3);
            } else if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) {
                setDirection(2);
            } else if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) {
                setDirection(1);
            } else if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) {
                setDirection(0);
            }
        } else if (getDirection() == 3) {
            if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) {
                setDirection(0);
            } else if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) {
                setDirection(3);
            } else if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) {
                setDirection(2);
            } else if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) {
                setDirection(1);
            }
        }
        return getDirection();
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
        switch (direction) {
            case 0:
                if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) {
                    if (robMaze.getCell(getRobotRow() - 1, getRobotCol()) == 'o') {
                        robMaze.setCell(getRobotRow() - 1, getRobotCol(), 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'v');
                        robMaze.setCell(0, 1, '*');
                        setRobotRow(-1);
                        return true;
                    } else {
                        robMaze.setCell(getRobotRow() - 1, getRobotCol(), 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'o');
                        robMaze.setCell(0, 1, '*');
                        setRobotRow(-1);
                        return true;
                    }
                }
            case 1:
                if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) {
                    if (robMaze.getCell(getRobotRow(), getRobotCol() + 1) == 'o') {
                        robMaze.setCell(getRobotRow(), getRobotCol() + 1, 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'v');
                        robMaze.setCell(0, 1, '*');
                        setRobotCol(1);
                        return true;
                    }
                    else {
                        robMaze.setCell(getRobotRow(), getRobotCol() + 1, 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'o');
                        robMaze.setCell(0, 1, '*');
                        setRobotCol(1);
                        return true;
                    }
                }
            case 2:
                if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) {
                    if (robMaze.getCell(getRobotRow() + 1, getRobotCol()) == 'o') {
                        robMaze.setCell(getRobotRow() + 1, getRobotCol(), 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'v');
                        robMaze.setCell(0, 1, '*');
                        setRobotRow(1);
                        return true;
                    } else {
                        robMaze.setCell(getRobotRow() + 1, getRobotCol(), 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'o');
                        robMaze.setCell(0, 1, '*');
                        setRobotRow(1);
                        return true;
                    }
                }
            case 3:
                if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) {
                    if (robMaze.getCell(getRobotRow(), getRobotCol() - 1) == 'o') {
                        robMaze.setCell(getRobotRow(), getRobotCol() - 1, 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'v');
                        robMaze.setCell(0, 1, '*');
                        setRobotCol(-1);
                        return true;
                    } else {
                        robMaze.setCell(getRobotRow(), getRobotCol() - 1, 'R');
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'o');
                        robMaze.setCell(0, 1, '*');
                        setRobotCol(-1);
                        return true;
                    }
                }
        }
        return false;
    }
}
/**
 * This robot will solve the maze by strictly following the left hand wall.
 *
 * @author Ethan Christensen
 * CSIT 150
 */

public class LeftHandRobot extends FacingRobot {
    /**
     * This creates a robot that is given a maze as a parameter to solve by following the left hand side of the maze
     * @param maze that the robot must solve
     */
    LeftHandRobot(Maze maze) {
        super(maze);
        setDirection(0);
    }

    /**
     * Based on a specific condition the robot will always follow along the left wall
     * @return a direction change based on if the robot can go left and continue going the left
     */
    @Override
    public int chooseMoveDirection() {
        if (getDirection() == 0){
            if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) { setDirection(3); }
            else if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) { setDirection(0); }
            else if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) { setDirection(1); }
            else if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) { setDirection(2); }
        }
        else if (getDirection() == 1) {
            if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) { setDirection(0); }
            else if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) { setDirection(1); }
            else if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) { setDirection(2); }
            else if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) { setDirection(3); }
        }
        else if (getDirection() == 2) {
            if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) { setDirection(1); }
            else if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) { setDirection(2); }
            else if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) { setDirection(3); }
            else if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) { setDirection(0); }

        }
        else if (getDirection() == 3) {
            if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) { setDirection(2); }
            else if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) { setDirection(3); }
            else if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) { setDirection(0); }
            else if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) { setDirection(1); }
        }
        return getDirection();
    }

    /**
     * This will move the robot based on the direction given.
     * @param direction an int 0-3 indicating the direction of the robot
     * @return true if moved, false if unable to move
     */
    @Override
    public boolean move(int direction) {
        int row = getRobotRow();
        int col = getRobotCol();
        switch (direction) {
            case 0:
                if(robMaze.openCell( row - 1, col)) {
                    if (robMaze.getCell(getRobotRow() - 1, getRobotCol()) == 'o') {
                        robMaze.setCell(row - 1, col, 'R');
                        robMaze.setCell(row, col, 'v');
                        robMaze.setCell(0, 1, '*');
                        setRobotRow(-1);
                        return true;
                    } else {
                        robMaze.setCell(row - 1, col, 'R');
                        robMaze.setCell(row, col, 'o');
                        robMaze.setCell(0, 1, '*');
                        setRobotRow(-1);
                        return true;
                    }
                }
                else
                    return false;
            case 1:
                if(robMaze.openCell(getRobotRow(), getRobotCol() + 1)) {
                    if (robMaze.getCell(getRobotRow(), getRobotCol() + 1) == 'o') {
                        robMaze.setCell(row, col + 1, 'R');
                        robMaze.setCell(row, col, 'v');
                        robMaze.setCell(0, 1, '*');
                        setRobotCol(1);
                        return true;
                    } else {
                        robMaze.setCell(row, col + 1, 'R');
                        robMaze.setCell(row, col, 'o');
                        robMaze.setCell(0, 1, '*');
                        setRobotCol(1);
                        return true;
                    }
                }
                else
                    return false;
            case 2:
                if(robMaze.openCell(getRobotRow() + 1, getRobotCol())) {
                    if (robMaze.getCell(getRobotRow() + 1, getRobotCol()) == 'o') {
                        robMaze.setCell(row + 1, col, 'R');
                        robMaze.setCell(row, col, 'v');
                        robMaze.setCell(0, 1, '*');
                        setRobotRow(1);
                        return true;
                    } else {
                        robMaze.setCell(row + 1, col, 'R');
                        robMaze.setCell(row, col, 'o');
                        robMaze.setCell(0, 1, '*');
                        setRobotRow(1);
                        return true;
                    }
                }
                else
                    return false;
            case 3:
                if(robMaze.openCell(getRobotRow(), getRobotCol() - 1)) {
                    if (robMaze.getCell(getRobotRow(), getRobotCol() - 1) == 'o') {
                        robMaze.setCell(row, col - 1, 'R');
                        robMaze.setCell(row, col, 'v');
                        robMaze.setCell(0, 1, '*');
                        setRobotCol(-1);
                        return true;
                    } else {
                        robMaze.setCell(row, col - 1, 'R');
                        robMaze.setCell(row, col, 'o');
                        robMaze.setCell(0, 1, '*');
                        setRobotCol(-1);
                        return true;
                    }
                }
                else
                    return false;
        }
        return false;
    }
}

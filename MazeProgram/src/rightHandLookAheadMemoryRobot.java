public class rightHandLookAheadMemoryRobot extends RightHandLookAheadRobot {
    /**
     * This creates a robot that is given a maze as a parameter to solve
     *
     * @param maze that the robot must solve
     */
    rightHandLookAheadMemoryRobot(Maze maze) {
        super(maze);
    }

    @Override
    public boolean move(int direction) {
        if (getRobotRow() == robMaze.getExitRow() && getRobotCol() == robMaze.getExitCol()) {
            return false;
        }
        switch (direction) {
            case 0:
                if (robMaze.getCell(getRobotRow() - 1, getRobotCol()) == 'o') {
                    robMaze.setCell(getRobotRow() - 1, getRobotCol(), 'R');
                    robMaze.setCell(getRobotRow(), getRobotCol(), 'D');
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
                    robMaze.setCell(getRobotRow(), getRobotCol(), 'D');
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
                    robMaze.setCell(getRobotRow(), getRobotCol(), 'D');
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
                    robMaze.setCell(getRobotRow(), getRobotCol(), 'D');
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
}

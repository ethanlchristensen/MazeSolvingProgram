public class leftHandMemoryRobot extends LeftHandRobot {
    /**
     * This creates a robot that is given a maze as a parameter to solve by following the left hand side of the maze
     *
     * @param maze that the robot must solve
     */
    leftHandMemoryRobot(Maze maze) {
        super(maze);
    }

    @Override
    public boolean move(int direction) {
        int row = getRobotRow();
        int col = getRobotCol();
        switch (direction) {
            case 0:
                if(robMaze.openCell( row - 1, col)) {
                    if (robMaze.getCell(getRobotRow() - 1, getRobotCol()) == 'o') {
                        robMaze.setCell(row - 1, col, 'R');
                        robMaze.setCell(row, col, 'D');
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
                        robMaze.setCell(row, col, 'D');
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
                        robMaze.setCell(row, col, 'D');
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
                        robMaze.setCell(row, col, 'D');
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

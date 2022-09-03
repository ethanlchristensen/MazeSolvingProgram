public class rightHandMemoryRobot extends RightHandRobot {

    /**
     * This will create a robot will a maze to solve also
     *
     * @param maze that is solved by the right hand robot
     */
    rightHandMemoryRobot(Maze maze) {
        super(maze);
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
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'D');
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
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'D');
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
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'D');
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
                        robMaze.setCell(getRobotRow(), getRobotCol(), 'D');
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

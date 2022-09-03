import com.sun.org.glassfish.gmbal.IncludeSubclass;

import java.util.*;
/**
 * This robot will solve the maze by strictly following the right hand wall
 *
 * @author Ethan Christensen
 * CSIT 150
 */

public class depthFirstSearchRobot extends FacingRobot {
    /**
     * This will create a robot will a maze to solve also
     *
     * @param maze that is solved by the right hand robot
     */
    depthFirstSearchRobot(Maze maze) {
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
        return 0;
    }

    @Override
    public ArrayList<Integer> getMoves() {
        ArrayList<Integer> startPosition = new ArrayList<>();
        System.out.println(robMaze.getCols());
        System.out.println(robMaze.getRows());
        for( int i = 0; i < robMaze.getRows(); i++) {
            for( int j = 0; j < robMaze.getCols(); j++) {
                System.out.println(robMaze.getCell(i, j));
                if (robMaze.getCell(i, j) == 'S') {
                    startPosition.add(i);
                    startPosition.add(j);
                    break;
                }
            }
        }
        System.out.println(startPosition);
        return startPosition;
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
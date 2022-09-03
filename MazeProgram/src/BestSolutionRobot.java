/**
 * This robot is similar to a Random Look Ahead Robot. It will recursively move forward until it comes to an intersection.
 * At the intersection the robot will randomly decide what to do based on current conditions.
 *
 * @author Ethan Christensen
 * CSIT 150
 */

public class BestSolutionRobot extends FacingRobot {
    /**
     * This creates a robot that is given a maze as a parameter to solve
     *
     * @param maze that the robot must solve
     */
    BestSolutionRobot(Maze maze) {
        super(maze);
        setDirection(2);
    }

    /**
     * This methods job is to choose a move direction randomly based on its current facing. This method will not allow
     * the robot to turn completely around though. This is because it will decrease the likely hood of the robot randomly
     * finding the best solution. This method also checks to see if the cell it is about to turn to is open, if it isn't
     * the method will recurse until it finds an open cell it can turn in to.
     * @return an int value equal to a direction
     */
    public int chooseMoveDirection() {
        int[] EorWorN = {1, 3, 0};
        int[] EorWorS = {1, 3, 2};
        int[] NorSorE = {1, 2, 0};
        int[] NorSorW = {0, 2, 3};

        if (deadEnd(getDirection())) {
            turnAround();
        }
        else {
            if (getDirection() == 0) {
                int tryDirection = (int) (3 * Math.random());
                if (EorWorN[tryDirection] == 0) {
                    if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) {
                        setDirection(0);
                        return getDirection();
                    } else {
                        return chooseMoveDirection();
                    }
                }
                else if (EorWorN[tryDirection] == 1) {
                    if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) {
                        setDirection(1);
                        return getDirection();
                    } else {
                        return chooseMoveDirection();
                    }
                }
                else if (EorWorN[tryDirection] == 3) {
                    if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) {
                        setDirection(3);
                        return getDirection();
                    } else {
                        return chooseMoveDirection();
                    }
                }
            }
            else if (getDirection() == 1) {
                int tryDirection = (int) (3 * Math.random());
                if (NorSorE[tryDirection] == 0) {
                    if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) {
                        setDirection(0);
                        return getDirection();
                    } else {
                        return chooseMoveDirection();
                    }
                }
                else if (NorSorE[tryDirection] == 1) {
                    if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) {
                        setDirection(1);
                        return getDirection();
                    } else {
                        return chooseMoveDirection();
                    }
                }
                else if (NorSorE[tryDirection] == 2) {
                    if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) {
                        setDirection(2);
                        return getDirection();
                    } else {
                        return chooseMoveDirection();
                    }
                }
            }
            else if (getDirection() == 2) {
                int tryDirection = (int) (3 * Math.random());
                if (EorWorS[tryDirection] == 1) {
                    if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) {
                        setDirection(1);
                        return getDirection();
                    } else {
                        return chooseMoveDirection();
                    }
                }
                else if (EorWorS[tryDirection] == 2) {
                    if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) {
                        setDirection(2);
                        return getDirection();
                    } else {
                        return chooseMoveDirection();
                    }
                }
                else if (EorWorS[tryDirection] == 3) {
                    if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) {
                        setDirection(3);
                        return getDirection();
                    } else {
                        return chooseMoveDirection();
                    }
                }
            }
            else if (getDirection() == 3) {
                int tryDirection = (int) (3 * Math.random());
                if (NorSorW[tryDirection] == 0) {
                    if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) {
                        setDirection(0);
                        return getDirection();
                    } else {
                        return chooseMoveDirection();
                    }
                }
                else if (NorSorW[tryDirection] == 2) {
                    if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) {
                        setDirection(2);
                        return getDirection();
                    } else {
                        return chooseMoveDirection();
                    }
                }
                else if (NorSorW[tryDirection] == 3) {
                    if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) {
                        setDirection(3);
                        return getDirection();
                    } else {
                        return chooseMoveDirection();
                    }
                }
            }
        }
        return getDirection();
    }

    /**
     * This robot will move the robot one space initially and then check to see if the robot moved into an intersection.
     * If it hasn't moved into an intersection then the robot recursively moves forward until it hits an intersection. Once
     * it hits an intersection the method will break resulting in the robot choosing a new move direction.
     * @param direction an int corresponding to the robots facing
     * @return true if the robot moved, false if the robot didn't move
     */
    public boolean move(int direction) {
        if (getRobotRow() == robMaze.getExitRow() && getRobotCol() == robMaze.getExitCol()) {
            return false;
        }
        switch (direction) {
            case 0:
                if (robMaze.openCell(getRobotRow() - 1, getRobotCol())) {
                    robMaze.setCell(getRobotRow() - 1, getRobotCol(), 'R');
                    robMaze.setCell(getRobotRow(), getRobotCol(), 'o');
                    robMaze.setCell(0, 1, '*');
                    setRobotRow(-1);
                    break;
                }
                else {
                    return false;

                }
            case 1:
                if (robMaze.openCell(getRobotRow(), getRobotCol() + 1)) {
                    robMaze.setCell(getRobotRow(), getRobotCol() + 1, 'R');
                    robMaze.setCell(getRobotRow(), getRobotCol(), 'o');
                    robMaze.setCell(0, 1, '*');
                    setRobotCol(1);
                    break;
                }
                else {
                    return false;
                }
            case 2:
                if (robMaze.openCell(getRobotRow() + 1, getRobotCol())) {
                    robMaze.setCell(getRobotRow() + 1, getRobotCol(), 'R');
                    robMaze.setCell(getRobotRow(), getRobotCol(), 'o');
                    robMaze.setCell(0, 1, '*');
                    setRobotRow(1);
                    break;
                }
                else {
                    return false;
                }
            case 3:
                if (robMaze.openCell(getRobotRow(), getRobotCol() - 1)) {
                    robMaze.setCell(getRobotRow(), getRobotCol() - 1, 'R');
                    robMaze.setCell(getRobotRow(), getRobotCol(), 'o');
                    robMaze.setCell(0, 1, '*');
                    setRobotCol(-1);
                    break;
                }
                else {
                    return false;
                }
        }
        if (direction == 0) {
            if (isIntersection(0)) {
                return false;
            }
            else {
                return move(0);
            }
        }
        else if (direction == 1) {
            if (isIntersection(1)) {
                return false;
            }
            else {
                return move(1);
            }
        }
        else if (direction == 2) {
            if (isIntersection(2)) {
                return false;
            }
            else {
                return move(2);
            }
        }
        else if (direction == 3) {
            if (isIntersection(3)) {
                return false;
            }
            else {
                return move(3);
            }
        }
        return false;
    }

    /**
     * Based on the current facing, this method allows the robot to check to see if it has moved into an intersection.
     * @param direction an int corresponding to its facing.
     * @return true if it is an intersection, false if it isn't an intersection
     */
    private boolean isIntersection(int direction) {
        if (direction == 0) {
            return robMaze.openCell(getRobotRow(), getRobotCol() + 1) || robMaze.openCell(getRobotRow(), getRobotCol() - 1);
        }
        else if (direction == 1) {
            return robMaze.openCell(getRobotRow() + 1, getRobotCol()) || robMaze.openCell(getRobotRow() - 1, getRobotCol());
        }
        else if (direction == 2) {
            return robMaze.openCell(getRobotRow(), getRobotCol() + 1) || robMaze.openCell(getRobotRow(), getRobotCol() - 1);
        }
        else if (direction == 3) {
            return robMaze.openCell(getRobotRow() + 1, getRobotCol()) || robMaze.openCell(getRobotRow() - 1, getRobotCol());
        }
        return false;
    }

    /**
     * If the robot hits a dead end, then this method is called and will rotate the robot 180 degrees.
     */
    private void turnAround() {
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
     * This method allows the robot to recognize it is in a dead end. It will only return true if the space in front and to the left and right of the robot are not available.
     * @param direction an int corresponding to its facing
     * @return true if it is a dead end, false if it isn't a dead end
     */
    private boolean deadEnd(int direction) {
        if (direction == 0) {
            return (!robMaze.openCell(getRobotRow() - 1, getRobotCol()) && !robMaze.openCell(getRobotRow(), getRobotCol() - 1) && !robMaze.openCell(getRobotRow(), getRobotCol() + 1));
        }
        if (direction == 1) {
            return (!robMaze.openCell(getRobotRow(), getRobotCol() + 1) && !robMaze.openCell(getRobotRow() + 1, getRobotCol()) && !robMaze.openCell(getRobotRow() - 1, getRobotCol()));
        }
        if (direction == 2) {
            return (!robMaze.openCell(getRobotRow() + 1, getRobotCol()) && !robMaze.openCell(getRobotRow(), getRobotCol() - 1) && !robMaze.openCell(getRobotRow(), getRobotCol() + 1));
        }
        if (direction == 3) {
            return (!robMaze.openCell(getRobotRow(), getRobotCol() - 1) && !robMaze.openCell(getRobotRow() + 1, getRobotCol()) && !robMaze.openCell(getRobotRow() - 1, getRobotCol()));
        }
        return false;
    }
}

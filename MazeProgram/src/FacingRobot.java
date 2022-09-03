/**
 * This contains the four cardinal directions
 *
 * @author Ethan Christensen
 * CSIT 150
 */

public abstract class FacingRobot extends Robot {
    private Directions facing = Directions.NORTH;

    /**
     * This creates a robot that is given a maze as a parameter to solve
     * @param maze that the robot must solve
     */
    FacingRobot(Maze maze) {
        super(maze);
    }

    @Override
    public abstract int chooseMoveDirection();

    @Override
    public abstract boolean move(int direction);

    /**
     * @return the int value of the direction
     */
    public int getDirection() { return facing.ordinal(); }

    /**
     * Sets the direction of the robot
     * @param d int 0-3
     */
    public void setDirection(int d) {
        if (d == 0) { facing = Directions.NORTH; }
        if (d == 1) { facing = Directions.EAST; }
        if (d == 2) { facing = Directions.SOUTH; }
        if (d == 3) { facing = Directions.WEST; }
    }
}

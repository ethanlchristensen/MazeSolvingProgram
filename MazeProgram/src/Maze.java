/**
 * This class is responsible for creating an array that will store the maze from the text file. It is
 * also responsible for changing and updating and reporting information about the maze.
 *
 * @author Ethan Christensen
 * CSIT 150
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Default constructor of a maze.
 */
public class Maze {
    private int startRow;
    private int startCol;
    private int endRow;
    private int endCol;
    private int numRow;
    private int numCol;
    private char[][] Maze;

    /**
     * This constructor takes in a txt file.
     * creates the char array and variables that will store the corresponding int from the txt file
     *
     * @param MazeFile is the imported txt file
     * @throws IOException
     */
    public Maze(File MazeFile) throws IOException {
        Scanner mazeScan = new Scanner(MazeFile);
        numRow = Integer.parseInt(mazeScan.next()); //reads the first two integers in
        numCol = Integer.parseInt(mazeScan.next());
        mazeScan.nextLine(); //goes to next line in txt file
        startRow = Integer.parseInt(mazeScan.next()); //reads in the next two integers
        startCol = Integer.parseInt(mazeScan.next());
        mazeScan.nextLine(); //reads in the next line in txt file
        endRow = Integer.parseInt(mazeScan.next()); //reads in the next two integers
        endCol = Integer.parseInt(mazeScan.next());
        mazeScan.nextLine();
        Maze = new char[numRow][numCol];//creates the maze board array
        int i = 0;
        while (i < numRow) { //this loop goes through each line and assigns each of position of the char array with each corresponding char of the string line
            String line = mazeScan.nextLine();
            for (int j = 0; j < numCol; j++) {
                Maze[i][j] = line.charAt(j);
            }
            i++;
        }
    }

    /**
     * @return the char maze
     */
    public char[][] getMaze() {
        char[][] returnMaze = new char[getRows()][getCols()];
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                returnMaze[i][j] = Maze[i][j];
            }
        }
        return returnMaze;
    }

    /**
     * @return the number of rows in the maze array
     */
    public int getRows() {
        return numRow;
    }

    /**
     * @return the number of columns in the maze array
     */
    public int getCols() {
        return numCol;
    }

    /**
     * @return the row position of the start of the maze
     */
    int getStartRow() {
        return startRow;
    }

    /**
     * @return the col position of the start of the maze
     */
    int getStartCol() {
        return startCol;
    }

    /**
     * @return the row position of the end of the maze
     */
    int getExitRow() {
        return endRow;
    }

    /**
     * @return the col position of the end of the maze
     */
    int getExitCol() {
        return endCol;
    }

    /**
     * @param row the row position robot wants to get
     * @param col the col position robot wants to get
     * @return the char of the cell requested by the robot
     */
    char getCell(int row, int col) {
        if (row < 0 || col < 0 || row > getRows() || col > getCols()) {
            return 'X';
        } else {
            return Maze[row][col];
        }
    }

    /**
     * This function is used to determine if a cell is available to be moved to
     *
     * @param row the row of the cell the robot wants to move to
     * @param col the col of the cell the robot wants to move to
     * @return true of false if the cell is or isn't open
     */
    boolean openCell(int row, int col) {
        if (row < 0 || col < 0) { //if the robot is trying to move outside of the maze array
            return false;
        }
        if (row > getRows() - 1 || col > getCols() - 1) {
            return false;
        }
        return Maze[row][col] == 'o' || Maze[row][col] == ' ' || Maze[row][col] == 'X' || Maze[row][col] == 'v';
    }

    /**
     * This sets a cell to a specified char
     *
     * @param row   where the cell is being modified
     * @param col   where the cell is being modified
     * @param newCh char that is being put into the cell
     */
    public void setCell(int row, int col, char newCh) {
        Maze[row][col] = newCh;
    }

    /**
     * @return the maze array in a expanded format that is easier to visualize
     */
    public String toString() {
        StringBuffer mazeBoard = new StringBuffer();
        for (char[] chars : Maze) {
            for (char aChar : chars) {
                mazeBoard.append(aChar).append(" ");
            }
            mazeBoard.append("\n");
        }
        return String.valueOf(mazeBoard);
    }

    public Maze(Maze inMaze) {
        numRow = inMaze.getRows();
        numCol = inMaze.getCols();
        startRow = inMaze.getStartRow();
        startCol = inMaze.getStartCol();
        endRow = inMaze.getExitRow();
        endCol = inMaze.getExitCol();
        for (int i = 0; i < inMaze.getMaze().length; i++) {
            for (int j = 0; j < inMaze.getMaze()[i].length; j++) {
                Maze = inMaze.getMaze();
            }
        }
    }
}
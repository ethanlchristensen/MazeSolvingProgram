import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;


/**
 * This program simulates a robot getting through a maze.
 *	Unlike tic-tac-toe, where the user is the player, the robot moves 
	autonomously through the maze.
 * 	We intentionally share the memory location of the maze with the robot.
	Otherwise the robot would not know how to plan and make its moves.
	
	The maze is stored in a text file that will be entered at runtime.  
	The layout of each maze file will contain:
�	In the first line:  two integers (the number of rows and columns, respectively,  in the maze)  
�	In the second line:  two integers (the row and column locations, respectively, of the Start cell
�	In the third line:  two integers (the row and column locations, respectively, of the Exit cell
�	Each line thereafter will contain characters appearing in one row of the maze.  

 * Created by Sherri Harms
 * built on top of Eddy's UW-Parkside solution
 */

public class MazeDriver {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner input = new Scanner(System.in);
		int ans = 0;
		while (ans != 1) {
			int answer;
			int moves;
			File inputFile = getFile();  //sample: testmaze.txt
			Maze maze = new Maze(inputFile);
			System.out.println(maze);
			System.out.println("What type of robot do you want to solve the maze?\n1. Random Robot\n2. RightHandRobot\n3. LeftHandRobot\n4. RightHandLookAheadRobot\n5. LeftHandLookAheadRobot\n6. RandomLookAheadRobot\n7. BestSolutionRobot");
			answer = input.nextInt();
			if (answer == 1) {
				Robot bot = new RandomRobot(maze);
				moves = 0;
				for (int k = 0; k < 1000000 && !bot.solved(); k++)
				//this limits the robot's moves, in case it takes too long to find the exit.
				{
					int direction = bot.chooseMoveDirection();
					if (direction >= 0)  //invalid direction is -1
						bot.move(direction);

					Thread.sleep(200);
					System.out.println(maze);
					moves++;
				}
				System.out.print("It took the robot " + moves + " moves to solve the maze.");
				System.out.println("Do you want to try a different robot? 1. no 2. yes");
				ans = input.nextInt();
			}
			else if (answer == 2) {
				Robot bot = new RightHandRobot(maze);
				moves = 0;
				for (int k = 0; k < 1000000 && !bot.solved(); k++)
				//this limits the robot's moves, in case it takes too long to find the exit.
				{
					int direction = bot.chooseMoveDirection();
					if (direction >= 0)  //invalid direction is -1
						bot.move(direction);

					Thread.sleep(200);
					System.out.println(maze);
					moves++;
				}
				System.out.println("It took the robot " + moves + " moves to solve the maze.");
				System.out.println("Do you want to try a different robot? 1. no 2. yes");
				ans = input.nextInt();
			}
			else if (answer == 3) {
				Robot bot = new LeftHandRobot(maze);
				moves = 0;
				for (int k = 0; k < 1000000 && !bot.solved(); k++)
				//this limits the robot's moves, in case it takes too long to find the exit.
				{
					int direction = bot.chooseMoveDirection();
					if (direction >= 0)  //invalid direction is -1
						bot.move(direction);

					Thread.sleep(200);
					System.out.println(maze);
					moves++;
				}
				System.out.println("It took the robot " + moves + " moves to solve the maze.");
				System.out.println("Do you want to try a different robot? 1. no 2. yes");
				ans = input.nextInt();
			}
			else if (answer == 4) {
				Robot bot = new RightHandLookAheadRobot(maze);
				moves = 0;
				for (int k = 0; k < 1000000 && !bot.solved(); k++)
				//this limits the robot's moves, in case it takes too long to find the exit.
				{
					int direction = bot.chooseMoveDirection();
					if (direction >= 0)  //invalid direction is -1
						bot.move(direction);

					Thread.sleep(200);
					System.out.println(maze);
					moves++;
				}
				System.out.println("It took the robot " + moves + " moves to solve the maze.");
				System.out.println("Do you want to try a different robot? 1. no 2. yes");
				ans = input.nextInt();
			} else if (answer == 5) {
				Robot bot = new LeftHandLookAheadRobot(maze);
				moves = 0;
				for (int k = 0; k < 1000000 && !bot.solved(); k++)
				//this limits the robot's moves, in case it takes too long to find the exit.
				{
					int direction = bot.chooseMoveDirection();
					if (direction >= 0)  //invalid direction is -1
						bot.move(direction);

					Thread.sleep(200);
					System.out.println(maze);
					moves++;
				}
				System.out.print("It took the robot " + moves + " moves to solve the maze.");
				System.out.println("Do you want to try a different robot? 1. no 2. yes");
				ans = input.nextInt();
			}
			else if (answer == 6) {
				Robot bot = new RandomLookAheadRobot(maze);
				moves = 0;
				for (int k = 0; k < 1000000 && !bot.solved(); k++)
				//this limits the robot's moves, in case it takes too long to find the exit.
				{
					int direction = bot.chooseMoveDirection();
					if (direction >= 0)  //invalid direction is -1
						bot.move(direction);

					Thread.sleep(200);
					System.out.println(maze);
					moves++;
				}
				System.out.println("It took the robot " + moves + " moves to solve the maze.");
				System.out.println("Do you want to try a different robot? 1. no 2. yes");
				ans = input.nextInt();
			}
			else if (answer == 7) {
				System.out.println("BestSolutionRobot - This may take me a second!");
				int movesCount = 10000;
				char[][] restartMaze = new char[maze.getRows()][maze.getCols()];
				for (int i = 0; i < maze.getRows(); i++) {
					for (int j = 0; j < maze.getCols(); j++) {
						restartMaze[i][j] = maze.getCell(i, j);
					}
				}
				char[][] bestSolution = new char[maze.getRows()][maze.getCols()];
				for (int i = 0; i < 1000000; i++) {
					Robot bot = new BestSolutionRobot(maze);
					moves = 0;
					for (int k = 0; k < movesCount && !bot.solved(); k++) {
						int direction = bot.chooseMoveDirection();
						if (direction >= 0)  //invalid direction is -1
							bot.move(direction);
						moves++;
					}
					if (moves < movesCount) {
						for (int a = 0; a < bot.robMaze.getRows(); a++) {
							for (int b = 0; b < bot.robMaze.getCols(); b++) {
								bestSolution[a][b] = bot.robMaze.getCell(a, b);
							}
						}
						movesCount = moves;
					}
					for (int a = 0; a < bot.robMaze.getRows(); a++) {
						for (int b = 0; b < bot.robMaze.getCols(); b++) {
							bot.robMaze.setCell(a, b, restartMaze[a][b]);
						}
					}
				}
				StringBuffer mazeBoard = new StringBuffer();
				for (char[] chars : bestSolution) {
					for (char aChar : chars) {
						mazeBoard.append(aChar).append(" ");
					}
					mazeBoard.append("\n");
				}
				System.out.println(mazeBoard);
				System.out.println("The best solution I could find to the maze took " + movesCount + " moves to solve.");
				System.out.println("Do you want to try a different robot? 1. no 2. yes");
				ans = input.nextInt();
			}
		}
		System.out.println("Thanks for solving!");
	}

	/**
	 * Get the file that has the maze specifications.
	 * @return File chosen by user.
	 */
	public static File getFile()
	{
		JFileChooser chooser;
		try{

			// Get the filename.
			chooser = new JFileChooser();
			int status = chooser.showOpenDialog(null);
			if (status != JFileChooser.APPROVE_OPTION)
			{
				System.out.println("No File Chosen");
				System.exit(0);
			}
			return chooser.getSelectedFile();
		} catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
			System.exit(0);

		}
		return null; //should never get here, but makes compiler happy
	}
}
import java.util.ArrayList;
import java.util.HashSet;

public class RobotInAGrid {
	public static void main(String[] args){
		boolean[][] testMaze = new boolean[5][5];
		for(int i = 0; i < testMaze.length; i++){
			for(int j = 0; j < testMaze.length; j++){
				testMaze[i][j] = true;
			}
		}
		ArrayList<Point> result = getPath(testMaze);
		for(Point a: result){
			System.out.println(a.column + ", " + a.row);
		}
	}
	
	//Original idea: bidirectional search from the end and the beginning, as O(k^(d/2)) where d is the distance between, and k is the number 
	//of nodes to be searched
	//in this instance, O(2^(d/2)), as there can only be down and right coming from upper node, and up and left coming from bottom node
	
	
	
	//Better soln: simply go through all points/solutions and record accessed points.
	//================================================================================================================
	//Problem: Caching is not working
	//================================================================================================================
	
	public static ArrayList<Point> solveGrid(boolean[][] maze){
		CoupledReference result = solveGridRec(maze, new HashSet<Point>(), new ArrayList<Point>(), new Point(0,0));
		return result.path;
	}
	
	private static CoupledReference solveGridRec(boolean[][] maze, HashSet<Point> failPoints, ArrayList<Point> path, Point curr){
		Point belowPoint = new Point(curr.row + 1, curr.column);
		boolean belowExists = belowPoint.row < maze.length && maze[belowPoint.row][belowPoint.column];

		Point rightPoint = new Point(curr.row, curr.column + 1);
		boolean rightExists = rightPoint.column < maze[0].length && maze[rightPoint.row][rightPoint.column];

		if(!rightExists && !belowExists){
			if(curr.column == maze[0].length -1 && curr.row == maze.length - 1){
				path.add(curr);
			}else{
				failPoints.add(curr);
			}
			return (new CoupledReference(path, curr));
			
		}else{
			boolean belowUntested = !failPoints.contains(belowPoint) && !path.contains(belowPoint);
			
			if(belowExists && belowUntested){
				
				CoupledReference test = solveGridRec(maze, failPoints, path, belowPoint);
				Point testPoint = test.curr;
				
				//is this 2D array's reference to the column length?
				if(testPoint.column == maze[0].length - 1 && testPoint.row == maze.length - 1){
					path.add(curr);
				}else{
					failPoints.add(curr);
				}
			}
			
			boolean rightUntested = !failPoints.contains(rightPoint) && !path.contains(rightPoint);
			
			if(rightExists && rightUntested){
				
				CoupledReference test = solveGridRec(maze, failPoints, path, rightPoint);
				Point testPoint = test.curr;
				
				if(testPoint.column == maze[0].length - 1 || testPoint.row == maze.length - 1){
					path.add(curr);
				}else{
					failPoints.add(curr);
				}
			}
			
			return new CoupledReference(path, curr);
		}
	}
	
	public static ArrayList<Point> getPath(boolean[][] maze){
		if(maze == null || maze.length == 0){
			return null;
		}
		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		
		if(getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)){
			return path;
		}
		return null;
	}
	
	private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints){
		if(col < 0 || row < 0 || !maze[row][col]){
			return false;
		}
		Point p = new Point(row, col);
		
		if(failedPoints.contains(p)){
			return false;
		}
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		if(isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)){
			path.add(p);
			return true;
		}
		
		failedPoints.add(p);
		return false;
	}
}

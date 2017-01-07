import java.util.ArrayList;

public class CoupledReference {
	public ArrayList<Point> path;
	public Point curr;
	
	public CoupledReference(ArrayList<Point> path, Point curr){
		this.curr = curr;
		this.path = path;
	}
}

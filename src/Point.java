
public class Point{
	public int row;
	public int column;
	
	public Point(int row, int column){
		this.row = row;
		this.column = column;
	}

	@Override
	public boolean equals(Object other){
		Point test = (Point) other;
		return (this.row == test.row) && (this.column == test.column);
	}
	
	//incorrect unique hashing for any maze with row length over 10, but that doesn't matter for my testing
	@Override
	public int hashCode(){
		return row + 10*column;
	}
}

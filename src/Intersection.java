
public class Intersection {
	public static void main(String[] args){
		intPoint a1 = new intPoint(-1,-1);
		intPoint a2 = new intPoint(1,1);
		intPoint b1 = new intPoint(-1, 1);
		intPoint b2 = new intPoint(1, -1);
		
		doublePoint soln00 = interMethod(a1, a2, b1, b2);
		if(soln00 != null){
			System.out.println("x: " + soln00.x + ", y: " + soln00.y);
		}
	}
	
	public static doublePoint interMethod(intPoint a1, intPoint a2, intPoint b1, intPoint b2){
		double aSlope = ((double) (a2.y-a1.y))/(a2.x - a1.x);
		double bSlope = ((double) (b2.y-b1.y))/(b2.x - b1.x);
		
		//if infinite solutions
		if(aSlope - bSlope < 0.001){
			return new doublePoint((double)a1.x, (double)a1.y);
		}
		
		double aIntersect = a2.y - (aSlope*a2.x);
		double bIntersect = b2.y - (bSlope*b2.x);
		
		
		double x = (aIntersect - bIntersect)/(bSlope - aSlope);
		
		if (((x >= a2.x && x<= a1.x) || (x<= a2.x && x > a1.x)) && ((x >= b2.x && x < b1.x) || (x <= b2.x && x > b1.x))){
			return new doublePoint(x, aSlope*x + aIntersect);
		}
		return null;
	}
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Recursively computes PowerSet
public class PowerSet {
	public static void main(String[] args){
		ArrayList<Integer> testSet = new ArrayList<Integer>();
		for(int i = 0; i < 3; i++){
			testSet.add(i);
		}
		Queue<ArrayList<Integer>> testSoln = powerSetMethod(testSet);
		
		while(!testSoln.isEmpty()){
			ArrayList<Integer> a = testSoln.remove();
			for(int i = 0; i < a.size(); i++){
				System.out.print(a.get(i) + ", ");
			}
			System.out.println();
		}
	}
	
	public static Queue<ArrayList<Integer>> powerSetMethod(ArrayList<Integer> set){
		Queue<ArrayList<Integer>> solns = new LinkedList<ArrayList<Integer>>();
		solns.add(new ArrayList<Integer>());
		return powerSetMethod(set, solns, 0);
	}
	
	private static Queue<ArrayList<Integer>> powerSetMethod(ArrayList<Integer> set,
			Queue<ArrayList<Integer>> solns, int index){
		int amtRem = solns.size();
		if(index < set.size()){
			System.out.println("Swag");
			for(int i = 0; i < amtRem; i++){
				ArrayList<Integer> curr = solns.remove();
				
				@SuppressWarnings("unchecked")
				ArrayList<Integer> copy = (ArrayList<Integer>) curr.clone();
				copy.add(set.get(index));
				solns.add(curr);
				solns.add(copy);
			}
			powerSetMethod(set, solns, index + 1);
		}
		return solns;
	}
}

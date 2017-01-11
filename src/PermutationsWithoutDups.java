import java.util.LinkedList;
import java.util.Queue;

public class PermutationsWithoutDups {
	public static void main(String[] args){
		String abc = new String("abc");
		Queue<String> result = permsWithoutDups("abc");
		while(!result.isEmpty()){
			String temp = result.remove();
			System.out.println(temp);
		}
	}
	
	public static Queue<String> permsWithoutDups(String s){
		Queue<String> sQue = new LinkedList<String>();
		sQue.add(s);
		return permsWithoutDups(s, sQue, 0);
	}
	
	private static Queue<String> permsWithoutDups(String s, Queue<String> sQue, int index){
		if(index < s.length()){
			int sQueSZ = sQue.size();
			for(int i = 0; i < sQueSZ; i++){
				String same = sQue.remove();
				for(int j = index + 1; j < same.length(); j++){
					char[] copy = same.substring(0, same.length()).toCharArray();
					char temp = copy[index];
					copy[index] = copy[j];
					copy[j] = temp;
					sQue.add(new String(copy));
				}
				sQue.add(same);
			}
			permsWithoutDups(s, sQue, index+1);
		}
		return sQue;
	}
}

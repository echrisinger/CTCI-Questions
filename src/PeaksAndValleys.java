import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

//O(n) solution, as it iterates through, and finds all the instances of certain integer values, and creates the max->min peak valley list.
//One pass solution

//Other solution is to track an element as either a peak or a valley, and swap with the ones next to it according to whether they would fit as a peak or a valley
//then swapping whether this should be a peak or a valley accordingly as you move to the next element with the integer. This would also be O(n) as at most you
//access O(n+2) things.

public class PeaksAndValleys {
	public static void main(String[] args){
		int[] a = {5,3,1,2,3,4,7,0,9,8,2};
		ArrayList<Integer> newOrder = pvMethod(a);
		for(int b : newOrder){
			System.out.print(b + ", ");
		}
	}
	
	public static ArrayList<Integer> pvMethod(int[] a){
		HashMap<Integer, Integer> intInst = new HashMap<Integer, Integer>();
		for(int i = 0; i < a.length; i++){
			if(!intInst.containsKey(a[i])){
				intInst.put(a[i], 0);
			}
			intInst.put(a[i], intInst.get(a[i]) + 1);
		}
		
		ArrayList<Integer> keys = new ArrayList<Integer>(intInst.keySet());

		int frontTrack = 0;
		int backTrack = keys.size() - 1;
		
		boolean takeFront = true;
		
		ArrayList<Integer> reOrder = new ArrayList<Integer>();
		
		while(!(frontTrack > backTrack)){
			int keyVal;
			int currKey;
			if(takeFront){
				currKey = keys.get(frontTrack);
				keyVal = intInst.get(currKey);
				if(keyVal > 0){
					reOrder.add(currKey);
					intInst.put(currKey, intInst.get(currKey) - 1);
				}else{
					frontTrack++;
					if(frontTrack > backTrack){
						break;
					}else{
						continue;
					}
				}
			}else{
				currKey = keys.get(backTrack);
				keyVal = intInst.get(keys.get(backTrack));
				if(keyVal > 0){
					reOrder.add(currKey);
					intInst.put(currKey, intInst.get(currKey) - 1);
				}else{
					backTrack--;
					if(backTrack < frontTrack){
						break;
					}else{
						continue;
					}
				}
			}
			//flip to the other case
			takeFront = !takeFront;
		}
		
		return reOrder;
	}
}

import java.util.Set;

//better implementation is to use binary search on sorted array, thus finding it faster, by comaring the difference between the index and
//A[ind]
public class MagicIndex {
	public static void main(String[] args){
		int[] pizza = new int[5];
		pizza[0] = -1;
		pizza[1] = 0;
		pizza[2] = 1;
		pizza[3] = 2;
		pizza[4] = 4;
		
		System.out.println(magicIndexMethod(pizza));
	}
	
	public static int magicIndexMethod(int[] val){
		return magicIndexMethodRec(val, 0);
	}
	
	private static int magicIndexMethodRec(int[] val, int ind){
		if(val[ind] == ind){
			return ind;
		//if an earlier distinct value is greater than the final value of val[i], there can be no values for which val[i] = i from there on in sorted arr
		}else if(val[ind] > val.length - 1 || val.length - 1 == ind){
			return -1;
		}else{
			return magicIndexMethodRec(val, ind + 1);
		}
	}
}

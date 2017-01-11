
public class SortedMerge {
	public static void main(String[] args){
		int[] a = {0,2,4,6,8,0,0,0,0,0};
		int[] b = {1,3,5,7,9};
		int[] result = SortedMerge(a, b);
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i]+ ", ");
		}
	}
	
	public static int[] SortedMerge(int[] a, int[] b){
		int arrPos = a.length - 1;
		
		int aEnd = a.length - b.length - 1;
		int bEnd = b.length - 1;
		
		while(bEnd >= 0){
			if(b[bEnd] > a[aEnd]){
				a[arrPos] = b[bEnd];
				bEnd--;
			}else{
				a[arrPos] = a[aEnd];
				aEnd--;
			}
			arrPos--;
		}
		
		return a;
	}
}

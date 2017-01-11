
public class SearchInRotatedArray {
	public static void main(String[] args){
		int[] a = {15, 16,19,20,25,1,3,4,5,7,10,14};
		int find = 5;
		System.out.println(rotatedSearch(a, find));
	}
	
	public static int rotatedSearch(int[] a, int find){
		int fIndex = findRotation(a, 0, a.length - 1);
		int lIndex = fIndex - 1;
		
		if(lIndex < 0){
			lIndex = a.length - lIndex;
		}
		return searchRotation(a, fIndex, lIndex, find);
		
	}
	
	private static int searchRotation(int[] a, int fIndex, int lIndex, int find){
		int x;
		
		if(fIndex == 0){
			x = binSearch(a, 0, a.length-1, find);
		}else if (find < a[a.length - 1]){
			return binSearch(a, fIndex, a.length - 1, find);
		}else{
			return binSearch(a, 0, fIndex - 1, find);
		}
		
		return x;
	}
	
	private static int binSearch(int[] a, int start, int end, int find){
		int mid = (start + end) / 2;
		int x;
		if(a[mid] > find){
			x = binSearch(a, mid, start, find);
		}else if(a[mid] < find){
			x = binSearch(a, start, mid, find);
		}else{
			x = mid;
		}
		return x;
	}
	
	private static int findRotation(int[] a, int start, int end){
		int mid = (end + start) / 2;
		int result;
		
		//base case
		if(start == end - 1){
			if(a[start] < a[end]){
				return start;
			}else{
				return end;
			}
		}else if(a[mid] > a[start]){
			result = findRotation(a, mid, end);
		}else{
			result = findRotation(a, start, mid);
		}
		return result;
	}
	
}

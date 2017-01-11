
public class SparseSearch {
	//makes the assumption that the first element is a real string, otherwise problem is impossible
	public static void main(String[] args){
		String[] strings = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		System.out.println(findInSparse("ball", strings));
	}
	
	public static int findInSparse(String s, String[] strings){
		return findElement(s, strings, 0, strings.length - 1);
	}
	
	private static int findElement(String s, String[] strings, int start, int end){
		int middle = (start + end)/2;
		
		boolean goLeft = false;
		while(strings[middle].equals("")){
			middle++;
			if(strings[middle].equals(strings[end])){
				goLeft = true;
				middle = (start + end)/2;
				break;
			}
		}
		
		while(goLeft){
			middle--;
			if(!strings[middle].equals("")){
				if(strings[middle].equals(strings[start])){
					if(s.equals(strings[end])){
						return end;
					}else{
						return start;
					}
				}
				break;
			}
			
		}
		
		int sRel = s.compareTo(strings[middle]);
		
		int x;
		
		if(sRel == -1){
			x = findElement(s, strings, start, middle);
		}else if(sRel == 1){
			x = findElement(s, strings, middle, end);
		}else{
			x = middle;
		}
		
		return x;
	}
}

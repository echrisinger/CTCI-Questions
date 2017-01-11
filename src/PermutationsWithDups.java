import java.util.ArrayList;
import java.util.HashMap;

public class PermutationsWithDups {
	public static void main(String[] args){
		String java = new String("java");
		ArrayList<String> result = permsWithoutDups(java);
		for(String a : result){
			System.out.println(a);
		}
	}
	
	public static ArrayList<String> permsWithoutDups(String s){
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		char[] tempChar = s.toCharArray();
		
		for(int i = 0; i < tempChar.length; i++){
			if(!charMap.containsKey(tempChar[i])){
				charMap.put(tempChar[i], 1);
			}else{
				int curr = charMap.get(tempChar[i]);
				charMap.put(tempChar[i], curr + 1);
			}
		}
		
		ArrayList<String> result = new ArrayList<String>();
		permsAux(charMap, new String(), tempChar.length, result);
		
		return result;
	}

	private static void permsAux(HashMap<Character, Integer> charMap, String currString, int counter, ArrayList<String> result){
		if(counter == 0){
			result.add(currString);
		}else{
			for(char c : charMap.keySet()){
				if(charMap.get(c) > 0){
					charMap.put(c, charMap.get(c) - 1);
					permsAux(charMap, currString + c, counter - 1, result);
					charMap.put(c, charMap.get(c) + 1);
				}
			}
		}	
	}
}

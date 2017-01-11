import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams {
	
	public static void main(String[] args){
		String[] strings = {"Hillary", "Rodham", "Clinton", "Hilraly", "Rhodam", "Clniton"};
		String[] newStrings = anagramMethod(strings);
		for(String a : newStrings){
			System.out.print(a + ", ");
		}
	}
	
	//O(n*m), where n is the number of strings, and m is the length of the longest string
	
	public static String[] anagramMethod(String[] strings){
		HashMap<HashMap<Character, Integer>, ArrayList<Integer>> gramPos = new HashMap<HashMap<Character,Integer>, ArrayList<Integer>>();
		
		for(int i = 0; i < strings.length; i++){
			
			HashMap<Character, Integer> currChars = new HashMap<Character, Integer>();

			for(int j = 0; j < strings[i].length(); j++){
				char c = strings[i].charAt(j);
				if(!currChars.containsKey(c)){
					currChars.put(c, 0);
				}
				currChars.put(c, currChars.get(c)+1);
			}
			
			if(!gramPos.containsKey(currChars)){
				gramPos.put(currChars, new ArrayList<Integer>());
			}
			ArrayList<Integer> temp = gramPos.get(currChars);
			temp.add(i);
			gramPos.put(currChars, temp);
			
		}
		
		ArrayList<String> sortedStrings = new ArrayList<String>();
		for(HashMap<Character, Integer> a : gramPos.keySet()){
			ArrayList<Integer> curr = gramPos.get(a);
			for(Integer i : curr){
				sortedStrings.add(strings[i]);
			}
		}
		String[] stringArr = new String[sortedStrings.size()];
		return sortedStrings.toArray(stringArr);
	}
}

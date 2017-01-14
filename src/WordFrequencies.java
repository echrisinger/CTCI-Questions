//not bothering to finish, but implementation for repetitive searches while using minimal space is correct. For more space soln, use hashing for O(1) lookup.
//current soln has O(m) lookup where m is the length of the word.
//has O(m) insertion as well

public class WordFrequencies {
	private charNode root;
	
	public WordFrequencies(){
		root = new charNode();
	}
	public static void main(String[] args){
		charNode root = new charNode();
		WordFrequencies wordTree = new WordFrequencies();
		
	}
	
	public void wordProcessor(String n){
		charNode curr = root;
		boolean inWord = false;
		for(int i = 0; i < n.length(); i++){
			if(n.charAt(i) == ' '){
				curr.count++;
			}
		}
	}
	//assumes all lower case //O(n) as it looks at each word once to establish where it ends, then takes that subsection.
	private int addWord(String n){
		charNode curr = root;
		for(int i = 0; i < n.length(); i++){
			int intRep = (int) n.charAt(i);
			if(curr.children[intRep - 97] == null){
				curr.children[intRep-97] = new charNode();
			}
			curr = curr.children[intRep - 97];
		}
		curr.count++;
		return curr.count;
	}
}

//incomplete; looked at answer, as wording of problem and hints were poorly worded
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BSTSequences {
	TreeNode root;

	public BSTSequences(TreeNode root){
		this.root = root;
	}
	
	public String[] BSTSequencesMethod(){
	ArrayList<Integer[]> strings = new ArrayList<Integer[]>();
	Queue<Integer> leftQueue = new LinkedList<Integer>();
	Queue<Integer> rightQueue = new LinkedList<Integer>();
	
	strings.add(leftFirst(root, true, leftString));
	strings.add(leftFirst(root, false, rightString));uu
	}
	
	private ArrayList<Integer> leftFirst(TreeNode curr, boolean leftFirst, ArrayList<Integer> intlist){
		if(leftFirst){
			intlist.add(curr.data);
			lefte
		}else{
			
		}
	}
}

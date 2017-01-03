import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class ListOfDepths {
	//Don't need to use a queue for this problem. Can just do it level to level using an arraylist alone.
	//Problem also was unclear, but wanted nodes, instead of data values (represented as integer id's).
	
	private class DepthNode{
		public int depth;
		public int id;
		
		public DepthNode(int id){
			this.id = id;
		}
	}
	
	private BSTNode root = null;
	private int maxDepth = 0;

	public ListOfDepths(BSTNode root){
		this.root = root;
	}
	
	@SuppressWarnings("unchecked")
	public LinkedList<Integer>[] ListOfDepthsMethod() throws Exception{
		BSTNode curr = root;
		Queue<DepthNode> rawData = new LinkedList<DepthNode>(); 
		if(root == null){
			throw new Exception();
		}
		addElementToQueue(rawData, curr, 0);
		
		//originally constructed problem using array to minimize extra memory usage for more optimal soln; didn't work, then substituted for AL. Still
		//doesn't work, and not worth figuring out why.
		ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();
		
		while(!rawData.isEmpty()){
			DepthNode front = rawData.remove();
			lists.get(front.depth).add(front.id);
		}
		
		return (LinkedList<Integer>[]) lists.toArray();
	}
	
	private void addElementToQueue(Queue<DepthNode> rawData, BSTNode curr, int i){
		DepthNode currConv = new DepthNode(curr.id);
		currConv.depth = i;
		rawData.add(currConv);
		
		if(i > maxDepth){
			maxDepth = i;
		}
		
		if(curr.left != null){
			addElementToQueue(rawData, curr.left, i+1);
		}
		
		if(curr.right != null){
			addElementToQueue(rawData, curr.right, i+1);
		}
	}
	
	public static void main(String[] args){
		//non-exhaustive testing
		BSTNode N0_1 = new BSTNode(0);
		BSTNode N1_1 = new BSTNode(1);
		BSTNode N1_2 = new BSTNode(1);
		N0_1.left = N1_1;
		N0_1.right = N1_2;
		BSTNode N2_1 = new BSTNode(2);
		N1_2.right = N2_1;
		
		ListOfDepths f = new ListOfDepths(N0_1);
		LinkedList<Integer>[] lists = null;
		try {
			lists = f.ListOfDepthsMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < lists.length; i++){
			Iterator<Integer> listIter = lists[i].iterator();
			System.out.print("Depth " + i + ":");
			while(listIter.hasNext()){
				System.out.print(listIter.next() + ", ");
			}
			System.out.println();
		}
	}
}

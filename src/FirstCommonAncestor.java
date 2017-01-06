import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstCommonAncestor {
	private TreeNode node1;
	private TreeNode node2;
	
	public FirstCommonAncestor(TreeNode node1, TreeNode node2){
		this.node1 = node1;
		this.node2 = node2;
	}
	
	public TreeNode firstCommonAncestorMethod(){
		Queue<TreeNode> qNode1 = new LinkedList<TreeNode>();
		Queue<TreeNode> qNode2 = new LinkedList<TreeNode>();
		
		//HashMaps for when a node has been touched by the expansion on node1 and node2
		HashMap<Integer, TreeNode> srcNode1 = new HashMap<Integer, TreeNode>();
		HashMap<Integer, TreeNode> srcNode2 = new HashMap<Integer, TreeNode>();
		
		qNode1.add(node1);
		qNode2.add(node2);
		
		//changes to true when the node is found, used to keep searching
		boolean found = false;
		
		//while true, node1 expands to it's neighbor nodes in the queue
		boolean node1time = false;
		int currRound1 = 1;
		int currRound2 = 1;
		int nextRound1 = 0;
		int nextRound2 = 0;
		
		TreeNode ancestor = null;
		
		while(!found){
			TreeNode currNode;
			
			//enters if expanding by one from node1's starting point
			if(node1time){
				for(int i = 0; i < currRound1; i++){
					currNode = qNode1.remove();
					
					//if the current node being examined is already recorded in the hashMap of other nodes.
					if(srcNode2.get(currNode.data) != null){
						ancestor = retToHighestAncestor(currNode, srcNode1, srcNode2);
						found = !found;
						break;
					}else{
						//not a common node
						nextRound1 = 0;
						
						//if currNode.left exists and hasn't been examined, add it to the queue
						if(currNode.left != null && srcNode1.get(currNode.left.data) == null){
							qNode1.add(currNode.left);
							nextRound1++;
						}
						//same for right element
						if(currNode.right != null && srcNode1.get(currNode.right.data) == null){
							qNode1.add(currNode.right);
							nextRound1++;
						}
						//same for parent
						if(currNode.parent != null && srcNode1.get(currNode.parent.data) == null){
							qNode1.add(currNode.parent);
							nextRound1++;
						}
					}
				}
				currRound1 = nextRound1;
			
			//enters if expanding by one on node2
			}else{
				for(int i = 0; i < currRound2; i++){
					currNode = qNode2.remove();
					
					//if the current node being examined is already recorded in the hashMap of other nodes.
					if(srcNode1.get(currNode.data) != null){
						ancestor = retToHighestAncestor(currNode, srcNode1, srcNode2);
						found = !found;
						break;
					}else{
						//not a common node
						nextRound2 = 0;
						
						//if currNode.left exists and hasn't been examined, add it to the queue
						if(currNode.left != null && srcNode2.get(currNode.left.data) == null){
							qNode2.add(currNode.left);
							nextRound2++;
						}
						//same for right element
						if(currNode.right != null && srcNode2.get(currNode.right.data) == null){
							qNode2.add(currNode.right);
							nextRound2++;
						}
						//same for parent
						if(currNode.parent != null && srcNode2.get(currNode.parent.data) == null){
							qNode2.add(currNode.parent);
							nextRound2++;
						}
					}
				}
				currRound2 = nextRound2;
			}
			
			//switch to expanding on other node's neighbors
			node1time = !node1time;
		}
		
		return ancestor;
	}
	
	private TreeNode retToHighestAncestor(TreeNode curr, HashMap<Integer, TreeNode> srcNode1, HashMap<Integer, TreeNode> srcNode2){
		boolean inMap1 = srcNode1.get(curr.parent.data) != null;
		boolean inMap2 = srcNode2.get(curr.parent.data) != null;
		
		while(inMap1 || inMap2){
			curr = curr.parent;
			inMap1 = srcNode1.get(curr.parent.data) != null;
			inMap2 = srcNode2.get(curr.parent.data) != null;
		}
		
		//returns the highest of the nodes searched
		return curr;
	}
	
	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[31];
		
		for(int i = 0; i < 31; i++){
			nodes[i] = new TreeNode(i);
		}
		
		for(int i = 0; i < 16; i++){
			if(2*i + 1 < 31){
				nodes[i].left = nodes[2*i + 1];
			}
			if(2*i + 2 < 31){
				nodes[i].right = nodes[2*i + 2];
			}
		}
		
		FirstCommonAncestor rootTest = new FirstCommonAncestor(nodes[15], nodes[30]);
		System.out.println("Should return 0" + rootTest.firstCommonAncestorMethod().data);
	}
	
}

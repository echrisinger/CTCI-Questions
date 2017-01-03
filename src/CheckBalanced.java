
public class CheckBalanced {
	
	BSTNode root;
	
	public CheckBalanced(BSTNode root){
		this.root = root;
	}
	
	public boolean CheckBalancedMethod(){
		BSTNode curr = root;
		recursiveCheck(curr);
		return balanced;
	}
	
	boolean balanced = true;
	
	private int recursiveCheck(BSTNode curr){
		int maxSub;
		if(curr.right != null && curr.left != null){
			int rightDepth = recursiveCheck(curr.right) + 1;
			int leftDepth = recursiveCheck(curr.left) + 1;
			if(Math.abs(rightDepth - leftDepth) > 1){
				balanced = false;
			}
			if(leftDepth > rightDepth){
				maxSub = leftDepth;
			}else{
				maxSub = rightDepth;
			}
		}else if(curr.right != null){
			int rightDepth = recursiveCheck(curr.right) + 1;
			if(rightDepth > 1){
				balanced = false;
			}
			maxSub = rightDepth;
		}else if(curr.left != null){
			int leftDepth = recursiveCheck(curr.left) + 1;
			if(leftDepth > 1){
				balanced = false;
			}
			maxSub = leftDepth;
		}else{
			maxSub = 0;
		}
		return maxSub;
	}
	
	public static void main(String[] args){
		BSTNode[] nodes = new BSTNode[31];
		//creates a tree with 31 nodes in an array
		for(int i = 0; i < 5; i++){
			nodes[i] = new BSTNode(i);
		}
		
		for(int i = 0; i < 5; i++){
			nodes[i].left = nodes[2*i+1];
			nodes[i].right = nodes[2*i+2];
		}
		
		CheckBalanced swag = new CheckBalanced(nodes[0]);
		System.out.println("Should print true for a full, perfect binary tree" + swag.CheckBalancedMethod());
		nodes[4].left = null;
		System.out.println("Should print false: " + swag.CheckBalancedMethod());
	}
}

//O(n) time soln, O(log n) space
public class ValidateBST {
	private BSTNode root;
	
	public ValidateBST(BSTNode root){
		this.root = root;
	}
	
	boolean trueTree;
	public boolean ValidateBSTMethod(){
		//implement's a recursive preorder traversal, returns a global value trueTree
		BSTNode curr = root;
		trueTree = true;
		
		ValidateBSTAux(curr);
		return trueTree;
	}
	
	private void ValidateBSTAux(BSTNode curr){
		if(curr.left != null){
			if(curr.left.id <= curr.id){
				ValidateBSTAux(curr.left);
			}else{
				trueTree = false;
			}
		}
		if(curr.right != null){
			if(curr.right.id > curr.id){
				ValidateBSTAux(curr.right);
			}else{
				trueTree = false;
			}
		}
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
		
		ValidateBST test = new ValidateBST(nodes[0]);
		System.out.println("Should return false: " + test.ValidateBSTMethod());
	}
	
}

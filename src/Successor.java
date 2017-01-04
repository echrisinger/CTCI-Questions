//first problem to extend Abstract TreeProblem class (simple root constructor)
//Solves the problem of finding it, not replacing parent node's connections. That can be accomplished by dereferencing successorNode (leaf) from it's
//parent node, making successorNode's left and right the same as delNode's left and right connections, updating left and 
//right's parents to successorNode. Then take delNode's parent connection and use
//that to make it's child the successorNode in place of the delNode (delNode is then garbage collected). Successor node's parent must be updated
//to the new parent. Simple insertion/deletion referencing and dereferencing problem.

public class Successor extends TreeProblem {
	
	public Successor(BSTNode root){
		super(root);
	}
	
	public BSTNode SuccessorMethod(BSTNode delNode) throws Exception{
		BSTNode curr = delNode;
		if(curr.right != null){
			curr = curr.right;
			while(curr.left != null){
				curr = curr.left;
			}
		}else{
			BSTNode prev = curr;
			if(curr.parent == null){
				throw new Exception();
				//this occurs when Successor tries to find the successor to the rightmost BSTNode in the tree.
			}
			curr = curr.parent;
			while(curr.right.equals(prev)){
				if(curr.parent == null){
					throw new Exception();
					//same casing as above
				}
				prev = curr;
				curr = curr.parent;
			}
			while(curr.right == null){
				curr = curr.parent;
			}
			curr = curr.right;
			while(curr.left != null){
				curr = curr.left;
			}
		}
		return curr;
	}
}

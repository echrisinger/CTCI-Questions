
public class MinimalTree {
	
	private class BSTNode{
		public BSTNode left;
		public BSTNode right;
		public int data;
		
		public BSTNode(int data){
			this.data = data;
		}
	}
	
	private int[] nums;
	enum state {NEW, USED};
	
	public MinimalTree(int[] nums){
		this.nums = nums;	
	}
	
	//implemented iteratively, for no particular reason
	public BSTNode makeMinTree(int start, int end){
		int midval = (start + end)/2;
		BSTNode root = new BSTNode(nums[midval]);
		root.left = makeMinTree 
	}
}

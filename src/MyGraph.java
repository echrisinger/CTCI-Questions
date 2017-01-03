
public class MyGraph {
	
	public Node[] nodes;
	
	public MyGraph(){
		nodes = null;
	}
	
	public void createNodes(Node[] nodes){
		this.nodes = nodes;
	}
	
	public class Node {
		public int name;
		public Node[] children = null;
		
		public Node(int n){
			name = n;
		}
	}
}

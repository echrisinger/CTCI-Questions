//incomplete due to node structure; switched up mid-problem. Finish by 1/5
public class RouteBetweenNodes {
	
	private class MyGraph {
		
		public Node[] nodes;
		
		public MyGraph(){
			nodes = null;
		}
		
		public void createNodes(Node[] nodes){
			this.nodes = nodes;
		}
	}
	
	private class Node {
		public int name;
		public Node[] children = null;
		public boolean visited = false;
		
		public Node(int n){
			name = n;
		}
	}
	
	private Node node1;
	private Node node2;
	
	public RouteBetweenNodes(Node node1, Node node2){
		this.node1 = node1;
		this.node2 = node2;
	}
	
	public boolean recursiveDFS(Node currNode){
		currNode.visited = true;
		if(currNode.name == node2.name){
			return true;
		}else{
			for(int i = 0; i < currNode.children.length; i++){
				if(!(currNode.children[i].visited)){
					recursiveDFS(currNode.children[i]);
				}
			}
			return false;
		}
	}
}

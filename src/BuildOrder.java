import java.util.ArrayList;
import java.util.HashMap;

public class BuildOrder {
	
	private class TreeNode{
		protected char proj;
		//list of other treenodes this class depends on
		public ArrayList<TreeNode> deps = new ArrayList<TreeNode>();
		//list of treenodes that depend on this class
		public ArrayList<TreeNode> helps = new ArrayList<TreeNode>();
		
		public TreeNode(char proj){
			this.proj = proj;
		}
	}
	ArrayList<Character> projects;
	dependency[] dependencies;
	
	HashMap<Character, TreeNode> elements = new HashMap<Character, TreeNode>();
	
	public BuildOrder(char[] projects, dependency[] dependencies){
		this.projects = new ArrayList<Character> ();
		for(char a : projects){
			this.projects.add(a);
		}
		
		this.dependencies = dependencies;
		//creates an unconnected treenode in the arraylist of treenodes, elements
		for(char a : projects){
			elements.put(a, new TreeNode(a));
		}
		for(dependency b : this.dependencies){
			//adds the treenodes that b's TreeNode depends on to it's dep ArrayList.
			elements.get(b.proj).deps.add(elements.get(b.dependsOn));
		}
	}
	
	public char[] buildOrderMethod(){
		ArrayList<Character> order = new ArrayList<Character>();
		while(!projects.isEmpty()){
			for(int i = 0; i < projects.size(); i++){
			//for(char a : projects){
				char currProj = projects.get(i);
				System.out.println(currProj);
				if(elements.get(currProj).deps.isEmpty()){
					order.add(currProj);
					TreeNode n = elements.remove(currProj);
					for(TreeNode x : n.helps){
						x.deps.remove(n);
					}
					//change for loop to refer by index to remove efficiently, so no search + removal
					projects.remove(currProj);
				}
			}
		}
		
		char[] finalOrder = new char[order.size()];
		for(int i = 0; i < order.size(); i++){
			finalOrder[i] = order.get(i);
		}
		return finalOrder;
	}
	
	public static void main(String[] args){
		char[] projects = {'a', 'b', 'c', 'd', 'e', 'f'};
		dependency[] dependencies = {new dependency('a', 'd'), new dependency('f', 'b'), new dependency ('b', 'd'), new dependency ('f', 'a'),
				new dependency ('d', 'c')};
		BuildOrder test = new BuildOrder(projects, dependencies);
		char[] result = test.buildOrderMethod();
		System.out.print("expected result similar to f, e, a, b, d, c: -> ");
		for(char a : result){
			System.out.print(a + ", ");
		}
	}
	
}

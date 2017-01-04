import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class BuildOrder {
	
	private class TreeNode{
		protected char proj;
		//list of other treenodes this class depends on
		public HashMap<Character, TreeNode> deps = new HashMap<Character, TreeNode>();
		//list of treenodes that depend on this class
		public ArrayList<TreeNode> helps = new ArrayList<TreeNode>();
		
		public TreeNode(char proj){
			this.proj = proj;
		}
	}
	HashSet<Character> projects = new HashSet<Character>();
	HashMap<Character, TreeNode> elements = new HashMap<Character, TreeNode>();
	
	public BuildOrder(char[] projects, dependency[] dependencies){
		for(char a : projects){
			this.projects.add(a);
		}		
		//creates an unconnected treenode in the arraylist of treenodes, elements
		for(char a : projects){
			elements.put(a, new TreeNode(a));
		}
		
		for(dependency b : dependencies){
			//adds the treenodes that b's TreeNode depends on to it's dep ArrayList.
			char curProj = b.proj;
			char curDep = b.dependsOn;
			
			TreeNode n = elements.get(curProj);
			TreeNode nDepsOn = elements.get(curDep);
			
			//creates bidirectional edge in "deps" (depends on) and "helps"
			n.deps.put(curDep, nDepsOn);
			nDepsOn.helps.add(n);
			
		}
	}
	
	public char[] buildOrderMethod(){
		ArrayList<Character> order = new ArrayList<Character>();
		while(!projects.isEmpty()){
			Iterator<Character> projIter = projects.iterator();
			while(projIter.hasNext()){
				char currProj = projIter.next();
				if(elements.get(currProj).deps.isEmpty()){
					System.out.println(currProj);
					order.add(currProj);
					TreeNode n = elements.remove(currProj);
					for(TreeNode x : n.helps){
						x.deps.remove(n.proj);
					}
					//change for loop to refer by index to remove efficiently, so no search + removal
					projIter.remove();
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

import java.util.Stack;
//unfinished
public class TowersOfHanoi {
	public static void main(String[] args){
		
	}
	
	public static Stack<Integer>[] towersOfHanoiMethod(Stack<Integer>[] stacks){
		
		return stacks;
	}
	
	private static Stack<Integer>[] towersOfHanoiMethod(Stack<Integer>[] stacks, boolean onStack3){
		if(!stacks[0].isEmpty()){
			if(onStack3){
				int temp = stacks[0].pop();
				stacks[1].push(temp);
				while(!stacks[2].isEmpty()){
					temp = stacks[2].pop();
					stacks[0].push(temp);
					temp = stacks[2].pop();
					stacks[1].push(temp);
					temp = stacks[0].pop();
					stacks[1].push(temp);
				}
			}else{
				int temp = stacks[0].pop();
				stacks[2].push(temp);
			}
		}
		return stacks;
		
	}
}

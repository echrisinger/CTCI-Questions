
import java.util.*;

public class Stack3_3<T> {
	
	private class StackNode<T>{
		private T data;
		private StackNode<T> next = null;
		
		public StackNode(T data){
			this.data = data;
		}
	}
	
	private StackNode<T> top;
	protected int size = 0;
	
	public Stack3_3(){
		top = null;
	}
	
	public void push(T data){
		StackNode<T> temp = new StackNode<T>(data);
		temp.next = top;
		top = temp;
		size++;
	}
	
	public T pop(){
		if(top == null){
			throw new EmptyStackException();
		}else{
			StackNode<T> temp = top;
			top = top.next;
			size--;
			return temp.data;
		}
	}
	
	public T peek(T data){
		if(top != null){
			return top.data;
		}else{
			throw new EmptyStackException();
		}
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public static void main(String[] args){
		Stack3_3<Integer> stk = new Stack3_3<Integer>();
		
		stk.push(5);
		System.out.println(stk.pop());
		
		for(int i = 0; i < 5; i++){
			stk.push(i);
		}
		
		for(int i = 0; i < 5; i++){
			System.out.println(stk.pop());
		}
		
		System.out.println(stk.isEmpty());	
	}
}

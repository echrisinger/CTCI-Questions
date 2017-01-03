import java.util.EmptyStackException;

public class MyQueue3_4<T> {
	private MyStack<T> pushStack;
	private MyStack<T> popStack;
	
	private class MyStack<T> {
		private class StackNode<T>{
			private T data;
			private StackNode<T> next;
			
			public StackNode (T data){
				this.data = data;
			}
		}
		
		private StackNode<T> top;
		
		private T pop(){
			if (top == null){
				throw new EmptyStackException();
			}
			T item = top.data;
			top = top.next;
			return item;
		}
		
		private void push (T item){
			StackNode<T> t = new StackNode<T> (item);
			t.next = top;
			top = t;
		}
		
		private T peek () {
			if (top == null){
				throw new EmptyStackException();
			}
			return top.data;

		}
		
		private boolean isEmpty(){
			return top == null;
		}
	}
	
	public MyQueue3_4(){
		pushStack = new MyStack<T>();
		popStack = new MyStack<T>();
	}
	
	public void add (T data){
		pushStack.push(data);
	}
	
	//O(n) time
	public T remove(){
		rev(pushStack, popStack);
		if(popStack.isEmpty()){
			throw new EmptyStackException();
		}
		//LOGIC: everything is reversed, and the there exists some elements in the Queue.
		T temp = popStack.pop();
		rev(popStack, pushStack);
		return temp;
	}
	
	private void rev(MyStack<T> remStack, MyStack<T> addStack){
		while(!remStack.isEmpty()){
			addStack.push(remStack.pop());
		}
	}
	
	//O(n) time
	public T peek(){
		rev(pushStack, popStack);
		if(popStack.isEmpty()){
			throw new EmptyStackException();
		}
		//LOGIC: everything is reversed and in popStack, with first element added on top, and there exists some elements in popStack
		T temp = popStack.peek();
		rev(popStack, pushStack);
		return temp;
	}
	
	public boolean isEmpty(){
		return pushStack.isEmpty();
	}
	
	public static void main(String[] args){
		MyQueue3_4<Integer> testQue = new MyQueue3_4<Integer>();
		for(int i = 0; i < 5; i++){
			testQue.add(i);
		}
		System.out.println("Result should read: 0,1,2,3,4");
		for(int i = 0; i < 5; i++){
			System.out.print(testQue.remove() + ", ");
		}
		
		System.out.println("TestQueue should be empty: " + testQue.isEmpty());
		
		for(int i = 0; i < 2; i++){
			testQue.add(i);
		}
		
		System.out.println("TestQueue peek should return 0: " + testQue.peek());
		
		System.out.println("Tests complete");
	}

}

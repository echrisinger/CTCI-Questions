

import java.util.NoSuchElementException;

public class MyQueue<T> {
	
	private class QueueNode<T>{
		private T data;
		private QueueNode<T> next = null;
		
		public QueueNode (T data){
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T item){
		QueueNode<T> temp = new QueueNode<T> (item);
		if(last != null){
			last.next = temp;
		}
		last = temp;
		if (first == null){
			first = last;
		}
	}

	public T remove() {
		if (first == null){
			throw new NoSuchElementException();
		}
		T data = first.data;
		first = first.next;
		if (first == null) {
			 last = null;
		}
		return data;
	}
	
	public T peek(){
		if (first == null) throw new NoSuchElementException();
		return first.data;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
}

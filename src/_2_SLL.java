
public class _2_SLL<E> {
	
	public LinkedListNode<E> head;
	
	public class LinkedListNode<E>{
		public E data;
		public LinkedListNode<E> next;
		
		public LinkedListNode (E data){
			this.data = data;
			this.next = null;
		}
	}
	
	
	public _2_SLL (){
		head = null;
	}
	
	public _2_SLL (E data){
		head = new LinkedListNode<E> (data);
	}
	
	//adds new LinkedListNode to end of list
	public boolean add (E data){
		if(head == null){
			head = new LinkedListNode<E> (data);
			return true;
		}else{
			LinkedListNode<E> curr = head;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = new LinkedListNode<E> (data);
			return true;
		}
	}
	
	public boolean add (E data, int n){
		LinkedListNode<E> curr = head;
		if(n == 0){
			LinkedListNode<E> newHead = new LinkedListNode<E> (data);
			newHead.next = curr;
			head = newHead;
			return true;
		}else{
			for(int i = 0; i < n-1; i++){
				if(curr == null){
					return false;
					//when the index before where it should be inserted DNE
				}else{
					curr = curr.next;
				}
			}
			if(curr == null){
				return false;
			}
			LinkedListNode<E> appSubList = curr.next;
			curr.next = new LinkedListNode<E> (data);
			curr = curr.next;
			curr.next = appSubList;
			return true;
		}
	}
	
	public boolean delete (int n){
		LinkedListNode<E> curr = head;
		if(n == 0){
			head = curr.next;
		}else{
			for(int i = 0; i < n-1; i++){
				if(curr==null){
					return false;
				}else{
					curr = curr.next;
				}
			}
			if(curr.next == null){
				return false;
			}
			curr.next = curr.next.next;
		}
		return true;
	}
	
	public void printList(){
		LinkedListNode<E> curr = head;
		while(curr != null){
			System.out.print(curr.data + ",");
			curr = curr.next;
		}
		System.out.println();
	}
	public static void main(String[] args){
		_2_SLL<Integer> ints = new _2_SLL<Integer>();
		//add nodes with ints 0-9
		for(int i = 0; i < 10; i++){
			ints.add(i);
		}
		System.out.println("List should read numbers 0-9");
		ints.printList();
		
		//delete all nodes that are even
		for(int i = 9; i >= 0 ; i--){
			if(i%2 == 0){
				ints.delete(i);
			}
		}
		System.out.println("List should be only be odd numbers");
		ints.printList();
		
		//List should read 1,3,5,7,9
		System.out.println("Added 99 to front of list" + ints.add(99, 0));
		System.out.println("List should read 99, 1, 3, 5, 7, 9");
		ints.printList();
		
		System.out.println("Added 101 to back of list" + ints.add(101, 6));
		System.out.println("List should read 99, 1, 3, 5, 7, 9, 101");
		ints.printList();
		
		System.out.println("Adding 500 to node 8 that doesn't exist" + ints.add(500, 8));
		System.out.println("List should be same as before");
		ints.printList();
	}
}

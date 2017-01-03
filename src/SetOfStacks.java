
import java.util.*;

public class SetOfStacks<T> extends Stack3_3 {
	ArrayList<Stack> stkArr = new ArrayList<Stack>();
	private int stkSize = 5;
	private int tracker = 4;
	private int maxStkSize = 50;
	
	public SetOfStacks(){
		@SuppressWarnings("unchecked")
		stkArr = new List<Stack3_3<T>>();
		
	}
	
	@Override
	public void push (T data){
		if(stkArr[tracker].size == maxStkSize){
			//add casing for if it is at 0th element and size is 50
			tracker = tracker - 1;
			stkArr[tracker].push(data);
		}else{
			stkArr[tracker].push(data);
		}
	}
	
	@Override
	public T pop (){
		if(stkArr[tracker].isEmpty()){
			//this is the code for push
			tracker = tracker + 1;
			if(tracker >= stkSize){
			@SuppressWarnings("unchecked")
			Stack3_3<T>[] tempArr = (Stack3_3<T>[]) new Stack3_3[stkSize*2];
			for(int i = 0; i < stkSize; i++){
				tempArr[(stkSize + i)] = stkArr[i];
			}
			tracker = stkSize - 1;
			stkSize = stkSize * 2;
			}else if()
		}
	}
	
	@Override
	public boolean isEmpty(){
		
	}
	
}

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class AnimalShelter {
	
	private abstract class Animal {
		private int order;
		protected String name;
		
		public Animal(String n){
			name = n;
		}
		public void setOrder (int n){
			order = n;
		}
		public int getOrder(){
			return order;
		}
		
		public boolean isOlderThan(Animal a){
			return (order < a.getOrder());
		}
	}
	
	protected class Dog extends Animal{
		public Dog(String n) {
			super(n);
		}
		
	}
	
	protected class Cat extends Animal{
		public Cat(String n){
			super(n);
		}
	}
	
	LinkedList<Dog> dogs;
	LinkedList<Cat> cats;
	//represents the current number to be assigned
	int queOrd = 0;
	
	public AnimalShelter(){
		dogs = new LinkedList<Dog>();
		cats = new LinkedList<Cat>();
	}

	public void enqueue(Animal a){
		a.setOrder(queOrd);
		queOrd++;
		
		if(a instanceof Cat){
			cats.add((Cat) a);
		}else if(a instanceof Dog){
			dogs.add((Dog) a);
		}
	}
	
	public Animal dequeueAny(){	
		Dog fDog = dogs.peek();
		Cat fCat = cats.peek();
		
		if(fDog != null && fCat != null){
			if(fDog.getOrder() < fCat.getOrder()){
				return dogs.removeFirst();
			}else{
				return cats.removeFirst();
			}
		}else if(fCat != null){
			return cats.removeFirst();
		}else if(fDog != null){
			return dogs.removeFirst();
		}else{
			throw new EmptyStackException();
		}
		
	}
	
	public Dog dequeueDog(){
		return dogs.removeFirst();
	}
	
	public Cat dequeueCat(){
		return cats.removeFirst();
	}
	
	public static void main(String[] args){
		AnimalShelter test = new AnimalShelter();
		test.enqueue(test.new Dog("Rover"));
		test.enqueue(test.new Cat("Winston"));
		test.enqueue(test.new Cat("Woof"));
		System.out.println("Should print Rover: " + test.dequeueAny().name);
		System.out.println("Should print Winston: " + test.dequeueCat().name);
		System.out.println("Should print Woof: " + test.dequeueAny().name);
	}
	
}

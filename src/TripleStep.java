
public class TripleStep {
	public static void main(String[] args){
		System.out.println(tripleStepRec(20));
		System.out.println(tripleStepRec(5));
		System.out.println(tripleStepRec(4));
		System.out.println(tripleStepRec(3));
		System.out.println(tripleStepRec(2));
		System.out.println(tripleStepRec(1));
	}
	
	public static int tripleStepRec(int n){
		if(n < 0){
			return 0;
		}else if(n == 0){
			return 1;
		}else{
			return tripleStepRec(n-3) + tripleStepRec(n-2) + tripleStepRec(n-1);
		}
	}
}

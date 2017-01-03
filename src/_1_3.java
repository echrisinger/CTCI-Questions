
public class _1_3 {
	
	public static char[] URLify(char[] original){
		int counter = original.length - 1;
		boolean inExtras = true;
		
		for(int i = (original.length-1); i >= 0; i--){
			if(original[i] == ' ' && !inExtras){
				original[counter] = '0';
				counter--;
				original[counter] = '2';
				counter--;
				original[counter] = '%';
				counter--;
				
			}else if(original[i] == ' '){
				continue;
			}else{
				inExtras = false;
				original[counter] = original[i];
				counter--;
			}
			
		}
		return original;
	}
	
	public static void main(String[] args) {
		System.out.println(new String(URLify("Mr John Smith    ".toCharArray())));
	}

}

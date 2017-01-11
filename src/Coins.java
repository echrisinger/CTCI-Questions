import java.util.HashMap;

//correct =)
public class Coins {
	public static void main(String[] args){
		int[] coins = {25, 10, 5, 1};
		System.out.println(coinsMethod(coins, 100));
	}
	
	public static int coinsMethod(int[] coins, int changeAmt){
		HashMap<HashMap<Integer, Integer>, Integer> cacheWays = new HashMap<HashMap<Integer,Integer>, Integer>();
		HashMap<Integer, Integer> currCoins = new HashMap<Integer, Integer>();
		for(int i : coins){
			currCoins.put(i, 0);
		}
		return coinsAux(coins, changeAmt, currCoins, cacheWays);
	}
	
	private static int coinsAux(int[] coins, int currRem, HashMap<Integer, Integer> currCoins, HashMap<HashMap<Integer, Integer>, Integer> cacheWays){
		if(cacheWays.containsKey(currCoins)){
			return cacheWays.get(currCoins);
		}else{
			int currWays = 0;
			for(int i : coins){
				int tempRem = currRem - i;
				
				currCoins.put(i, currCoins.get(i) + 1);
				
				if(tempRem > 0){
					currWays += coinsAux(coins, tempRem, currCoins, cacheWays);
				}else if(tempRem == 0){
					currWays += 1;
					//can't cache the result with 1; would avoid some simple tests, but overall doesn't effect runtime
				}
				
				currCoins.put(i, currCoins.get(i) - 1);

			}
			cacheWays.put(currCoins, currWays);
			return currWays;
		}
	}
}

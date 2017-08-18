import java.util.*;

public class SnakesAndLaddersQuickestWayUp {

	private static Map<Integer,Integer> ladders = new HashMap<Integer,Integer>();
	private static Map<Integer,Integer> snakes = new HashMap<Integer,Integer>();
	private static Map<Integer,Integer> costs = new HashMap<Integer,Integer>(); // (the point we stand on, the cost to get to 100)
	
	private static int getCostToOneHundred(int die) {
		int cost = Integer.MAX_VALUE;
		
		if(die<100) {
			if(costs.containsKey(die)) {
				cost = 1 + costs.get(die);
			} else if(ladders.containsKey(die)) {
				cost = 1 + getMinimumMoves(ladders.get(die));
				costs.put(die, cost);
			} else if(snakes.containsKey(die)) {
				cost = 1 + getMinimumMoves(snakes.get(die));
				costs.put(die, cost);
			} else {
				cost = 1 + getMinimumMoves(die);
				costs.put(die, cost);
			}
		} else if(die == 100) {
			return 1;
		}
		
		System.out.println("Die and cost in OneHundred Func: " + die + " " + cost);
		
		return cost;
	}
	
	private static int getMinimumMoves(int startingPoint) {
		
		int die1 = startingPoint+1;
		int die2 = startingPoint+2;
		int die3 = startingPoint+3;
		int die4 = startingPoint+4;
		int die5 = startingPoint+5;
		int die6 = startingPoint+6;
		
		int cost1 = (die1 > 100) ? Integer.MAX_VALUE : getCostToOneHundred(die1);
		int cost2 = (die2 > 100) ? Integer.MAX_VALUE : getCostToOneHundred(die2);
		int cost3 = (die3 > 100) ? Integer.MAX_VALUE : getCostToOneHundred(die3);
		int cost4 = (die4 > 100) ? Integer.MAX_VALUE : getCostToOneHundred(die4);
		int cost5 = (die5 > 100) ? Integer.MAX_VALUE : getCostToOneHundred(die5);
		int cost6 = (die6 > 100) ? Integer.MAX_VALUE : getCostToOneHundred(die6);
		
		int min1 = Math.min(cost1, cost2);
		int min2 = Math.min(cost3, cost4);
		int min3 = Math.min(cost5, cost6);
		
		return Math.min(min1, Math.min(min2, min3));
		
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
		List<Integer> retVals = new ArrayList<Integer>();
        
        for(int i=0; i<t; i++) {
        	int numOfLadders = in.nextInt();
        	for(int j=0; j<numOfLadders; j++) {
        		int key = in.nextInt();
        		int val = in.nextInt();
        		ladders.put(key,val);
        	}
        	int numOfSnakes = in.nextInt();
        	for(int j=0; j<numOfSnakes; j++) {
        		int key = in.nextInt();
        		int val = in.nextInt();
        		snakes.put(key,val);
        	}
        	
        	int minMoves = getMinimumMoves(1);
        	retVals.add(minMoves);
        	
        	ladders.clear();
        	snakes.clear();
        	costs.clear();
        }
        
        for(int i=0; i<retVals.size(); i++) {
        	System.out.println(retVals.get(i));
        }
        
        
        in.close();
    }
}
import java.util.*;

public class StockMaximize {
	
	private static int findMaxIndex(List<Integer> arr) {
		int ind = 0;
		int max = arr.get(0);
		for(int i=1; i<arr.size(); i++) {
			if(arr.get(i) > max) {
				max = arr.get(i);
				ind = i;
			}
		}
		return ind;
	}
	
	
	private static <V> void printArr(List<V> arr) {
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
	
	private static long calculateMaxProfit(List<Integer> arr) {
		
		if(arr.size() <= 1)
			return 0;
		
		int maxInd = findMaxIndex(arr);
		//System.out.println("Mind and mval: " + maxInd + ", " + arr.get(maxInd));
		if(maxInd == 0) {
			return calculateMaxProfit(arr.subList(1, arr.size()));
		}
			
		
		long partialSum = (long) maxInd*arr.get(maxInd) - (long) arr.subList(0, maxInd).stream().mapToLong(Integer::intValue).sum();

		return partialSum + calculateMaxProfit(arr.subList(maxInd+1, arr.size()));
		
	}
	
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        List<Long> profits = new ArrayList<Long>();
        for(int i=0; i<t; i++) {
        	int n = in.nextInt();
        	List<Integer> nums = new ArrayList<Integer>();
        	for(int j=0; j<n; j++) {
        		nums.add(in.nextInt());
        	}
        	profits.add(calculateMaxProfit(nums));
        }
        
        printArr(profits);
        
        in.close();
    }
}

import java.util.*;

public class MinimumDistances {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        } in.close();
        HashMap<Integer, Integer> intIndexPair = new HashMap<Integer, Integer>();
        int distance = 100000;
        for(int i=0; i<n; i++) {
        	if(intIndexPair.containsKey(A[i])) {
        		int newCand = i - intIndexPair.get(A[i]);
        		if(newCand < distance)
        			distance = newCand;
        		intIndexPair.replace(A[i], i);
        	} else {
        		intIndexPair.put(A[i], i);
        	}
        }
        if(distance == 100000)
        	System.out.println(-1);
        else
        	System.out.println(distance);
    }
}

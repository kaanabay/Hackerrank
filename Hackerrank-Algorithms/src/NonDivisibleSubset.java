import java.util.*;

public class NonDivisibleSubset {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        
        if(k == 1) {
        	System.out.println(1);
        	in.close();
        	return;
        }
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++) {
        	int newIn = in.nextInt();
        	newIn %= k;
        	if(hm.containsKey(newIn)) {
        		hm.replace(newIn, hm.get(newIn)+1);
        	} else {
        		hm.put(newIn, 1);
        	}
        }
        in.close();
        
        int limit = (k%2 == 0) ? k/2 : (k/2) + 1;
        int myCount = 0;
        for(int i=1; i<limit; i++) {
        	int fh = 0, sh = 0; //First half - second half
        	if(hm.get(i) != null) 
        		fh = hm.get(i);
        	if(hm.get(k-i) != null) 
        		sh = hm.get(k-i);
        	myCount += Integer.max(fh, sh);
        }
        
        if(hm.containsKey(0))
        	myCount++;
        
        if(k%2 == 0 && hm.containsKey(k/2))
        	myCount++;
        
        System.out.println(myCount);
        
    }
}
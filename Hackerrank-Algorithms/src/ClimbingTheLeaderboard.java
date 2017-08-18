import java.util.*;

public class ClimbingTheLeaderboard {

	static int findItsPlace(List<Integer> arr, int aliceScore, int beginning) {
		for(int i=beginning; i>=0; i--) {
			if(arr.get(i) > aliceScore)
				return i+2;
			if(arr.get(i) == aliceScore)
				return i+1;
		}
		return 1;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> scores = new ArrayList<Integer>();
        int previous = in.nextInt();
        scores.add(previous);
        int current;
        for(int scores_i=1; scores_i < n; scores_i++){
            current = in.nextInt();
        	if(current != previous) {
        		scores.add(current);
        		previous = current;
        	}
        }
        
        int m = in.nextInt();
        
        int lastPlace = scores.size()+1;
        for(int i=0; i<m; i++) {
        	int alice = in.nextInt();
        	lastPlace = findItsPlace(scores, alice, lastPlace-2);
        	System.out.println(lastPlace);
        }
        
        in.close();
        
    }
}
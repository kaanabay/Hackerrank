import java.util.*;

public class FormingAMagicSquare {

    private static int [][][] allMagicSquares = {
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
                };
    
    static int compareToOneMagicSquare(int[][] square, int msi) {
    	int cost = 0;
    	for(int i=0; i<3; i++) {
    		for(int j=0; j<3; j++) {
    			cost += Math.abs(square[i][j] - allMagicSquares[msi][i][j]);
    		}
    	}
    	return cost;
    }
    
    static int compareAll(int[][] square) {
    	List<Integer> costs = new ArrayList<Integer>();
    	for(int i=0; i<8; i++) {
    		int cost = compareToOneMagicSquare(square, i);
    		costs.add(cost);
    	}
    	return Collections.min(costs);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i=0; s_i < 3; s_i++){
            for(int s_j=0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        } in.close();
        //  Print the minimum cost of converting 's' into a magic square
        System.out.println(compareAll(s));
    }
}

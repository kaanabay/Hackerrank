import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JourneyToTheMoon<T> {

	private static int nodesInAComponent = 0;
	private static ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
	
	private static void dfs(int i, boolean[] visited) {
		if(!visited[i])
			nodesInAComponent++;
		visited[i] = true;
		
		List<Integer> adj = adjacencyList.get(i);
		
		for(int j=0; j<adj.size(); j++) {
			if(!visited[adj.get(j)]) {
				dfs(adj.get(j),visited);
			}
		}
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        int n = in.nextInt();
        int p = in.nextInt();
        boolean[] visited = new boolean[n];
        List<Integer> numOfAstronautsByCluster = new ArrayList<Integer>();
        long result = 0;
        
        adjacencyList.clear();
        for(int i=0; i<=n; i++) adjacencyList.add(new ArrayList<Integer>());
        
        for(int a1 = 0; a1 < p; a1++){
            int ast_1 = in.nextInt();
            int ast_2 = in.nextInt();
            adjacencyList.get(ast_1).add(ast_2);
            adjacencyList.get(ast_2).add(ast_1);
        } in.close();
        
        for(int i=0; i<n; i++) {
        	if(!visited[i]) {
        		dfs(i,visited);
        		numOfAstronautsByCluster.add(nodesInAComponent);
        		nodesInAComponent = 0;
        	}
        }
        
        if(numOfAstronautsByCluster.size() < 2) {
        	System.out.println(0);
        	return;
        }
        
        int sumUpToN = numOfAstronautsByCluster.get(0) + numOfAstronautsByCluster.get(1);
        result = numOfAstronautsByCluster.get(0) * numOfAstronautsByCluster.get(1);
        for(int i=2; i<numOfAstronautsByCluster.size(); i++) {
        	result += numOfAstronautsByCluster.get(i)*sumUpToN;
        	sumUpToN += numOfAstronautsByCluster.get(i);
        }
        
        /*
        for(int i=0; i<numOfAstronautsByCluster.size(); i++) {
        	for(int j=i+1; j<numOfAstronautsByCluster.size(); j++) {
        		result += numOfAstronautsByCluster.get(i) * numOfAstronautsByCluster.get(j);
        	}
        }
        */
        System.out.println(result);
        
        
    }
}

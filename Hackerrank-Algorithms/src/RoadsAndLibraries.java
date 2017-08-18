import java.util.*;

public class RoadsAndLibraries<T> {

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
        int q = in.nextInt();
        List<Long> answers = new ArrayList<Long>();
        
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            long clib = in.nextLong();
            long croad = in.nextLong();
            
            boolean[] visited = new boolean[n+1];
            
            adjacencyList.clear();
            for(int i=0; i<=n; i++) adjacencyList.add(new ArrayList<Integer>());
            
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                adjacencyList.get(city_1).add(city_2);
                adjacencyList.get(city_2).add(city_1);
            } 
                        
            if(clib < croad) {
            	answers.add(clib*n);
            	continue;
            }
            
            long cost = 0;
            for(int i=1; i<=n; i++) {
            	if(!visited[i]) {
            		dfs(i,visited);
            		cost += (nodesInAComponent-1) * croad + clib;
            		//System.out.println("ITERATION: "+ i);
            		//System.out.println("NODES: " + nodesInAComponent);
            		//printAdjList(adjacencyList);
            		
            		//printBoolArr(visited);
            		nodesInAComponent = 0;
            	}
            }
            answers.add(cost);
            
        } in.close();
        
        for(int i=0; i<q; i++) {
        	System.out.println(answers.get(i));
        }
    }
}

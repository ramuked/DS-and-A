import java.io.*;
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
public class TopologicalSortKhansAlgorithm
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt(); // number of vertices;
        int m = in.nextInt(); // number of edges;
        List<List<Integer>> adj = new ArrayList<>(); //graph with adjacency list representation
        for(int i = 0; i < n; i++)adj.add(new ArrayList<>());
        for(int i = 0; i < m; i++){
		int a = in.nextInt();
		int b = in.nextInt();
		//there is an edge from vertex a to vertex b
		adj.get(a).add(b);
	}	
	
	int topologicalOrder[] = topologicalSort(adj);
	
	if(topologicalOrder == null){
		System.out.println("Graph is not a Directed Acyclic Graph");
	}
	else{
		System.out.println("Topological Order: ");
		for(int i : topologicalOrder)System.out.print(i+" ");
		
	}
	}
	
	public static int[] topologicalSort(List<List<Integer>> adj){
		int n = adj.size();
		int[] indegree = new int[n];
		for(int i = 0; i < n; i++){
			for(int to : adj.get(i)){
				indegree[to]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < n; i++){
			if(indegree[i] == 0)
				q.offer(i);
		}
		
		int topologicalOrder[] = new int[n];
		int index = 0;
		while(!q.isEmpty()){
			int at = q.poll();
			topologicalOrder[index++] = at;
			for(int to : adj.get(at)){
				indegree[to]--;
				if(indegree[to] == 0){
					q.offer(to);
				}
			}
		}
		if(index != n){
			return null;
		}
		return topologicalOrder;
		
	}
	
}

import java.io.*;
import java.util.*;

public class TarjansSCCAlgorithm
{
	int n;
	List<List<Integer>> graph;
	boolean solved;
	int sccCount,id;
	boolean[] onStack;
	int[] ids, low;
	Deque<Integer> stack;
	static final int UNVISITED = -1;
	
	public TarjansSCCAlgorithm(List<List<Integer>> graph){
		this.graph = graph;
		n = graph.size();
		
	}
	
	public void solve(){
		ids = new int[n];
		low = new int[n];
		onStack = new boolean[n];
		stack = new ArrayDeque<>();
		
		Arrays.fill(ids,UNVISITED);
		
		for(int i = 0; i < n; i++){
			if(ids[i] == UNVISITED)
				dfs(i);
				
		}
	}
	
	public void dfs(int at){
			
		stack.push(at);
		onStack[at] = true;
		ids[at] = low[at] = id++;
		
		for(int to : graph.get(at)){
			
			if(ids[to] == UNVISITED)dfs(to);
			if(onStack[to]) low[at] = Math.min(low[at],low[to]);
			
		}
		
		if(ids[at] == low[at]){
			for(int node = stack.pop();;node = stack.pop()){
				onStack[node] = false;
				low[node] = ids[at];
				if(node == at)break;
			}
			sccCount++;
		}
	
		
		
	}
	
	public static List<List<Integer>> createGraph(int n){
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < n; i++)graph.add(new ArrayList<>());
		return graph;
	}
	
	public static void addEdge(List<List<Integer>> graph,int from,int to){
		graph.get(from).add(to);
	}
	
	
    public static void main(String[] args)
    {	
		
		int n = 8;
		
		
		List<List<Integer>> graph = createGraph(n);
		
		
		addEdge(graph, 6, 0);
		addEdge(graph, 6, 2);
		addEdge(graph, 3, 4);
		addEdge(graph, 6, 4);
		addEdge(graph, 2, 0);
		addEdge(graph, 0, 1);
		addEdge(graph, 4, 5);
		addEdge(graph, 5, 6);
		addEdge(graph, 3, 7);
		addEdge(graph, 7, 5);
		addEdge(graph, 1, 2);
		addEdge(graph, 7, 3);
		addEdge(graph, 5, 0);
		
		TarjansSCCAlgorithm solver = new TarjansSCCAlgorithm(graph);
		solver.solve();
		
		int numberOFSCC = solver.sccCount;
		System.out.println("Number of Strongly connected components : " + numberOFSCC);
		
		
		
        
    }
}

import java.io.*;
import java.util.*;

public class BellmanFord
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Edge> edgeList = new ArrayList<>();
        for(int i = 0; i < m; i++){
			int from = in.nextInt();
			int to = in.nextInt();
			int wt = in.nextInt();
			
			edgeList.add(new Edge(from,to,wt));
			
		}
        
        int dist[] = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[edgeList.get(0).from] = 0;
        for(int i = 0; i < n - 1; i++){	
			for(Edge e : edgeList){
				int from = e.from;
				int to = e.to;
				int wt = e.wt;
				if(dist[from] + wt < dist[to]){
					dist[to] = dist[from] + to;
				}
			}
		
		}
		
		for(int i = 0; i < n - 1; i++){	
			for(Edge e : edgeList){
				int from = e.from;
				int to = e.to;
				int wt = e.wt;
				if(dist[from] + wt < dist[to]){
					dist[to] = (int)-1e8;
				}
			}
		
		}
        
        for(int i : dist)System.out.print(i+" ");
		
    }
    
    static class Edge{
		int from,to,wt;
		Edge(int from,int to,int wt){
			this.from = from;
			this.to = to;
			this.wt = wt;
		}
		
	}
}

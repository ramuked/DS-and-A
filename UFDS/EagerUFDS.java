public class EagerUFDS{

	private int[] id;
	private int[] size;
	
	public EagerUFDS(int N){
		
		id = new int[N];
		size = new int[N];
		
		for(int i = 0; i < N; i++){
			id[i] = i;
			size[i] = 1;
		}
	}
	
	private int root(int i){
		while (i != id[i]){
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	
	public boolean isConnnected(int p, int q){
		return root(p) == root(q);
			
	}
		
	
	public void union(int p, int q){
		
		int i = root(p);
		int j = root(q);
		if(i == j)return;
		if(size[i] < size[j]){
			id[i] = id[j];
			size[j] += size[i];
		}
		else{
			id[j] = id[i];
			size[i] += size[j];
			
			
		}
	}

}

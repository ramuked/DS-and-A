public class LazyUFDS{

	private int[] id;
	
	public LazyUFDS(int N){
		id = new int[N];
		for(int i = 0; i < N; i++){
			id[i] = i;
		}
	}
	
	private int root(int i){
		while (i != id[i]) i = id[i];
		return i;
	}
	
	
	public boolean isConnnected(int p, int q){
		return root(p) == root(q);
	}
		
	
	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}

}

public class EagerUFDS{

	//id maps elements to its parent in the UFDS tree
	private int[] id;
	
	//maintains size of each tree component in the UFDS tree
	private int[] size;
	
	//constructor, takes parameter as the size of the UFDS
	public EagerUFDS(int N){
		id = new int[N];
		size = new int[N];
		for(int i = 0; i < N; i++){
			//initially, each element is its own parent
			id[i] = i;
			
			//intially each component has a size of 1
			size[i] = 1;
		}
	}
	
	private int root(int i){
		while (i != id[i]){
			
			//path compression
			id[i] = id[id[i]];
		
			i = id[i];
		}
		return i;
	}
	
	
	public boolean isConnected(int p, int q){
		return root(p) == root(q);
	}
		
	
	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		
		//if the roots of two elements are the same, they are already in the same component
		if(i == j)return;
		
		//size based union, the smaller component is added to the larger component
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

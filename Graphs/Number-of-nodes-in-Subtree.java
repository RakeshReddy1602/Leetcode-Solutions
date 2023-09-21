class Solution {

			boolean[] vis;
	    public int [] countSubTrees(int n, int[][] edges, String labels) {
	        List<List<Pair>> adj = new ArrayList<>();
	        int[] result = new int[n];
					vis = new boolean[n];
	        
	        for(int i =0;i<n;i++) {
	        	adj.add(new ArrayList<>());
	        }
	        for(int i=0;i<edges.length;i++){
	            int par = edges[i][0];
	            int child = edges[i][1];
	            adj.get(par).add(new Pair(child, labels.charAt(child)));
							adj.get(child).add(new Pair(par,labels.charAt(par)));
	        }
	        
	        getLabelCount(0,labels,result,adj);
	        return result;
	        
	    }

		private int[] getLabelCount(int node,String labels,int[] result, List<List<Pair>> adj) {
			// TODO Auto-generated method stub
			int[] parMap = new int[26];
			int[]  childMap = new int[26];
			vis[node] = true;
			for(Pair p : adj.get(node)){
			  if(!vis[p.node]){
					childMap = getLabelCount(p.node,labels,result,adj);
					for(int i =0;i<26;i++){
						parMap[i] += childMap[i];
					}
				}
			
			}
			int index = labels.charAt(node) -'a';
			result[node] = 1 +parMap[index];
			parMap[index]++;
			return parMap;
		}
	}

	class Pair{
	    int node;
	    char label;
	    Pair(int node,char label){
	        this.node = node;
	        this.label = label;
	    }
	}
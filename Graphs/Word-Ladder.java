class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int moves = 1;
        for(String s : wordList) {
        	set.add(s);
        }
        queue.add(beginWord);
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	for(int i =0;i<size;i++) {
        		String node = queue.poll();
        		
        		if(node.equals(endWord)) {
        			return moves;
        		}
        		
        		for(int j =0;j<node.length();j++) {
        			char[] arr = node.toCharArray();
        			char ch = 'a';
        			for(int k =0;k<26;k++) {
        				arr[j] = ch;
        				String nei = new String(arr);
        				if(set.contains(nei)) {
        					set.remove(nei);
        					queue.add(nei);
        				}
        				ch++;
        			}
        		}
        	}
        	moves++;
        }
        return 0;
    }
}
class Pair{
    String node;
    int dist;
    public Pair(String node,int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public static boolean check(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        return diffCount == 1;  
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        wordList.add(beginWord);
        HashMap<String,Integer> map= new HashMap<>();
        for(int i=0;i<wordList.size();i++){
            map.put(wordList.get(i),i);
        }
        // System.out.println(map);
        // System.out.println(wordList);
        // System.out.println(map.get(endWord));
        if(!map.containsKey(endWord)) return 0;
        ArrayList<ArrayList<String>> adj =new ArrayList<>();
        for(int i=0;i<wordList.size();i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<wordList.size();i++){
            for(int j=i+1;j<wordList.size();j++){
                if (check(wordList.get(i), wordList.get(j))) {
                    adj.get(i).add(wordList.get(j));
                    adj.get(j).add(wordList.get(i));  
                }
            }
        }
        // for (int i = 0; i < adj.size(); i++) {
        //     System.out.println(wordList.get(i) + " -> " + adj.get(i));
        // }
        int d[] = new int[wordList.size()];
        Arrays.fill(d,(int)(1e8));
        d[map.get(endWord)]=0;
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(endWord,0));
        while(!pq.isEmpty()){
            String str = pq.peek().node;
            int dist = pq.peek().dist;
            pq.poll();
            // System.out.print("Hi");
            int ind = map.get(str);
            // System.out.print(ind);
            for(String s: adj.get(ind)){
                if(dist+1<d[map.get(s)]){
                    d[map.get(s)]=dist+1;
                    pq.add(new Pair(s,dist+1));
                }
            }
        }
        // System.out.println(Arrays.toString(d));
        return d[map.get(beginWord)] +1>=(int)(1e8) ? 0 : d[map.get(beginWord)] +1;
    }
}
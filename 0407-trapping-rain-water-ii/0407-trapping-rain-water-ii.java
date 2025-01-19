class Solution {
    class Pair implements Comparable<Pair>{
        int row;
        int col;
        int height;
        public Pair(int x, int y, int h){
            this.row=x;
            this.col=y;
            this.height=h;
        }
        public int compareTo(Pair a){
            return this.height - a.height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] vis = new boolean[n][m];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    pq.add(new Pair(i,j,heightMap[i][j]));
                    vis[i][j]=true;
                }
            }
        }
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        int traps = 0;
        while(!pq.isEmpty()){
            Pair rem = pq.poll();
            for(int[] dir : dirs){
                int rowx = rem.row + dir[0];
                int colx = rem.col + dir[1];

                if(rowx>0 && rowx<n && colx>0 && colx<m && vis[rowx][colx]==false){
                    vis[rowx][colx]=true;
                    int nextHeight = heightMap[rowx][colx];
                    if(nextHeight<rem.height){
                        traps+=rem.height-nextHeight;
                        heightMap[rowx][colx]=rem.height;
                    } 
                    pq.offer(new Pair(rowx,colx,heightMap[rowx][colx]));
                }
            }
        }
        return traps;
        
    }
}
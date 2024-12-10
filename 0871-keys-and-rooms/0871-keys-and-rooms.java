class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited=new int[rooms.size()];
        visited[0]=1;
        dfs(rooms,visited,0);
        return isVisited(visited);
    }

    public void dfs(List<List<Integer>> rooms,int[] visited,int room){

        List<Integer> rm=rooms.get(room);
        for(int i=0;i<rm.size();i++){
            int key=(int)rm.get(i);
            if(visited[key]==0){
                visited[key]=1;
                dfs(rooms,visited,key);
            }
        }
    }

    boolean isVisited(int [] visit){
        for(int i: visit){
            if(i==0) return false;
        }
        return true;
    }
}
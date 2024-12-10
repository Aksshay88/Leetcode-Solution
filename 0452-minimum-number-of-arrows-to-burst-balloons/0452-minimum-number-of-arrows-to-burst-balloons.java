class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));
        int end = points[0][1];
        int r = 0;
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= end){
                end = Math.min(end,points[i][1]);
            }else{
                end = points[i][1];
                r++;
            }
        }
        
        return r+1;
    }
}
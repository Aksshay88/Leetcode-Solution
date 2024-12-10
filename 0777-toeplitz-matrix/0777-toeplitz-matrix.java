class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int r = matrix.length;
        int c= matrix[0].length;
        int i = r-1;
        while(i>=0){
            int j = 0;
            int e = matrix[i][j];
            for(int m = i; m<r && j<c ; m++){
                if(e != matrix[m][j] ){
                    return false;
                }
                j++;
            }
            i--;
        }
        int j = 1;
        while(j<c){
            int k = 0;
            int e = matrix[k][j];
            for(int m = j; m<c && k<r ; m++){
                if(e != matrix[k][m]){
                    return false;
                }
                k++;
            }
            j++;
        }
        return true;
    }
}
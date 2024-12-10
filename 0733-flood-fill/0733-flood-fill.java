class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int originalColor = image[sr][sc];
        if(originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        return image;
    }

    private void dfs(int image[][], int x, int y, int originalColor, int newColor) {

        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != originalColor) {
            return;
        }

        image[x][y] = newColor;

        dfs(image, x + 1, y, originalColor, newColor);
        dfs(image, x - 1, y, originalColor, newColor);
        dfs(image, x, y + 1, originalColor, newColor);
        dfs(image, x , y - 1, originalColor, newColor);

    }
}
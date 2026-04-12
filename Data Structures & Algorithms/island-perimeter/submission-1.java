class Solution {
    int ans = 0;
    boolean isSafe(int i, int j, int[][] grid, Set<String> visited) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1 && !visited.contains(Integer.toString(i) + " " + Integer.toString(j));
    }
    int getBoundaryCount(int[][] grid, int i, int j) {
        int c = 0;
        if (i-1 < 0 || grid[i-1][j] == 0) {
            c++;
        }
        if (i+1 >= grid.length || grid[i+1][j] == 0) {
            c++;
        }
        if (j-1 < 0 || grid[i][j-1] == 0) {
            c++;
        }
        if (j+1 >= grid[0].length || grid[i][j+1] == 0) {
            c++;
        }
        return c;
    }
    void dfs(int[][] grid, int i, int j, Set<String> visited) {
        if(!isSafe(i, j, grid, visited)) {
            return;
        }
        visited.add(Integer.toString(i) + " " + Integer.toString(j));
        ans+=getBoundaryCount(grid, i, j);
        dfs(grid, i+1, j, visited);
        dfs(grid, i, j+1, visited);
        dfs(grid, i-1, j, visited);
        dfs(grid, i, j-1, visited);
    }
    public int islandPerimeter(int[][] grid) {
        int r = - 1, c = -1;
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    r = i; c = j;
                    break;
                }
            }
        }
        if (r == -1 || c == -1) return 0;
        System.out.println(Integer.toString(r) + " " + Integer.toString(c));
        dfs(grid, r, c, new HashSet<> ());
        return ans;
    }
}
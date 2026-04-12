class Solution {
    boolean isSafe(int i, int j, int[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1;
    }
    int dfs(int[][] grid, int i, int j, Set<String> visited) {
        if(!isSafe(i, j, grid)) {
            return 1;
        }
        if (visited.contains(Integer.toString(i) + " " + Integer.toString(j))) {
            return 0;
        }
        visited.add(Integer.toString(i) + " " + Integer.toString(j));

        return dfs(grid, i+1, j, visited)
        + dfs(grid, i, j+1, visited)
        + dfs(grid, i-1, j, visited)
        + dfs(grid, i, j-1, visited);
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
        return dfs(grid, r, c, new HashSet<> ());
    }
}
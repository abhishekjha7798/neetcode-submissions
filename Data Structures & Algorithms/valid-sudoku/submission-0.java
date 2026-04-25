class Solution {
    public boolean isValidSudoku(char[][] board) {
        // valid row
        int r = board.length;
        int c = board[0].length;
        for (int i=0;i<r; i++) {
            Set<Character> seen = new HashSet<>();
            for (int j=0;j<c;j++) {
                if (board[i][j] == '.') continue;
                if (seen.contains(board[i][j])) return false;
                seen.add(board[i][j]);
            }
        }

        System.out.println("hii1");

        //valid column
        for (int i=0;i<c; i++) {
            Set<Character> seen = new HashSet<>();
            for (int j=0;j<r;j++) {
                if (board[j][i] == '.') continue;
                if (seen.contains(board[j][i])) return false;
                seen.add(board[j][i]);
            }
        }

        System.out.println("hii1");

        // valid sub-box
        int sr = 0, sc = 0, step = r/3;
        while (sr < r) {
            while(sc < c) {
                Set<Character> seen = new HashSet<>();
                for (int i=sr;i<sr+step; i++) {
                    for (int j=sc;j<sc+step;j++) {
                        if (board[i][j] == '.') continue;
                        if (seen.contains(board[i][j])) return false;
                        seen.add(board[i][j]);
                    }
                }
                sc += step;
            }
            sr += step;
            sc = 0;
        }

        return true;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> seen;

        for (int row = 0; row < board.length; row++) {
            seen = new HashSet<>();
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (seen.contains(board[row][col])) {
                    return false;
                }
                seen.add(board[row][col]);
            }
        }

        for (int col = 0; col < board[0].length; col++) {
            seen = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (seen.contains(board[row][col])) {
                    return false;
                }
                seen.add(board[row][col]);
            }
        }

        for (int box = 0; box < 9; box++) {
            seen = new HashSet<>();

            for (int boxRow = 0; boxRow < 3; boxRow++) {
                for (int boxCol = 0; boxCol < 3; boxCol++) {
                    int boardRow = (box / 3) * 3 + boxRow;
                    int boardCol = (box % 3) * 3 + boxCol;

                    if (board[boardRow][boardCol] == '.') {
                        continue;
                    }
                    if (seen.contains(board[boardRow][boardCol])) {
                        return false;
                    }
                    seen.add(board[boardRow][boardCol]);
                }
            }
        }
    
        return true;
    }
}

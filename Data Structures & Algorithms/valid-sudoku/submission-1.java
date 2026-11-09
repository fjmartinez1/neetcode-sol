class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSeen = new HashSet[9];
        HashSet<Character>[] colSeen = new HashSet[9];
        HashSet<Character>[] boxSeen = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSeen[i] = new HashSet<>();
            colSeen[i] = new HashSet<>();
            boxSeen[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char cell = board[row][col];

                if (cell == '.') {
                    continue;
                }

                int box = (row / 3) * 3 + (col / 3);

                if (rowSeen[row].contains(cell) 
                || colSeen[col].contains(cell) 
                || boxSeen[box].contains(cell)) {
                    return false;
                }
                rowSeen[row].add(cell);
                colSeen[col].add(cell);
                boxSeen[box].add(cell);
            }
        }

        return true;
    }
}

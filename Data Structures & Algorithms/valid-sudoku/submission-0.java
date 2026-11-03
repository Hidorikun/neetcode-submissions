class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validateRows(board)
            && validateColumns(board)
            && validateSubBoxes(board);
    }


    private boolean validateRows(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (hasDuplicates(board[i])) {
                System.out.println("row = " + String.valueOf(i));
                return false;
            }
        }

        return true;
    }

    private boolean validateColumns(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (hasDuplicates(getColumn(board, i))) {
                System.out.println("col = " + String.valueOf(i));
                return false;
            }
        }

        return true;
    }

    private char[] getColumn(char[][] board, int i) {
        char[] col = new char[board.length];

        for (int j = 0; j < board.length; j++) {
            col[j] = board[j][i];
        }

        return col;
    }

    private boolean validateSubBoxes(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (hasDuplicates(getSubBox(board, i))) {
                System.out.println("box = " + String.valueOf(i));
                return false;
            }
        }

        return true;
    }

    private char[] getSubBox(char[][] board, int i) {
        int[] rows = new int[]{0,0,0,3,3,3,6,6,6};
        int[] cols = new int[]{0,3,6,0,3,6,0,3,6};

        char[] subBox = new char[board.length];
        int cnt = 0; 
        for (int r = rows[i]; r < rows[i] + 3; r++) {
            for (int c = cols[i]; c < cols[i] + 3; c++) {
                subBox[cnt++] = board[r][c];
            }
        }

        return subBox;
    }

    private boolean hasDuplicates(char[] cells) {
        Map<Character, Boolean> seen = new HashMap<>();

        for (Character c : cells) {
            if (c.equals('.')) {
                continue;
            }

            if (seen.containsKey(c)) {
                System.out.println("key = " + c);
                return true;
            } 

            seen.put(c, true);
        }

        return false;
    }
}

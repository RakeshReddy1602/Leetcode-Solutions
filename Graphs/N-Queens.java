import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i =0;i<n;i++){
            Arrays.fill(board[i],'.');
        }

        placeQueens(0,board,result);
        return result;
    }

    void placeQueens(int col,char[][] board,List<List<String>> result){
        if(col >= board.length){
            constructBoard(board,result);
            return ;
        }

        for(int row = 0;row < board.length;row++){
            if(canPlaceSafe(row,col,board)){
                board[row][col] = 'Q';
                placeQueens(col+1, board);
                board[row][col] = '.';
            }
        }
    }

    boolean canPlaceSafe(int row,int col,char[][] board){
        int actualRow = row;
        int actualCol = col;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        row = actualRow;
        col = actualCol;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }

        row = actualRow;
        col = actualCol;
        while(col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }
        return true;
    }

    void constructBoard(char[][] board,List<List<String>> result){
        for(int i =0;i<board.length;i++){
            result.add(new String(board[i]));
        }
    } 
}
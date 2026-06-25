import java.util.List;
import java.util.ArrayList;

public class Nqueens {  
    public static boolean isSafe(int row, int col, char[][] board) {
    // 1. Horizontal Check
        for(int j = 0; j < board.length; j++) {
            if(board[row][j] == 'Q') {
                return false;
            }
        }

    // 2. Vertical Check
        for(int i = 0; i < board.length; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

    // 3. Upper Left Diagonal (r goes up, c goes left)
        for(int r = row, c = col; c >= 0 && r >= 0; c--, r--) {
            if(board[r][c] == 'Q') {
                return false;
            }   
        }   

    // 4. Upper Right Diagonal (r goes up, c goes right)
        for(int r = row, c = col; c < board.length && r >= 0; r--, c++) {
            if(board[r][r] == 'Q') { // Wait, make sure it's board[r][c]
                return false;
            }
        }return true;
    }
    
    public static void saveBoard(char[][] board,List<List<String>> allboards) {
        String row="";
        List<String> newboard= new ArrayList<>();

        for(int i=0;i<board.length;i++) {
            row=" ";
            for(int j=0;j<board.length;j++) {
                if(board[i][j]=='Q') {
                    row+='Q';

                }else {
                    row+='.';
                }
            }newboard.add(row);

        }allboards.add(newboard);
    }
    
    
    public static void helper(char[][] board,List<List<String>> allboards,int col) {
        if(col == board.length) {
            saveBoard(board,allboards);
            return;
        }
        for(int row=0;row<board.length;row++) {
            if(isSafe(row,col,board)) {
                board[row][col]='Q';
                helper(board, allboards, col+1);
                board[row][col]='.';
            }
        }
    }


    public static List<List<String>> SolveQueens(int n) {
        List<List<String>> allboard = new ArrayList<>();
        char[][] board = new char[n][n];

        helper(board, allboard, 0);
        return allboard;
    } 
    
    public static void main(String args[]) {
        int n=4;
        System.out.println(SolveQueens(n));
    }
    
}

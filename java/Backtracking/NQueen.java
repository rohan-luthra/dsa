import java.util.*;
public class NQueen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        placeNQueens(n);
    }

    static int[][] board;

    public static void placeNQueens(int n){

        board = new int[n][n];
        nQueenHelper(n, 0);

    }

    public static void nQueenHelper(int n, int row){
        if(row == n){
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    System.out.print(board[i][j]+" ");
            System.out.println("");
            return;
        }

        for(int i=0; i<n; i++){
            if(checkIfpossible(n, row, i)){
                board[row][i]=1;
                nQueenHelper(n, row+1);
                board[row][i]=0;
            }
        }
    }

    public static boolean checkIfpossible(int n, int row, int col){

        // check for column
        for(int i=0;i<n;i++){
            if(board[i][col]==1) return false;
        }

        // check for upper left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 1) return false;
        }

        for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++){
            if(board[i][j] == 1) return false;
        }

        return true;

    }


}
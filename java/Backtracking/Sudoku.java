import java.util.*;

public class Sudoku {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[][] sudoku =  new int[9][9];
        for(int i=0;i<9;i++){
            String[] s = sc.nextLine().split("");
            for(int j=0;j<s.length;j++)
                sudoku[i][j]=Integer.parseInt(s[j]);
        }
        printSudokuSol(sudoku, 0, 0);
        sc.close();
    }

    public static void printSudokuSol(int[][] sudoku, int row, int col){

        if(row==8 && col==8){
            // check fot the last element
            if(sudoku[row][col]==0){
                // put a possible number
                for(int i=1;i<=9;i++){
                    if( isPossibe(sudoku, i, row, col) ){
                        sudoku[row][col]=i;
                        printSudoku(sudoku);
                    }
                }
            }
            return;
        }

        if(sudoku[row][col]==0){
            for(int j=1;j<=9;j++){
                if( isPossibe(sudoku, j, row, col) ){
                    sudoku[row][col]=j;
                    if(col<8 && row<9){
                        printSudokuSol(sudoku, row, col+1);
                    }else if(row<8){
                        printSudokuSol(sudoku, row+1, 0);
                    }
                    sudoku[row][col]=0;
                }
            }
        }
        if(col<8 && row<9){
            printSudokuSol(sudoku, row, col+1);
        }else if(row<8){
            printSudokuSol(sudoku, row+1, 0);
        }
        
    }

    public static boolean isPossibe(int[][] sudoku, int value, int row, int col){
        
        for(int i=0;i<9;i++){
            if(sudoku[row][i]==value) return false;
        }
        for(int i=0;i<9;i++){
            if(sudoku[i][col]==value) return false;
        }
        for(int i= (row/3)*3; i< ((row/3)+1)*3;i++){
            for(int j= (col/3)*3; j< ((col/3)+1)*3;j++){
                if(sudoku[i][j]==value) return false;
            }
        }
        return true;
    }

    public static void printSudoku(int[][] sudoku){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]);
            }
            System.out.println("");
        }
    }

}
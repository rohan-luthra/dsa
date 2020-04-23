import java.util.*;

public class RatInARace {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] maze = new int[n][n];        
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                maze[i][j] = sc.nextInt();
        
        ratInAMaze(maze);

    }


    static int[][] temp;

    public static void ratInAMaze(int[][] maze){

        int n = maze[0].length;
        temp = new int[n][n];

        qRatInAMazeHelper(maze, n, 0, 0);

    }

    public static void qRatInAMazeHelper(int[][] maze, int n, int row, int col){
        if(row==n-1 && col==n-1){
            temp[row][col] = 1;
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    System.out.print(temp[i][j]+" ");
        	temp[row][col] = 0;
            System.out.println("");
            return;
        }

        // check left
        if( col-1>=0 && maze[row][col-1]==1 && temp[row][col-1]==0 ){
            // System.out.println(row+"-"+col+" taking left");
            temp[row][col] = 1;
            qRatInAMazeHelper(maze, n, row, col-1);
            temp[row][col] = 0;
        }

        // check right
        if( col+1<n && maze[row][col+1]==1 && temp[row][col+1]==0 ){
            // System.out.println(row+"-"+col+" taking right");
            temp[row][col] = 1;
            qRatInAMazeHelper(maze, n, row, col+1);
            temp[row][col] = 0;
        }
        
        //check up
        if( row-1>=0 && maze[row-1][col]==1 && temp[row-1][col]==0){
            // System.out.println(row+"-"+col+" taking up");
            temp[row][col] = 1;
            qRatInAMazeHelper(maze, n, row-1, col);
            temp[row][col] = 0;
        }
        
        // check down
        if( row+1<n && maze[row+1][col]==1  && temp[row+1][col]==0 ){
            // System.out.println(row+"-"+col+" taking down");
            temp[row][col] = 1;
            qRatInAMazeHelper(maze, n, row+1, col);
            temp[row][col] = 0;
        }
                
    }

}
package DataStructures.Medium;

import java.io.*;
import java.util.*;

public class JimAndSkyscraper {

    // Complete the solve function below.
    public static long solve( int[] arr ) {
        long routesCount = 0;
        Stack<Integer> stack = new Stack<>();

        // Using stack to store the latest value
        for( int i = 0; i < arr.length; i++ ) {

            // 2 test cases
            // stack is empty || stack.top >= arr[i] - push it to stack
            // stack.top < s


            int s = arr[i];
            if( stack.isEmpty() || stack.peek() >= s ) {
                stack.add( s );
            }
            else {
                // stack.top < s
                // pop 
                // check for all the same values
                // then routes = (n*(n-1))/2 * 2 for number of same count
                while( !stack.isEmpty() && stack.peek() < s ) {
                    long sameS, cnt = 0;
                    do {
                        sameS = stack.pop();
                        cnt++;
                    } while( !stack.isEmpty() &&  stack.peek() == sameS );
                    if( cnt >= 2 ) {
                        routesCount += ((cnt-1)*cnt);
                    }
                }
                stack.add( s );
            }
        }

        // checking number of routes of the remaining elements
        if( !stack.isEmpty() ) {
            long cnt = 1;
            boolean same;
            int s1 = stack.pop();
            while( !stack.isEmpty() ) {
                same = (s1 == stack.peek());
                if( same ) {
                    stack.pop();
                    cnt++;
                    if( stack.isEmpty() ) {
                        if( cnt > 1 ) {
                            routesCount += ((cnt-1)*cnt);
                        }
                    }
                }
                else {
                    if( cnt > 1 ) {
                        routesCount += ((cnt-1)*cnt);
                    }
                    cnt = 1;
                    s1 = stack.pop();
                }
             }
        }
        return routesCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        long result = solve(arr);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();
        System.out.println(result);

        scanner.close();
    }
}

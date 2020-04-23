package Algorithms.Medium;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {

        // a-z
        // getting count for each character
        // storing it in an array - arr
        int[] arr = new int[26];
        for(char c: s.toCharArray()){
            arr[c-'a']++;
        }

        // System.out.println(Arrays.toString(arr));
        

        // maximum count in the array
        int max = -1;

        // flag to check if anomaly has occured before of not
        int encounter = 0;

        for(int i=0; i<26;i++){
            // skip if the character doesnt exists
            if(arr[i]==0) continue;
            // setting max, if its not initialized
            // and skip this iteration
            if(max == -1) { max = arr[i]; continue; }
            // skip if count is equal to max
            if(max == arr[i]) continue;
            // checing anomaly 
            // if 1 then return "NO"
            if(encounter == 1) return "NO";
            // anomaly detected
            // check if count is 1 OR count is 1 greater then the max (so that we can remove it, and set encounter to 1)
            if(arr[i] ==1 || arr[i] == max+1) encounter++;
            // cannot remove this anomaly, return "NO"
            else return "NO";

        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String result = isValid(s);
        System.out.println(result);
        scanner.close();
    }
}

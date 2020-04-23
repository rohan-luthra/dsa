package Algorithms.Advance;

import java.util.*;

/**
 * ONLY RUNS FOR BASIC TEST CASES
 * RUNS OUT OF MEMORY WHEN BIGGER TEST CASES 
 * 
 */

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        

        while(t-- > 0){
            String a = sc.nextLine();
            String b = sc.nextLine();
            System.out.println(solve(a, b, ""));
        }

    }

    // Backtracking concept
    // check by choosing each character a[0] or b[0] and proceed


    public static String solve(String a, String b, String result) {

        if(a.equals("")) return result+b;
        if(b.equals("")) return result+a;
        if(a.charAt(0) < b.charAt(0)){
            return solve(a.substring(1), b, result+a.charAt(0));
        }else if(a.charAt(0) > b.charAt(0)){
            return solve(a, b.substring(1), result+b.charAt(0));
        }else{
            String s1 = solve(a.substring(1), b, result+a.charAt(0));
            String s2 = solve(a, b.substring(1), result+b.charAt(0));
            if(compareString(s1, s2)) return s1;
            return s2;
        }
        
    }

    // returns true if s1 is lexicographically smaller that s2
    public static boolean compareString(String s1, String s2){
        int min = (s1.length()<s2.length())?s1.length():s2.length();
        for(int i=0; i<min; i++){
            if(s1.charAt(i) < s2.charAt(i)) return true;
        }
        return false;

    }

}
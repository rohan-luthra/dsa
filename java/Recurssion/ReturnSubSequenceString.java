import java.util.ArrayList;
import java.util.Scanner;

public class ReturnSubSequenceString {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<String> list = subSequence(s);
        System.out.println(list.toString());

    }


    public static ArrayList<String> subSequence(String s){

        if(s.equals("")) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        ArrayList<String> newList = subSequence(s.substring(1));
        System.out.println(s.charAt(0) + newList.toString());
        ArrayList<String> result = new ArrayList<>();
        for(String str: newList){
            result.add(s.charAt(0)+str);
        }
        for(String str: newList){
            result.add(str);
        }

        return result;
        
    }
}
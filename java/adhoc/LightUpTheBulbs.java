import java.util.*;
public class LightUpTheBulbs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int x = Integer.parseInt(str[1]);
        int y = Integer.parseInt(str[2]);
        
        String s = sc.nextLine();
        int count = 0;
        if(s.charAt(0)=='0') count++;
        for(int i=0; i<n-1; i++)
            if(s.charAt(i) == '1' && s.charAt(i+1) == '0')
                count++;
        
        int res = Math.min(x,y)*count + y;
        System.out.println(res);
        sc.close();
    }
}
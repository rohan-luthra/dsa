package DataStructures.Medium;
import java.util.*;

public class ElementMaximum {
    public static void main(String[] args) {
        // store the stack
        Stack<Integer> stack = new Stack<Integer>();
        // to store max for each postion
        // so that if the the max element is popped the we can get the previous max element
        Stack<Integer> maxStack = new Stack<Integer>();
        
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while(n-- > 0)
        {
           int type = sc.nextInt();
            switch(type)
            {
                case 1:
                    int val = sc.nextInt();
                    // adding to stack
                    stack.push(val);
                    // updating the max
                    if(maxStack.isEmpty() || maxStack.peek() <= val)
                        maxStack.push(val);
                    break;
                case 2:
                    int temp = stack.pop();
                    // resetting the max
                    // if poped element was max, then the new max is the previous max = maxStack.pop element.
                    if(temp == maxStack.peek())
                        maxStack.pop();
                    break;
                case 3:
                    System.out.println(maxStack.peek());
            }
        }
        
        
    }
}    
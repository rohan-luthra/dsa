import java.util.*;

public class BigSorting {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {

        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length() > b.length()) return 1;
                if(a.length() < b.length()) return -1;
                if(a.length() == 0) return 0;
                if(a.charAt(0) == b.charAt(0)) return a.charAt(0)-b.charAt(0);
                return compare(a.substring(1,a.length()), b.substring(1, b.length()));
            }

        };

        Arrays.sort(unsorted, comparator);
        return unsorted;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {
        Scanner scanner =  new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.nextLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);
        // for(int i=0;i<n;i++) System.out.println(result[i]);
        System.out.println(result[3]);

        scanner.close();
    }
}

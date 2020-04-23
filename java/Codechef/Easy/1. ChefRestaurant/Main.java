import java.util.*;

public class Main{

    static public class Intervals {
        public int start;
        public int end;
        public Intervals(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return start+"-"+end;
        }
    }

    public static int binary_search(Intervals[] ar, int l, int r, int x)
    {
        int m = l + (r - l ) / 2 ;
        while(l<=r)
        {
            Intervals newnode = ar[m];
            if((newnode.start)==x)
                return m;
            if((newnode.start)<x)
                return binary_search(ar, m+1, r, x);
            else
                return binary_search(ar, l, m-1, x);
        }
        return m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        Comparator<Intervals> comparator = new Comparator<Intervals>(){
            @Override
            public int compare(Intervals a, Intervals b) {
                return a.start - b.start;
            }
        };

        while(t-->0){
            int n = sc.nextInt();
            int m =sc.nextInt();

            Intervals[] ar = new Intervals[n];
            for(int i=0;i<n;i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                ar[i] = new Intervals(start, end);
            }
            Arrays.sort(ar, comparator);
            for(int i=0; i<m; i++){
                int time = sc.nextInt();
               
                int index = binary_search(ar, 0, n-1, time);
               
               if(index==0)
               {
                    int ans = ar[index].start-time;
                    System.out.println(ans);
               }
               else
               {
                   int ans=-1;
                   if(ar[index-1].end > time)
                    ans=0;
                   else if(index < ar.length)
                    ans = ar[index].start-time;
                    System.out.println(ans);
               }
            }

        }
        sc.close();
    }
}
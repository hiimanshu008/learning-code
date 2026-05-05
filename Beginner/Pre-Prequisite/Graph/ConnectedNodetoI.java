import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectedNodetoI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> [] g = new ArrayList[n];
        for(int i=0; i<n; i++){
            g[i] = new ArrayList<>();
        }

        while (m-- != 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            g[x].add(y); g[y].add(x);
        }

        for(int i=0; i<n; i++) System.out.println("Node "+i+" count : "+ g[i].size());
        sc.close();
    }
    // public static void main(String[] args) {
    //     int[][] b = new int[10][10];
    //     Scanner sc = new Scanner(System.in);
    //     /*5 4 
    //     0 1 
    //     1 2 
    //     2 3 
    //     4 2 
    //      */
    //     int n, m;
    //     n = sc.nextInt();
    //     m = sc.nextInt();

    //     while(m-- != 0){
    //         int x = sc.nextInt();
    //         int y = sc.nextInt();

    //         b[x][y]=1; b[y][x]=1;
    //     }

    //     for(int i=0; i<n; i++){
    //         int count=0;
    //         for(int j=0; j<n; j++){
    //             if (b[i][j]==1) count++;
    //         }
    //         System.out.println("Node "+i+" count : "+count);
    //     }
    //     sc.close();
    // }
}

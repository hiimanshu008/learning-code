import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathBFS {
    public static void main(String[] args) {

        /*5 4
        1 2
        1 3
        2 4
        3 5 */
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int m = sc.nextInt();

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        while (m-- !=0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            list.get(x).add(y); 
            list.get(y).add(x);
        }
        //int src = sc.nextInt();
        int[] distance = shortestPath(n, list, 1);

        for (int i = 1; i <= n; i++) {
            System.out.println("Distance from 1 to " + i + " = " + distance[i]);
        }

        sc.close();
    }

    public static int[] shortestPath(int n, List<List<Integer>> list, int src){
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        dist[src]=0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int ne : list.get(node)){
                if(dist[ne]==-1){
                    dist[ne] = dist[node]+1;
                    queue.offer(ne);
                }
            }
        }

        return dist;
        
    }
}

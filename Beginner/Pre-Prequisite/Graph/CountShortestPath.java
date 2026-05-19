import java.util.*;

public class CountShortestPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int m = sc.nextInt();

        int[] value= new int[n+1];
        for(int i=1; i<=n; i++){
            value[i]=sc.nextInt();
        }

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

        

        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);

        int[] five= new int[n+1];

        long[] ways= new long[n+1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        dist[1] = 0;
        five[1] = (value[1]==5 ? 1:0);
        ways[1] = 1;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int ne : list.get(node)){
                int newDist = dist[node] + 1;
                int newFive =five[node]+(value[ne]==5 ? 1:0);

                if(dist[ne]==-1){
                    dist[ne] = newDist;
                    five[ne] = newFive;
                    ways[ne] =ways[node];
                    q.offer(ne);
                }
                else if(dist[ne]==newDist){
                    if(newFive> five[ne]){
                        five[ne] = newFive;
                        ways[ne] = ways[node];
                    }
                    else if(newFive == five[ne]){
                        ways[ne]+=ways[node];
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            System.out.println("Node "+i+" Ways = "+ways[i]);
        }
        sc.close();
    }
}

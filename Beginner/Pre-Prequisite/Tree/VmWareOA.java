package Tree;
import java.util.*;

public class VmWareOA {

    static long[] sum;

    static int[] value;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sum = new long[n+1];

        value = new int[n+1];
        for(int i=1; i<=n; i++){
            value[i] = sc.nextInt();
        }

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=1; i<n; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            list.get(u).add(v);
            list.get(v).add(u);
        }

        int[] visited = new int[n+1];
        int[] parent = new int[n+1];

        dfs(1, list, visited, parent);

        long answer = Long.MIN_VALUE;
        for(int i=1; i<=n; i++){
            answer = Math.max(answer,sum[i]);
        }
        System.out.println(answer);
        sc.close();
    }

    public static void dfs(int node,List<List<Integer>> list,int[] visited,int[] parent){
        visited[node] = 1;
        for(int ne : list.get(node)){
            if(visited[ne] == 0){
                parent[ne] = node;
                dfs(ne, list, visited, parent);
            }
        }
        long bestChild = 0;
        for(int ne : list.get(node)){
            if(ne == parent[node]) continue;
            bestChild = Math.max(bestChild,sum[ne]);
        }
        sum[node] = value[node]+bestChild;
    }
}


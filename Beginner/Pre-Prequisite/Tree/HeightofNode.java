package Tree;

import java.util.*;

public class HeightofNode {
    static long[] height;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        height = new long[n+1];

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n;i++){
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
        for(int i=1; i<=n; i++) System.out.println(height[i]);
        sc.close();
    }

    public static void dfs(int node,List<List<Integer>> list,int[] visited,int[] parent){

        visited[node] = 1;
        for(int ne : list.get(node)){
            if(visited[ne] == 0){
                parent[ne]= node;
                dfs(ne, list, visited, parent);
            }
        }

        long maxHeight = 0;
        for(int ne : list.get(node)){
            if(ne==parent[node]) continue;
            maxHeight = Math.max(maxHeight,height[ne]);
        }
        height[node]= maxHeight + 1;
    }
}

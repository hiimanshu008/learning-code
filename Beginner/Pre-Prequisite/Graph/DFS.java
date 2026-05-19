import java.util.*;

public class DFS {
    public static void main(String[] args){
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
    
        boolean[] visited = new boolean[n+1];
        dfs(1, list, visited);
        sc.close();
    }

    public static void dfs(int node,List<List<Integer>> list,boolean[] visited){

        visited[node] = true;
        System.out.print(node + " ");

        for(int ne : list.get(node)){
            if(!visited[ne]){
                dfs(ne, list, visited);
            }
        }
    }
}

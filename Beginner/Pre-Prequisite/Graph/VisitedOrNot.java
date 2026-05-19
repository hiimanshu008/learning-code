import java.util.*;

public class VisitedOrNot {
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

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] =true;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int ne : list.get(node)){
                if(!visited[ne]){
                    visited[ne] = true;
                    q.offer(ne);
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(visited[i]) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }
}

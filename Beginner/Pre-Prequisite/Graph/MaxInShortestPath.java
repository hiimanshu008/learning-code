import java.util.*;
public class MaxInShortestPath {
    public static void main(String[] args) {
        
    }

    public static int[] maxInShortest(List<List<Integer>> list, int[] value, int n){
        int dist[] = new int[n+1];
        int[] fiveCount = new int[n+1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 1;
        fiveCount[1] = value[1]==5 ? 1 : 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for(int ne : list.get(node)){
                if(dist[ne]==0){
                    dist[ne] = dist[node]+1;
                    fiveCount[ne] = fiveCount[node] + (value[ne]==5 ? 1 : 0);
                    q.offer(ne);
                }else if(dist[ne] == dist[node]+1){
                    fiveCount[ne] = Math.max(
                        fiveCount[ne],
                        fiveCount[node] + (value[ne] == 5 ? 1 : 0)
                    );
                }
            }
        }
        return fiveCount;
    }
}

package Tree;
import java.util.*;


public class Session1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0; i<n-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            list.get(x).add(y);
            list.get(y).add(x);
        }

        // int[] child = countChildren(n, list, 0);

        // System.out.println("Children Count:");
        // for (int i = 0; i < n; i++) System.out.println(i + " -> " + child[i]);

        // // print leaf nodes
        // System.out.println("Leaf Nodes:");
        // for (int i = 0; i < n; i++) {
        //     if (child[i] == 0) System.out.print(i + " ");
        // }

        int[] value = new int[n];
        for (int i=0; i<n; i++) {
            value[i]=sc.nextInt();
        }
        int[] answer = countOnes(n,list,0,value);

        for (int i=0; i<n; i++) {
            System.out.println(i+"->"+answer[i]);
        }

        sc.close();
    }

    public static int[] countChildren(int n,List<List<Integer>> tree,int src) {
        Queue<Integer> q = new LinkedList<>();
        int[] used = new int[n];
        int[] children = new int[n];

        used[src] = 1;
        q.offer(src);

        while (!q.isEmpty()) {

            int node = q.poll();
            int c=0;

            for (int u : tree.get(node)) {
                if (used[u] == 0) {
                    c++;
                    used[u] = 1;
                    q.offer(u);
                }
            }
            children[node]=c;
        }
        return children;
    }

    public static int[] countOnes(int n,List<List<Integer>> tree,int src, int[] value) {
        Queue<Integer> q = new LinkedList<>();
        int[] used = new int[n];
        int[] ans = new int[n];

        used[src] = 1;
        q.offer(src);
        ans[src] = value[src];

        while (!q.isEmpty()) {

            int node = q.poll();
            for (int u : tree.get(node)) {
                if (used[u] == 0) {
                    used[u] = 1;
                    ans[u] = ans[node]+value[u];
                    q.offer(u);
                }
            }
        }
        return ans;
    }
}

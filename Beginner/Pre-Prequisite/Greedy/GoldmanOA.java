import java.util.*;

public class GoldmanOA {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Long> p1m = new ArrayList<>();
        List<Long> p2m = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            long x = sc.nextLong();

            if (x >= 0) {
                p1m.add(x);
            } else {
                p2m.add(Math.abs(x));
            }
        }

        List<Long> p1f = new ArrayList<>();
        List<Long> p2f = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            long x = sc.nextLong();
            if (x >= 0) {
                p1f.add(x);
            } else {
                p2f.add(Math.abs(x));
            }
        }

        long ans = 0;
        ans += match(p1f, p2m);
        ans += match(p1m, p2f);
        System.out.println(ans);
        sc.close();
    }

    static long match(List<Long> a, List<Long> b) {

        Collections.sort(a);
        Collections.sort(b);
        int i = 0;
        int j = 0;
        long count = 0;

        while (i < a.size() && j < b.size()) {
            if (b.get(j) > a.get(i)) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count;
    }
}

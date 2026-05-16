public class MatchPlayer {
    public static void main(String[] args) {
        long[] b = {1, 2, 3, 4, 5};
        int n = b.length;

        int start = 0;
        int end = n-1;

        long p1 = 0;
        long p2 = 0;

        int turn = 1;
        boolean reversed = false;

        while (start <= end) {
            long selected;
            if (turn % 2 != 0) {
                if (!reversed) {
                    selected = b[start];
                    p1 += selected;
                    start++;
                } else {
                    selected = b[end];
                    p1 += selected;
                    end--;
                }
            }

            else {
                if (!reversed) {
                    selected = b[start];
                    p2 += selected;
                    start++;
                } else {
                    selected = b[end];
                    p2 += selected;
                    end--;
                }
            }

            if (selected % 2 == 0) {
                reversed = !reversed;
            }
            turn++;
        }

        System.out.println("P1 = " + p1);
        System.out.println("P2 = " + p2);
    }
}

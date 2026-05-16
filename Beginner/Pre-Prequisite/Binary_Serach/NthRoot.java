package Binary_Serach;
public class NthRoot {
    public static void main(String[] args) {
        int n = 3, m=27;
        System.out.println(nthValue(n, m));   
    }

    public static double nthValue(int n, int m){
        double l=1, r=m;
        while ((r-l)>1e-6) {
            double mid = (l+r)/2;
            if(lessthanEqual(mid, n, m)) l = mid;
            else r = mid;
        }
        return l;
    }
    //use binary exponentation ( O (logn) )
    private static boolean lessthanEqual(double mid, int n, int m) {
        double res = 1;
        for(int i=1; i<=n; i++){
            res *= mid;
            if(res>m) return false;
        }
        return true;
    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BasicMaths {
    static final int num = 1000000;
    static int[] prime = new int[num+1];

    public static void main(String[] args) {
        spf();
        int i = 84;
        System.out.println("Smallest Factor of "+i+" : "+prime[i]);
    }
    //smallest prime factor till 10^6;
    public static void spf(){
        for(int i = 2; i<num+1; i++) prime[i]=i; 
        for(int i=2; i*i<=num ; i++){
            if (prime[i]==i){
                for(int j=i*i ; j<=num ; j+=i) prime[j]= i;
            }
        }
    }

    //Sieve of Eratosthenes ( O(n log(log n)))
    public static boolean[] soe(int n){
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes,true);
        primes[0]=primes[1]=false;

        for(int i=2; i*i<=n; i++){
            if (primes[i]){
                for(int j = i*i ; j<=n; j+=i) primes[j] = false;
            }
        }
        return primes;
    }

    //Representing each no into its product of its prime factors ( o (sqrt(n)))
    public static Map<Integer,Integer> primeProduct(int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        while(n%2==0){
            map.put(2,map.getOrDefault(2,0)+1);
            n/=2;
        }

        for(int i=3 ; i*i<=n; i+=2){
            while(n%i==0){
                map.put(i,map.getOrDefault(i,0)+1);
                n/=i;
            }
        }

        if (n!=1) map.put(n,1);

        return map;
    }

    // Prime factors of all numbers in an array 
}

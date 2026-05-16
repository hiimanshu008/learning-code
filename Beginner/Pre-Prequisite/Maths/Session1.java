import java.util.Scanner;

public class Session1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a, b, k;
        a = scanner.nextInt();
        b = scanner.nextInt();
        k = scanner.nextInt();
        
        System.out.println((a % k + b % k) % k);
        System.out.println(((a % k) * (b % k)) % k);
        System.out.println((a % k - b % k + k) % k);
        
        scanner.close();
    }
}



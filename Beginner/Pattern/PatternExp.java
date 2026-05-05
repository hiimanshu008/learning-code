public class PatternExp {
    public static void main(String[] args) {
        sumPattern(5);
    }

    public static void oddSquare(int n){
        for(int row=1; row<=n; row++){
            for(int col=row; col<=n; col++){
                System.out.print(col*2-1+" ");
            }
            int a=1;
            for(int k=1; k<=row; k++){
                System.out.print(a+" ");
                a+=2;
            }
            System.out.println();
        }
    }

    public static void sumPattern(int n){
        for(int row=1; row<=n; row++){
            int sum=0;
            for(int col=1; col<=row; col++){
                sum+=col;
                System.out.print(col+" ");
                if(col<row) System.out.print("+ ");
            }
            System.out.println("= "+sum);
        }
    }

    public static void pattern13(int n){
        for(int row=1; row<=n; row++){
            for(int col=1; col<=2*n-row; col++){
                if(row==1 || row==col || col==2*n-row) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern00(int n){
        for(int row=1; row<2*n; row++){
            int totalRowsInCol = row>n? 2*n-row : row;
            for(int space=1; space<=n-totalRowsInCol; space++){
                System.out.print("  ");
            }
            for(int col=totalRowsInCol; col>=1; col--){
                System.out.print(col+" ");
            }
            for(int col=2; col<=totalRowsInCol; col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    public static void pattern12(int n){
        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern11(int n){
        for(int i=0;i<n; i++){
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            for(int j=0; j<n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern10(int n){
        int org = n;
        n *= 2;

        for(int row=1; row<n; row++){
            for(int col=1; col<n; col++){
                int atEveryIdx = org - Math.min(Math.min(row,col), Math.min(n-row,n-col)) + 1;
                System.out.print(atEveryIdx+" ");
            }
            System.out.println();
        }
    }

    public static void pattern9(int n){
        for(int i=1; i<2*n; i++){
            int totalCols = i>n ? 2*n-i : i;
            for(int j=1; j<=n-totalCols; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=totalCols; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern1(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void pattern2(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                char c = (char)('A'+i);
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n){
        char c = 'A';
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                char xc = (char)(c+j);
                System.out.print(xc+" ");
            }
            c++;
            System.out.println();
        }
    }

    public static void pattern4(int n){
        char c = (char)('A'+n-1);
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                char xc = (char)(c+j);
                System.out.print(xc+" ");
            }
            c--;
            System.out.println();
        }
    }

    public static void pattern5(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++){
                System.out.print(k);
            }
            System.out.println();
        }
    }

    public static void pattern6(int n) {
        for(int i=n; i>=1; i--){
            for(int j=i; j>=1;j--){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void pattern7(int n) {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++){
                System.out.print(k);
            }
            System.out.println();
        }
    }

    public static void pattern8(int n) {
        for(int i=1; i<=n; i++){
            //int totalCols = i>n ? 2*n-1 : i;
            for(int j=1; j<=n-i;j++){
                System.out.print(" ");
            }
            for(int k=i; k<=2*i-1; k++){
                System.out.print(k);
            }
            for(int l=2*i-2; l>=i;l--){
                System.out.print(l);
            }
            System.out.println();
        }
    }
    
    
}

import java.util.TreeSet;

public class PracticeQuestion {
    public static void main(String[] args) {
        
    }

    public static int largerstValidSubString(String s, int k){
        TreeSet<Character> ts = new TreeSet<>();
        int maxLen =0;

        for(int i=0,j=0; j<s.length(); j++){
            ts.add(s.charAt(j));
            while (ts.last()-ts.first()>k) {
                ts.remove(s.charAt(i));
                i++;
            }
            maxLen = Math.max(maxLen, j-i+1);
        }

        return maxLen;
    }
}   

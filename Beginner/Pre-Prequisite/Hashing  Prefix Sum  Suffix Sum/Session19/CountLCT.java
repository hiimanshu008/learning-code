public class CountLCT {
    public static void main(String[] args) {
        String s= "lctlllct";
        System.out.println(countLCT(s));
    }

    public static long countLCT(String s){
        long countL=0, countC=0;
        long lct=0;

        for(char c : s.toCharArray()){
            if(c=='l') countL++;
            if(c=='c') countC += countL;
            if(c=='t') lct += countC; 
        }


        // for l to be inserted
        long countonlyC=0; 
        long countCT=0;
        for(char c : s.toCharArray()){
            if(c=='c') countonlyC++;
            if(c=='t') countCT += countonlyC;
        }

        long newCountL = lct + countCT; 

        // for t to be inserted
        long newCountT = lct + countC;

        // as C can be added anywhere so we need to calculate
        // total_L before C * total_R after T
        
        int[] preL = new int[s.length()];
        int l=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='l') l++;
            preL[i] = l;
        }

        int[] suffT = new int[s.length()];
        int t=0;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i)=='t') t++;
            suffT[i] = t;
        }
        long bestC=0;
        for(int i = 0; i<=s.length(); i++){
            int leftL = (i==0) ? 0 : preL[i-1];
            int rightT = (i==s.length())? 0 : suffT[i];
            bestC = Math.max((long)rightT * leftL, bestC); 
        }

        // find max (newCountL, newCountL, best c);
        return Math.max(Math.max(newCountL,newCountT), bestC+lct);
    }
}

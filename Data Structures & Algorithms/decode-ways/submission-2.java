class Solution {

    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return recur(s,0,dp);
    }


    int recur(String s, int index, int dp[]){
        if(index==s.length()){
            return 1;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int left = 0;
        if((int)(s.charAt(index)-'0')>0){
           left = recur(s,index+1,dp);
        }
        int right = 0;
        if(index+1<s.length() ){
           int result = (s.charAt(index)-'0')*10 + s.charAt(index+1)-'0';
           if(result>=10 && result<=26){
               right = recur(s,index+2,dp);
           }    
        }
        dp[index] = left+right;
        return dp[index];
    }
}

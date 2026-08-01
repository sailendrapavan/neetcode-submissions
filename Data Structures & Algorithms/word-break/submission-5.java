class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return recur(s,wordDict,0,dp);
    }

    public boolean recur(String s, List<String> list, int index, int[] dp){
        if(index==s.length()){
            return true;
        }
        if(dp[index]!=-1){
            if(dp[index]==0){
                return false;
            }
            else{
                return true;
            }
        }
        for(String match: list){
            int len = match.length();
            if(s.length()<index+len){
                continue;
            }
            String extracted = s.substring(index, index+len);
            if(extracted.equals(match) && recur(s,list, index+len, dp)){
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = 0;
        return false;
    }
}

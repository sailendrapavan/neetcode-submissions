class Solution {
    HashMap<String, String> map = new HashMap<String,String>();

    public int numDecodings(String s) {
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("5", "E");
        map.put("6", "F");
        map.put("7", "G");
        map.put("8", "H");
        map.put("9", "I");
        map.put("10", "J");
        map.put("11", "K");
        map.put("12", "L");
        map.put("13", "M");
        map.put("14", "N");
        map.put("15", "O");
        map.put("16", "P");
        map.put("17", "Q");
        map.put("18", "R");
        map.put("19", "S");
        map.put("20", "T");
        map.put("21", "U");
        map.put("22", "V");
        map.put("23", "W");
        map.put("24", "X");
        map.put("25", "Y");
        map.put("26", "Z");
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
        if(map.get(s.substring(index,index+1))!=null){
           left = recur(s,index+1,dp);
        }
        int right = 0;
        if(index+1<s.length() && map.get(s.substring(index,index+2))!=null){
           right = recur(s,index+2,dp);
        }
        dp[index] = left+right;
        return dp[index];
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int i = prices.length-1;
        int largest = prices[i];
        int max_sum = 0;
        while(i>=0){
            int current_sum = largest - prices[i];
            max_sum = Math.max(current_sum,max_sum);
            largest = Math.max(largest,prices[i]);
            i--;
        }
        return max_sum;
    }
}

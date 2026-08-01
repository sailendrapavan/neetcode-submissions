class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int max = -1;
       int min = Integer.MAX_VALUE;
       for(int i=0;i<piles.length;i++){
        if(max<piles[i]){
          max = piles[i];
        }
       }

       int low = 0;
       int high = max;
       while(low<=high){
         int mid = low+(high-low)/2;
         System.out.println(mid);
         int hours = eatingRateFinder(piles, mid);
         System.out.println(hours);
         if(hours<=h){
             min = Math.min(min,mid);
         }    
         if(hours>h){
            low = mid+1;
         }else{
            high = mid -1;
         }
       }
       return min;
    }

    public int eatingRateFinder(int[] piles, int eatingRate){
        if(eatingRate==0){
            return Integer.MAX_VALUE;
        }
        int sum = 0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]%eatingRate==0){
                sum = sum+ (piles[i] / eatingRate);
            }else if (piles[i]<eatingRate){
                sum = sum + 1;
            }else{
                sum = sum + (piles[i] / eatingRate) + 1;
            }
        }
        return sum;
    }
}

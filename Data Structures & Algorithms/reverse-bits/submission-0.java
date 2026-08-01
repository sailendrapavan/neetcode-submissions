class Solution {
    public int reverseBits(int n) {
        int result = 0;

       for(int i=0;i<32;i++){
        int bit=(n>>i)&1;
        System.out.println(bit);
        result = result + (bit<<(31-i));
        System.out.println(result);
       }
       return result;
    }
}

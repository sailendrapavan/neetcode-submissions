class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasStations = gas.length;
        for(int i =0;i<gasStations;i++){
            int count = gasStations;
            int tank = 0;
            int j = i;
            while(count!=0){
                tank = tank + (gas[j%gasStations]) - cost[j%gasStations];
                if(tank>=0){
                    count--;
                }else{
                    break;
                }
                j++;
            }
            if(count ==0){
                return i;
            }
        }
        return -1;
    }
}


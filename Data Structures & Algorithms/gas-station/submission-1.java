class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasStations = gas.length;
        for(int i =0;i<gasStations;i++){
            int count = gasStations;
            int tank = 0;
            int j = i;
            while(count!=0){
                tank = tank + (gas[j%gasStations]);
                if(tank>=(cost[j%gasStations])){
                    count--;
                    tank = tank -(cost[j%gasStations]);
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


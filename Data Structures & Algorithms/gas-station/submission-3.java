class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasStations = gas.length;
        int startIndex = 0;
        int tank =0;
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0;i<gasStations;i++){
            totalGas = totalGas + gas[i];
            totalCost =  totalCost +  cost[i];
        }
        if(totalGas<totalCost){
            return -1;
        }
        for(int i =0;i<gasStations;i++){
            tank = tank + gas[i] - cost[i];
            if(tank<0){
                startIndex = i+1;
                tank=0;
            }             
        }
        return startIndex;
    }


    public int canCompleteCircuit2(int[] gas, int[] cost) {
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


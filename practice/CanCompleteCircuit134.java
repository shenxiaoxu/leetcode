/*
134.gas station
there are n gas stations along a circular route, where the amount of gas at station i is gas[i].
return starting gas station index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
gas = [1,2,3,4,5]
cost = [3,4,5,1,2]
output:3
3-4-0-1-2-3

gas = [2,3,4]
cost = [3,4,3]
output: -1
*/
class CanCompleteCircuit{
	public static void main(String[] args){
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		System.out.println(canCompleteCircuit(gas, cost, 0));
	}
	public static int canCompleteCircuit(int[] gas, int[] cost, int startIndex){
		for(int j = 0; j < gas.length; j++){
			startIndex = j;		
			int remaining = gas[startIndex];
			for(int i = startIndex; i < gas.length; i++){
				remaining = remaining - cost[i];
				if(remaining < 0){break;}
				if(i == gas.length - 1){
					remaining = remaining + gas[0];
				}else{
					remaining = remaining + gas[i + 1];
				}
			}
			if(remaining < 0){continue;}
			for(int i = 0; i < startIndex; i++){
				remaining = remaining - cost[i];
				if(remaining < 0){break;}
				if(i == startIndex - 1){
					return startIndex;
				}
				remaining = remaining + gas[i + 1];
		
			}
		}
		return -1;
	}
}
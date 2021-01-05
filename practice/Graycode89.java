/*
89.gray code
binary numeral system where two successive values differ in only onebit
given integer n representing total number of bits in the code.
in:2
ou:[0,1,3,2]
00-0
01-1
11-3
10-2
not uniquely define
00 - 0
10 - 2
11 - 3
01 - 1
*/
import java.util.*;
class Graycode{
	public static void main(String[] args){
		int number = 3;
		List<Integer> results = new LinkedList<Integer>();
		List<Integer> result = new LinkedList<Integer>();
		for(int i = 0; i < number; i++){
			result.add(0);
		}
		grayCode(number, results, result);
		System.out.println(results);
	}
	public static void grayCode(int number, List<Integer> results, List<Integer> result){
		System.out.println(result);
		int temp = 0;
		int count = 0;		
		for(int i = result.size() - 1; i>=0; i--){
			temp = result.get(i)*(int)Math.pow(2,count) + temp;
			count++;
		}
		if(results.indexOf(temp) == -1){			
			results.add(temp);
			if(results.size() == (int)Math.pow(2,number)){
				return;
			}
		}else{
			return;
		}
		for(int i = number - 1; i >= 0; i--){
			if(result.get(i) == 0){
				result.set(i, 1);
				grayCode(number, results, result);
				result.set(i, 0);
			}else{
				result.set(i, 0);
				grayCode(number, results, result);
				result.set(i, 1);			
			}

		}
	}
}
/*
120.triangle
given a triangle, find the minimum path sum from top to bottom,each step you may move to adjacent numbers on the row below
[
[2],
[3,0],
[6,5,7],
[4,1,8,0]
]
2+3+5+1=11
*/
import java.util.*;
class MinimumTotal{
	public static void main(String[] args){
		LinkedList<Integer> first = new LinkedList<Integer>();
		first.add(2);
		LinkedList<Integer> second = new LinkedList<Integer>();
		second.add(3);	
		second.add(0);
		LinkedList<Integer> fourth = new LinkedList<Integer>();
		fourth.add(6);
		fourth.add(5);
		fourth.add(7);
		LinkedList<Integer> fifth = new LinkedList<Integer>();
		fifth.add(4);
		fifth.add(1);
		fifth.add(8);
		fifth.add(0);
		LinkedList<LinkedList<Integer>> input = new LinkedList<LinkedList<Integer>>();
		input.add(first);
		input.add(second);
		input.add(fourth);
		input.add(fifth);
		System.out.println(minimumTotal(input, 0, 0, Integer.MAX_VALUE, 0));
	}
	public static int minimumTotal(LinkedList<LinkedList<Integer>> input, int step, int index, int minimum, int sum){
		if(step > input.size()){
			return minimum;
		}

		if(step == input.size()  && sum < minimum){
			minimum = sum;
			System.out.println("SUM: " + sum);		
			return minimum;
		}
		if(index > input.get(step).size() - 1|| index < 0){
			return minimum;
		}
		int value = input.get(step).get(index);
		System.out.println("step: " + step + "index: " + index + "value: " + value);
		int first = minimumTotal(input, step + 1, index + 1, minimum, sum + value);
		int second = minimumTotal(input, step + 1, index - 1, minimum, sum + value);
		int third = minimumTotal(input, step + 1, index, minimum, sum + value);
		return Math.min(Math.min(first, second),third);
	}
}
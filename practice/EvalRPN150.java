/*
150.evaluate reverse polish notation
evaluate the value of an arithmetic expression in reverse polish notation
in:[2,1,+,3,*]
out:9
((2+1)*3) = 9
in:[10,6,9,3,+,-11,*,/,*,17,+,5,+]
out:22
*/
import java.util.*;
class EvalRPN{
	public static int evalRPN(String[] tokens){
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < tokens.length; i++){
			String temp = tokens[i];
			char[] array = temp.toCharArray();
			if(array[0] == '+'){
				int element1 = queue.pollLast();
				int element2 = queue.pollLast();
				int result = element1+element2;
				//System.out.println("result " + result);
				queue.add(result);
			}else if(array[0] == '-' && array.length == 1){
				int element1 = queue.pollLast();
				int element2 = queue.pollLast();
				int result = element1-element2;
				//System.out.println("result " + result);
				queue.add(result);
			}
			else if(array[0] == '*'){
				int element1 = queue.pollLast();
				int element2 = queue.pollLast();
				int result = element1*element2;
				//System.out.println("result " + result);
				queue.add(result);
			}
			else if(array[0] == '/'){
				int element1 = queue.pollLast();
				int element2 = queue.pollLast();
				int result = (int)element2/element1;
				//System.out.println("result " + result);
				queue.add(result);
			}else{
				int result = Integer.parseInt(temp);
				//System.out.println("result " + result);
				queue.add(result);
			}				
		}
		int resultfinal = queue.pollLast();
		return resultfinal;  
	}
	public static void main(String[] args){
		String[] input = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		System.out.println(evalRPN(input));	
	}
}
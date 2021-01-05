/*
127.word ladder
given two words(beginword and endword) and a dictionary's word list, find length of shortest transformation sequence from begin to end
1.only one letter can be changed at a time
2. each transformed word must exist in word list
in:
beginword = hit
endword = cog
wordlist = [hot,dot,dog,lot,log,cog]
out: 5
hit-hot-dot-dog-cog 
*/
import java.util.*;
class LadderLength{
	public static void main(String[] args){
		LinkedList<String> lists = new LinkedList<String>();
		lists.add("hot");
		lists.add("dot");
		lists.add("dog");
		lists.add("lot");
		lists.add("cog");
		LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
		
		String beginword = "hit";
		String endword = "cog";
		LinkedList<String> path = new LinkedList<String>();
		path.add(beginword);
		int minimum = ladderLength(beginword, endword, lists, result, path, Integer.MAX_VALUE);
		System.out.println(minimum);
		System.out.println(result);

	}
	public static int ladderLength(String begin, String end, LinkedList<String> lists, LinkedList<LinkedList<String>> result,LinkedList<String> path, int minimum){
		if(begin.compareTo(end) == 0){
			System.out.println("path: " + path);
			result.add(new LinkedList<String>(path));
			if(path.size() < minimum){
				minimum = path.size();
			}
			return minimum;
		}
		for(int i = 0; i < begin.length(); i++){
			for(char a = 'a'; a <= 'z'; a++){
				String previous = begin;
				char[] array = begin.toCharArray();
				array[i] = a;
				begin = new String(array);
				//System.out.println("begin: " + begin);
				if(lists.indexOf(begin) != -1 && path.indexOf(begin) == -1){	
					System.out.println("begin: " + begin);				
					path.add(begin);
					minimum = ladderLength(begin, end, lists, result, path, minimum);
					begin = previous;
					path.pollLast();
				}else{
					begin = previous;
				}
			}
		}
		return minimum;
	}
}
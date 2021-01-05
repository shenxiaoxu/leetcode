/*948. Bag of Tokens
Medium

You have an initial power P, an initial score of 0 points, and a bag of tokens.

Each token can be used at most once, has a value token[i], and has potentially two ways to use it.

If we have at least token[i] power, we may play the token face up, losing token[i] power, and gaining 1 point.
If we have at least 1 point, we may play the token face down, gaining token[i] power, and losing 1 point.
Return the largest number of points we can have after playing any number of tokens.

 

Example 1:

Input: tokens = [100], P = 50
Output: 0
Example 2:

Input: tokens = [100,200], P = 150
Output: 1
Example 3:

Input: tokens = [100,200,300,400], P = 200
Output: 2
 

Note:

tokens.length <= 1000
0 <= tokens[i] < 10000
0 <= P < 10000
solution:
p = 0;
p[i] = if choose face up, p[i + 1] + 1; p - points[i]
       if choose face down,p[i + 1] - 1; p + points[i] 

coding wrong answer: if recursing make P bigger, hard to make points bigger. casue low already cover that number. 
right ansnswer: make P bigger than zero, then use P to change points. use if not while.
*/
import java.util.*;
class BagofTokens948{
	public static void main(String[] args){	
		int[] array1 = {100};
		int p1 = 50;
		int[] array2 = {100,200};
		int p2 = 150;
		int[] array3 = {100,200,300,400};
		int p3 = 200;
		int[] array4 = {52,65,35,88,28,1,4,68,56,95};
		int p4 = 94;
		int[] array5 = {33,4,28,24,96};
		int p5 = 35;
		BagofTokens948 object = new BagofTokens948();
		//System.out.println("result:" + object.bagoftoken(array1, p1));
		//System.out.println("result:" + object.bagoftoken(array2, p2));
		System.out.println("result:" + object.bagoftokenGreedy(array5, p5));
		//System.out.println("result:" + object.bagoftoken(array4, p4));
	}
	public int bagoftoken(int[] tokens, int p){
		Arrays.sort(tokens);
		int[] visited = new int[tokens.length];
		return bagoftokenrecursive(tokens, p, visited, 0, 0);
	}
	public int bagoftokenrecursive(int[] tokens, int power, int[] visited, int points, int maximum){
		if(points > maximum){
			maximum = points;
		}
		
		for(int i = tokens.length - 1; i>=0;i--){
			if(visited[i] == 0){
				if(points >= 1){
					visited[i] = 1;
					maximum = Math.max(maximum, bagoftokenrecursive(tokens, power + tokens[i], visited, points - 1, maximum));
					visited[i] = 0;
				}
				if(power >= tokens[i]){
					visited[i] = 1;
					maximum = Math.max(maximum, bagoftokenrecursive(tokens, power - tokens[i], visited, points + 1, maximum));
					visited[i] = 0;
				}
			}
		}
		
		return maximum;
	}
	
	public int bagoftokenGreedy(int[] tokens, int P){
		Arrays.sort(tokens);
		int lo = 0, hi = tokens.length - 1;
		int ans = 0, points = 0;
		while(lo <= hi && (points > 0 || P >= tokens[lo])){
			while(lo <= hi && P >= tokens[lo]){
				P -= tokens[lo++];
				points++;
			}
			ans = Math.max(ans, points);
			if(lo <= hi && points > 0){
				P += tokens[hi--];
				points--;
			}
		}
		return ans;
	}
}











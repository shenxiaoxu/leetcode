/*
Given an integer n, find a sequence that satisfies all of the following:

The integer 1 occurs once in the sequence.
Each integer between 2 and n occurs twice in the sequence.
For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.

Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution.

A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b differ, sequence a has a number greater than the corresponding number in b. For example, [0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.
*/
class Solution {
    public int[] constructDistancedSequence(int n) {        
        int[] res = new int[2*n - 1];
        int[] visited = new int[n + 1];
        dfs(res, n, 0, visited);
        return res;
    }
    private boolean dfs(int[] res, int n, int idx, int[] visited){
        if(idx == res.length){
            return true;
        }
        if(res[idx] > 0){
            if(dfs(res, n, idx + 1, visited)) return true;
        }else{
            for(int i = n; i >= 1; i--){
                if(visited[i] == 1) continue;
                res[idx] = i;
                visited[i] = 1;
                if(i == 1){
                    if(dfs(res, n, idx + 1, visited)) return true;
                }else if(i + idx < res.length && res[i + idx] == 0){
                    res[i + idx] = i;
                    if(dfs(res, n, idx + 1, visited)) return true;
                    res[i + idx] = 0;
                }
                res[idx] = 0;
                visited[i] = 0;
            }          
        }
        return false;
    }
}
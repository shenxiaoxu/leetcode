/*763. Partition Labels
Medium

1675

80

Add to List

Share
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList();
        HashMap<Character, Integer> map = new HashMap();
        for(char c: S.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }//count each character
        int left = 0;
        while(left < S.length()){
            Set<Character> windowLetter = new HashSet();
            int count = 0;
            for(int right = left; right < S.length(); right++){
                char c = S.charAt(right);
                if(!windowLetter.contains(c)){
                    windowLetter.add(c);
                }
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0){
                    count++;
                }
                if(count == windowLetter.size()){
                    result.add(right - left + 1);
                    left = right + 1;
                    break;
                }
            }
        }
        return result;
    }
}
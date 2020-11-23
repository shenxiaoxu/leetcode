class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, right = 0, l = s.length(), res = 0;
        HashMap<Character, Integer> map = new HashMap();
        while(right < l){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if(map.size() > 2){
                while(map.size() > 2){
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    if(map.get(s.charAt(left)) == 0){
                        map.remove(s.charAt(left));
                    }
                    left++;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}

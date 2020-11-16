class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        HashSet<Character> set1 = new HashSet();
        HashSet<Character> set2 = new HashSet();
        for(char a: word1.toCharArray()) {count1[(int)(a - 'a')]++; set1.add(a);}
        for(char a: word2.toCharArray()) {count2[(int)(a - 'a')]++; set2.add(a);}

        Arrays.sort(count1);
        Arrays.sort(count2);
        
        return Arrays.equals(count1, count2) && set1.equals(set2);
    }
}

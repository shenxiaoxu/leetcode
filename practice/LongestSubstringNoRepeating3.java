import java.util.LinkedList;
public class LongestSubstringNoRepeating
{

    public static void main(String[] args)
    {
        String stringTest = new String("abcabcbb");
        String stringTestTwo = new String("bbbbb");
        String stringTestThree = new String("pwwkew");
        System.out.println(findLongesSubstring(stringTest));
        System.out.println(findLongesSubstring(stringTestTwo));
        System.out.println(findLongesSubstring(stringTestThree));
    }
    public static int findLongesSubstring(String input)
    {
        int record = 1;
        int array[] = new int[256];
        for(int i = 0; i < array.length;i++){
            array[i] = 0;
        }
        for(int i = 0;i < input.length();i++){
            for(int j = i + 1;j < input.length();j++){
                char index = input.charAt(j);
                int charJ = (int)index;
                //System.out.println(charJ);                
                if(input.charAt(j)!=input.charAt(i) && array[charJ] == 0){
                    record = Math.max(record,j-i+1);
                    array[charJ] = 1;
                }else{
                    for(int k = 0; k < array.length;k++){
                        array[k] = 0;
                    }
                    break;
                }
            }
        }
        return record;
    }
}
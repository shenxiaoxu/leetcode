import java.util.LinkedList;
/*
Given two string text1, text2. return the length of their longest common subsequence.
abcde ace, 3
abc abc 3
abc def 0
*/
public class LongestCommonSubstring
{

    public static void main(String[] args)
    {
        String stringTest = new String("abcde");
        String stringTestTwo = new String("ace");
        String stringTestThree = new String("ae");
        System.out.println(findLongestCommonSubstring(stringTest, stringTestTwo));
        System.out.println(findLongestCommonSubstring(stringTestTwo, stringTestThree));
        System.out.println(findLongestCommonSubstring(stringTestThree, stringTest));
    }
    public static int findLongestCommonSubstring(String input, String input2)
    {
      int[][] array = new int[input2.length()][input.length()];
        for(int i = 0; i < input.length(); i++){           
            if(input2.charAt(0) == input.charAt(i)){
                array[0][i] = 1;
                for(int j = i; j < input.length(); j++){
                    array[0][j] = 1;
                }
                break;
            }else{
                array[0][i] = 0;
            }
        }
      
      for(int j = 0; j < input2.length(); j++){
            if(input.charAt(0) == input2.charAt(j)){
                array[j][0] = 1;
                for(int i = j; i < input2.length(); i++){
                    array[i][0] = 1;
                }
                break;
            }else{
                array[j][0] = 0;
            }       
      }          
      for(int i = 1; i < input2.length(); i++){
        for(int j = 1; j < input.length(); j++){

            if(input2.charAt(i) == input.charAt(j)){
                array[i][j] = array[i - 1][j - 1] + 1;
            }else{
                array[i][j] = Math.max(array[i - 1][j], array[i][j - 1] );
            }
        }
      }
      return array[input2.length() - 1][input.length() - 1];
    }
}
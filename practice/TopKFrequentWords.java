/*
692.given a non-empty list of words, return the k most frequent elements.
sorted by frequency from highest to lowest. if two words have the same frequency, the word with lower alphabetical order comes first.
input[i, love, leetcode, i, love, coding] k = 2 output[i, love]
input[the, day, is, sunny, the, the, the, sunny, is, is] k = 4 output[the, is, sunny, day]
try to solve it in o(nlogk) time and o(n) extra space
*/
import java.util.*;
public class TopKFrequentWords
{

    public static void main(String[] args)
    {
        String[] array = {"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(array, 2));
    }
    public static List<String> topKFrequent(String[] words, int k){
       Map<String, Integer> wordMap = new HashMap<String, Integer>();

       for(int i = 0; i < words.length; i++){
          if(wordMap.containsKey(words[i])){
            wordMap.put(words[i], wordMap.get(words[i]) + 1);
          }else{
            wordMap.put(words[i], 1);
          }
       }
       System.out.println(wordMap);
       Map<String, Integer> result = new LinkedHashMap<String, Integer>();
       List<String> output = new LinkedList<String>();
      /*wordMap.entrySet().stream()
              .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
              .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
      */
      List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(wordMap.entrySet());
      Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
          public int compare(Map.Entry<String, Integer>o1, Map.Entry<String, Integer>o2)
          {
            if(o1.getValue() == o2.getValue()){
              return (o1.getKey()).compareTo(o2.getKey());
            }else{
              return -(o1.getValue()).compareTo(o2.getValue());
            }
          }
        });
      for(Map.Entry<String, Integer>entry : list)
      {
        result.put(entry.getKey(), entry.getValue());
      }
      System.out.println(result);
       int number = k;
       for (Map.Entry<String, Integer> x : result.entrySet()){
            if(number != 0){
              output.add(x.getKey());
              number--;
            }else{
              break;
            }
        }
        return output;
    }
}
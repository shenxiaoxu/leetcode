/*
207. Course Schedule
Medium

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/
import java.util.*;
public class CourseScheduler207
{
    public static void main(String[] args){
    	int[][] array = {{1,0},{2,0},{3,1},{3,2}};
        CourseScheduler207 object = new CourseScheduler207();
        boolean result = object.numCoursesSolution2(4,array);

        System.out.println(result);
    }
    public static int[] numCourses(int numCourses, int[][] array){ 
        int[] result = new int[numCourses];
        int count = 0;
        List<Set<Integer>> prerequirest = new ArrayList<Set<Integer>>();
        for(int i = 0; i < array.length; i++){
            prerequirest.add(new HashSet<Integer>());
        }
        for(int j = 0; j < array.length; j++){
            prerequirest.get(array[j][1]).add(array[j][0]);
        }
        int[] degree = new int[numCourses];
        for(int k = 0; k < numCourses; k++){
            for(int kk : prerequirest.get(k))
                degree[kk]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int l = 0; l < degree.length; l++){
            if(degree[l] == 0){
                q.offer(l);
            }
        }
 
        while(!q.isEmpty()){
            int element = q.poll();
            for(int p : prerequirest.get(element)){
                degree[p]--;
                if(degree[p] == 0){
                    q.offer(p);
                }
            }
            result[count] = element;
            count++;
        }
        if(result.length == numCourses){ 
            return result;
        }   
        return new int[0];
    }
    public boolean numCoursesSolution2(int numCourses, int[][] array){
        if(array == null || array.length == 0) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] indegree = new int[numCourses];
        for(int[] pair : array){
            indegree[pair[0]]++;
            if(map.containsKey(pair[1])){
                map.get(pair[1]).add(pair[0]);
            }else{
                List<Integer> list = new LinkedList<Integer>();
                list.add(pair[0]);
                map.put(pair[1], list);
            }  
        }

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        while(queue.size() != 0){
            int key = queue.poll();
            List<Integer> subCourses = map.get(key);
            for(int i = 0; subCourses != null && i < subCourses.size(); i++){
                if(--indegree[subCourses.get(i)] == 0){
                    queue.offer(subCourses.get(i));
                }
            }
        }
        for(int i = 0; i < indegree.length; i++){
            //System.out.println(indegree[i]);
            if(indegree[i] != 0){
                return false;
            }
        }
        return true;
    }
}  















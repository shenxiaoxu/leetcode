/*
210. Course Schedule II

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.*/
import java.util.*;
public class CourseScheduler210
{
    public static void main(String[] args){
    	int[][] array = {{1,0},{2,0},{3,1},{3,2}};
        int[][] array2 = {{0,1},{1,0}};
        
        CourseScheduler210 object = new CourseScheduler210();
        //int[] result = object.numCoursesSolution2(4,array);
        int[] result = object.numCoursesSolution2(4,array);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
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
    public int[] numCoursesSolution2(int numCourses, int[][] prerequisites){
        int[] result = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];

        for(int[] pre: prerequisites){
            indegree[pre[0]]++;
            if(map.containsKey(pre[1])){
                map.get(pre[1]).add(pre[0]);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(pre[0]);
                map.put(pre[1], list);
            }
        }
        
    
        int slow = 0, fast = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                result[fast++] = i;
            }
        }
   
        while(slow < fast){
            List<Integer> subCourse = map.get(result[slow]);
            if(subCourse != null){
                for(int sub : subCourse){
                    if(--indegree[sub] == 0) 
                        result[fast++] = sub;
                }
            }
            slow++;
        }
        if(fast != numCourses) return new int[0];
        return result;
    }
}  























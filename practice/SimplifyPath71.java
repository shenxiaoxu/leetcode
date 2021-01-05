/*71. Simplify Path

Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.

 

Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:

Input: "/a/./b/../../c/"
Output: "/c"
Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"
Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
attention: use stack to pop, but result should be FIFO
*/
import java.util.*;
class Solution {
    public String simplifyPath(String path) {
        if(path.length() == 0) return "";
        String[] components = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String component: components){
        	if(component.isEmpty() || component.equals(".")){//the character is . or empty
        		continue;
        	}else if(component.equals("..")){//character is '..'
        		if(!stack.isEmpty()){
        			stack.pop();
        		}
        	}else{
        		stack.add(component);
        	}
        }

        StringBuilder result = new StringBuilder();
        for(String c:stack){
        	result.append("/");
        	result.append(c);
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}

























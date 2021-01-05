/*
71.given an absolute path, simplif it.
path = "/home/"->"/home"
path = "/a/./b/../../c/"->"/c"
path = "/a/../../b/../c//.//"->"/c"
path = "/a//b////c/d//././/.."->"/a/b/c"

corner case
"/../"-->"/"
/home//foo/-->/home/foo
*/
import java.util.*;
class SimplyPath{
	public static void main(String[] args){
		String path1 = "/home/";
		String path2 = "/a/./b/../../c/";
		String path3 = "/a/../../b/../c//.//";
		String path4 = "/a//b////c/d//././/..";
		String path5 = "/../";
		String path6 = "/home//foo/";
		//System.out.println(simplyPath(path1));
		//System.out.println(simplyPath(path2));
		System.out.println(simplyPath(path3));
		//System.out.println(simplyPath(path4));
		//System.out.println(simplyPath(path5));
		//System.out.println(simplyPath(path6));
	}
	public static String simplyPath(String path){
		LinkedList<String> stringlist = new LinkedList<String>();
		for(int i = 0; i < path.length(); i++){
			while(i != path.length() && path.charAt(i) == '/'){
				i++; 
			}
			int index = i;
			while(index != path.length() && path.charAt(index) != '/'){
				index ++; 
			}
			String sub = path.substring(i, index);
			System.out.println(sub);
			if(sub.equals("..") && stringlist.size() != 0){
				
				String s = stringlist.pollLast();
				//System.out.println("poll" + s);
				i = index;
				continue;
			}
			if(sub.equals("..") && stringlist.size() == 0)
				continue;
			if(!sub.equals(".") && !sub.equals("")){
				//System.out.println("add" + sub);
				stringlist.add(sub);
				i = index;
			}
			i = index;
		}
		
		String result = "";
		for(int i = 0; i < stringlist.size();i++){
			result = result + "/" + stringlist.get(i);
		}
		if(stringlist.size() == 0){
			return "/";
		}
		return result;
	}
}
/*
. match any single character
* match zero or more of preceding element.
given input . "*"
s="aa", p = "a" false
s= "aa" p = "a*" true
s = "ab" p = ".*" true
s = "aab" p = "c*a*b" true
s = "mississippi" p = "mis*is*p*." false
*/
class IsMatch{
	public static void main(String[] args){
		String s = "aa";
		String p = "a";

		String s1 = "aa";
		String p1 = "a*";

		String s2 = "ab";
		String p2 = ".*";

		String s3 = "aab";
		String p3 = "c*a*b";		

		String s4 = "mississippi";
		String p4 = "mis*is*p*";

		System.out.println(isMatch(s,p));
		System.out.println(isMatch(s1,p1));
		System.out.println(isMatch(s2,p2));
		System.out.println(isMatch(s3,p3));
		System.out.println(isMatch(s4,p4));

	}
	public static boolean isMatch(String s, String p){
		int index1 = 0;
		int index2 = 0;
		while(index1 != s.length() && index2 != p.length()){
			char s1 = s.charAt(index1);
			char s2 = p.charAt(index2);
			System.out.println("s1: " + s1 + " s2:" + s2);
			if(s1 == '.' || s2 == '.'){
				index1++;
				index2++;
				continue;
			}
			if(s1 == '*'){
				char previous = s.charAt(index1 - 1);
				if(previous == '.'){
					return true;
				}
				s2 = p.charAt(index2 - 1);
				while(index2 + 1 <= p.length() && previous == s2){
					s2 = p.charAt(index2);
					index2++;
				}
				index2--;
				index1++;
			}
			if(s2 == '*'){
				char previous = p.charAt(index2 - 1);
				if(previous == '.'){
					return true;
				}
				s1 = s.charAt(index1 - 1);
				while(index1 + 1 <= s.length() && previous == s1){
					s1 = s.charAt(index1);
					index1++;					
				}
				index1--;
				index2++;
			}
			
			if(index1 == s.length() && index2 == p.length()){
				return true;
			}
			s1 = s.charAt(index1);
			s2 = p.charAt(index2);
			if(s1 == s2){
				index1++;
				index2++;
			}else{
				if(index1 <= s.length() - 2 && s.charAt(index1 + 1)== '*'){
					index1=index1+2;
					continue;
				}
				if(index2 <= p.length() - 2 && p.charAt(index2 + 1)== '*'){
					index2=index2+2;
					continue;
				}
				break;
			}
		}
		if(index1 != s.length() || index2 != p.length()){
			return false;
		}
		return true;
	}
}
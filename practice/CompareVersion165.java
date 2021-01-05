/*
165.compare version numbers
if version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0;
in:version1 = 0.1, version2 = 1.1
out:-1
in:version1 = 1.0.1 version2 = 1
out:1
in:version1 = 7.5.2.4 version2 = 7.5.3
out:-1
*/
class CompareVersion{
	public static void main(String[] args){
		String version1 = "0.1";
		String version2 = "1.1";
		String version3 = "1.0.1";
		String version4 = "1";
		String version5 = "7.5.2.4";
		String version6 = "7.5.3";
		System.out.println(compareVersion(version1,version2));
		System.out.println(compareVersion(version3,version4));
		System.out.println(compareVersion(version5,version6));
	}
	public static int compareVersion(String version1, String version2){
		int index1 = 0;
		int index2 = 0;
		while(index1 != version1.length() || index2 != version2.length()){
			int previous1 = index1;
			int previous2 = index2;
			String temp1 = "";
			String temp2 = "";
			int number1 = -1;
			int number2 = -1;
			while(index1 != version1.length() && version1.charAt(index1) != '.' ){
				index1++;
			}
			if(previous1 != index1){
				temp1 = version1.substring(previous1, index1);
				number1 = Integer.valueOf(temp1);
			}else{
				number1 = -1;
			}
			System.out.println("number1: " + number1);
			while(index2 != version2.length() && version2.charAt(index2) != '.' ){
				index2++;
			}
			if(previous2 != index2){
				temp2 = version2.substring(previous2, index2);
				number2 = Integer.valueOf(temp2);
			}else{
				number2 = -1;
			}
			System.out.println("number2: " + number2);
			if(number1 == number2 && index1 != version1.length() && index2 != version2.length()){
				index1++;
				index2++;
				continue;
			}else if(number1 == number2 && index1 == version1.length()){
				return -1;
			}else if(number1 == number2 && index2 == version2.length()){
				return 1;
			}else if(number1 < number2){
				return -1;
			}else{
				return 1;
			}
		}
		return 0;
	}
}
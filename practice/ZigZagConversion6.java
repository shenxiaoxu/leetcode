/*
6.zigzag conversion
string paypalishiring is written in a zigzag pattern on a given number of rows like this:
P A H N
APLSIIG
Y I R
then read line by line:"PAHNAPLSIIGYIR"
string convert(string s, int numRows)
input s = "PAYPALISHIRING", numRows = 3
output:"PAHNAPLSIIGYIR"
input s = "PAYPALISHIRING", numRows = 4
output:"PINALSIGYAHRPI"

solution:
list<string builder> 1,2..n
join string.

while string!=end /mod n/flag =true/currow +1?-1 godown
*/
import java.util.*;
class ZigZagConversion{
	public static String convert(String s, int numRows){
		List<StringBuilder> list = new LinkedList<StringBuilder>();
		String result = "";
		for(int i = 0; i < numRows; i++){
			StringBuilder temp = new StringBuilder();
			list.add(temp);
		}
		boolean godown = false;
		int currow = 0;
		for(int j = 0; j < s.length();j++){
			if(currow == 0 || currow == (numRows -1 )){
				godown = !godown;
			}
			list.get(currow).append(s.charAt(j));
			currow += godown? 1:-1;			
		}
		for(int k = 0; k < numRows;k++){
			result += list.get(k).toString();
		}
		return result;
	}
	public static void main(String[] args){
		String s = "PAYPALISHIRING";
		System.out.println(convert(s, 3));
		System.out.println(convert(s, 4));
	}
}
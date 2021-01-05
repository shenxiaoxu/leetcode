import java.util.ArrayList;
public class Parenthese
{
    public static void main(String[] args){
    	ArrayList<String> s = new ArrayList<String>();
        parenthese(3,3,"",s);
        for(int i = 0; i < s.size(); i++){
        	System.out.println(s.get(i));
        }
    }
    public static void parenthese(int leftNumber, int rightNumber, String st, ArrayList<String> s){ 
    	System.out.println(leftNumber + " " + rightNumber + " " + st); 
        if(leftNumber == 0 && rightNumber == 0){
            s.add(st);
        }
        if(leftNumber > 0){
            parenthese(leftNumber - 1,rightNumber,st + "(", s); 
        }
        if(rightNumber > 0 && leftNumber < rightNumber){
            parenthese(leftNumber, rightNumber - 1,st + ")", s);          
        }
        
    }
}  
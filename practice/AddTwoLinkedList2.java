import java.util.LinkedList;
public class AddTwoLinkedList
{

    public static void main(String[] args)
    {
    	//list 3,5,7 list 6,0,4 ==>result 9,5,1,1
    	LinkedList linkedFirst = new LinkedList();
    	linkedFirst.add(9);
    	linkedFirst.add(9);
    	linkedFirst.add(9);
    	LinkedList linkedSecond = new LinkedList();
    	linkedSecond.add(1);
    	linkedSecond.add(1);
    	linkedSecond.add(1); 
    	LinkedList newlinkedlist = addTwoLinkedlist(linkedFirst,linkedSecond);   	
        for(int i = 0; i < newlinkedlist.size(); i++){
        	System.out.println(Integer.parseInt(String.valueOf(newlinkedlist.get(i))));
        }
    }
    public static LinkedList addTwoLinkedlist(LinkedList listFirst, LinkedList listSecond)
    {
        int carry = 0;
        int firstSize = listFirst.size();
        int secondSize = listSecond.size();
        int maxSize = Math.max(firstSize,secondSize);
        LinkedList newlinkedlist = new LinkedList();
        for(int i = 0;i < maxSize; i++){
            int number1 = 0;
            int number2 = 0;
            int newNumber = 0;
            if(i < firstSize){
                number1= Integer.parseInt(String.valueOf(listFirst.get(i)));
            }
            if(i < secondSize){
                number2 = Integer.parseInt(String.valueOf(listSecond.get(i)));
            }
            newNumber = number1 + number2 + carry;
            //System.out.println(newNumber);
            if(newNumber >= 10){
                carry = 1;
                newNumber = newNumber - 10;
            }else{
                carry = 0;
            }
            newlinkedlist.add(newNumber);
        }
        if(carry == 1){
            newlinkedlist.add(carry);
        }
        return newlinkedlist;
    }
}
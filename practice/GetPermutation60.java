/*
60.permutation sequence
set[1,2,3...,n] contains a total of n! unique permutations
given n and k, return kth permutation sequence.
in n =3,k=3 ou "213"
in n = 4,k=9 ou "2314"
solution: permutation , if get to the number, return
*/
import java.util.*;
class GetPermutation{
	public static void main(String[] args){
		int[] array = {1,2,3};
		int k = 3;
		NextPermutation next = new NextPermutation();
		while(k != 1){
			next.nextPermutation(array);
			k--;
		}
	}

}
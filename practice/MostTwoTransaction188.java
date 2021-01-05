import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class MostTwoTransaction
{

    public static void main(String[] args)
    {
        int[] array = {3,3,5,0,0,3,1,4};
        //atMostKTransaction(array, 2);
        System.out.println(atMostKTransaction(array, 3));
    }
    public static int atMostKTransaction(int[] array, int k){
       int[][]priceStore = new int[k + 1][array.length];
       int maxPrice1 = 0;
       int maxPrice2 = 0;
       for(int i = 0; i < k + 1; i++){
            priceStore[i][0] = 0;
       }
       for(int j = 0; j < array.length; j++){
            priceStore[0][j] = 0;
       }
       for(int l = 1; l <= k; l++){
            for(int i = 1; i < array.length; i++){           
                for(int j = 0; j < i; j++){
                    maxPrice1 = Math.max(maxPrice1, priceStore[l - 1][j] + array[i] - array[j]);
                }
                maxPrice2 = Math.max(priceStore[l][i - 1], maxPrice1);
                priceStore[l][i] = maxPrice2;
                //System.out.println(l + " " + i + " " + maxPrice2);
            }
       }

       return priceStore[k][array.length - 1];
    }
}
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        
        //First issue is the array needs to be sorted.
        for (int outer =  0 ; outer < x.length - 1 ; outer++)
        {
            int smallestIndex = outer;
            for (int inner = outer + 1 ; inner < x.length ; inner++)
            {
                if (x[inner] < x[smallestIndex])
                {
                    smallestIndex = inner;
                }
            }
            int temp = x[outer];
            x[outer] = x[smallestIndex];
            x[smallestIndex] = temp;
        }
        
        //Next we need to find the largest distance between any two houses;
        int greatestDistance = 0;
        for (int outer = 1 ; outer < x.length ; outer++)
        {
            if ((x[outer] - x[outer-1]) > greatestDistance)
            {
                greatestDistance = x[outer] - x[outer-1];
            }
        }
        
        //Now we find how many transmitters we need
        int count = 0;
        int[] transHouses = new int[n];
        int transHouseCount = 0;
        int index = 0;
        int realCenter = 0;
        while (index < x.length)
        {
            //System.out.println("The index is " + index);
            int initialVal = x[index];
            
            if ((x[index] + k) > x[x.length-1])
            {
                realCenter = x[index];
                index = x.length;               
            }
            while (index < x.length && x[index] <= initialVal + k)
            {
                index++;
            }
            
            index = index - 1;
            int centerValue = x[index];
            transHouses[transHouseCount] = centerValue;
            if (realCenter != 0)
            {
               transHouses[transHouseCount] = realCenter; 
            }
            transHouseCount++;
            while (index < x.length && x[index] <= centerValue + k)
            {
                index++;
            }
            //System.out.println("The last index is " + index);
            count++;
        }
        
        /*for (int z = 0 ; z < transHouseCount ; z++)
        {
            System.out.println("[" + transHouses[z] + "]");
        }*/
        System.out.println(count);
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //number of houses
        int k = in.nextInt(); //distance of transmitter
        int[] x = new int[n]; //holds location of house
        
        //for loop puts location of house
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        in.close();
        //first need to find greatest distance between adjacent houses. For that you need the thing sorted.

        int transDistance;
        int[] tempX = new int[n];        
        for (int z = 0 ; z < x.length ; z++)
        {
            int indexLowest = z;
            for (int zz = z + 1 ; zz < x.length ; zz++) 
            {
                if (x[zz] < x[indexLowest]) 
                {
					System.out.println(z + "," + zz);
                    indexLowest = zz;
                }
            }
            int temp = x[z];
            x[z] = x[indexLowest];
            x[indexLowest] = temp;
        }
        transDistance = x[1] - x[0];
        for (int z = 2 ; z < x.length ; z++)
        {
            int temp = x[z] - x[z-1];
            if (temp > transDistance)
            {
                transDistance = temp;
            }
        }

        //now that we have all the houses sorted and the max distance between two adjacent houses,
        //we figure out where to place transmitter
        int count = 0;
        int index = 0;
        int halfWay = x[0] + k;
        int endPoint = 0;
        while (endPoint < x[x.length-1] && endPoint < x[x.length-1]) {
            if ((x[index+1] -x[index]) > transDistance )
            {
                count++;
                index++;
                halfWay = x[index] + k;
            }
            else
            {
                while(x[index] < halfWay)
                {
                    index++;
                }
                endPoint = x[index-1] + k;
                count++;
                while (x[index] < endPoint && endPoint < x[x.length-1])
                {
                    index++;
                }
                halfWay = x[index] + k;
                endPoint = halfWay +k;
            }
        }


        System.out.println(count);
    }
}

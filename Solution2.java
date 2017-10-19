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
        int[] x = new int[100001];
        int greatest = 0;
        for(int x_i=0; x_i < n; x_i++){
            int temp = in.nextInt();
            if (temp > greatest)
            {
                greatest = temp;
            }
            x[temp] = 1;
        }
        
        
        int count = 0;
        int index = 0;
        while (index < x.length) 
        {
            if (index + k >= greatest)
            {
                count++;
                index = x.length;
            }
            else if (x[index] == 1)
            {
                int reverse = index + k;
                while (x[reverse] != 1)
                {
                    reverse--;
                }
                count++;
                index = reverse + k;
            }
            index++;
        }
        
        System.out.println(count);
        
        //Next we need to find the largest distance between any two houses;
        
        /*
        int greatestDistance = 0;
        for (int outer = 0 ; outer < x.length ; outer++)
        {
            int switcher = 0;
            int a = 0;
            int b = 0;
            if (x[outer] == 1 && switcher == 0)
            {
                a = outer;
                switcher++;
            }
            else if (x[outer] == 1 && switcher == 1)
            {
                b = outer;
                switcher++;
            }
            
            if (switcher == 2)
            {
                int temp = b - a;
                if (temp > greatestDistance)
                {
                    greatestDistance == temp;
                }
                a = 0;
                b = 0;
                switcher = 0;
            }
        }
        */
        
        //now find how many transmitters we need
        
    }
}

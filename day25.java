import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        while (scan.hasNext())
        {
            boolean prime = true;
            int temp = scan.nextInt();
            int divisor = 5;
            if (temp <= 1 || (temp % 2 == 0 && temp != 2 ) || (temp % 3 == 0 && temp > 3) )
            {
                prime = false;
            }
            while (divisor < (temp / divisor) + 1)
            {
                if (temp % divisor == 0)
                {
                    prime = false;
                }
                divisor = divisor + 2;
            }


            if (prime) 
            {
                System.out.println("Prime");
            }
            else
            {
                System.out.println("Not prime");
            }
        }

    }
}


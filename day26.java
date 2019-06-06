import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int[] actual = new int[3];
        int[] expected = new int [3];
        int count = 0;
        int fine = 0;

        while (count < 6)
        {
            if (count < 3) 
            {
                actual[count] = scan.nextInt();
            }
            else 
            {
                expected[count-3] = scan.nextInt();
            }
            count++;
        }

        if (actual[2] > expected[2])
        {
            fine = 10000;
        }
        else if (actual[2] == expected[2] && actual[1] > expected[1])
        {
            fine = 500 * (actual[1] - expected[1]);
        }
        else if (actual[2] == expected[2] && actual[1] == expected[1] && actual[0] > expected[0])
        {
            fine = 15 *(actual[0] - expected[0]);
        }
        System.out.println(fine);
    }
}


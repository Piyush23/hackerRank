package challenges.leftRotation;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
      //code here
        
        int [] rotate = new int[n];
        if (k>n)
            k = k - n;
        
        int index;
        for(int i = 0 ; i < a.length  ; i ++){
            index = i+k;
            if(index < a.length)
                rotate[i] = a[index];
            else
                rotate[i] = a[ index % a.length];
        }
        
        return rotate;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        // k rotation
        int k = in.nextInt();
        
        int a[] = new int[n];
        
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
}


package javaCourse.introduction.loops2;

import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            getQueries(a,b,n);
        }
        in.close();
    }
    
    private static void getQueries(int a, int b , int n){
        int sum = a;
        for(int i=0; i < n; i++){
            sum = (int) (sum + (Math.pow(2, i) * b));
            System.out.print(sum + " ");
        }
        System.out.println();
    }
}
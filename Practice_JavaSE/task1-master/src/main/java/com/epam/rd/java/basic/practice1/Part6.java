package com.epam.rd.java.basic.practice1;

/**
 * The class creates an array from n elements and fills it with an ascending sequence of prime numbers (2, 3, 5, 7 …).
 * The n number is passed as the command line parameter.
 */
public class Part6 {
    private static boolean isPrime(int n){
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        for(int i = 3; i <= Math.sqrt(n); i += 2){
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] simple = new int[n];

        int k = 0;
        for(int i = 2; k < n; ++i){
            if(isPrime(i)){
                simple[k] = i;
                k++;
            }
        }

        String str = "";

        for (int m = 0; m<simple.length-1; m++){
            str += simple[m] + " ";
        }
        System.out.print(str + simple[simple.length-1]);
    }
}

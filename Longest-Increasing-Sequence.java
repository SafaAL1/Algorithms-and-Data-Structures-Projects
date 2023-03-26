/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Safa
 */
import java.util.Scanner;

public class LIS {
    //initalizing the values 
    static int size;
    static int sizeB;
    static int arrayA[] = new int[100];
    static int arrayB[] = new int[100];
    
    //This section of the code focuses on grabbing the user's input using scanner
       public static void main(String args[]) {
    
        System.out.print("Enter the length of the array: ");
        Scanner scan = new Scanner(System.in);
        size = scan.nextInt();

        for(int i =0; i < size ; i++){
            arrayA[i] = scan.nextInt();
        }
        arrayB[0] = arrayA[0];
        int k = 0;
        for(int i = 1; i < size; i++){
            if(arrayA[i] > arrayB[k]){
                arrayB[++k] = arrayA[i];
            }
        }
        sizeB = k + 1;
        
        System.out.println("LIS: " + sizeB);
        
        for (int i = 0; i < sizeB; i++){
            System.out.print(arrayB[i] + " ");
        }
        System.out.println();
    }


}

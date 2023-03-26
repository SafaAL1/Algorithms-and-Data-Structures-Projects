/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Safa
 */
import java.util.*;

public class NQueen{
    private final int userIn;
    //This section of the code focuses on grabbing the user's input using scanner
    public NQueen() {
        System.out.println("Insert value for chess");
        Scanner scan = new Scanner(System.in); 
        userIn = scan.nextInt();
        System.out.println("The following will be generated");
    } 
    //This section of the code will check the digonals of the code
    public boolean generate(int[][] chess, int row, int col) {
        int i, j;
        boolean val = false;
        boolean esl = true;
        for (i = 0; i < col; i++) {
            if (chess[row][i] == 1) {
                return val;
            }
        }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return val;
            }
        }
        for (i = row, j = col; j >= 0 && i < userIn; i++, j--) {
            if (chess[i][j] == 1) {
                return val;
            }
        }
          return esl;
    }
      public static void main(String[] args) {
        NQueen queen = new NQueen();
        queen.Queen();
    }
      
    //this section will print the final result 
    public void printChess(int[][] chess) {
        for (int i = 0; i < userIn; i++) {
            for (int j = 0; j < userIn; j++) {
                System.out.print(" " + chess[i][j] + " ");}
            System.out.println();
        }}
    
    public boolean solution(int[][] chess, int col) {
        if (col == userIn) {
            return true;
        }
        for (int i = 0; i < userIn; i++) {
            if (generate(chess, i, col)) {
                chess[i][col] = 1;
                if (solution(chess, col + 1)) {
                    return true;
                }
                chess[i][col] = 0;
            }
        }
        return false;
    }
    
    public boolean Queen() {
        int[][] chess = new int[userIn][userIn];
        if (!solution(chess, 0)) {
            return false;}
        
        printChess(chess);
        return true;
    }   
}

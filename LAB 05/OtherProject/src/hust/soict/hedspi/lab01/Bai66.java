package hust.soict.hedspi.lab01;
import java.util.Scanner;

public class Bai66{
    public static void main(String args[]){
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nhap kich thuoc ma tran");
        int rows = keyboard.nextInt();
        int columns = keyboard.nextInt();
        int[][] matrA = new int[rows][columns];
        int[][] matrB = new int[rows][columns];
        int[][] matrSum = new int[rows][columns];

        System.out.println("MatrA: ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrA[i][j] = keyboard.nextInt();
            }
        }

        System.out.println("MatrB: ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j< columns; j++){
                matrB[i][j] = keyboard.nextInt();
            }
        }

        System.out.println("MatrSum = MatrA + MatrB =  ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j< columns; j++){
                matrSum[i][j] = matrA[i][j] + matrB[i][j];
                System.out.print(matrSum[i][j] + " ");
            }
            System.out.print("\n");
        }
        keyboard.close();
    }
}
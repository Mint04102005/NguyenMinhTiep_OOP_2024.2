import java.util.Scanner;

public class Bai63{
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nhap chieu cao cua tam giac: ");
        int d = keyboard.nextInt();
        for(int i = 0; i < d; i++){
            for(int j = 0; j < 2*d-1; j++){
                if(j >= d-1-i && j <= d-1+i){
                    System.out.print("*");
                }                
                else{
                    System.out.print(" ");
                }
            } 
            System.out.print("\n");           
        }
        keyboard.close();
    }
}
import java.util.Arrays;
import java.util.Scanner;

public class Bai65{
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("So phan tu cua mang: ");
        int n = keyboard.nextInt();
        int[] arrays = new int[n];
        System.out.println("Nhap mang: ");
        for(int i = 0; i < n; i++){
            arrays[i] =  keyboard.nextInt();
        }
        System.out.println("Mang ban dau: " + Arrays.toString(arrays));
        Arrays.sort(arrays);
        System.out.println("Mangkhi sap xep: " + Arrays.toString(arrays));
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arrays[i];
        }
        System.out.println("Tong cua mang: " + sum);

        double average = (double)sum/n;
        System.out.println("Trung binh cua mang: " + average);
        keyboard.close();
    }
}
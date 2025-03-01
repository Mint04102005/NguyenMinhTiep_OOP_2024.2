import java.util.Scanner;

public class Bai225 {
    public static void main(String[] args) {
        double a, b;
        java.util.Scanner keyboard = new Scanner(System.in);
        System.out.println(" Nhap so thu nhat: ");
        a = keyboard.nextDouble();
        System.out.println("Nhap so thu 2: ");
        b = keyboard.nextDouble();
        System.out.println("Tong 2 so: " + (a + b));
        System.out.println("Hieu 2 so: " + (a - b));
        System.out.println("Tich 2 so: " + (a * b));
        if (b == 0) {
            System.out.println("Null");
        } else {
            System.out.println("Thuong 2 so: " + (a / b));
        }
        keyboard.close();
    }
}
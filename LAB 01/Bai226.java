import java.util.Scanner;

public class Bai226 {
    public static void main(String[] args) {
    
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nhap truong hop: "); // bac1: 1; bac2: 2; he pt: 3
        int PT = keyboard.nextInt();

        if (PT == 1) {
            double a, b, x;
            System.out.println("Nhap a = ");
            a = keyboard.nextDouble();
            System.out.println("Nhap b = ");
            b = keyboard.nextDouble();

            if (a == 0) {
                if (b == 0) {
                    System.out.println("Vo so nghiem");
                } else {
                    System.out.println("Vo nghiem");
                }
            } else {
                x = -b / a;
                System.out.println("Nghiem cua pt: x = " + x);
            }
        }
        
        else if (PT == 2) {
            double a1, b1, c1, delta, x1, x2;
            System.out.println("Nhap a1 = ");
            a1 = keyboard.nextDouble();
            System.out.println("Nhap b1 = ");
            b1 = keyboard.nextDouble();
            System.out.println("Nhap c1 = ");
            c1 = keyboard.nextDouble();

            if (a1 == 0) {
                System.out.println("NULL");
            } else {
                delta = b1 * b1 - 4 * a1 * c1;

                if (delta > 0) {
                    x1 = (-b1 + Math.sqrt(delta)) / (2 * a1);
                    x2 = (-b1 - Math.sqrt(delta)) / (2 * a1);
                    System.out.println("2 nghiem phan biett:");
                    System.out.println("Nghiem 1: x1 = " + x1);
                    System.out.println("Nghiem 2: x2 = " + x2);
                } else if (delta == 0) {
                    x1 = -b1 / (2 * a1);
                    System.out.println("Nghiem kep:");
                    System.out.println("Nghiem x = " + x1);
                } else {
                    System.out.println("Vo nghiem");
                }
            }
        }

        else if (PT == 3) {
            double a11, a12, b1, a21, a22, b2;
            double D, D1, D2, x1, x2;

            System.out.println("Nhap a11: ");
            a11 = keyboard.nextDouble();
            System.out.println("Nhap a12: ");
            a12 = keyboard.nextDouble();
            System.out.println("Nhap b1: ");
            b1 = keyboard.nextDouble();
            System.out.println("Nhap a21: ");
            a21 = keyboard.nextDouble();
            System.out.println("Nhap a22: ");
            a22 = keyboard.nextDouble();
            System.out.println("Nhap b2: ");
            b2 = keyboard.nextDouble();

            // Tính các định thức D, D1, D2
            D = a11 * a22 - a21 * a12;
            D1 = b1 * a12 - b2 * a22;
            D2 = a11 * b2 - a21 * b1;

            if (D == 0) {
                if (D1 == 0 && D2 == 0) {
                    System.out.println("Vo so nghiem");
                } else {
                    System.out.println("Vo nghiem");
                }
            } else {
        
                x1 = D1 / D;
                x2 = D2 / D;
                System.out.println("nghiem cua he: x1 = " + x1 + ", x2 = " + x2);
            }
        }
        keyboard.close();
    }
}

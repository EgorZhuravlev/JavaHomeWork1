// Вычислить n-ое треугольного число (сумма чисел от 1 до n)

/**
 * Exercise1
 */

import java.util.Scanner;
public class Exercise1 {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число n: ");
        int n = iScanner.nextInt();
        System.out.printf("Треугольное число равно: %d \n", giveMeNumber(n));
        iScanner.close();
      }
      public static int giveMeNumber(int a) {
        return (a * (a + 1) / 2);

        
      }
}
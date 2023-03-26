// Вычислить n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число n: ");
        int n = iScanner.nextInt();
        System.out.printf("Факториал числа n равно: %d \n", giveMeNumber(n));
        iScanner.close();
    }

    public static int giveMeNumber(int a) {
        int result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;

    }
}
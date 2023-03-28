// +Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
// Требуется восстановить выражение до верного равенства. 
// Предложить хотя бы одно решение или сообщить, что его нет.

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите уравнение вида a? + ?b = c:");
        String equation = scanner.nextLine().trim();
        int a = Integer.parseInt(equation.substring(0, equation.indexOf("?")));
        int b = Integer.parseInt(equation.substring(equation.indexOf("+") + 2, equation.lastIndexOf("?")));
        int c = Integer.parseInt(equation.substring(equation.lastIndexOf("=") + 2));
        scanner.close();

        if (isValidEquation(a, b, c)) {
            System.out.println("Решение:");
            if (a == -1) {
                for (int q = 1; q <= 9; q++) {
                    int w = c - q - b;
                    if (w >= 0 && w <= 9 && w != q) {
                        System.out.printf("%d%d + %d = %d%d\n", q, getPlaceholder(w), b, q, w);
                    }
                }
            } else if (b == -1) {
                for (int w = 1; w <= 9; w++) {
                    int q = c - w - a;
                    if (q >= 0 && q <= 9 && q != w) {
                        System.out.printf("%d%d + %d = %d%d\n", a, getPlaceholder(q), w, a, w);
                    }
                }
            } else {
                for (int q = 1; q <= 9; q++) {
                    for (int w = 1; w <= 9; w++) {
                        int e = q + w;
                        if (q != a || w != b) {
                            continue;
                        }
                        if (isValidEquation(q, w, c - e)) {
                            System.out.printf("%d%d + %d = %d\n", q, getPlaceholder(w), w, e, c);
                        }
                    }
                }
            }
        } else {
            System.out.println("Уравнение не имеет решения.");
        }
    }

    private static boolean isValidEquation(int a, int b, int c) {
        if (a < 0 || a > 9 || b < 0 || b > 9 || c < 0 || c > 99) {
            return false;
        }
        if (a == 0 && b == 0) {
            return false;
        }
        int num1 = a * 10 + b;
        int num2 = b * 10 + (c - a - b);
        int sum = a + b;

        int carry = (num1 + num2) / 100;
        return sum == c % 10 && num1 + num2 == sum * 100 + carry;
    }

    private static char getPlaceholder(int digit) {
        return digit == 0 ? '?' : (char) ('0' + digit);
    }
}
// Вывести все простые числа от 1 до 1000 (числа, которые делятся только на 1 и на себя без остатка)



import java.util.ArrayList;
import java.util.List;


public class Exercise3 {

    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= 1000; i++) {
            boolean isPrimeNumber = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if (isPrimeNumber) {
                primes.add(i);
            }
        }
        System.out.println("Простые числа: " + primes);
    }
}
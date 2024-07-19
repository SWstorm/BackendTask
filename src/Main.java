import java.util.stream.LongStream;

public class Main {
    public static long calculateSumBetween (int a, int b) {
        return LongStream.range(a,b).sum();
    }
    public static void main(String[] args) {
        int a = 10000000;
        int b = 1000000000;

        long sum = calculateSumBetween(a,b);
        System.out.println("Сумма чисел мужду " + a + " и " + b + " равна: " + sum);
    }
}

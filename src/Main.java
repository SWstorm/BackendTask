import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 15) + 1;
        }
        System.out.println("Вывод,: " + Arrays.toString(arr));
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (var entry : countMap.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();
            if (count > 1) {
                System.out.println("Число '" + number + "' встречается " + count + " раз(а)");
            }
        }
    }
}
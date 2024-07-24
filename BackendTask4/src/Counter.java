import java.util.*;

public class Counter {

    public void analyzer() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите строку");
        String text = in.nextLine();
        System.out.println("Введите подстроку");
        String subtext = in.nextLine();

        int index = 0, count = 0;

        if (isEmpty(text) || isEmpty(subtext)) {
            System.out.println("Подстрока '" + subtext + "' встречается " + count + " раз");
        } else {
            while (true) {
                index = text.indexOf(subtext, index);
                if (index != -1) {
                    count++;
                    index += subtext.length();
                } else {
                    break;
                }
            }
            System.out.println("Подстрока '" + subtext + "' встречается " + count + " раза");
        }
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }
}

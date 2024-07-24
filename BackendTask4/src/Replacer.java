import java.util.Scanner;

public class Replacer {
    public void replace() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите строку");
        String text = in.nextLine();

        if (isEmpty(text)) {
            System.out.println("Ошибка: Некорректные данные!");
            return;
        }

        String replText1 = text.replace("кака", "вырезано цензурой");
        String replText2 = replText1.replace("бяка", "вырезано цензурой");

        System.out.println(replText2);
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }
}

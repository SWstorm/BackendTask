import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TransformerOfDate {
    public void transformDate() {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        String strDate = in.nextLine();

        if (isEmpty(strDate)) {
            System.out.println("Ошибка: Некорректные данные!");
            return;
        }

        SimpleDateFormat inputDate = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat outputDate = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = inputDate.parse(strDate);
            String formattedDate = outputDate.format(date);

            System.out.println(formattedDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }
}

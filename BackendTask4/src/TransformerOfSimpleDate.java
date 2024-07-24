import java.util.Scanner;

public class TransformerOfSimpleDate {
    public void transformDate() {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        String strDate = in.nextLine();

        if (isEmpty(strDate)) {
            System.out.println("Ошибка: Некорректные данные!");
            return;
        }

        String[] date = strDate.split("\\.");
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);

        String formDate = String.format("%d-%02d-%02d", year, month, day);
        System.out.println(formDate);
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            Date date = formatter.parse(strDate);
//            System.out.println(date);
//        }
//        catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(formatter.format(date));
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }
}

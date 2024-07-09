import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static final Calendar calendar = Calendar.getInstance();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату (формат 31.12.2020): ");
        String inputDate = scanner.nextLine();

        Date date;

        try {
            date = dateFormat.parse(inputDate);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты!");
            return;
        }

        Date increasedDate = setOffsetToDate(date);
        System.out.println("Дата после добавления 45 дней: " + dateFormat.format(increasedDate));

        Date startOfYear = shiftToStartOfYear(date);
        System.out.println("Дата после сдвига на начало года: " + dateFormat.format(startOfYear));

        Date increasedWorkDaysDate = setOffsetOfWorkDays(date);
        System.out.println("Дата после добавления 10 рабочих дней: " + dateFormat.format(increasedWorkDaysDate));

        System.out.print("Введите вторую дату (формат 31.12.2020): ");
        String secondInputDate = scanner.nextLine();

        Date secondDate;

        try {
            secondDate = dateFormat.parse(secondInputDate);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты!");
            return;
        }

        int workDaysBetweenDates = calculateWorkDaysBetweenDates(date, secondDate);
        System.out.println("Количество рабочих дней между датами: " + workDaysBetweenDates);

        scanner.close();
    }

    private static Date setOffsetToDate(Date startDate) {
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_YEAR, 45);
        return calendar.getTime();
    }

    private static Date setOffsetOfWorkDays(Date startDate) {
        calendar.setTime(startDate);
        int workDays = 0;

        while (workDays < 10) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                workDays++;
            }
        }
        return calendar.getTime();
    }

    private static Date shiftToStartOfYear(Date date) {
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static int calculateWorkDaysBetweenDates(Date startDate, Date endDate) {
        calendar.setTime(startDate);
        int workDays = 0;

        int increment = startDate.before(endDate) ? 1 : -1;
        while (calendar.getTime().before(endDate) || calendar.getTime().after(endDate)) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                workDays++;
            }
            calendar.add(Calendar.DAY_OF_YEAR, increment);
        }

        int lastDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (lastDayOfWeek != Calendar.SATURDAY && lastDayOfWeek != Calendar.SUNDAY && calendar.getTime().equals(endDate)) {
            workDays++;
        }

        return workDays - 1;
    }
}
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class EX7 {
    static final int MAX_USERS = 5;

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> userList = new ArrayList<>();

        for (int i = 0; i < MAX_USERS; i++) {
            System.out.print("Введите имя пользователя " + (i+1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Введите возраст пользователя " + (i+1) + ":");
            int age = scanner.nextInt();
            scanner.nextLine();

            User user = new User(name, age);
            userList.add(user);
        }

        userList.sort(Comparator.comparing(User::getAge));

        System.out.println("Список пользователей, отсортированный по возрасту:");
        for (User user : userList) {
            System.out.println(user.toString());
        }
        scanner.close();
    }
}

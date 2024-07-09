import java.util.Scanner;
public class EX6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя первого пользователя");
        String name1 = scanner.nextLine();
        System.out.print("Введите возраст первого пользователя");
        int age1 = scanner.nextInt();
        scanner.nextLine();

        User user1 = new User(name1, age1);

        System.out.print("Введите имя второго пользователя: ");
        String name2 = scanner.nextLine();
        System.out.print("Введите возраст второго пользователя: ");
        int age2 = scanner.nextInt();

        User user2 = new User(name2, age2);

        User userWithMinAge = (user1.getAge() < user2.getAge()) ? user1 : user2;

        System.out.print("Данные пользователя с наименьшим возрастом:\n" + userWithMinAge);

        scanner.close();
    }
}

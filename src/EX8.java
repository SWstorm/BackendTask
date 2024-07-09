import java.util.*;
public class EX8 {
    static final int MAX_USERS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, List<User>> userMap = new HashMap<>();

        for (int i = 0; i < MAX_USERS; i++) {
            System.out.print("Введите имя пользователя " + (i + 1) + ":");
            String name = scanner.nextLine();
            System.out.print("Введите возраст пользователя " + (i + 1) + ":");
            int age = scanner.nextInt();
            scanner.nextLine();

            User user = new User(name, age);

            if (userMap.containsKey(age)) {
                List<User> userList = userMap.get(age);
                userList.add(user);
            } else {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                userMap.put(age, userList);
            }
        }

        System.out.print("Введите возраст для поиска: ");
        int searchAge = scanner.nextInt();

        if (userMap.containsKey(searchAge)) {
            List<User> userList = userMap.get(searchAge);
            userList.sort(Comparator.comparing(User::getName));

            System.out.println("Пользователи с возрвастом " + searchAge + ", отсортированные по имени:");
            for (User user : userList) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("Нет пользователей с таким возрастом");
        }
    }
}